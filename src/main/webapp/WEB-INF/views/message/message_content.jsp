<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- ajax이용한 메세지 content(오른쪽 영역)처리 -->
<c:forEach var="tmp" items="${clist}">
	<%-- <div msgRoomNo="${tmp.msgRoomNo }" />--%>
	<c:choose>
		<c:when test="${tmp.sendId eq null}">
		
		</c:when>
		<c:when test="${tmp.curId ne tmp.sendId}">
		&nbsp;&nbsp;${tmp.sendId}
			<%-- 받은 메세지 --%>
			
			<div class="incoming_msg">
				<div class="incoming_msg_img">
					<a href="profile.do?memberId=${tmp.curId}"> 
						<%-- 이미지 있으면 해당 이미지로 --%>
						<c:if test="${tmp.image ne null}">
							<img src="${tmp.image}" alt="상대방 프로필 사진경로"/>
						</c:if> 
						<%-- 이미지가 없으면 기본 이미지로 --%> 
						<c:if test="${tmp.image eq null}">
							<img src="/resources/assets/images/mypage/basicImg.png" alt="보낸사람 프로필"
								class='img_circle'>
						</c:if>
					</a>
				</div>
				<div class="received_msg">
					<div class="received_withd_msg">
						<p>${tmp.msgContent}</p>
						<span class="time_date"> <fmt:formatDate
								pattern="yyyy-MM-dd HH:mm" value="${tmp.msgSendTime }" />
						</span>
					</div>
				</div>
			</div>
		</c:when>

		<%-- 보낸 메세지 --%>
		<c:otherwise>
			<div class="outgoing_msg">
				<div class="sent_msg">
				<br> &nbsp;&nbsp;나
					<p>${tmp.msgContent}</p>
					<span class="time_date"> <fmt:formatDate
							pattern="yyyy-MM-dd HH:mm" value="${tmp.msgSendTime }" />
					</span>
				</div>
			</div>
		</c:otherwise>

	</c:choose>
</c:forEach>
<script>
	
</script>