<%@ page session="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>股道158</title>
<style type="text/css">
@import url("<%=request.getContextPath()%>/css/index.css");
@import url("<%=request.getContextPath()%>/css/gd158.css");

body {
	margin:0px;
	font-size:9pt;
	text-align:center;
}
</style>


<script  language="javascript"  src="<%=request.getContextPath()%>/js/lib/jquery-1.6.2.js"  type="text/javascript"></script>

<script language="javascript">
$(document).ready(function(){
	//遮罩层初始化-->隐藏	
	$(".img_mask_310_168_ie").hide();
	//对话框初始化-->hide()
	$('div[id*=dialog_]').hide();
	
	//单一新闻图片显示遮罩层
	$("img[width=310]").mouseover(function () {
			var newsindex=$("img[width=310]").index(this);
			$(".img_mask_310_168_ie:eq("+newsindex+")").show();
		  }
		);
	//单一新闻图片隐藏遮罩
	$(".img_mask_310_168_ie").mouseout(function(){
			var outindex=$("li").index(this);
			$("li:eq("+outindex+")").hide();
		});
	//导航栏控制
	$("#nav li").mouseover(function(){
		var sindex=$("#nav>ul>li").index(this);
		showDialog(sindex);
		});	
	$('div[id*=dialog_]').mouseout(function(){
		$('div[id*=dialog_]').hide();
		});
});

function showDialog(sindex){
	$('div[id*=dialog_]').hide();
	
	$('div[id*=dialog_'+sindex+']').show();
			
	}

</script>

</head>


<body>






<div id="dialog_2" class="">
</div>
<div id="dialog_3" class="">
</div>

<div class=" spear_5"></div>

