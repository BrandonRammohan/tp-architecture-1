


        $("#passengerBtn").on("click", function () 
        {
          passenger = $("#passNo").val();
          if (passenger <= 0) 
          {
            $("#returnError2").html("");
            $("#returnError2").html(
              '<p class="text-danger text-center">Invalid number of passengers!</p>'
            );
          } else if (passenger > 200) {
            $("#returnError2").html("");
            $("#returnError2").html(
              '<p class="text-danger text-center">Number of passengers you input exceeds flight capacity of 200 !</p>'
            );
          } 
          

          else if (passenger > 0 && passenger <= 200) 
          {
            total = prices[flightSrNo] * passenger;
            $("#passengerNames").show();
            // $("#returnError2").html('<p class="confirmation text-center">That will cost you a total of &#8377;' + total + '</p>');
            $("#enterPassengers").fadeOut(300);
            // $("#rePassNo").fadeIn(400).on("click", function() {
            //   $("#rePassNo").hide();
            //   $("#extraStuff").hide();
            //   $("#confirm").hide();
            //   $("#enterPassengers").fadeIn(300);
            //   $("#extraStuff").reset();
            //   $('#Bclass').attr('checked', false);
            // });;
            $("#reFlightNo").hide();
            // $("#extraStuff").show();

            $("#confirm").show();
            $(".yourTotal").html("");
            total = prices[flightSrNo] * passenger;
            $(".yourTotal").html("Your total amount: ₹" + total);
            $("#Bclass").click(function () {
              if ($("#Bclass").is(":checked")) {
                var additionalPrice = 5000 * passenger;
                total = prices[flightSrNo] * passenger + additionalPrice;
                $(".yourTotal").html("");
                $(".yourTotal").html("Your total amount: ₹" + total);
              } else {
                var additionalPrice = 5000 * passenger;
                total = total - additionalPrice;
                $(".yourTotal").html("");
                $(".yourTotal").html("Your total amount: ₹" + total);
              }
            });
            $("#getFood").click(function () {
              if ($("#getFood").is(":checked")) {
                var additionalPrice = 850 * passenger;
                total = total + additionalPrice;
                $(".yourTotal").html("");
                $(".yourTotal").html("Your total amount: ₹" + total);
              } else {
                var additionalPrice = 850 * passenger;
                total = total - additionalPrice;
                $(".yourTotal").html("");
                $(".yourTotal").html("Your total amount: ₹" + total);
              }
            });
          } 



          else 
          {
            $("#returnError2").html("");
            $("#returnError2").html(
              '<p class="text-danger text-center">Invalid number of passengers!</p>'
            );
          }
          
        });



        
  ///Starting of more flight system:

         $(".morefl").on("click", function () {
    $(".flight").fadeOut(800);
    $(".inputs").fadeOut(800);
    $("#moreflights").show(1000);
  });

  
  var fromCity = $("#fromCity").val();
  var toCity = $("#toCity").val();
  $("#searchFlight").on("click", function () 
  {
    if ($("#fromCity").val() == "") {
      $("#returnError3").html("");
      $("#returnError3").html(
        '<p class="text-danger text-center">City name cannot be blank</p>'
      );
    } else if ($("#toCity").val() == "") {
      $("#returnError3").html("");
      $("#returnError3").html(
        '<p class="text-danger text-center">City name cannot be blank</p>'
      );
    } else if ($("#enteredName").val() == "") {
      $("#returnError3").html("");
      $("#returnError3").html(
        '<p class="text-danger text-center">Flight Name cannot be blank!</p>'
      );
    } else {
      $("#returnError3").html("");
      fromCity = $("#fromCity").val();
      toCity = $("#toCity").val();
      var newFlightNumber =
        Math.floor(Math.random() * (9999 - 1000 + 1)) + 1000;
      var newSrno = currentSrNo + 1;
      currentSrNo = newSrno;
      var newFlight = $("#enteredName").val();
      var randomPrice = $("input[name='myRadio']:checked").val();
      console.log(randomPrice);
      if (randomPrice == "int") {
        randomPrice = (Math.floor(Math.random() * (50 - 15 + 1)) + 15) * 1000;
      } else if (randomPrice == "dom") {
        randomPrice = (Math.floor(Math.random() * (12 - 2 + 1)) + 2) * 1000;
      }

      ////PUSHING EVERYTHING!!!

      flsrno.push(newSrno);
      flightNumbers.push(newFlightNumber);
      flnm.push(newFlight);
      flsrc.push(fromCity);
      fldst.push(toCity);
      prices.push(randomPrice);

      //Done pushing :P

      $(".allFlights").append(
        '<div class="row flight"' +
          newFlightNumber +
          '" id="' +
          newFlightNumber +
          '"><div class="col-sm-2"><h5 class="text-center srno flightNo' +
          newSrno +
          '">' +
          newSrno +
          '</h5></div><div class="col-sm-2"><h5 class="text-center flno flightNo' +
          newSrno +
          '">' +
          newFlightNumber +
          '</h5></div><div class="col-sm-2"><h5 class="text-center flnm flightNo' +
          newSrno +
          '">' +
          newFlight +
          '</h5></div><div class="col-sm-2"><h5 class="text-center flsrc flightNo' +
          newSrno +
          '">' +
          fromCity +
          '</h5></div><div class="col-sm-2"><h5 class="text-center fldst flightNo' +
          newSrno +
          '">' +
          toCity +
          '</h5></div><div class="col-sm-2"><h5 class="text-center flprc flightNo' +
          newSrno +
          '">₹' +
          randomPrice +
          "</h5></div></div>"
      );
      $(".flight").show();
      $(".inputs").show();
      $("#moreflights").hide();
      $("#returnError4").html("");
      $(".flight").click(function () {
        flight = $(this).attr("id");
        mainsystem(flight);
        console.log(flight);
      });

      $("#returnError4").html(
        '<p class="text-info text-center"> 1 flight was found!'
      );
      $("#returnError4").fadeOut(3000);
      $("#returnError4  ").html("");
    }
  });
























  else if (flight > 0) 
    {
      var test = false;
      for (var i = 0; i < flightNumbers.length; i++) 
      {
        if (flightNumbers[i] == flight) 
        {
          flightSrNo = i;
          console.log(flightSrNo);
          test = true;
          break;
        }
      }
      if (test === false) 
      {
        $("#returnError").html(
          '<p class="text-danger text-center">Flight not found!</p>'
        );
        $(".flight").fadeIn(1000);
        $(".choosehead").fadeIn(500);
      } 
      
      else 
      {
        $("#returnError").html("");
        var no = "#" + flight;
        $(".flight").not(no).slideUp(1000);
        $(no).fadeIn(1200);
        $(".choosehead").fadeOut(500);
        $("#enterFlightNo").fadeOut(500);
        $("#enterPassengers").fadeIn(500);
        $("#reFlightNo")
          .show()

          
          .on("click", function () 
          {
            $("#enterFlightNo").fadeIn(500);
            $("#reFlightNo").hide();
            $("#enterPassengers").hide();
            $("#rePassNo").hide();
            $("#extraStuff").hide();
            $("#confirm").hide();
            $("#returnError2").html("");
          });
      }
    }