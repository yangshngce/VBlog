'use strict';
$(function () {
    $(".zoom-container").click(function () {
        var url="http://localhost:8080/VBlog_war/playVideo";
        var data={
            videoName:$(this).attr("videoName")
        };
        $.ajax({
            url:url,
            data:data?data:{},
            datatype:"json",
            type:"get",
            success:null
        });
    })
})
console.log("8888888888");
var url="http://localhost:8080/VBlog_war/session";
var data=null;
$.ajax({
    url:url,
    data:data?data:{},
    datatype:"json",
    type:"get",
    success:function(da){
        console.log(da);
        if (da.code == "3001") { //判断返回值，这里根据的业务内容可做调整
            $("#personalA").text("PersonalZone");
            $("#personalA").attr('href',"statics/user.html");
        } else if (da.code == "3000"){
            $("#personalA").text("LOGIN");
            $("#personalA").attr('href',"statics/index_login.html");
        }
    }
});
/*$().myAjaxGet(url,data,function(da){
    console.log(da);
    if (da.code == "3001") { //判断返回值，这里根据的业务内容可做调整
        $("#personalA").text("PersonalZone");
        $("#personalA").attr('href',"statics/yuyy_html_test/personalZone.html");
    } else if (da.code == "3000"){
        $("#personalA").text("LOGIN");
        $("#personalA").attr('href',"statics/index_login.html");
    }
},"get");*/
var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

/*
  More about this function - 
  https://codepen.io/rachsmith/post/animation-tip-lerp
*/
function lerp(_ref, _ref2) {
  var x = _ref.x;
  var y = _ref.y;
  var targetX = _ref2.x;
  var targetY = _ref2.y;

  var fraction = 0.2;

  x += (targetX - x) * fraction;
  y += (targetY - y) * fraction;

  return { x: x, y: y };
}