<div id="top">
	<div id="icon">
    	<li><img src="<%=request.getContextPath()%>/imgs/icon.png" width="105" height="25" alt="Gd158" longdesc="http://www.gd158.net" />
           	
            <span>账户类型：读者|</span>
            <span>切换账户类型</span>
        	<div id="idinfo">
           	高绪杨 账户金额:10000点
            </div>
        </li>
    </div>
    <div class=" spear_5"></div>
    <div id="nav">
        	<ul  class=" margin_top_15 width_450 float_left">
        		<li class="margin_left_15  list_type_style_none float_left"><a href="#" class="a_nav">主页</a></li>
        		<li class="list_type_style_none float_left margin_left_15">
                	<a href="#"  class="a_nav">个人中心</a>
                	<div id="dialog_1" class=" border_radius_5px text_align_center  nav_top  bg_color_gray1 transparent  ">
						<ul id="nav_list" class=" margin_bottom_10 margin_left_10  margin_top_10 margin_right_10  bg_color_white   transparent_ie_100 transparent_ff_100">
                          	<a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	我的书架
                                </li>
                            </a>
                         	<a href="#" class="font_color_000000 text-decoration_none a_menu">    
                        		<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                        			我的订阅
                        		</li>
                        	</a>
                            <a href="#" class="font_color_000000 text-decoration_none a_menu">
                                <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">
                                    修改个人信息
                                </li>
                            </a>
                             <a href="#" class="font_color_000000 text-decoration_none a_menu">
                                <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">
                                   我要充值
                                </li>
                             </a>
                              <a href="#" class="font_color_000000 text-decoration_none a_menu">
                                <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">
                                   我要提现
                                </li>
                               </a>
                              <a href="#" class="font_color_000000 text-decoration_none a_menu"> 
                                <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">
                                    账户查询
                                </li>
                            	</a>
                        </ul>
					</div>
                </li>
            	<li class="list_type_style_none float_left margin_left_15">
                	<a href="#" class="a_nav">排行榜</a>
                    <div id="dialog_2" class=" border_radius_5px text_align_center  nav_top  bg_color_gray1 transparent  ">
						<ul id="nav_list" class=" margin_bottom_10 margin_left_10  margin_top_10 margin_right_10  bg_color_white   transparent_ie_100 transparent_ff_100">
                        <a href="#" class="font_color_000000 text-decoration_none a_menu">
                        <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">24小时排行</li>
                        </a>
                        <a href="#" class="font_color_000000 text-decoration_none a_menu">
                        <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">48小时排行</li>
                        </a>
                        <a href="#" class="font_color_000000 text-decoration_none a_menu">
                        <li  class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">72小时排行</li>
                        </a>
                        <a href="#" class="font_color_000000 text-decoration_none a_menu">
                        <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">7天排行</li>
                        </a>
                        <a href="#" class="font_color_000000 text-decoration_none a_menu">
                        <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">30天排行</li>
                        </a>
                        <a href="#" class="font_color_000000 text-decoration_none a_menu">
                        <li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5 padding_bottom_5 bg_color_white nav_menu">90天排行</li>
                        </a>
                        </ul>
					</div>
                </li>
            	<li class="list_type_style_none float_left margin_left_15">
                	<a href="#" class="a_nav">分类中心</a>
                     <div id="dialog_3" class=" border_radius_5px text_align_center  nav_top  bg_color_gray1 transparent">
						<ul id="nav_list" class=" margin_bottom_10 margin_left_10  margin_top_10 margin_right_10  bg_color_white   transparent_ie_100 transparent_ff_100">
                         	<a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	行业分类
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	行业分类
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	行业分类
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	行业分类
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	行业分类
                                </li>
                            </a>
                        </ul>
					</div>
                </li>
            	<li class="list_type_style_none float_left margin_left_15"><a href="#" class="a_nav">帮助</a>
                <div id="dialog_4" class=" border_radius_5px text_align_center  nav_top  bg_color_gray1 transparent">
						<ul id="nav_list" class=" margin_bottom_10 margin_left_10  margin_top_10 margin_right_10  bg_color_white   transparent_ie_100 transparent_ff_100">
                         	<a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	帮助1
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	帮助1
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	帮助1
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	帮助1
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	帮助1
                                </li>
                            </a>
                        </ul>
					</div>
                </li>
            	<li class="list_type_style_none float_left margin_left_15"><a href="#" class="a_nav">登录</a>
                <div id="dialog_5" class=" border_radius_5px text_align_center  nav_top  bg_color_gray1 transparent">
						<ul id="nav_list" class=" margin_bottom_10 margin_left_10  margin_top_10 margin_right_10  bg_color_white   transparent_ie_100 transparent_ff_100">
                         	<a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	网站登录
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	网站登出
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	忘记密码
                                </li>
                            </a>
                            <a href="#" class=" font_color_000000 text-decoration_none">
                            	<li class="list_type_style_none  padding_left_10 padding_right_10 padding_top_5  padding_bottom_5 bg_color_white nav_menu">
                            	  	邀请我的朋友
                                </li>
                            </a>
                  
                        </ul>
					</div>
                
                
                </li>
            </ul>
            
            <ul id="search" class=" margin_top_15  float_left width_450 list_type_style_none">
            	<li class="list_type_style_none float_right margin_right_15"><img src="<%=request.getContextPath()%>/imgs/search_1.png"/></li>
            	<li class="list_type_style_none float_right margin_right_15"><input name="" type="text" /></li>
            	<li class="list_type_style_none float_right margin_right_15"><img src="<%=request.getContextPath()%>/imgs/Arrow_1.png"/></li>
        		<li class="list_type_style_none float_right margin_right_15"><a href="#" class="a_nav">搜索类型</a></li>
      		</ul>    
    </div>
</div>
<!--又见分割线-->
<div class=" spear_15"></div>

<div id="FirstNews" class="box_out border_radius_0px " >
<ul class=" width_900 height_44">
	<li class="list_type_style_none float_left"><div id="daliybox" class="bg_color_black" ><span>6月<br/>25日</span></div></li>
    <li class="list_type_style_none float_left title_1">今日头条</li>
</ul>
<ul class=" float_left  text_vertical_mid" >
<li class=" list_type_style_none  width_465 float_left"><img src="<%=request.getContextPath()%>/imgs/default_topnews.png" width="465" height="245" alt="今日头条" /></li>
<li class=" list_type_style_none  width_500 height_105 float_left margin_left_15 font_size_30 text_align_left">Top News:FaceBook Names 1st Woman to Board,China Targets US Home,And More</li>
<li class=" list_type_style_none  width_500 height_20 float_left margin_left_15 font_color_999999 text_align_left">inkedin.com · 4 days ago</li>
<li class=" list_type_style_none  width_500 height_90 float_left margin_left_15 text_align_left">Facebook,facing crtiicism</li>
<li class=" list_type_style_none  width_515 height_30 float_left bg_color_gray1 text_line_height_25 font_color_999999 text_align_left" >
       	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left  margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
</li>
</ul>
</div>
<!--又见分割线-->
<div class=" spear_15"></div>
<div class=" margin_bottom_5 box_out border_radius_5px width_980  height_100per text_align_left   ">

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>


