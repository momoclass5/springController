console.log('reply.js=========')

// get방식 요청
function fetchGet(url, callback){
	try{
		// url 요청
		fetch(url)
			// 요청결과 json문자열을 javascript 객체로 반환
			.then(response => response.json())
			// 콜백함수 실행
			.then(map => callback(map));			
	}catch(e){
		console.log('fetchGet',e);
	}
}

// post방식 요청
function fetchPost(url, obj, callback){
	try{
		// url 요청
		fetch(url
				, {
					method : 'post'
					, headers : {'Content-Type' : 'application/json'}
					, body : JSON.stringify(obj)
				})
			// 요청결과 json문자열을 javascript 객체로 반환
			.then(response => response.json())
			// 콜백함수 실행
			.then(map => callback(map));			
	}catch(e){
		console.log('fetchPost', e);
	}
	
}


// 댓글 조회및 출력
function getReplyList(){
	let bno = document.querySelector('#bno').value;
	let page = '1';
	console.log('bno : ', bno);
	
	console.log('/reply/list/' + bno + '/' + page);
	console.log(`/reply/list/${bno}/${page}`);
	
	// url : 요청경로
	// callback : 응답결과를 받아 실행시킬 함수
	fetchGet(`/reply/list/${bno}/${page}`, replyView)
	
}

function replyView(map){
	let list = map.list;
	console.log(list);
	replyDiv.innerHTML = '댓글목록'
		+ '<table class="table">                       '
		+ '  <thead>                                   '
		+ '    <tr>                                    '
		+ '      <th scope="col">#</th>                '
		+ '      <th scope="col">댓글</th>            '
		+ '      <th scope="col">작성자</th>             '
		+ '      <th scope="col">등록일날짜</th>           '
		+ '    </tr>                                   '
		+ '  </thead>                                  '
		+ '  <tbody>                                   '
	
		
		+ '    <tr>                                    '
		+ '      <th scope="row">1</th>                '
		+ '      <td>와~ 반가워요</td>                         '
		+ '      <td>momo</td>                         '
		+ '      <td>23/07/12</td>                         '
		+ '    </tr>                                   '
		
		
		+ '  </tbody>                                  '
		+ '</table>                                    ';
	                                               
}
























