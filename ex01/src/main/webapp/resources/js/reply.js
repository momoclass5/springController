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
	let page = 1;
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
	
	// 리스트 사이즈를 확인하여 메세지 처리
	if(list.length == 0){
		replyDiv.innerHTML = '등록된 댓글이 없어요~!'
	} else {
		
		
		let replyDivStr = 
			'댓글목록'
			+ '<table class="table">                       '
			+ '  <thead>                                   '
			+ '    <tr>                                    '
			+ '      <th scope="col" class="col-1">#</th>                '
			+ '      <th scope="col" class="col-9">댓글</th>            '
			+ '      <th scope="col" class="col-1">작성자</th>             '
			+ '      <th scope="col" class="col-1">등록일날짜</th>           '
			+ '    </tr>                                   '
			+ '  </thead>                                  '
			+ '  <tbody>                                   ';
		
		// 리스트를 돌며 댓글목록을 생성
		list.forEach(reply => {
			replyDivStr += 
			  '    <tr>                                    '
			+ '      <th scope="row">' + reply.rno + '</th>                '
			+ '      <td>' + reply.reply + '</td>                         '
			+ '      <td>' + reply.replyer + '</td>                         '
			+ '      <td>' + reply.replydate + '</td>                         '
			+ '    </tr>									';    	
		})
			                               
			
		replyDivStr += '  </tbody>                           '
						+ '</table>                          ';

		// 화면에 출력
		replyDiv.innerHTML = replyDivStr;
	}
		
//	if(!list){
//	} else {
//		replyDiv.innerHTML = '등록된 댓글이 없어요~!'
//	}                              
}

// 답글 등록하기
function replyWrite(){
	
	// 답글 작성시 필요한 데이터 수집 - bno, reply, replyer
	let bno = document.querySelector('#bno').value;
	let reply = document.querySelector('#reply').value;
	let replyer = document.querySelector('#replyer').value;
	
	// 전달할 객체로 생성
	let obj = {bno : bno
			, reply : reply
			, replyer : replyer};
	
	console.log(obj);
	
	// url : 요청경로
	// obj : JSON형식으로 전달할 데이터
	// callback : 콜백함수(응답결과를 받아서 처리할 함수)
	fetchPost('/reply/insert', obj, replyRes);
}

// 답글 등록, 수정, 삭제의 결과를 처리하는 함수
function replyRes(map){
	console.log(map);
	// 성공 : 리스트 조회및 출력
	// 실패 : 메세지 출력
}





















