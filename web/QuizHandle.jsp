<%-- 
    Document   : LessonView
    Created on : Jun 16, 2022, 2:26:20 AM
    Author     : Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="js sizes customelements history pointerevents postmessage postmessage-structuredclones webgl websockets cssanimations csscolumns csscolumns-width csscolumns-span csscolumns-fill csscolumns-gap csscolumns-rule csscolumns-rulecolor csscolumns-rulestyle csscolumns-rulewidth csscolumns-breakbefore csscolumns-breakafter csscolumns-breakinside flexbox picture srcset webworkers" lang="en"><head>
        <jsp:include page="Header.jsp"></jsp:include>
        <div class="container">
            <div class="row pt-17 mt-9">
            <c:if test="${quizzList != null}">    
                <div class="col-md-12 ml-8 border mb-2" style="border-radius: 4px;padding: 24px">
                    <div class="row">
                        <div class="col-md-7 fs-3 text-left" style="line-height: 80%;">
                            <h3>${quizzList.getLession().getName()}</h3>
                            <span style="font-size:14px;">Duration:  ${quizzList.getQuiz().getDuration()} minutes</span>
                            <br>
                            <span style="font-size:14px;">Pass Rate: ${quizzList.getQuiz().getPass_rate()} %</span>
                            <br>
                            <span style="font-size:14px;">Number of Question: ${quizzList.getQuiz().getNumOfQuestion()}</span>
                        </div>
                        <div class="col-md-4 text-right " id="timer-area" style="display: inline;">
                            <h3 class="inline-block">Time remaining: </h3>
                            <span class="inline-block" id="time" style="font-size:24px;">${time}</span>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-5 ml-8 border p-3" style="background-color: #ffffff">
                        <c:forEach items="${quizzList.getLstQuestion()}" var="q">
                            <div class="question mt-6" id="${q.getId()}" style="display: none; 
                                 color: #658fa9;">
                                <h4>${q.getQuestionName()}</h4>                     
                                <h4>${q.getQuestionDetail()}</h4> 
                                <c:forEach items="${q.getAnswer()}" var="ans">
                                    <div class="mt-1">
                                        <input class="ans-form"
                                               name="${q.getId()}"
                                               id="${ans.getID()}" 
                                               type="${q.getNumAnsCorrect()>1?"checkbox":"radio"}"
                                               value="${ans.getID()}"/>
                                        ${ans.getAnswerContent()} 
                                        <label class="label"></label>                            
                                    </div>            
                                </c:forEach>
                            </div>
                        </c:forEach>
                        <div class="mt-4">
                            <button class="btn btn-outline-pending" id="btn_previous" onclick="previousQuestion()">Pre</button>
                            <button class="btn btn-outline-secondary" id="btn_next" onclick="nextQuestion()">Next</button>
                        </div>
                        <form id="result-form" type="hidden" method="POST" action="QuizHandle">
                            <input name="QuizID" value="${quizzList.getLession().getID()}" hidden="true">
                            <input id="result" name="result" type="hidden"/> 
                        </form> 
                    </div>
                    <div class="col-md-4"></div>
                </div>


            </c:if>
        </div>

    </div>
    <!--        JS Vendor, Plugins & Activation Script Files 
    
            Vendors JS -->
    <script src="./assets/js/vendor/modernizr-3.11.7.min.js"></script>
    <script src="./assets/js/vendor/jquery-3.6.0.min.js"></script>
    <script src="./assets/js/vendor/jquery-migrate-3.3.2.min.js"></script>
    <script src="./assets/js/vendor/bootstrap.bundle.min.js"></script>

    <!--        Plugins JS -->
    <script src="./assets/js/plugins/aos.js"></script>
    <script src="./assets/js/plugins/parallax.js"></script>
    <script src="./assets/js/plugins/swiper-bundle.min.js"></script>
    <script src="./assets/js/plugins/perfect-scrollbar.min.js"></script>
    <script src="./assets/js/plugins/jquery.powertip.min.js"></script>
    <script src="./assets/js/plugins/nice-select.min.js"></script>
    <script src="./assets/js/plugins/glightbox.min.js"></script>
    <script src="./assets/js/plugins/jquery.sticky-kit.min.js"></script>
    <script src="./assets/js/plugins/imagesloaded.pkgd.min.js"></script>
    <script src="./assets/js/plugins/masonry.pkgd.min.js"></script>
    <script src="./assets/js/plugins/flatpickr.js"></script>
    <script src="./assets/js/plugins/range-slider.js"></script>
    <script src="./assets/js/plugins/select2.min.js"></script>


    <!--        Activation JS -->
    <script src="./assets/js/main.js"></script>
    <script src="./assets/js/QuizHandle.js"></script>

    <!--</body>-->
    <grammarly-desktop-integration data-grammarly-shadow-root="true"></grammarly-desktop-integration>
</html>
