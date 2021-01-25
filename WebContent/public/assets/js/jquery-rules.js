//VALIDATIONS
$(document).ready(function(){
	
	//Validation of all fields with rules and messages
	
	$('#form').validate({ //Find the form by id
		rules: { //Validation rules for fields
			code: {
				required: true,
		 	},
		  	merchandiseType: {
		    	required: true,
		  	},
		  	name: {
		    	required: true,
		  	},
		  	quantity: { 
		    	required: true,
		    	digits: true,
		  	},
		  	price: {
		    	required: true,
		  	},
		  	businessType: {
		    	required: true,
		  	},
		},
		messages: { //Notifications for fields
		    code: {
		    	required: "Digite o codigo da mercadoria",
		    },
		    merchandiseType: {
		    	required: "Digite o tipo da mercadoria",
		    },
		    name: {
		    	required: "Digite o nome da mercadoria",
		    },
		    quantity: {
		    	required: "Digite a quantidade",
		    	digits: "Numero de quantidade invalido",
		    },
		    price: {
		    	required: "Digite o valor",
		    },
		    businessType: {
		    	required: "Escolha o tipo de negocio",
		    },
		},
		highlight: function(element) {
			$(element).closest('.control-group').removeClass('success').addClass('error').addClass('invalid');
		},
		success: function(element) {
			element
			.text('OK!').addClass('valid')
			.closest('.control-group').removeClass('error').addClass('success');
		}
	});

	//Mask for the price field
	$("#price").mask('000.000.000.000.000,00', {reverse: true});

}); // end document.ready