<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul >
		<li class=" list_type_style_none bg_color_black height_35 border_top_1px_white border_bottom_1px_gary ">
        	<span class="margin_left_10  margin_top_10 text_align_left font_size_14 font_color_ffffff float_left">我的书架[17-30]</span>
        	<span class="float_right margin_right_15 margin_top_10"><img src="<%=request.getContextPath()%>/imgs/arrow2.gif" width="6" height="11" /></span>
        </li>
        <li class=" list_type_style_none bg_color_gray1 height_30 border_top_1px_white border_bottom_1px_gary  ">
        	<span class=" margin_left_10 margin_top_10 float_left">1.<<开开心心炒股票>></span>
            <span class=" float_right margin_right_10 m margin_top_10">点击查看</span>
        </li>
        <li class=" list_type_style_none bg_color_gray1 height_30 border_top_1px_white border_bottom_1px_gary ">
            <span class="  margin_left_10 margin_top_10 float_left">2.<<又开开心心炒股票>></span>
            <span class=" float_right margin_right_10 margin_top_10">点击查看</span>
        </li>
        <li class=" list_type_style_none bg_color_gray1 height_30 border_top_1px_white border_bottom_1px_gary ">
            <span class="  margin_left_10 margin_top_10 float_left">3.<<再开开心心炒股票>></span>
            <span class=" float_right margin_right_10 margin_top_10">点击查看</span>
        </li>
        <li class=" list_type_style_none bg_color_gray1 height_30 border_top_1px_white border_bottom_1px_gary ">
            <span class="  margin_left_10 margin_top_10 float_left">4.<<高叔的炒股心得>></span>
            <span class=" float_right margin_right_10 margin_top_10">点击查看</span>
        </li>
        <li class=" list_type_style_none bg_color_gray1 height_30 border_top_1px_white border_bottom_1px_gary ">
            <span class="  margin_left_10 margin_top_10 float_left">5.<<徐叔的炒股心得>></span>
            <span class=" float_right margin_right_10 margin_top_10">点击查看</span>
        </li>
        <li class=" list_type_style_none bg_color_gray1 height_30 border_top_1px_white border_bottom_1px_gary ">
            <span class="  margin_left_10 margin_top_10 float_left">6.<<赵小弟的炒股心得>></span>
            <span class=" float_right margin_right_10 margin_top_10">点击查看</span>
        </li>

        <li class=" list_type_style_none bg_color_black height_30 border_top_1px_white border_bottom_1px_gary ">
        	<span class="margin_left_10  margin_top_10 text_align_left font_size_14 font_color_ffffff float_left">我的书柜[30-50]</span>
        	<span class="float_right margin_right_15 margin_top_10"><img src="<%=request.getContextPath()%>/imgs/arrow2.gif" width="6" height="11" /></span>
  </li>
        <li class=" list_type_style_none bg_color_black height_35 border_top_1px_white border_bottom_1px_gary ">
        	<span class="margin_left_10  margin_top_10 text_align_left font_size_14 font_color_ffffff float_left">定制中心</span>
        	<span class="float_right margin_right_15 margin_top_10"><img src="<%=request.getContextPath()%>/imgs/arrow2.gif" width="6" height="11" /></span>
      </li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="">
 		<li class="list_type_style_none height_25 border_bottom_1px_gary">
        	<span class="float_left"><img src="<%=request.getContextPath()%>/imgs/icon_2.png" width="52" height="25" /></span>
            <span class=" margin_left_10  margin_top_10 text_align_left font_size_14  float_left">新加入的站友列表</span>
        </li>
        <li class="list_type_style_none height_70 border_top_1px_white border_bottom_1px_gary">
        	<span class="margin_top_10 float_left"><img src="<%=request.getContextPath()%>/imgs/zt_1.png" width="52" height="52" class=" border_1px"/></span>
            <span class="float_left margin_top_10 margin_left_10 width_200 ">
            	<a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
            </span>
            <span class="float_left margin_top_5  margin_left_10 width_200">我就炒民生银行</span>
        </li>
        <li class="list_type_style_none height_70 border_top_1px_white border_bottom_1px_gary">
        	<span class="margin_top_10 float_left"><img src="<%=request.getContextPath()%>/imgs/zt_1.png" width="52" height="52" class=" border_1px"/></span>
            <span class="float_left margin_top_10 margin_left_10 width_200 ">
            	<a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道2道</a>
            </span>
            <span class="float_left margin_top_5  margin_left_10 width_200">我就炒浦发银行</span>
        </li>
		<li class="list_type_style_none height_70 border_top_1px_white border_bottom_1px_gary">
        	<span class="margin_top_10 float_left"><img src="<%=request.getContextPath()%>/imgs/zt_1.png" width="52" height="52" class=" border_1px"/></span>
            <span class="float_left margin_top_10 margin_left_10 width_200 ">
            	<a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道3道</a>
            </span>
            <span class="float_left margin_top_5  margin_left_10 width_200">我就炒工商银行</span>
        </li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<div class=" margin_left_10 margin_top_15 width_310 height_300 float_left ">
	<ul class="news">
    	<li class="bg_color_gray1 list_type_style_none height_50"><span class="font_size_30 text_line_height_50  margin_left_15">Top news in gd158</span></li>
        <li class="bg_color_gray1 list_type_style_none height_50"><span class="text_line_height_40 margin_left_15 font_color_999999">gaoxy 0days ago</span></li>
        <li class="list_type_style_none  height_168 width_310"><a href="#" class="mask"><img src="<%=request.getContextPath()%>/imgs/news_1.png" width="310" /></a></li>
        <li class="bg_color_gray1 list_type_style_none height_30  ">
        	<span class="text_line_height_25 font_color_999999 text_align_left margin_left_15 float_left margin_top_5">
            	<a href="#" class="font_color_999999 text-decoration_none">加入收藏</a> ·     
                <a href="#" class="font_color_999999 text-decoration_none">付费阅读</a>·
                <a href="#" class="font_color_999999 text-decoration_none">评论</a>· 
                <a href="#" class="font_color_999999 text-decoration_none">推荐</a>
            </span>
        </li>
     <li class="list_type_style_none img_mask_310_168_ie img_mask_310_168_ff"></li>
    </ul>
