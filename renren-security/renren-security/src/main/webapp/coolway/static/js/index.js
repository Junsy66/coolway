
(function($){
		  
	$("div[data-scro='controler'] b,div[data-scro='controler2'] a").click(function(){
		var T = $(this);
		if(T.attr("class")=="down") return false;
		J2ROLLING_ANIMATION.st({
			findObject : T,
			main : T.parent().parent().find("div[data-scro='list']"),
			pagSource : T.parent().parent().find("div[data-scro='controler'] b"),
			className : "down",
			duration : "slow",
			on : $(this)[0].tagName=="A" ? true : false
		});
		return false;
	});
	
	var J2SETTIME="", J2Time=true,J2ROLLING_ANIMATION = {
		init : function(){
			this.start();
			this.time();	
		},
		st : function(o){
			if(J2Time){
				this.animate(o.findObject,o.main,o.className,o.duration,o.pagSource,o.on);
				J2Time = false;
			}
		},
		animate : function(T,M,C,S,P,O){
				var _prevDown = O ? P.parent().find("*[class='"+C+"']") : T.parent().find(T[0].tagName+"[class='"+C+"']"),
					_prevIndex = _prevDown.index(),
					_thisIndex = O ? (T.attr("class")=="next" ? _prevIndex+1 : _prevIndex-1) : T.index(),
					_list = M.find(".item"),
					p2n = 1;
				_prevDown.removeClass(C);
				if(O){
					if(_thisIndex==-1) _thisIndex=_list.size()-1;
					if(_thisIndex==_list.size()) _thisIndex=0;
					P.eq(_thisIndex).addClass(C);
				}else{
					T.addClass(C);
				}
				if(T.attr("class")=="prev" || _thisIndex<_prevIndex) p2n = false;
				if((T.attr("class")=="next" || _thisIndex>_prevIndex)&&T.attr("class")!="prev") p2n = true;
				
				!p2n ? _list.eq(_thisIndex).css("left",-M.width()) : '';
				_list.eq(_prevIndex).animate({left:p2n ? -M.width() : M.width()},S,function(){
					$(this).removeAttr("style");	
					J2Time = true;
				});
				_list.eq(_thisIndex).animate({left:"0px"},S);
		},
		start : function(){
			$("#section-focus-pic div[data-scro='controler'] b,#section-focus-pic div[data-scro='controler2'] a").mouseover(function(){
				window.clearInterval(J2SETTIME);																			   
			}).mouseout(function(){
				J2ROLLING_ANIMATION.time();
			});
		},
		time : function(){
			J2SETTIME = window.setInterval(function(){
				var num = $("#section-focus-pic div[data-scro='controler'] b[class='down']").index(),
					_list = $("#section-focus-pic div[data-scro='list'] li");
				_list.eq(num).animate({"left":-$("#section-focus-pic div[data-scro='list']").width()},"slow",function(){
					$(this).removeAttr("style");	
					$("#section-focus-pic div[data-scro='controler'] b").removeClass("down").eq(num).addClass("down");
				});	
				num++;
				if(num==_list.size()){
					num=0;
				}
				_list.eq(num).animate({"left":"0px"},"slow");		
			},4000);
		}
	};
	$("a").click(function(){
		$(this).blur();				  
	});
	
	J2ROLLING_ANIMATION.init();	
})(this.jQuery || this.baidu);

/*
 *
 * Copyright (c) 2014 Daniele Lenares (https://github.com/Ryuk87)
 * Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
 * and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
 * 
 * Version 0.5.1
 *
 */
