<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="/">
		<html>
			<body>
				<table border="1">
					<tr>
						<th>Type</th>
						<th>Country</th>
						<th>Staying</th>
						<th>Transport</th>
						<th>Hotel</th>
						<th>Cost</th>
					</tr>
					<xsl:for-each select="touristvoucher/trippass">
						<tr>
							<td>
								<xsl:value-of select="type" />
							</td>
							<td>
								<xsl:value-of select="country" />
							</td>
							<td>
								<ul>
									<li>
										Days:
										<xsl:value-of select="staying/days" />
									</li>
									<li>
										Nights:
										<xsl:value-of select="staying/nights" />
									</li>
								</ul>
							</td>
							<td>
								<xsl:value-of select="transport" />
							</td>
							<td>
								<ul>
									<li>
										Name:
										<xsl:value-of select="hotel/name" />
									</li>
									<li>
										Stars:
										<xsl:value-of select="hotel/stars" />
									</li>
									<li>
										Meal:
										<xsl:value-of select="hotel/meal" />
									</li>
									<li>
										Rooms:
										<xsl:value-of select="hotel/room" />
									</li>
									<li>
										Has TV:
										<xsl:value-of select="hotel/tv" />
									</li>
									<li>
										Has conditioner:
										<xsl:value-of select="hotel/conditioner" />
									</li>
								</ul>
							</td>
							<td>
								<xsl:value-of select="cost" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>