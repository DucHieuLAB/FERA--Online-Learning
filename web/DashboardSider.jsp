<%-- 
    Document   : DashboardSider
    Created on : Jun 14, 2022, 7:56:40 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="side-nav">
    <ul>
        <li><a href="#" class="side-menu side-menu--active side-menu--open">
                <div class="side-menu__icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                  viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                                  stroke-linejoin="round" class="lucide ">
                        <path d="m3 9 9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                        <polyline points="9 22 9 12 15 12 15 22"></polyline>
                    </svg></div>
                <div class="side-menu__title">Dashboard<div class="side-menu__sub-icon transform rotate-180"><svg
                            xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                            stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                            class="lucide ">

                        </svg></div>
                </div>
            </a>
        </li>

        <li><a href="#" class="side-menu side-menu--active side-menu--open">
                <div class="side-menu__icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                  viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                                  stroke-linejoin="round" class="lucide ">
                        <path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path>
                        <path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path>
                    </svg></div>
                <div class="side-menu__title">System Setting<div class="side-menu__sub-icon transform rotate-180"><svg
                            xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                            stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                            class="lucide ">

                        </svg></div>
                </div>
            </a>
            <ul class="side-menu__sub-open" style="display: block;">
                <c:forEach items="${listSetting}" var = "st">
                    <c:if test="${st.settingStatus == true}">

                        <li><a href="#" class="side-menu side-menu--active">
                                <div class="side-menu__icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                                  viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                                                  stroke-linejoin="round" class="lucide ">
                                        <polyline points="22 12 18 12 15 21 9 3 6 12 2 12"></polyline>
                                    </svg></div>
                                <div class="side-menu__title">${st.settingName}</div>
                            </a></li></c:if>
                    </c:forEach>
            </ul>
        </li>

    </ul>
    <li class="side-nav__devider my-6"></li>
</ul>
</nav>
