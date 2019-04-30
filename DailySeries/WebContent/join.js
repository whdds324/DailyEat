function checkName() {
		if(document.frm.name.value ==="" || isNaN(frm.name.value)===false) {
			frm.name.focus();
			alert("옳바른 이름을 입력하세요.")
			return;
		}
	}
	function checkID() {
		if(frm.userid.value.length<4) {
			frm.userid.focus();
			alert("ID는 4글자 이상이여야만 합니다.");
			return;
		}
		
	}
	function pwcheck() {
		if(frm.repassword.value !== frm.password.value) {
			frm.repassword.focus();
			alert("비밀번호를 확인하세요.");
			return;
		}
	}
	function idCheck() {
		var url ="idCheck.do?userid="+document.frm.userid.value;
		window.open(url,"_balnk_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=450,height=400");
		
	}
	function idok() {
		opener.frm.userid.value=document.frm.userid.value;
		
	}
	
	function deletemember() {
		var url ="/delete.jsp";
		window.open(url,"_balnk_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=450,height=400");
	}
	
	function shoppingbag(key) {
		
		var url ="BagServlet?key="+key;
		window.open(url,"_balnk_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=500,height=400");
	}