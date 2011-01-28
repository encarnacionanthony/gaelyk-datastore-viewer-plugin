<% include '/WEB-INF/includes/data/header.gtpl' %>

<%
  def kind = request.kind
%>

<h2>Create Entity: ${kind}</h2>

<form action="/data/insert/${kind}" method="post">
<table border="0">
  <tbody>
     <% request.kindProperties.eachWithIndex { property, index -> %>
     <% def propertyValue = entity.getProperty(property.key.name) %>
     <% def propertyType = groovyx.gaelyk.plugins.datastore.viewer.data.DatastorePropertyType.getPropertyTypeForJavaType(propertyValue.class) %>
     <tr>
        <td>
           <b>${property.key.name}</b><br>
           <table>
              <tbody>
                 <tr>
                    <td>Value:</td>
                    <td>
                       <input type="hidden" name="name_${index}" value="${property.key.name}">
                       <input type="text" name="value_${index}" size="32">
                       <input type="hidden" name="type_${index}" value="${propertyType}">
                    </td>
                 </tr>
                 <tr>
                    <td>Type:</td>
                    <td>${propertyType.label}</td>
                 </tr>
              </tbody>
           </table>
        </td>
     </tr>
     <tr><td><br></td></tr>
     <% } %>
  </tbody>
</table>
<input type="submit" value="Insert" name="Insert">&nbsp;<input type="button" value="Cancel" name="Cancel" onclick="javascript:document.location.href='/data/browse?kind=${kind}'">
</form>

<% include '/WEB-INF/includes/data/footer.gtpl' %>