(function ( $ ) {
	
	$.goup = function(user_params) {
		
		/* Default Params */
		var params = $.extend({
				location : 'right',
				locationOffset : 20,
				bottomOffset : 10,
				containerRadius : 10,
				containerClass : 'goup-container',
				arrowClass : 'goup-arrow',
				alwaysVisible : false,
				trigger: 500,
				entryAnimation : 'fade',
				goupSpeed : 'slow',
				hideUnderWidth : 500,
				containerColor : '#000',
				arrowColor : '#fff',
                title : '',
                titleAsText : false,
                titleAsTextClass : 'goup-text'
			}, user_params);
		/* */
		
		
		$('body').append('<div style="display:none" class="'+params.containerClass+'"></div>');
		var container = $('.'+params.containerClass);
		$(container).html('<div class="'+params.arrowClass+'"></div>');
		var arrow = $('.'+params.arrowClass);
		
		/* Parameters check */
		var location = params.location;
		if (location != 'right' && location != 'left') {
			location = 'right';
		}
		
		var locationOffset = params.locationOffset;
		if (locationOffset < 0) {
			locationOffset = 0;
		}
		
		var bottomOffset = params.bottomOffset;
		if (bottomOffset < 0) {
			bottomOffset = 0;
		}
		
		var containerRadius = params.containerRadius
		if (containerRadius < 0) {
			containerRadius = 0;
		}
		
		var trigger = params.trigger;
		if (trigger < 0) {
			trigger = 0;
		}
		
		var hideUnderWidth = params.hideUnderWidth;
		if (hideUnderWidth < 0) {
			hideUnderWidth = 0;
		}
		
		var checkColor = /(^#[0-9A-F]{6}$)|(^#[0-9A-F]{3}$)/i;
		if (checkColor.test(params.containerColor)) {
			var containerColor = params.containerColor;
		} else {
			var containerColor = '#000';
		}
		if (checkColor.test(params.arrowColor)) {
			var arrowColor = params.arrowColor;
		} else {
			var arrowColor = '#fff';
		}
        
        if (params.title === '') {
            params.titleAsText = false;
        }
		/* */
		
		/* Container Style */
		var containerStyle = {};
		containerStyle = {
			position : 'fixed',
			width : 40,
			height : 40,
			background : 'rgba(183,182,191,0.5)',
			cursor: 'pointer'
		};
		containerStyle['bottom'] = bottomOffset;
		containerStyle[location] = locationOffset;
		containerStyle['border-radius'] = containerRadius;
		
		$(container).css(containerStyle);
        if (!params.titleAsText) {
            $(container).attr('title', params.title);
        } else {
            $('body').append('<div class="'+params.titleAsTextClass+'">'+params.title+'</div>');
            var textContainer = $('.'+params.titleAsTextClass);
            $(textContainer).attr('style', $(container).attr('style'));
            $(textContainer).css('background','transparent')
                           .css('width',80)
                           .css('height','auto')
                           .css('text-align','center')
                           .css('font-size','12px')
                           .css('color','rgb(183,182,191)')
                           .css(location,locationOffset - 20);
            var containerNewBottom = $(textContainer).height() + 10;
            $(container).css('bottom', '+='+containerNewBottom+'px');
        }
            
		
		/* Arrow Style */		
		var arrowStyle = {};
		arrowStyle = {
			width : 0,
			height : 0,
			margin : '0 auto',
			'padding-top' : 13,
			'border-style' : 'solid',
			'border-width' : '0 10px 10px 10px',
			'border-color' : 'transparent transparent '+arrowColor+' transparent' 
		};
		$(arrow).css(arrowStyle);
		/* */
		
		
		
		/* Trigger Hide under a certain width */
		var isHidden = false;
		$(window).resize(function(){
			if ($(window).outerWidth() <= hideUnderWidth) {
				isHidden = true;
				do_animation($(container), 'hide', params.entryAnimation);
                if (textContainer)
                    do_animation($(textContainer), 'hide', params.entryAnimation);
			} else {
				isHidden = false;
				$(window).trigger('scroll');
			}
		});
		/* If i load the page under a certain width, i don't have the event 'resize' */
		if ($(window).outerWidth() <= hideUnderWidth) {
			isHidden = true;
			$(container).hide();
            if (textContainer)
                $(textContainer).hide();
		}
		
		
		/* Trigger show event */
		if (!params.alwaysVisible) {
			$(window).scroll(function(){
				if ($(window).scrollTop() >= trigger && !isHidden) {
					do_animation($(container), 'show', params.entryAnimation);
                    if (textContainer)
                        do_animation($(textContainer), 'show', params.entryAnimation);
				}
				
				if ($(window).scrollTop() < trigger && !isHidden) {
					do_animation($(container), 'hide', params.entryAnimation);
                    if (textContainer)
                        do_animation($(textContainer), 'hide', params.entryAnimation);
				}
			});
		} else {
			do_animation($(container), 'show', params.entryAnimation);
            if (textContainer)
                do_animation($(textContainer), 'show', params.entryAnimation);
		}
		/* If i load the page and the scroll is over the trigger, i don't have immediately the event 'scroll' */
		if ($(window).scrollTop() >= trigger && !isHidden) {
			do_animation($(container), 'show', params.entryAnimation);
            if (textContainer)
                do_animation($(textContainer), 'show', params.entryAnimation);
		}
		
		/* Click event */
		$(container).on('click', function(){
			$('html,body').animate({ scrollTop: 0 }, params.goupSpeed);
			return false;
		});		
        
        $(textContainer).on('click', function(){
			$('html,body').animate({ scrollTop: 0 }, params.goupSpeed);
			return false;
		});
	};
	
	
	/* Private function for the animation */
	function do_animation(obj, type, animation) {
		if (type == 'show') {
			switch(animation) {
				case 'fade':
					obj.fadeIn();
				break;
				
				case 'slide':
					obj.slideDown();
				break;
				
				default:
					obj.fadeIn();
			}
		} else {
			switch(animation) {
				case 'fade':
					obj.fadeOut();
				break;
				
				case 'slide':
					obj.slideUp();
				break;
				
				default:
					obj.fadeOut();
			}
		}
	}
	
}( jQuery ));
