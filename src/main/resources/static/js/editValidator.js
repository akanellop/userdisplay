$().ready(function() {

    $.validator.addMethod('pass', function(value, element) {
    return this.optional(element) || /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(value);
    }, "Password must contain one special character,\n one uppercase letter, one digit");
    $('#register').validate({
        rules: {
            name: {
                required:true
            },
            phone:{
                digits: true
            },
            password1:{
                minlength: 8,
                pass:true
            },
            password2:{
                minlength: 8,
                pass:true
            }
        },
        messages: {
            name: {
                required: "Name Field is required."
            },
            phone: {
                digits:"Enter valid Phone number."
            },
            password1: {
                minlength: "Password must be over 8 characters."
            },
            password2: {
                minlength: "Password must be over 8 characters."
            }
        }
    });

});

