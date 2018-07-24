<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<html>
		<body>
			<xsl:for-each select="touristvoucher/trippass">
				<ul>
					<li><p>Type: <xsl:value-of select="type"/></p></li>
					<li><p>Country: <xsl:value-of select="country"/></p></li>
					<li><p>Days: <xsl:value-of select="staying/days"/></p></li>
					<li><p>Nights: <xsl:value-of select="staying/nights"/></p></li>
					<li><p>Transport: <xsl:value-of select="transport"/></p></li>
					<li>Hotel
						<ul>
							<li><p>Name: <xsl:value-of select="hotel/name"/></p></li>
							<li><p>Stars: <xsl:value-of select="hotel/stars"/></p></li>
							<li><p>Meal: <xsl:value-of select="hotel/meal"/></p></li>
							<li><p>Rooms: <xsl:value-of select="hotel/room"/></p></li>
							<li><p>TV: <xsl:value-of select="hotel/tv"/></p></li>
							<li><p>Conditioner: <xsl:value-of select="hotel/conditioner"/></p></li>
						</ul>
					</li>
					<li><p>Cost: <xsl:value-of select="cost"/></p></li>
				</ul>
				<hr></hr>
			</xsl:for-each>
		</body>
	</html>
</xsl:template>

</xsl:stylesheet>