var Slider = function () {
  function Slider(el) {
    _classCallCheck(this, Slider);

    var imgClass = this.IMG_CLASS = 'slider__images-item';
    var textClass = this.TEXT_CLASS = 'slider__text-item';
    var activeImgClass = this.ACTIVE_IMG_CLASS = imgClass + '--active';
    var activeTextClass = this.ACTIVE_TEXT_CLASS = textClass + '--active';

    this.el = el;
    this.contentEl = document.getElementById('slider-content');
    this.onMouseMove = this.onMouseMove.bind(this);

    // taking advantage of the live nature of 'getElement...' methods
    //this.activeImg = el.getElementsByClassName(activeImgClass);
    //this.activeText = el.getElementsByClassName(activeTextClass);
    //this.images = el.getElementsByTagName('img');

    //document.getElementById('slider-dots').addEventListener('click', this.onDotClick.bind(this));

    //document.getElementById('left').addEventListener('click', this.prev.bind(this));

    //document.getElementById('right').addEventListener('click', this.next.bind(this));

    //window.addEventListener('resize', this.onResize.bind(this));

    this.onResize();

    //this.length = this.images.length;
    this.lastX = this.lastY = this.targetX = this.targetY = 0;
  }

  Slider.prototype.onResize = function onResize() {
    var htmlStyles = getComputedStyle(document.documentElement);
    var mobileBreakpoint = htmlStyles.getPropertyValue('--mobile-bkp');

    var isMobile = this.isMobile = matchMedia('only screen and (max-width: ' + mobileBreakpoint + ')').matches;

    this.halfWidth = innerWidth / 2;
    this.halfHeight = innerHeight / 2;
    this.zDistance = htmlStyles.getPropertyValue('--z-distance');

    if (!isMobile && !this.mouseWatched) {
      this.mouseWatched = true;
      //this.el.addEventListener('mousemove', this.onMouseMove);
      //this.el.style.setProperty('--img-prev', 'url(' + this.images[+this.activeImg[0].dataset.id - 1].src + ')');
      //this.contentEl.style.setProperty('transform', 'translateZ(' + this.zDistance + ')');
    } else if (isMobile && this.mouseWatched) {
      this.mouseWatched = false;
      //this.el.removeEventListener('mousemove', this.onMouseMove);
      //this.contentEl.style.setProperty('transform', 'none');
    }
  };

  Slider.prototype.getMouseCoefficients = function getMouseCoefficients() {
    var _ref3 = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];

    var pageX = _ref3.pageX;
    var pageY = _ref3.pageY;

    var halfWidth = this.halfWidth;
    var halfHeight = this.halfHeight;
    var xCoeff = ((pageX || this.targetX) - halfWidth) / halfWidth;
    var yCoeff = (halfHeight - (pageY || this.targetY)) / halfHeight;

    return { xCoeff: xCoeff, yCoeff: yCoeff };
  };

  Slider.prototype.onMouseMove = function onMouseMove(_ref4) {
    var pageX = _ref4.pageX;
    var pageY = _ref4.pageY;

    this.targetX = pageX;
    this.targetY = pageY;

    if (!this.animationRunning) {
      this.animationRunning = true;
      this.runAnimation();
    }
  };

  Slider.prototype.runAnimation = function runAnimation() {
    if (this.animationStopped) {
      this.animationRunning = false;
      return;
    }

    var maxX = 10;
    var maxY = 10;

    var newPos = lerp({
      x: this.lastX,
      y: this.lastY
    }, {
      x: this.targetX,
      y: this.targetY
    });

    var _getMouseCoefficients = this.getMouseCoefficients({
      pageX: newPos.x,
      pageY: newPos.y
    });

    var xCoeff = _getMouseCoefficients.xCoeff;
    var yCoeff = _getMouseCoefficients.yCoeff;

    this.lastX = newPos.x;
    this.lastY = newPos.y;

    this.positionImage({ xCoeff: xCoeff, yCoeff: yCoeff });

    this.contentEl.style.setProperty('transform', '\n      translateZ(' + this.zDistance + ')\n      rotateX(' + maxY * yCoeff + 'deg)\n      rotateY(' + maxX * xCoeff + 'deg)\n    ');

    if (this.reachedFinalPoint) {
      this.animationRunning = false;
    } else {
      requestAnimationFrame(this.runAnimation.bind(this));
    }
  };

  Slider.prototype.positionImage = function positionImage(_ref5) {
    var xCoeff = _ref5.xCoeff;
    var yCoeff = _ref5.yCoeff;

    var maxImgOffset = 1;
    var currentImage = this.activeImg[0].children[0];

    currentImage.style.setProperty('transform', '\n      translateX(' + maxImgOffset * -xCoeff + 'em)\n      translateY(' + maxImgOffset * yCoeff + 'em)\n    ');
  };

  Slider.prototype.onDotClick = function onDotClick(_ref6) {
    var target = _ref6.target;

    if (this.inTransit) return;

    var dot = target.closest('.slider__nav-dot');

    if (!dot) return;

    var nextId = dot.dataset.id;
    var currentId = this.activeImg[0].dataset.id;

    if (currentId == nextId) return;

    this.startTransition(nextId);
  };

  Slider.prototype.transitionItem = function transitionItem(nextId) {
    var _this = this;

    function onImageTransitionEnd(e) {
      e.stopPropagation();

      nextImg.classList.remove(transitClass);

      self.inTransit = false;

      this.className = imgClass;
      this.removeEventListener('transitionend', onImageTransitionEnd);
    }

    var self = this;
    var el = this.el;
    var currentImg = this.activeImg[0];
    var currentId = currentImg.dataset.id;
    var imgClass = this.IMG_CLASS;
    var textClass = this.TEXT_CLASS;
    var activeImgClass = this.ACTIVE_IMG_CLASS;
    var activeTextClass = this.ACTIVE_TEXT_CLASS;
    var subActiveClass = imgClass + '--subactive';
    var transitClass = imgClass + '--transit';
    var nextImg = el.querySelector('.' + imgClass + '[data-id=\'' + nextId + '\']');
    var nextText = el.querySelector('.' + textClass + '[data-id=\'' + nextId + '\']');

    var outClass = '';
    var inClass = '';

    this.animationStopped = true;

    nextText.classList.add(activeTextClass);

    el.style.setProperty('--from-left', nextId);

    currentImg.classList.remove(activeImgClass);
    currentImg.classList.add(subActiveClass);

    if (currentId < nextId) {
      outClass = imgClass + '--next';
      inClass = imgClass + '--prev';
    } else {
      outClass = imgClass + '--prev';
      inClass = imgClass + '--next';
    }

    nextImg.classList.add(outClass);

    requestAnimationFrame(function () {
      nextImg.classList.add(transitClass, activeImgClass);
      nextImg.classList.remove(outClass);

      _this.animationStopped = false;
      _this.positionImage(_this.getMouseCoefficients());

      currentImg.classList.add(transitClass, inClass);
      //currentImg.addEventListener('transitionend', onImageTransitionEnd);
    });

    if (!this.isMobile) this.switchBackgroundImage(nextId);
  };

  Slider.prototype.startTransition = function startTransition(nextId) {
    function onTextTransitionEnd(e) {
      if (!e.pseudoElement) {
        e.stopPropagation();

        requestAnimationFrame(function () {
          self.transitionItem(nextId);
        });

        this.removeEventListener('transitionend', onTextTransitionEnd);
      }
    }

    if (this.inTransit) return;

    var activeText = ""//this.activeText[0];
    var backwardsClass = this.TEXT_CLASS + '--backwards';
    var self = this;

    this.inTransit = true;

    activeText.classList.add(backwardsClass);
    activeText.classList.remove(this.ACTIVE_TEXT_CLASS);
    //activeText.addEventListener('transitionend', onTextTransitionEnd);

    requestAnimationFrame(function () {
      activeText.classList.remove(backwardsClass);
    });
  };

  Slider.prototype.next = function next() {
    if (this.inTransit) return;

    var nextId = 0;//+this.activeImg[0].dataset.id + 1;

    if (nextId > this.length) nextId = 1;

    this.startTransition(nextId);
  };

  Slider.prototype.prev = function prev() {
    if (this.inTransit) return;

    var nextId = +this.activeImg[0].dataset.id - 1;

    if (nextId < 1) nextId = this.length;

    this.startTransition(nextId);
  };

  Slider.prototype.switchBackgroundImage = function switchBackgroundImage(nextId) {
    function onBackgroundTransitionEnd(e) {
      if (e.target === this) {
        this.style.setProperty('--img-prev', imageUrl);
        this.classList.remove(bgClass);
        this.removeEventListener('transitionend', onBackgroundTransitionEnd);
      }
    }

    var bgClass = 'slider--bg-next';
    var el = this.el;
    var imageUrl = 'url(' + this.images[+nextId - 1].src + ')';

    el.style.setProperty('--img-next', imageUrl);
    //el.addEventListener('transitionend', onBackgroundTransitionEnd);
    el.classList.add(bgClass);
  };

  _createClass(Slider, [{
    key: 'reachedFinalPoint',
    get: function get() {
      var lastX = ~ ~this.lastX;
      var lastY = ~ ~this.lastY;
      var targetX = this.targetX;
      var targetY = this.targetY;

      return (lastX == targetX || lastX - 1 == targetX || lastX + 1 == targetX) && (lastY == targetY || lastY - 1 == targetY || lastY + 1 == targetY);
    }
  }]);

  return Slider;
}();

