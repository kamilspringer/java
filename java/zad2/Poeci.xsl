<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xslt="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="CollectionOfPoems">
        <html>
            <body>
                <h1>Zbiór wierszy</h1>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="Poem">
        <div style="height:5%; clear:both;"></div>
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="Author">
        <p style="font-weight: bold;"><xslt:value-of select="FirstName"/> <xslt:value-of select="LastName"/></p>
    </xsl:template>
    <xsl:template match="Title">
        <h2><xslt:value-of select="."/> </h2>
    </xsl:template>
    <xsl:template match="Subtitle">
        <p style="margin:0; padding:0; font-weight: bold;"><xslt:value-of select="."/> </p>
        <div style="height:1.5%; clear:both;"></div>
    </xsl:template>
    <xsl:template match="Strophe">
        <div style="background-color">
            <xsl:apply-templates/>
        </div>
        <br/>
    </xsl:template>
    <xsl:template match="Verse">
        <p style="margin:0; padding:0;">
            <xsl:value-of select="Verse"/>
            <xsl:apply-templates/>
        </p>
    </xsl:template>
    <xsl:template match="Bold">
        <b><xsl:value-of select="."/></b>
    </xsl:template>
</xsl:stylesheet>