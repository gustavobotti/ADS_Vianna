<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card">
    
    <h1>Exames do cliente: ${requestScope.exames[0].usuario.nome}</h1>
    
</div>

<c:if test="${requestScope.exames.size() == 0}">
    <h1 style="padding: 10px">N?o h? exames para mostrar.</h1>
</c:if>
    
<c:if test="${requestScope.exames.size() > 0}">
    <c:forEach items="${requestScope.exames}" var="e">
        <div class="card" >

            <div class="data">

                <div class="nome long-and-truncated">Exame</div>
                <div class="niver">
                    <div>C?digo: ${e.id} </div>
                    <div> ${e.descricao} </div>
                    <div>Data planejada: 
                        <fmt:formatDate pattern="dd/MM/yyyy" value="${e.dataPlanejada}" /></div>
                    <div> ${e.tempoJejum}h em jejum</div>
                    <div>Finalizada: <c:if test="${e.dataFinalizada != null}"><fmt:formatDate pattern="dd/MM/yyyy" value="${e.dataFinalizada}" />
                        </c:if><c:if test="${e.dataFinalizada == null}">Ainda n?o est? pronto</c:if>
                    </div>
                    
                </div>


            </div>

            <div class="image">
                <img src="img/group.svg" alt="fest" />
            </div>


        </div>
    </c:forEach>
</c:if>
    
<!--    <a href="control?ac=newExame" style="padding-top: 40px;">
        <div class="iconFabExame" style="position: relative;
                                                            width: 85px;
                                                            height: 85px;
                                                            line-height: 72px;    
                                                            text-align: center;
                                                            cursor: pointer;

                                                            flex-shrink: 1;
                                                            margin-right: 45px;
                                                            font-size: 3rem;

                                                            transition: 0.5s;
                                                            transform: translateY(-35px);
                                                            background: #F0B357;

                                                            border-radius: 50%;
                                                            border: 8px solid #1D1B1B;   ">
                        <i class="fa-solid fa-plus"></i>
        </div>
    </a>-->
    
    <script>
        
        let botoesDelete = document.querySelectorAll(".del");
        
        botoesDelete.forEach( b => {
            b.onclick = (e)=>{
                        Swal.fire({
                            title: 'Tem certeza que deseja apagar?',
                            showDenyButton: true,
                            showCancelButton: true,
                            confirmButtonText: 'Sim',
                            denyButtonText: `N?o`,
                        }).then((result) => {
                        /* Read more about isConfirmed, isDenied below */
                            if (result.isConfirmed) {
                              //Swal.fire('Salvo!', '', 'success')
                              window.location = "/control?ac=delExame&id="+e.target.dataset.id;
                            } else if (result.isDenied) {
                              //Swal.fire('Mudan?as n?o foram salvas', '', 'info')
                        }
                      })
                  }
        })
    </script>