/**
 * Created by guoshencheng on 7/9/15.
 */
/**
*Url format
*http://localhost:8080/ResultView.html?backgroundId=4&imageUrl=url
 * background can be nil
 * if background is nil we get a random number for bakgroundImage
**/
var backgroundImageUrlsArray = ["img/result_view_background_image1.png",
                                "img/result_view_background_image2.png",
                                "img/result_view_background_image3.png",
                                "img/result_view_background_image4.png",
                                "img/result_view_background_image5.png",
                                "img/result_view_background_image6.png",
                                "img/result_view_background_image7.png"];
var titleArray = ['哇哦！颜值爆表！我结婚以后"靠脸"吃饭！',
                  '由于长相丑出天际，我结婚以后"靠体力"吃饭！',
                  '长得好看有人疼，我结婚以后"靠老公"吃饭！',
                  '基因这么好，我结婚以后"靠萌娃"吃饭！',
                  '长得好看又机智，我结婚以后"靠才华"吃饭！',
                  '生活在这个看脸的时代好累，我结婚以后"靠运气"吃饭！',
                  '什么鬼？我要报警了！我结婚以后"靠低保"吃饭！'];
var backgourndImage = document.getElementById("background-image");
var avatarImage = document.getElementById("avatar-image");
var shareButton = document.getElementById("share_button");
var startButton = document.getElementById("start_button");
var ruleButton = document.getElementById("rule_button");
var viewport = document.querySelector("meta[name=viewport]");
var winWidths= window.innerWidth;
var densityDpi=640/winWidths;
densityDpi= densityDpi>1?300*640*densityDpi/640:densityDpi;
if(isWeixin()){
    viewport.setAttribute('content', 'width=640, target-densityDpi='+densityDpi);
}else{
    viewport.setAttribute('content', 'width=640, user-scalable=no');
    window.setTimeout(function(){
        viewport.setAttribute('content', 'width=640, user-scalable=yes');
    },1000);
}
function isWeixin(){
    var ua = navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
        return true;
    } else {
        return false;
    }
}

var Request = GetRequest();
var imageUrl = Request['imageUrl'];
var lastAction = cookie('lastAction');
var backgroundId = Request['backgroundId'];
if (!backgroundId && ('rule' == lastAction || 'result' == lastAction)) {
    backgroundId = cookie('backgroundId');
}
if (backgroundId) {
    backgourndImage.src = backgroundImageUrlsArray[backgroundId] + '?time=' + new Date().getTime();
} else {
    var randomId = Math.round(Math.random()*6);
    backgourndImage.src = backgroundImageUrlsArray[randomId] + '?time=' + new Date().getTime();
    backgroundId = randomId;
}
cookie('lastAction', 'result', { expires: 365, path: '/' });
cookie('backgroundId', backgroundId, { expires: 365, path: '/' });

backgourndImage.onload = function () {
    configurAllContext();

    wx.config(wxConfig);
    wx.ready(function () {
        var cfg = {
            title: titleArray[backgroundId],
            link: window.location.href + "&backgroundId=" + backgroundId, //use url Format
            imgUrl: imageUrl //use imageUrl
        };
        wx.onMenuShareTimeline(cfg);
        wx.onMenuShareAppMessage(cfg);
    });
    wx.error(function (res) {
        alert(res.errMsg);
    });
}

function configurAllContext () {
    fixBackgroundPosition();
    configureStartButton();
    configureRuleButton();
    avatarImage.onload = function () {
        fixAvatarPosition();
    }
    avatarImage.src = imageUrl;
}

function fixBackgroundPosition () {
    backgourndImage.style.left = (document.body.offsetWidth - backgourndImage.width ) / 2 + "px";
}

function fixAvatarPosition () {
    avatarImage.style.width = backgourndImage.offsetHeight * (265 / 1645) + "px";
    avatarImage.style.height = backgourndImage.offsetHeight * (265 / 1645) + "px";
    avatarImage.style.left = (document.body.offsetWidth - avatarImage.width ) / 2 + "px";
    avatarImage.style.top = backgourndImage.offsetTop + backgourndImage.offsetHeight * (225 / 1645) + "px";
}

function configureShareButton () {
    shareButton.style.top = (790 / 1645) * backgourndImage.offsetHeight + "px";
    shareButton.style.width = (170 / 1645) * backgourndImage.offsetHeight + "px";
    shareButton.style.height = (35 / 1645) * backgourndImage.offsetHeight + "px";
    shareButton.style.left = (document.body.offsetWidth - shareButton.offsetWidth) / 2 + "px";
    shareButton.style.opacity = 1;
}

function configureStartButton () {
    startButton.style.top = (965 / 1645) * backgourndImage.offsetHeight + "px";
    startButton.style.width = (320 / 1645) * backgourndImage.offsetHeight + "px";
    startButton.style.height = (70 / 1645) * backgourndImage.offsetHeight + "px";
    startButton.style.left = (document.body.offsetWidth - startButton.offsetWidth) / 2 + "px";
    startButton.style.opacity = 1;
}

function configureRuleButton () {
    ruleButton.style.top = (1185 / 1645) * backgourndImage.offsetHeight + "px";
    ruleButton.style.width = (210 / 1645) * backgourndImage.offsetHeight + "px";
    ruleButton.style.height = (60 / 1645) * backgourndImage.offsetHeight + "px";
    ruleButton.style.left = (document.body.offsetWidth - ruleButton.offsetWidth) / 2 + "px";
    ruleButton.style.opacity = 1;
}

startButton.onclick = function () {
    window.location.href = "TakePhotoView.htm";
};

ruleButton.onclick = function () {
    cookie('lastAction', 'rule', { expires: 365, path: '/' });
    cookie('backgroundId', backgroundId, { expires: 365, path: '/' });
    window.location.href = "RuleView.htm";
}

function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