var sliderEl = document.getElementById('slider');
var slider = new Slider(sliderEl);

// ------------------ Demo stuff ------------------------ //

var timer = 0;

function autoSlide() {
  requestAnimationFrame(function () {
    slider.next();
  });

  timer = setTimeout(autoSlide, 5000);
}

function stopAutoSlide() {
  clearTimeout(timer);

  this.removeEventListener('touchstart', stopAutoSlide);
  this.removeEventListener('mousemove', stopAutoSlide);
}

//sliderEl.addEventListener('mousemove', stopAutoSlide);
//sliderEl.addEventListener('touchstart', stopAutoSlide);
timer = setTimeout(autoSlide, 2000);

console.log("99999999999999");
var url="http://localhost:8080/VBlog_war/session";
var data=null;
$.ajax({
    url:url,
    data:data?data:{},
    datatype:"json",
    type:"get",
    success:function(da){
        console.log(da);
        if (da.code == "3001") { //判断返回值，这里根据的业务内容可做调整
            $("#personalA").text("PersonalZone");
            $("#personalA").attr('href',"statics/user.html");
        } else if (da.code == "3000"){
            $("#personalA").text("LOGIN");
            $("#personalA").attr('href',"statics/index_login.html");
        }
    }
});
//加载主页数据
var url="http://localhost:8080/VBlog_war/mainLoadData";
var data=null;
$.ajax({
    url:url,
    data:data?data:{},
    datatype:"json",
    type:"get",
    success:function(da){
        console.log(da);
        for(var i=0;i<35;i++){
            var tempId="#video"+(i+1);
            $(tempId).attr('videoName',da[i].videoName);
            $(tempId).attr('videoUsr',da[i].uploadUsr);
            $(tempId).attr('videoTime',da[i].createTime);
            $(tempId).attr('imageUrl',da[i].imageUrl);
        }
        $(".low .zoom-container").siblings(".vid-name").css('background-color', 'red');
        $(".low .zoom-container").siblings(".info").css('background-color', 'red');
        $(".low .zoom-container").siblings(".info").children("h5").children("a").css('background-color', 'red');


        $(".low .zoom-container").siblings(".vid-name").children("a").text($(".zoom-container").attr('videoName'));
        $(".low .zoom-container").siblings(".info").children("span").text($(".zoom-container").attr('videoTime'));
        $(".low .zoom-container").siblings(".info").children("h5").children("a").text($(".zoom-container").attr('videoUsr'));
        /*for(var i=0;i<$(" .zoom-container").length;i++){
            console.log("i==="+i);

                $(".low .zoom-container")[i].siblings(".vid-name").text($(".zoom-container")[i].videoName);
                $(".low .zoom-container")[i].siblings(".info span").text($(".zoom-container")[i].videoTime);
                $(".low .zoom-container")[i].siblings(".info h5 a").text($(".zoom-container")[i].videoUsr);

        }*/

    }

});


//ajaxGet提交
$.fn.myAjaxGet=function (u,d,fn,type) {
    $.ajax({
        url:u,
        data:d?d:{},
        datatype:"json",
        type:type,
        success:fn?fn:null
    });

};
