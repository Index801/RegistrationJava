$(function () {
	$('#registr-form').validate({
		
		rules: {
			firstname : {
				required : true,
				minlength : 3
			},
			surname : {
				required: true,
				minlength : 3
			},
			patronymic : {
				required : true,
				minlength : 3
			},
			firstnamelatin : {
				required : true,
				minlength : 3
			},
			surnamelatin : {
				required : true,
				minlength : 3
			},
			patronymiclatin : {
				required : true,
				minlength : 3
			},
			email : {
				required : true,				
			},
			password : {
				required : true,
				minlength : 6
			},
			phone : {
				required : true,
				digits : true
			}
		}
	});
});
transliterate = (
function() {
    var rus = "щ   ш  ч  ц  ю  я  ё  ж  ъ  ы  э  а б в г д е з и й к л м н о п р с т у ф х ь".split(/ +/g),
        eng = "shh sh ch cz yu ya yo zh `` y' e` a b v g d e z i j k l m n o p r s t u f x y".split(/ +/g);
        return function(text, engToRus) {
            var x;
            for(x = 0; x < rus.length; x++) {
                text = text.split(engToRus ? eng[x] : rus[x]).join(engToRus ? rus[x] : eng[x]);
                text = text.split(engToRus ? eng[x].toUpperCase() : rus[x].toUpperCase()).join(engToRus ? rus[x].toUpperCase() : eng[x].toUpperCase());
            }
            return text;
        }
    }
)();
$(function () {
	$('.translit').on('change', function() {
		var name = '[name="'+$(this).attr('name')+'latin"]';
		var translit = transliterate($(this).val());
		$(name).val(translit);
		emailgenerate();
	});
});
function emailgenerate() {
	var firstname = $('[name=firstnamelatin]').val();
	var surname = $('[name=surnamelatin]').val();
	var patronymic = $('[name=patronymic]').val();
	if(firstname != '' & surname != '' & patronymic != '') {
		$('[name=email]').val(firstname[0]+'.'+surname);
	}
} 

