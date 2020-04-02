function validate_email(email_id) {
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (reg.test(email_id) == false)
        return false;
    else
        return true;
}
///Function to Validate Mobile NO.
function validateCell(phoneVal)
        {
          console.log("%%%%%%----"+phoneVal);
          //var phoneVal=  document.getElementById("tel").value;
          if((!phoneVal)){
              return false;
          }
           else if(isNaN(phoneVal)||phoneVal.indexOf(" ")!=-1)
           {
              // alert("Enter numeric value")
              return false; 
           }
            else if (phoneVal.length>10)
           {
               // alert("enter 12 characters");
                return false;
           }
           else{
                return true
           }
        }

/***
 * Function to add the error class to the input fields parent
 **/
function add_error_class(input_id, error_text) {
    $('#' + input_id).parent().addClass('error');
    if (error_text == undefined)
        error_text = 'Required field : Please enter value.';
    $('#error_' + input_id).remove();
    var error_html = '<div id="error_' + input_id + '" class="error">' + error_text + '</div>';
    $('#' + input_id).parent().append(error_html);

}

/***
 * Function to add the error class to the input fields parent
 **/
function remove_error_class(input_id) {
    $('#' + input_id).parent().removeClass('error');
    $('#' + input_id).parent().find('.error').fadeOut(1000);
    //Hide the error message
    $('#validation_error').fadeOut(2000);
}


////change this function for contact Email

function sendMail() {
    console.log("in Send Email");
    remove_error_class('name');
    remove_error_class('mob');
    remove_error_class('email');
    remove_error_class('message');
    var name,mob,email,message;
    var error_flag=0;
    name=$("#name").val();
    mob=$("#mob").val();
    email=$("#email").val();
    message=$("#message").val();
    //Check the validation
    if (validate_email(email) === false) {
        add_error_class('email', 'Please enter the valid Email-Id.');
        error_flag = 1;
    }    
    if (email === '') {
        add_error_class('email', 'Please enter Email-Id.');
        error_flag = 1;
    }
    if (mob === '') {
        add_error_class('mob', 'Please enter  Mobile no.');
        error_flag = 1;
    }
     if (validateCell(mob) == false) {
        console.log("Mobile Validation error");
        add_error_class('mob', 'Please enter the valid Mobile No.');
        error_flag = 1;
    } 
    if (name === '') {
        add_error_class('name', 'Please enter Name.');
        error_flag = 1;
    }
    if (message === '') {
        add_error_class('message', 'Please enter  Message.');
        error_flag = 1;
    }
    if (error_flag == 0) {
        ///Add Your Email Code
       alert("Email code goes here..!");
    }
}
