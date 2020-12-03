var flight;
var passenger;
var total;
var flightSrNo;
var checker1 = false;
var currentSrNo = 10;
var flsrno = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var flightNumbers = [
  "4563",
  "8205",
  "5455",
  "2853",
  "2956",
  "2653",
  "5959",
  "2468",
  "5012",
  "1752"
];
var flnm = [
  "Indian Airlines",
  "Aero Float",
  "Emirates",
  "Lufthansa",
  "Singapore Air",
  "Etihad Airways",
  "Turkish Airlines",
  "American Airlines",
  "Thai Airways",
  "Qatar Airways"
];
var flsrc = [
  "Delhi",
  "Kolkata",
  "Mumbai",
  "Chennai",
  "Goa",
  "Cochin",
  "Pune",
  "Assam",
  "Jaipur",
  "Mumbai"
];
var fldst = [
  "London",
  "Moscow",
  "Dubai",
  "Berlin",
  "Singapore",
  "Abu Dhabi",
  "Istanbul",
  "New York",
  "Bangkok",
  "Al Khor"
];
var prices = [
  40000,
  30000,
  20000,
  35000,
  20000,
  20000,
  25000,
  45000,
  20000,
  25000
];



$(document).ready(function () {
  ///////////Adding html and making the flight list visible///////

  for (var i = 0; i <= flsrno.length; i++) 
  {
    $(".flightNo" + (i + 1) + ".srno").text(flsrno[i]);
    $(".flightNo" + (i + 1) + ".flno").text(flightNumbers[i]);
    $(".flightNo" + (i + 1) + ".flnm").text(flnm[i]);
    $(".flightNo" + (i + 1) + ".flsrc").text(flsrc[i]);
    $(".flightNo" + (i + 1) + ".fldst").text(fldst[i]);
    $(".flightNo" + (i + 1) + ".flprc").text("₹" + prices[i]);
  }

  ////////////////////Main Program//////////////////////////////
  $("body").hide();
  $("body").fadeIn(1000);
  $("h2").fadeOut(10000);
  $("#moreflights").hide();
  $("#enterPassengers").hide();
  $("#reFlightNo").hide();
  $("#rePassNo").hide();
  $("#extraStuff").hide();
  $("#confirm").hide();




  $("#flightNoBtn").on("click", function ()
   {
    flight = $("#fNo").val();
    mainsystem(flight);
  });





  $(".flight").on("click", function ()
   {
    flight = $(this).attr("id");
    mainsystem(flight);
  });





  function mainsystem(flightnum) 
  {
    if (flight == "list") 
    {
      $(".flight").fadeIn(1000);
      $(".choosehead").fadeIn(500);
    } 
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
  }


  ///Starting of more flight system:

 

  //End of more flight system




  //Passenger Names:
  for (var i = 0; i < passenger; i++) {
    $("#passengerNames").append(
      '<div class="row"><div class="col-sm-6"><p class="text-right">Enter Passenger ' +
        (i + 1) +
        '\'s full name : </p></div><div class="col-sm-6"><input id="pNm" class="text-center" type="text" name="pName" placeholder="Full Name eg:Bill Gates"><br></div></div>'
    );
  }
});
