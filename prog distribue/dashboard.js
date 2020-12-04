var flight;
var passenger;
var total;
var flightSrNo;
var checker1 = false;
var currentSrNo = 9;
var flsrno = [1, 2, 3, 4, 5, 6, 7, 8, 9];
var flightNumbers = [
  "4563",
  "8205",
  "5455",
  "2853",
  "2956",
  "2653",
  "5959",
  "2468",
  "5012"
  
];
var flnm = [
  "Maghreb Airlines",
  "Srilanka Float",
  "Air Babtou",

  "Srilanka Float",
  "Air Babtou",
  "Maghreb Airlines",

  "Srilanka Float",
  "Maghreb Airlines",
  "Air Babtou"
];
var flsrc = [
  "NYK",
  "CDG",
  "DTR",
  "CDG",
  "NYK",
  "DTR",
  "DTR",
  "CDG",
  "NYK"
];
var fldst = [
  "DTR",
  "CDG",
  "NYK",
 "NYK",
  "CDG",
  "DTR",
  "CDG",
  "NYK",
  "DTR"
];
var prices = [
  400,
  300,
  200,
  350,
  200,
  200,
  250,
  450,
  200
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
    $(".flightNo" + (i + 1) + ".flprc").text("€" + prices[i]);
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
    $("#body").hide();
    /////////////ajouter resumer de l'achat (nom,n0 vol, prix) en inserant dans le html une balise avec js
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
      else 
      {
        
        var no = "#" + flight;
        $(".flight").not(no).slideUp(1000);
        $(no).fadeIn(1200);
        $(".choosehead").fadeOut(500);
        
        
          
      }
    }
  

 

});
