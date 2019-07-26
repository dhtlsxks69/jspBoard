<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>
<br />
<br />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>

<!--================Contact Area =================-->
<section class="contact_area p_120">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<form class="row contact_form" action="/blog/board?cmd=updateProc" method="post" id="contactForm" novalidate="novalidate" onsubmit="return validateCheck()">
					<input type="hidden" value="${board.id}" name="id" />
					<div class="col-md-12">
						<div class="form-group">
							<input type="text" class="form-control" id="title" name="title" placeholder="Title" maxlength="30" value="${board.title}">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<textarea class="form-control" name="content" id="summernote" rows="1" placeholder="Content">
								${board.content}
							</textarea>
						</div>
					</div>
					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">Updating</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<script>
	$('#summernote').summernote({
		placeholder : 'Hello bootstrap 4',
		tabsize : 2,
		height : 300
	});

	function validateCheck() {
		var title = document.querySelector('#title').value;
		if (title.length == 0) {
			alert("제목이 입력되지 않았습니다.");
			return false;
		}
	}
</script>
<!--================Contact Area =================-->

<%@ include file="/include/footer.jsp"%>