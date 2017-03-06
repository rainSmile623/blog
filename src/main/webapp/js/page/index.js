$(function(){
	$.ajax({
		type:'get',
		url:'./cms/article/list',
		success:function(data){
			console.log(data);
			var htmlStr = ' ';
			for(var i=0;i<data.length;i++){
				
				htmlStr += '<div class="blogs">';
				htmlStr += '<figure><img src='+data[i].articleImage+'></figure>';
				htmlStr += '<ul><h3><a href="/">'+ data[i].articleTitle +'</a></h3></ul>';
				htmlStr += '<p>'+ data[i].content +'</p>';
				htmlStr +='<p class="author">';
				htmlStr +='<span class="lm f_l"><a href="/">'+data[i].type+'</a></span>';
				htmlStr +='<span class="dtime f_l">'+data[i].time+'</span>';
				htmlStr +='<span class="viewnum f_r">浏览（<a href="/">'+data[i].hits+'</a>）</span> ';
				htmlStr +='<span class="pingl f_r">评论（<a href="/">'+data[i].comments+'</a>）</span>';	
				htmlStr +='</div>';
			}		
			$("#all_blogs").append(htmlStr);			
		}
	})
})
