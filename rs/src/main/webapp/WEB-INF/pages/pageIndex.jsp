<%--
Alex Velichko
07.06.14 : 14:34
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Special coefficients</title>
</head>
<body>
<h1>Special coefficients</h1>

<h3>Method1</h3>

<p>/spc/method1/{v1} , GET<br/>
    v1 - long</p>

<p>Example: <a href="/rs/spc/method1/1" target="_blank">/spc/method1/1</a></p>

<h3>Method2</h3>

<p>/spc/method2 , POST
</p>
<p>&lt;m2request&gt;<br />
    &lt;v1&gt;<br />
    1<br />
    &lt;/v1&gt;<br />
    &lt;v2&gt;<br />
    2<br />
    &lt;/v2&gt;<br />
    &lt;v3&gt;<br />
    3<br />
    &lt;/v3&gt;<br />
    &lt;/m2request&gt;</p>

<h3>F2 Export as CSV</h3>

<p>/spc/export/f2
</p>

<p>Example: <a href="/rs/spc/export/f2" target="_blank">/spc/export/f2</a></p>

<h3>Export as String</h3>

<p>/spc/getFDataAsString/{arg} , GET
    arg - 1 (F1 export) or 2 (F1 export)
</p>

<p>Example: <a href="/rs/spc/getFDataAsString/1" target="_blank">/spc/getFDataAsString/1</a></p>

<h3>Links</h3>
<p>GitHub: <a href="https://github.com/7LevelLabs/SpC" target="_blank">https://github.com/7LevelLabs/SpC</a></p>
<p>CI (Bamboo): <a href="http://7levellabs.com:8085/browse/SPC" target="_blank">http://7levellabs.com:8085/browse/SPC</a></p>
<p>Application : <a href="http://7levellabs.com:7001/rs" target="_blank">http://7levellabs.com:7001/rs</a></p>

</body>
</html>