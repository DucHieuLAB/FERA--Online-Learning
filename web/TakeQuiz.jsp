<%-- 
    Document   : QuizReview
    Created on : 19-Jul-2022, 01:40:42
    Author     : hieutdhe141410
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="js sizes customelements history pointerevents postmessage postmessage-structuredclones webgl websockets cssanimations csscolumns csscolumns-width csscolumns-span csscolumns-fill csscolumns-gap csscolumns-rule csscolumns-rulecolor csscolumns-rulestyle csscolumns-rulewidth csscolumns-breakbefore csscolumns-breakafter csscolumns-breakinside flexbox picture srcset webworkers" lang="en"><head>
        <jsp:include page="Header.jsp"></jsp:include>
        <div class="container">
            <div class="row pt-17 mt-9">
                <div class="col-md-12 ml-8 border mb-2" style="border-radius: 4px;padding: 24px">
                    <div class="row">
                    <c:if test="${quizzList != null}">
                        <div class="col-md-12 ml-3 mb-10 text-center">
                            <div class="fs-3">
                                ${quizzList.getLession().getName()}
                            </div>
                            <div class="ml-8 border">   
                            </div>
                            <div>
                                <div class="fs-4 fw-bold">
                                    Topic: ${topic.getTopicName()}
                                </div>
                                <div>
                                    <label class="form-label">Duration : ${quizzList.getQuiz().getDuration()} minutes</label>
                                    <label class="form-label">Pass Rate : ${quizzList.getQuiz().getPass_rate()} %</label> 
                                    <label class="form-label">Number of Question : ${quizzList.getQuiz().getNumOfQuestion()} </label>  
                                    <button class="btn btn-outline-secondary">Take Quiz</button>
                                </div>
                            </div>


                        </div>
                    </c:if>
                </div>

            </div>
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