</div>

<!--分割线-->

<div id="getMore" class=" height_40 width_950  bg_color_gray1 float_left margin_left_10 border_radius_5px margin_top_10 text_align_center"> 
	<div class="margin_top_15"><a href="#" class="  font_size_14  font_color_336699 font_weight_bold text-decoration_none">显示更多</a></div>
</div>

<div class="float_left width_710  margin_left_10 margin_top_15">
	<ul >
    	<li class=" list_type_style_none width_710 bg_color_black  height_30">
        	<span class="margin_left_15 font_color_ffffff font_weight_bold font_size_14 text_line_height_30">行业信息汇总</span>
        </li>
        <li class="list_type_style_none width_230 height_300 bg_color_gray1 float_left  margin_top_10">
        	<ul>
            	<li class=" list_type_style_none height_30 margin_bottom_5 margin_top_10">
                	<span class="margin_left_15 font_weight_bold   float_left">文章分类1</span>
                	<span class="margin_left_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看分类</a></span>
                </li>
                <li class="list_type_style_none  height_80   margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10  width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
                <li class="list_type_style_none  height_80  margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10 width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
                <li class="list_type_style_none  height_80  margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10 width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
            </ul>
        </li>
        <li class="list_type_style_none width_230 height_300 bg_color_gray1 float_left  margin_top_10 margin_left_10">
            <ul>
            	<li class=" list_type_style_none height_30 margin_bottom_5 margin_top_10">
                	<span class="margin_left_15 font_weight_bold   float_left">文章分类2</span>
                	<span class="margin_left_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看分类</a></span>
                </li>
                <li class="list_type_style_none  height_80   margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10  width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
                <li class="list_type_style_none  height_80  margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10 width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
                <li class="list_type_style_none  height_80  margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10 width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
            </ul>
        </li>
        <li class="list_type_style_none width_230 height_300 bg_color_gray1 float_left  margin_top_10 margin_left_10">
               <ul>
            	<li class=" list_type_style_none height_30 margin_bottom_5 margin_top_10">
                	<span class="margin_left_15 font_weight_bold   float_left">文章分类3</span>
                	<span class="margin_left_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看分类</a></span>
                </li>
                <li class="list_type_style_none  height_80   margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10  width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
                <li class="list_type_style_none  height_80  margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10 width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
                <li class="list_type_style_none  height_80  margin_left_10">
                    <span class=" float_left"><img src="<%=request.getContextPath()%>/imgs/news_2.png" width="65" height="35" /></span>
                    <span class="float_left  margin_left_10 width_125 ">
                        <a href="#" class="font_size_14  font_color_336699 font_weight_bold text-decoration_none">道1道</a>
                    </span>
                    <span class="float_left   margin_left_10 width_125">我就炒民生银行我就炒民生银行我就炒民生银行我就炒民生银行</span>
                </li>
            </ul>
        </li>
	</ul>

