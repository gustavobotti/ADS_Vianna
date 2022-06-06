<fieldset class="grupo" >
            <div class="campo" style="width: 100%">
                <label for="cpRes">Resultado</label>
                <textarea id="cpRes" name="cpRes" style="width: 100%" required="">${requestScope.exame.resultado}</textarea>
            </div>
</fieldset> 

<fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cpExame">Código do exame:</label>
                <select id="cpExame" name="cpExame" style="width:100%">
                    <c:forEach items="${requestScope.exames}" var="e">
                        <c:if test="${e.id != null}">
                             <option value="${e.id}">${e.id}</option>                            
                        </c:if>
                    </c:forEach>
                </select>
            </div>
</fieldset>
 
 <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cpUser">User</label>
                <select id="cpUser" name="cpUser" style="width:100%">
                    <c:forEach items="${requestScope.users}" var="u">
                        <c:if test="${u.id != null}">
                             <option value="${u.id}">CPF do usuário: ${e.id}</option>                            
                        </c:if>
                    </c:forEach>
                </select>
            </div>
</fieldset>
 