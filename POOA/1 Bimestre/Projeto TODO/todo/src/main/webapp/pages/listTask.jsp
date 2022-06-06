<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${requestScope.tarefas.size() == 0}">
    <h1 style="padding: 10px">Não há tarefas.</h1>
</c:if>
    
<c:if test="${requestScope.tarefas.size() > 0}">
    <c:forEach items="${requestScope.tarefas}" var="t">
        <div class="card" >

            <div class="data">

                <div class="nome long-and-truncated">${t.descricao}</div>
                <div class="niver">
                    <div>Categoria: ${t.categoria.nome} </div>
                    <div>Data planejada: 
                        <fmt:formatDate pattern="dd/MM/yyyy" value="${t.dataPlanejada}" /></div>
                    <div>Finalizada: <fmt:formatDate pattern="dd/MM/yyyy" value="${t.dataPlanejada}" /> (${t.horasGastas} horas gastas)</div>
                    <div>Usuário ${t.usuario.nome}</div><br/>
                    <div>
                        <a href="#" class="del" data-id="${t.id}">
                            <i class="fa-solid fa-trash"></i>                            
                        </a>
                        <c:if test="${!t.concluida}">
                            <a href="control?ac=editTask&id=${t.id}">                       
                                <i class="fa-solid fa-pencil"></i>
                            </a>
                            
                            <a href="control?ac=finishTask&id=${t.id}">
                                <i class="fa-solid fa-list"></i>           
                            </a>
                        </c:if>
                    </div>
                </div>


            </div>

            <div class="image">
                <img src="img/group.svg" alt="fest" />
            </div>


        </div>
    </c:forEach>
</c:if>
    
    <a href="control?ac=newTask" style="padding-top: 40px;">
        <div class="iconFabTask" style="
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
    </a>
    
    <script>
        
        let botoesDelete = document.querySelectorAll(".del");
        
        botoesDelete.forEach( b => {
            b.onclick = (e)=>{
                        Swal.fire({
                            title: 'Tem certeza que deseja apagar?',
                            showDenyButton: true,
                            showCancelButton: true,
                            confirmButtonText: 'Sim',
                            denyButtonText: `Não`,
                        }).then((result) => {
                        /* Read more about isConfirmed, isDenied below */
                            if (result.isConfirmed) {
                              //Swal.fire('Salvo!', '', 'success')
                              window.location = "/control?ac=delTask&id="+e.target.dataset.id;
                            } else if (result.isDenied) {
                              //Swal.fire('Mudanças não foram salvas', '', 'info')
                        }
                      })
                  }
        })
    </script>