</div>

<div class="float_left width_230 margin_left_10  margin_top_15">
	<ul >
    	<li class=" list_type_style_none width_230 bg_color_black  height_30">
        	<span class="margin_left_15 font_color_ffffff font_weight_bold font_size_14 text_line_height_30">特约评论员文章</span>
        </li>
        <li class="list_type_style_none width_230 height_300 bg_color_gray1 float_left  margin_top_10">
        	<ul>
            	<li class="list_type_style_none height_40 border_bottom_1px_gary margin_top_15">
                    <span class="margin_left_15 margin_top_15 float_left"><img src="<%=request.getContextPath()%>/imgs/logo_depart_1.png" width="18" height="18" /></span>
                    <span class="margin_left_15 margin_top_15 float_left font_weight_bold ">面哥操盘实录1</span>
                    <span class="margin_left_15 margin_top_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看更新</a></span>
        		</li>
               <li class="list_type_style_none height_40 border_bottom_1px_gary border_top_1px_white ">
                    <span class="margin_left_15 margin_top_15 float_left"><img src="<%=request.getContextPath()%>/imgs/logo_depart_2.png" width="18" height="18" /></span>
                    <span class="margin_left_15 margin_top_15 float_left font_weight_bold ">面哥操盘实录2</span>
                    <span class="margin_left_15 margin_top_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看更新</a></span>
        		</li>
               <li class="list_type_style_none height_40 border_bottom_1px_gary border_top_1px_white ">
                    <span class="margin_left_15 margin_top_15 float_left"><img src="<%=request.getContextPath()%>/imgs/logo_depart_3.png" width="18" height="18" /></span>
                    <span class="margin_left_15 margin_top_15 float_left font_weight_bold ">面哥操盘实录3</span>
                    <span class="margin_left_15 margin_top_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看更新</a></span>
        		</li>    
               <li class="list_type_style_none height_40 border_bottom_1px_gary border_top_1px_white ">
                    <span class="margin_left_15 margin_top_15 float_left"><img src="<%=request.getContextPath()%>/imgs/logo_depart_1.png" width="18" height="18" /></span>
                    <span class="margin_left_15 margin_top_15 float_left font_weight_bold ">面哥操盘实录4</span>
                    <span class="margin_left_15 margin_top_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看更新</a></span>
        		</li>
               <li class="list_type_style_none height_40 border_bottom_1px_gary border_top_1px_white ">
                    <span class="margin_left_15 margin_top_15 float_left"><img src="<%=request.getContextPath()%>/imgs/logo_depart_2.png" width="18" height="18" /></span>
                    <span class="margin_left_15 margin_top_15 float_left font_weight_bold ">面哥操盘实录5</span>
                    <span class="margin_left_15 margin_top_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看更新</a></span>
        		</li>
               <li class="list_type_style_none height_40 border_bottom_1px_gary border_top_1px_white ">
                    <span class="margin_left_15 margin_top_15 float_left"><img src="<%=request.getContextPath()%>/imgs/logo_depart_3.png" width="18" height="18" /></span>
                    <span class="margin_left_15 margin_top_15 float_left font_weight_bold ">面哥操盘实录6</span>
                    <span class="margin_left_15 margin_top_15 float_right margin_right_10"><a href="#" class="text-decoration_none">查看更新</a></span>
        		</li>                          
            </ul>
        </li>
	</ul>
</div>

<div class=" spear_15 float_left"></div>

</div>

<div class=" spear_15"></div>

<!--bottom的分割线-->
<div class=" width_980 body_center border_top_1px_gary" >
<ul>
        		<li class="list_type_style_none float_left margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15" >帮助中心</a>|</li>
        		<li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">关于我们</a>|
                </li>
            	<li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">网站招聘</a>|
                </li>
            	<li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">用户升级</a>|
                </li>
            	<li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">广告合作</a>|
                </li>
            	<li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">网站代理</a>|
                </li>
                <li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">版权申明</a>|
                </li>
            	<li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">驻站评论员</a>|
                </li>
            	<li class="list_type_style_none float_left  margin_top_10">
                	<a href="#" class="font_color_999999 text-decoration_none margin_left_15 margin_right_15">读者说明</a>
                </li>
</ul>

</div>

<div class=" spear_15 float_left"></div>

</body>
</html>
