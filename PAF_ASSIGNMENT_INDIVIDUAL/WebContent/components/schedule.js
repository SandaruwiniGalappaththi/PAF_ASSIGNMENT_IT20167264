/**
 * 
 */

$(document).ready(function() 
{ 
if ($("#alertSuccess").text().trim() == "") 
 { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
}); 
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "ScheduleAPI",
 type : type,
 data : $("#formItem").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onItemSaveComplete(response.responseText, status);
 }
 });
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidItemIDSave").val($(this).data("itemid")); 
 $("#location").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#start").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#end").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#date").val($(this).closest("tr").find('td:eq(3)').text()); 
}); 
// CLIENT-MODEL================================================================
function validateItemForm() 
{ 
// CODE
if ($("#location").val().trim() == "") 
 { 
 return "Insert location"; 
 } 
// NAME
if ($("#start").val().trim() == "") 
 { 
 return "Insert start time."; 
 }
// PRICE-------------------------------
if ($("#end").val().trim() == "") 
 { 
 return "Insert end time."; 
 } 
// DESCRIPTION------------------------
if ($("#date").val().trim() == "") 
 { 
 return "Insert date"; 
 } 
return true; 
}



function onItemSaveComplete(response, status)
{
if (status == "success")
 {

$("#alertSuccess").text("Successfully saved.");
$("#alertSuccess").show();
$("#hidItemIDSave").val("");
$("#formItem")[0].reset();
 var resultSet = JSON.parse(response);
$("#divItemsGrid").html(resultSet.data);


 if (resultSet.status.trim() == "success")
 {

 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 } 
 $("#hidItemIDSave").val("");
 $("#formItem")[0].reset();
}



$(document).on("click", ".btnRemove", function(event)
{
 $.ajax(
 {
 url : "ScheduleAPI",
 type : "DELETE",
 data : "itemID=" + $(this).data("itemid"),
 dataType : "text",
 complete : function(response, status)
 {

 onItemDeleteComplete(response.responseText, status);
 }
 });
});

function onItemDeleteComplete(response, status)
{
if (status == "success")
 {
 alert("successfully deleted!");
   $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}


