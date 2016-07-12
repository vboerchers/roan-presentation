<map version="freeplane 1.3.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="Roan-Presentation" FOLDED="false" ID="ID_1723255651" CREATED="1283093380553" MODIFIED="1468364996235" BACKGROUND_COLOR="#97c7dc" LINK="https://sourceforge.net/projects/freeplane/files/addons/roan/presentation/">
<font SIZE="16" BOLD="true" ITALIC="true"/>
<hook NAME="MapStyle">
    <properties show_icon_for_attributes="false" show_note_icons="true"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node">
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right">
<stylenode LOCALIZED_TEXT="default" MAX_WIDTH="600" COLOR="#000000" STYLE="as_parent">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.note"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
</stylenode>
</stylenode>
</map_styles>
</hook>
<hook NAME="AutomaticEdgeColor" COUNTER="4"/>
<attribute_layout NAME_WIDTH="144" VALUE_WIDTH="144"/>
<attribute NAME="name" VALUE="roan"/>
<attribute NAME="version" VALUE="0,2" OBJECT="org.freeplane.features.format.FormattedNumber|0.2"/>
<attribute NAME="author" VALUE="Jodi D.Krol"/>
<attribute NAME="maintainer since 2.0" VALUE="Volker B&#xf6;rchers"/>
<attribute NAME="graphics" VALUE="Pedrag Cuklin"/>
<attribute NAME="freeplaneVersionFrom" VALUE="1.3.11"/>
<attribute NAME="freeplaneVersionTo" VALUE=""/>
<attribute NAME="updateUrl" VALUE=""/>
<attribute NAME="included" VALUE="addon Inline Image by Rickenbroc"/>
<attribute NAME="roan-p" VALUE="inited,v0.1.0"/>
<attribute NAME="roan-currentNode" VALUE=""/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The homepage of this add-on should be set as the link of the root node.
    </p>
    <p>
      The basic properties of this add-on. They can be used in script names and other attributes, e.g. &quot;${name}.groovy&quot;.
    </p>
    <ul>
      <li>
        name: The name of the add-on, normally a technically one (no spaces, no special characters except _.-).
      </li>
      <li>
        author: Author's name(s) and (optionally) email adresses.
      </li>
      <li>
        version: Since it's difficult to protect numbers like 1.0 from Freeplane's number parser it's advised to prepend a 'v' to the number, e.g. 'v1.0'.
      </li>
      <li>
        freeplane-version-from: The oldest compatible Freeplane version. The add-on will not be installed if the Freeplane version is too old.
      </li>
      <li>
        freeplane-version-to: Normally empty: The newest compatible Freeplane version. The add-on will not be installed if the Freeplane version is too new.
      </li>
      <li>
        updateUrl: URL of the file containing information (version, download url) on the latest version of this add-on. By default: &quot;${homepage}/version.properties&quot;
      </li>
    </ul>
  </body>
</html>
</richcontent>
<node TEXT="description" POSITION="left" ID="ID_342474895" CREATED="1399926585605" MODIFIED="1468364519464">
<edge COLOR="#ff0000"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Description would be awkward to edit as an attribute.
    </p>
    <p>
      So you have to put the add-on description as a child of the <i>'description'</i>&#160;node.
    </p>
    <p>
      To translate the description you have to define a translation for the key 'addons.${name}.description'.
    </p>
  </body>
</html>
</richcontent>
<node ID="ID_1507385885" CREATED="1399927485452" MODIFIED="1402769513503"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      RoAn-Presentation supports step by step and continuous animation of using and traversing a mind map, taking over abundant clicking from the user. It provides for a combination of mind mapping with Powerpoint- and Prezi like presentation. The included Help file contains a full example which can be played or stepped.
    </p>
    <p>
      
    </p>
    <p>
      Menu RoAn-Presentation can be found in Tools. To use the addon, in the Freeplane preferences a path must be set to &quot;lib&quot;.<br/>
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="changes" FOLDED="true" POSITION="left" ID="ID_1771154217" CREATED="1399926585625" MODIFIED="1468364519467">
<edge COLOR="#0000ff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Change log of this add-on: append one node for each noteworthy version and put the details for each version into a child node.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="see Help file" ID="ID_1209734697" CREATED="1403000881360" MODIFIED="1403000890067"/>
</node>
<node TEXT="license" FOLDED="true" POSITION="left" ID="ID_166707522" CREATED="1399926585645" MODIFIED="1468364519472">
<edge COLOR="#00ff00"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The add-ons's license that the user has to accept before she can install it.
    </p>
    <p>
      
    </p>
    <p>
      The License text has to be entered as a child of the <i>'license'</i>&#160;node, either as plain text or as HTML.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="This add-on is free software: you can redistribute it and/or modify&#xa;it under the terms of the GNU General Public License as published by&#xa;the Free Software Foundation, either version 2 of the License, or&#xa;(at your option) any later version.&#xa;&#xa;This program is distributed in the hope that it will be useful,&#xa;but WITHOUT ANY WARRANTY; without even the implied warranty of&#xa;MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the&#xa;GNU General Public License for more details." ID="ID_1198072133" CREATED="1399926585655" MODIFIED="1403811602198"/>
</node>
<node TEXT="default.properties" FOLDED="true" POSITION="left" ID="ID_1785222944" CREATED="1399926585745" MODIFIED="1468364519480">
<edge COLOR="#00ffff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      These properties play together with the preferences: Each property defined in the preferences should have a default value in the attributes of this node.
    </p>
  </body>
</html>
</richcontent>
<attribute_layout NAME_WIDTH="365" VALUE_WIDTH="365"/>
<attribute NAME="addons.roan.onOpenMaxMenu.screenModeMaxOff" VALUE="true"/>
<attribute NAME="addons.roan.onOpenMaxMenu.greyBackgroundOff" VALUE="true"/>
<attribute NAME="addons.roan.onOpenMinMenu.screenModeMaxOn" VALUE="true"/>
<attribute NAME="addons.roan.onOpenMinMenu.greyBackgroundOn" VALUE="false"/>
<attribute NAME="addons.roan.onCloseMenu.screenModeMaxOff" VALUE="true"/>
<attribute NAME="addons.roan.onPlay.screenModeMaxOn" VALUE="false"/>
<attribute NAME="addons.roan.onPlay.greyBackgroundOn" VALUE="true"/>
<attribute NAME="addons.roan.finishPlay.screenModeMaxOff" VALUE="false"/>
<attribute NAME="addons.roan.finishPlay.greyBackgroundOff" VALUE="true"/>
<attribute NAME="addons.roan.finishPlay.tooltipsOn" VALUE="true"/>
<attribute NAME="addons.roan.onOpenMaxMenu.tooltipsOn" VALUE="true"/>
<attribute NAME="addons.roan.onOpenMinMenu.attributesOff" VALUE="true"/>
<attribute NAME="addons.roan.onOpenMaxMenu.attributesIconOff" VALUE="true"/>
<attribute NAME="addons.roan.onOpenMinMenu.tooltipsOff" VALUE="false"/>
<attribute NAME="addons.roan.onOpenMinMenu.attributesIconOff" VALUE="true"/>
<attribute NAME="addons.roan.onCloseMenu_greyBackgroundOff" VALUE="true"/>
<attribute NAME="addons.roan.onCloseMenu.tooltipsOn" VALUE="false"/>
<attribute NAME="addons.roan.onCloseMenu_attributesOn" VALUE="false"/>
<attribute NAME="addons.roan.onCloseMenu_attributesIconOn" VALUE="false"/>
<attribute NAME="addons.roan.onPlay.tooltipsOff" VALUE="true"/>
<attribute NAME="addons.roan.onPlay_attributesOff" VALUE="true"/>
<attribute NAME="addons.roan.onPlay_attributesIconOff" VALUE="true"/>
<attribute NAME="addons.roan.finishPlay_tooltipsOn" VALUE="false"/>
<attribute NAME="addons.roan.finishPlay_attributesOn" VALUE="false"/>
<attribute NAME="addons.roan.finishPlay_attributesIconOn" VALUE="false"/>
<attribute NAME="addons.roan.whilePlay.cycle" VALUE="true"/>
<attribute NAME="addons.roan.whilePlay.all" VALUE="true"/>
<attribute NAME="addons.roan.whilePlay.slowMove" VALUE="true"/>
<attribute NAME="addons.inlineImage.defaultDetails" VALUE="true"/>
<attribute NAME="addons.roan.whilePlay.doFilter" VALUE="false"/>
<attribute NAME="addons.roan.whilePlay.doAutoZoom" VALUE="false"/>
<attribute NAME="addons.roan.whilePlay.autoZoomMax" VALUE="&quot;150"/>
<attribute NAME="addons.roan.whilePlay.autoZoomMin" VALUE="&quot;100"/>
<attribute NAME="addons.roan.windowWidth" VALUE="&quot;1280"/>
<attribute NAME="addons.roan.windowHeight" VALUE="&quot;720"/>
<attribute NAME="addons.roan.imageinline.widthMax" VALUE="&quot;400"/>
<attribute NAME="addons.roan.imageinline.heightMax" VALUE="&quot;300"/>
<node TEXT="tools" FOLDED="true" ID="ID_1578864265" CREATED="1403179041931" MODIFIED="1405283287527">
<font BOLD="true"/>
<node TEXT="Instruction for translation" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1291857751" CREATED="1403185903209" MODIFIED="1403185991547">
<node TEXT="Copy node &quot;en&quot;" ID="ID_871000443" CREATED="1403185951531" MODIFIED="1403185979449"/>
<node TEXT="Paste on &quot;translations&quot;" ID="ID_1938211650" CREATED="1403185997590" MODIFIED="1403186024605"/>
<node TEXT="Rename &quot;en&quot;: replace by your language code" ID="ID_121099667" CREATED="1403186013883" MODIFIED="1403190406511" LINK="#ID_624507685"/>
<node TEXT="unfold &quot;tools&quot;" ID="ID_782249315" CREATED="1403186071667" MODIFIED="1403186092567"/>
<node TEXT="Click button in node &quot;table to source&quot;" ID="ID_422738885" CREATED="1403201292918" MODIFIED="1403201319516"/>
<node TEXT="Unfold &quot;source&quot;" ID="ID_1926730754" CREATED="1403186093144" MODIFIED="1403201329866"/>
<node TEXT="Replace English text in grandchildren of source,&#xa;by text in your language." ID="ID_876624342" CREATED="1403186105449" MODIFIED="1403186143108"/>
<node TEXT="Click the button in node &quot;source to table&quot;" ID="ID_1867362267" CREATED="1403186151156" MODIFIED="1403186212220"/>
<node TEXT="Save and Reinstall the addon to test it." ID="ID_1780325467" CREATED="1403187561836" MODIFIED="1403187635304"/>
<node TEXT="If all works fine, children of source may be deleted." ID="ID_1418959150" CREATED="1403250428994" MODIFIED="1403250458852"/>
</node>
<node TEXT="table to source" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_885043227" CREATED="1403184244360" MODIFIED="1403800280127" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="def translation=node.parent.parent&#xa;  def tools=node.parent&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xa;  def source=li[0]&#xa;  source.children.each{it.delete()}&#xa;    &#xa;    li=translation.attributes.getAttributeNames()&#xa;&#x9;li.each{&#xa;&#x9;&#x9;def attr=source.createChild()&#xa;&#x9;&#x9;attr.text=it&#xa;        &#xa;        def child=attr.createChild()&#xa;&#x9;&#x9;child.text=translation[it]&#x9;&#x9;&#xa;&#x9;}"/>
<node TEXT="first action" ID="ID_443120680" CREATED="1403250403517" MODIFIED="1403250410383"/>
</node>
<node TEXT="source to table" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1689573158" CREATED="1403184244360" MODIFIED="1403800280127" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="def translation=node.parent.parent&#xa;  def tools=node.parent&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xa;  def source=li[0]&#xa;&#xa;translation.attributes.clear()&#xa;source.children.each{ &#xa;    def valNode=it.children[0]&#xa;    translation[it.text]=valNode.text&#xa;    }"/>
<node TEXT="final action" ID="ID_858826132" CREATED="1403250392808" MODIFIED="1403250400173"/>
</node>
<node TEXT="filter source" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_598602101" CREATED="1403180253094" MODIFIED="1403800280111" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="String strip(String s){ &#xd;&#xa;    s-=&apos;&quot;&apos;;   s-=&apos;&quot;&apos;&#xd;&#xa;     s-=&quot;&apos;&quot;;   s-=&quot;&apos;&quot;&#xd;&#xa;     s-=&apos;,&apos;&#xd;&#xa;     return s&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;  def tools=node.parent&#xd;&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xd;&#xa;  def source=li[0]&#xd;&#xa;  &#xd;&#xa;  source.children.each{&#xd;&#xa;  it.text=strip(it.text)&#xd;&#xa;  def details=it.children[0]&#xd;&#xa;  details.text=strip(details.text)&#xd;&#xa;}"/>
<node TEXT="For developer only: removes unnessary &quot;, &apos; and , after copy to source from .groovy" ID="ID_638567410" CREATED="1403250344052" MODIFIED="1403250505044"/>
</node>
<node TEXT="source" FOLDED="true" ID="ID_1140884910" CREATED="1403179064996" MODIFIED="1411759697664" BACKGROUND_COLOR="#ffff99" STYLE="bubble">
<node TEXT="addons.roan.onOpenMaxMenu.screenModeMaxOff" FOLDED="true" ID="ID_24132539" CREATED="1403798422551" MODIFIED="1403811495650">
<node TEXT="true" ID="ID_407855675" CREATED="1403800120960" MODIFIED="1403800125593"/>
</node>
<node TEXT="addons.roan.onOpenMaxMenu.greyBackgroundOff" FOLDED="true" ID="ID_598401967" CREATED="1403815083943" MODIFIED="1403815083943">
<node TEXT="true" ID="ID_723050544" CREATED="1403815125376" MODIFIED="1403815151428"/>
</node>
<node TEXT="addons.roan.onOpenMinMenu.screenModeMaxOn" FOLDED="true" ID="ID_1164168468" CREATED="1403798422598" MODIFIED="1403811511266">
<node TEXT="true" ID="ID_235378912" CREATED="1403800132277" MODIFIED="1403800137285"/>
</node>
<node TEXT="addons.roan.onOpenMinMenu.greyBackgroundOn" FOLDED="true" ID="ID_409155644" CREATED="1403814988892" MODIFIED="1403814988892">
<node TEXT="false" ID="ID_1763964169" CREATED="1403815155584" MODIFIED="1403815954043"/>
</node>
<node TEXT="addons.roan.onCloseMenu.screenModeMaxOff" FOLDED="true" ID="ID_1025439176" CREATED="1403798422644" MODIFIED="1403809385567">
<node TEXT="true" ID="ID_758712379" CREATED="1403800145374" MODIFIED="1403800149274"/>
</node>
<node TEXT="addons.roan.onPlay.screenModeMaxOn" FOLDED="true" ID="ID_118768609" CREATED="1403798422691" MODIFIED="1403808401888">
<node TEXT="false" ID="ID_1793329124" CREATED="1403800152088" MODIFIED="1404544305054"/>
</node>
<node TEXT="addons.roan.onPlay.greyBackgroundOn" FOLDED="true" ID="ID_1025373184" CREATED="1403798422707" MODIFIED="1403808407692">
<node TEXT="true" ID="ID_471626519" CREATED="1403800168524" MODIFIED="1403800190801"/>
</node>
<node TEXT="addons.roan.finishPlay.screenModeMaxOff" FOLDED="true" ID="ID_360777324" CREATED="1403798422754" MODIFIED="1403808412918">
<node TEXT="false" ID="ID_675564700" CREATED="1403800194459" MODIFIED="1404544292278"/>
</node>
<node TEXT="addons.roan.finishPlay.greyBackgroundOff" FOLDED="true" ID="ID_1911428088" CREATED="1403798422785" MODIFIED="1403809390590">
<node TEXT="true" ID="ID_1726724099" CREATED="1403800203062" MODIFIED="1403800208242"/>
</node>
<node TEXT="addons.roan.finishPlay.tooltipsOn" FOLDED="true" ID="ID_895064094" CREATED="1403798422785" MODIFIED="1406452404028">
<node TEXT="true" ID="ID_56497093" CREATED="1403800203062" MODIFIED="1403800208242"/>
</node>
<node TEXT="addons.roan.onOpenMaxMenu.tooltipsOn" FOLDED="true" ID="ID_1984086557" CREATED="1403854990338" MODIFIED="1403854990338">
<node TEXT="true" ID="ID_775284143" CREATED="1403854996445" MODIFIED="1403855001048"/>
</node>
<node TEXT="addons.roan.onOpenMinMenu.attributesOff" FOLDED="true" ID="ID_1327819562" CREATED="1403855045711" MODIFIED="1403855045711">
<node TEXT="true" ID="ID_1065297054" CREATED="1403855051334" MODIFIED="1403855055890"/>
</node>
<node TEXT="addons.roan.onOpenMaxMenu.attributesIconOff" FOLDED="true" ID="ID_525521886" CREATED="1403855100428" MODIFIED="1403855100428">
<node TEXT="true" ID="ID_1205204608" CREATED="1403855104866" MODIFIED="1403855108922"/>
</node>
<node TEXT="addons.roan.onOpenMinMenu.tooltipsOff" FOLDED="true" ID="ID_808070915" CREATED="1403855166198" MODIFIED="1403855166198">
<node TEXT="false" ID="ID_975807443" CREATED="1403855170511" MODIFIED="1403855174442"/>
</node>
<node TEXT="addons.roan.onOpenMinMenu.attributesOff" FOLDED="true" ID="ID_1871759418" CREATED="1403855196134" MODIFIED="1403855196134">
<node TEXT="true" ID="ID_261104430" CREATED="1403855200010" MODIFIED="1403855204457"/>
</node>
<node TEXT="addons.roan.onOpenMinMenu.attributesIconOff" FOLDED="true" ID="ID_1024412132" CREATED="1403855223450" MODIFIED="1403855223450">
<node TEXT="true" ID="ID_1332766490" CREATED="1403855227154" MODIFIED="1403855231632"/>
</node>
<node TEXT="addons.roan.onCloseMenu_greyBackgroundOff" FOLDED="true" ID="ID_372917707" CREATED="1403855920966" MODIFIED="1403855920966">
<node TEXT="true" ID="ID_1495409392" CREATED="1403855929366" MODIFIED="1403855932767"/>
</node>
<node TEXT="addons.roan.onCloseMenu.tooltipsOn" FOLDED="true" ID="ID_690944573" CREATED="1403855272839" MODIFIED="1403855272839">
<node TEXT="false" ID="ID_1596257013" CREATED="1403855276217" MODIFIED="1403855329561"/>
</node>
<node TEXT="addons.roan.onCloseMenu_attributesOn" FOLDED="true" ID="ID_229988887" CREATED="1403855341940" MODIFIED="1403855341940">
<node TEXT="false" ID="ID_1911154524" CREATED="1403855348265" MODIFIED="1403855352727"/>
</node>
<node TEXT="addons.roan.onCloseMenu_attributesIconOn" FOLDED="true" ID="ID_1361149586" CREATED="1403855386977" MODIFIED="1411759697648">
<node TEXT="false" ID="ID_52030872" CREATED="1403855391508" MODIFIED="1403855395830"/>
</node>
<node TEXT="addons.roan.onPlay.tooltipsOff" FOLDED="true" ID="ID_1549613027" CREATED="1403855773000" MODIFIED="1403855773000">
<node TEXT="true" ID="ID_1605060054" CREATED="1403855777125" MODIFIED="1403855781790"/>
</node>
<node TEXT="addons.roan.onPlay_attributesOff" FOLDED="true" ID="ID_572494016" CREATED="1403855799738" MODIFIED="1403855799738">
<node TEXT="true" ID="ID_637977850" CREATED="1403855804052" MODIFIED="1403855825564"/>
</node>
<node TEXT="addons.roan.onPlay_attributesIconOff" FOLDED="true" ID="ID_1733168374" CREATED="1403855829597" MODIFIED="1403855829597">
<node TEXT="true" ID="ID_1740226404" CREATED="1403855834049" MODIFIED="1403855839370"/>
</node>
<node TEXT="addons.roan.finishPlay_tooltipsOn" FOLDED="true" ID="ID_1551626967" CREATED="1403858719961" MODIFIED="1403859579148">
<node TEXT="false" ID="ID_1311621316" CREATED="1403858725631" MODIFIED="1403858729703"/>
</node>
<node TEXT="addons.roan.finishPlay_attributesOn" FOLDED="true" ID="ID_1107548117" CREATED="1403858757947" MODIFIED="1403858757947">
<node TEXT="false" ID="ID_142728718" CREATED="1403858761870" MODIFIED="1403858766535"/>
</node>
<node TEXT="addons.roan.finishPlay_attributesIconOn" FOLDED="true" ID="ID_706926283" CREATED="1403858794919" MODIFIED="1403858794919">
<node TEXT="false" ID="ID_1013825222" CREATED="1403858800044" MODIFIED="1403858804396"/>
</node>
<node TEXT="addons.roan.whilePlay.cycle" FOLDED="true" ID="ID_1026386403" CREATED="1404467606169" MODIFIED="1404467606169">
<node TEXT="true" ID="ID_943749907" CREATED="1404467617611" MODIFIED="1404467625817"/>
</node>
<node TEXT="addons.roan.whilePlay.all" FOLDED="true" ID="ID_1985355650" CREATED="1404467606169" MODIFIED="1404468282532">
<node TEXT="true" ID="ID_49156701" CREATED="1404467617611" MODIFIED="1404467625817"/>
</node>
<node TEXT="addons.roan.whilePlay.slowMove" FOLDED="true" ID="ID_658195737" CREATED="1404467606169" MODIFIED="1404468288787">
<node TEXT="true" ID="ID_415374847" CREATED="1404467617611" MODIFIED="1404467625817"/>
</node>
<node TEXT="addons.inlineImage.defaultDetails" FOLDED="true" ID="ID_154488648" CREATED="1404711526125" MODIFIED="1404742562366">
<node TEXT="true" ID="ID_93032682" CREATED="1404711531997" MODIFIED="1404711536366"/>
</node>
<node TEXT="addons.roan.whilePlay.doFilter" FOLDED="true" ID="ID_94289813" CREATED="1405278767646" MODIFIED="1405278789065">
<node TEXT="false" ID="ID_256807082" CREATED="1405278767646" MODIFIED="1405278767646"/>
</node>
<node TEXT="addons.roan.whilePlay.doAutoZoom" FOLDED="true" ID="ID_1089034734" CREATED="1406893971716" MODIFIED="1406894298013">
<node TEXT="false" ID="ID_1035173251" CREATED="1406893971716" MODIFIED="1406893971716"/>
</node>
<node TEXT="addons.roan.whilePlay.autoZoomMax" FOLDED="true" ID="ID_1093542335" CREATED="1406894863463" MODIFIED="1406894916713">
<node TEXT="&quot;150" ID="ID_849336706" CREATED="1407233825370" MODIFIED="1411759658102"/>
</node>
<node TEXT="addons.roan.whilePlay.autoZoomMin" FOLDED="true" ID="ID_1224275639" CREATED="1406894897073" MODIFIED="1406894937003">
<node TEXT="&quot;100" ID="ID_829953913" CREATED="1406894897073" MODIFIED="1411759665247"/>
</node>
<node TEXT="addons.roan.windowWidth" FOLDED="true" ID="ID_1279001807" CREATED="1407010105091" MODIFIED="1407010157063">
<node TEXT="&quot;1280" ID="ID_13353093" CREATED="1407010105091" MODIFIED="1411759670831"/>
</node>
<node TEXT="addons.roan.windowHeight" FOLDED="true" ID="ID_823520974" CREATED="1407010181157" MODIFIED="1407010195993">
<node TEXT="&quot;720" ID="ID_173571701" CREATED="1407010181157" MODIFIED="1411759677929"/>
</node>
<node TEXT="addons.roan.imageinline.widthMax" FOLDED="true" ID="ID_303997330" CREATED="1411650006597" MODIFIED="1411717559883">
<node TEXT="&quot;400" ID="ID_402193220" CREATED="1407010181157" MODIFIED="1411759684622"/>
</node>
<node TEXT="addons.roan.imageinline.heightMax" FOLDED="true" ID="ID_696631871" CREATED="1411650006597" MODIFIED="1411717570694">
<node TEXT="&quot;300" ID="ID_506028947" CREATED="1407010181157" MODIFIED="1411759689115"/>
</node>
</node>
</node>
</node>
<node TEXT="deinstall" POSITION="left" ID="ID_1559504636" CREATED="1399926585795" MODIFIED="1468364716343">
<edge COLOR="#7c0000"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      List of files and/or directories to remove on uninstall
    </p>
  </body>
</html>
</richcontent>
<attribute_layout NAME_WIDTH="51" VALUE_WIDTH="731"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}.script.xml"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/lib/roan-presentation.jar"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/lib/roan.jar"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/lib/scriptlib.jar"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/auto_clearUserDirFiles.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/auto_setLibAndFileAction.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/copyLinkToNodeInOtherMap.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/insertInlineImage.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/insertInlineImage_forRoAn.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/presentation_editDialogAction.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/presentation_helpAction.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/presentation_menuAction.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/presentation_playAction.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/presentation_stepAction.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/presentation_windowSizeAction.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/freeplane/freeplaneTutorial.mm"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/freeplane/freeplaneTutorial_nl.mm"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/AlbumArtSmall.jpg"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/AlbumArt_{5FA05D35-A682-4AF6-96F7-0773E42D4D16}_Large.jpg"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/AlbumArt_{5FA05D35-A682-4AF6-96F7-0773E42D4D16}_Small.jpg"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/AlbumArt_{90050B65-0BAE-4F30-89CE-453F59AC7B77}_Large.jpg"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/AlbumArt_{90050B65-0BAE-4F30-89CE-453F59AC7B77}_Small.jpg"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/EditDialogs.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/Folder.jpg"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/ID_133677263_1.mp3"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/ID_1952766141_1.mp3"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/Ins.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/Nieuwe mindmap.mm"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/RoAn_logo.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/circleNavigation.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/ctrl.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/desktop.ini"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/enter.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/mouse_LB.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/mouse_LB_2x.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/mouse_RB.png"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/roan-presentation_help.mm"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/roan-presentation_help_nl.mm"/>
<attribute NAME="delete" VALUE="${installationbase}/doc/roan-presentation_help/someMp3.mp3"/>
<attribute NAME="delete" VALUE="${installationbase}/icons/roan-Scene.png"/>
<attribute NAME="delete" VALUE="${installationbase}/resources/images/roan-back.png"/>
<attribute NAME="delete" VALUE="${installationbase}/resources/images/roan-step.png"/>
<attribute NAME="delete" VALUE="${installationbase}/resources/images/roan-stop.png"/>
</node>
<node TEXT="scripts" FOLDED="true" POSITION="right" ID="ID_760814346" CREATED="1399926585835" MODIFIED="1468364519500">
<edge COLOR="#00007c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may contain multiple scripts. The node text defines the script name (e.g. inserInlineImage.groovy). The name must have a suffix of a supported script language like .groovy or .js and may only consist of letters and digits. The script properties have to be configured via attributes:
    </p>
    <p>
      
    </p>
    <p>
      * menuLocation: &lt;locationkey&gt;
    </p>
    <p>
      &#160;&#160;&#160;- Defines where the menu location.
    </p>
    <p>
      &#160;&#160;&#160;-&#160;See mindmapmodemenu.xml for how the menu locations look like.
    </p>
    <p>
      &#160;&#160;&#160;- http://freeplane.bzr.sf.net/bzr/freeplane/freeplane_program/trunk/annotate/head%3A/freeplane/resources/xml/mindmapmodemenu.xml
    </p>
    <p>
      &#160;&#160;&#160;- This attribute is mandatory
    </p>
    <p>
      
    </p>
    <p>
      * menuTitleKey: &lt;key&gt;
    </p>
    <p>
      &#160;&#160;&#160;- The menu item title will be looked up under the translation key &lt;key&gt; - don't forget to define its translation.
    </p>
    <p>
      &#160;&#160;&#160;- This attribute is mandatory
    </p>
    <p>
      
    </p>
    <p>
      * executionMode: &lt;mode&gt;
    </p>
    <p>
      &#160;&#160;&#160;- The execution mode as described in the Freeplane wiki (http://freeplane.sourceforge.net/wiki/index.php/Scripting)
    </p>
    <p>
      &#160;&#160;&#160;- ON_SINGLE_NODE: Execute the script once. The <i>node</i>&#160;variable is set to the selected node.
    </p>
    <p>
      &#160;&#160;&#160;- ON_SELECTED_NODE: Execute the script n times for n selected nodes, once for each node.
    </p>
    <p>
      &#160;&#160;&#160;- ON_SELECTED_NODE_RECURSIVELY: Execute the script on every selected node and recursively on all of its children.
    </p>
    <p>
      &#160;&#160;&#160;- In doubt use ON_SINGLE_NODE.
    </p>
    <p>
      &#160;&#160;&#160;- This attribute is mandatory
    </p>
    <p>
      
    </p>
    <p>
      * keyboardShortcut: &lt;shortcut&gt;
    </p>
    <p>
      &#160;&#160;&#160;- Optional: keyboard combination / accelerator for this script, e.g. control alt I
    </p>
    <p>
      &#160;&#160;&#160;- Use lowercase letters for modifiers and uppercase for letters. Use no + signs.
    </p>
    <p>
      &#160;&#160;&#160;- The available key names are listed at http://download.oracle.com/javase/1.4.2/docs/api/java/awt/event/KeyEvent.html#VK_0
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;In the list only entries with a 'VK_' prefix count. Omit the prefix in the shortcut definition.
    </p>
    <p>
      
    </p>
    <p>
      * Permissions&#160;that the script(s) require, each either false or true:
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_asking
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_file_restriction: permission to read files
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_write_restriction: permission to create/change/delete files
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_exec_restriction: permission to execute other programs
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_network_restriction: permission to access the network
    </p>
    <p>
      &#160;&#160;Notes:
    </p>
    <p>
      &#160;&#160;- The set of permissions is fixed.
    </p>
    <p>
      &#160;&#160;- Don't change the attribute names, don't omit one.
    </p>
    <p>
      &#160;&#160;- Set the values either to true or to false
    </p>
    <p>
      &#160;&#160;- In any case set execute_scripts_without_asking to true unless you want to annoy users.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="presentation_menuAction.groovy" ID="ID_796338224" CREATED="1400322533641" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="291"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.presentation_menuAction"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE="F8"/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="presentation_helpAction.groovy" ID="ID_1284029899" CREATED="1401779846608" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="287"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.presentation_helpAction"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="presentation_playAction.groovy" ID="ID_256579843" CREATED="1401779846624" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="287"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.presentation_playAction"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="presentation_stepAction.groovy" ID="ID_1232219065" CREATED="1401892688830" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="341"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.presentation_stepAction"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="insertInlineImage_forRoAn.groovy" ID="ID_513423073" CREATED="1402055668158" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="341"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.insertInlineImage"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="presentation_editDialogAction.groovy" ID="ID_1560123486" CREATED="1402665412329" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="300"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.presentation_editDialogAction"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="copyLinkToNodeInOtherMap.groovy" ID="ID_902427498" CREATED="1406228604177" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="298"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.copyLinkToNodeInOtherMap"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="auto_setLibAndFileAction.groovy" ID="ID_152078489" CREATED="1406148004197" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="341"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.auto_setLibAndFileAction"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="auto_clearUserDirFiles.groovy" ID="ID_1447292225" CREATED="1406387902980" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="503"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.auto_clearUserDirFiles"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
<node TEXT="presentation_windowSizeAction.groovy" ID="ID_50415285" CREATED="1407011591393" MODIFIED="1409843975888">
<attribute_layout NAME_WIDTH="287" VALUE_WIDTH="310"/>
<attribute NAME="menuTitleKey" VALUE="addons.${name}.presentation_windowSizeAction"/>
<attribute NAME="menuLocation" VALUE="main_menu_scripting/addons.${name}.presentation"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
</node>
</node>
<node TEXT="zips" FOLDED="true" POSITION="right" ID="ID_562669730" CREATED="1399926586037" MODIFIED="1468364519574">
<edge COLOR="#7c007c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may contain any number of nodes containing zip files.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The immediate child nodes contain a description of the zip. The devtools script releaseAddOn.groovy allows automatic zip creation if the name of this node matches a directory in the current directory.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The child nodes of these nodes contain the actual zip files.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- Any zip file will be extracted in the &lt;installationbase&gt;. Currently, &lt;installationbase&gt; is always Freeplane's &lt;userhome&gt;, e.g. ~/.freeplane/1.3.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The files will be processed in the sequence as seen in the map.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="doc" ID="ID_1148428595" CREATED="1402667462146" MODIFIED="1468364465603"/>
<node TEXT="icons" ID="ID_129487079" CREATED="1411213237525" MODIFIED="1468364472195"/>
</node>
<node TEXT="images" POSITION="right" ID="ID_1191857106" CREATED="1399926586047" MODIFIED="1468364519591">
<edge COLOR="#007c7c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may define any number of images as child nodes of the images node. The actual image data has to be placed as base64 encoded binary data into the text of a subnode.
    </p>
    <p>
      The images are saved to the <i>${installationbase}/resources/images</i>&#160;directory.
    </p>
    <p>
      
    </p>
    <p>
      The following images should be present:
    </p>
    <ul>
      <li>
        <i>${name}-icon.png</i>, like <i>oldicons-theme-icon.png</i>. This will be used in the app-on overview.
      </li>
      <li>
        <i>${name}-screenshot-1.png</i>, like <i>oldicons-theme-screenshot-1.png</i>. This will be used in the app-on details dialog. Further images can be included but they are not used yet.
      </li>
    </ul>
    <p>
      Images can be added automatically by releaseAddOn.groovy or must be uploaded into the map via the script <i>Tools-&gt;Scripts-&gt;Insert Binary</i>&#160;since they have to be (base64) encoded as simple strings.
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="lib" FOLDED="true" POSITION="right" ID="ID_1437272991" CREATED="1401781353621" MODIFIED="1468364519541">
<edge COLOR="#7c7c00"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may contain any number of nodes containing binary files (normally .jar files) to be added to the add-on's classpath.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The immediate child nodes contain the name of the file, e.g. 'mysql-connector-java-5.1.25.jar'). Put the file into a 'lib' subdirectory of the add-on base directory.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The child nodes of these nodes contain the actual files.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- Any lib file will be extracted in &lt;installationbase&gt;/&lt;addonname&gt;/lib.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The files will be processed in the sequence as seen in the map.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="roan-presentation.jar" ID="ID_690167891" CREATED="1410894172307" MODIFIED="1468364482426"/>
</node>
<node TEXT="Instruction for translating" LOCALIZED_STYLE_REF="styles.topic" POSITION="right" ID="ID_415454060" CREATED="1403188326818" MODIFIED="1403201382858" LINK="#ID_1819148369">
<edge COLOR="#ff0000"/>
</node>
<node TEXT="translations" FOLDED="true" POSITION="left" ID="ID_478027492" CREATED="1399926585755" MODIFIED="1468364519485">
<edge COLOR="#ff0000"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The translation keys that this script uses. Define one child node per supported locale. The attributes contain the translations. Define at least
    </p>
    <ul>
      <li>
        'addons.${name}' for the add-on's name
      </li>
      <li>
        'addons.${name}.description' for the description, e.g. in the add-on overview dialog (not necessary for English)
      </li>
      <li>
        'addons.${name}.&lt;scriptname&gt;' for each script since it will be the menu title.
      </li>
    </ul>
  </body>
</html>
</richcontent>
<node TEXT="en" FOLDED="true" ID="ID_536136732" CREATED="1399926585775" MODIFIED="1412619056403">
<attribute_layout NAME_WIDTH="465" VALUE_WIDTH="493"/>
<attribute NAME="addons.${name}" VALUE="roan"/>
<attribute NAME="addons.${name}.presentation" VALUE="RoAn-Presentation"/>
<attribute NAME="addons.${name}.presentation_playAction" VALUE="Play"/>
<attribute NAME="addons.${name}.presentation_stepAction" VALUE="Step"/>
<attribute NAME="addons.${name}.presentation_menuAction" VALUE="Menu"/>
<attribute NAME="addons.${name}.presentation_editDialogAction" VALUE="Edit"/>
<attribute NAME="addons.${name}.presentation_helpAction" VALUE="Help"/>
<attribute NAME="addons.${name}.insertInlineImage" VALUE="Inser inline image"/>
<attribute NAME="addons.roan.sliderTooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Nr of seconds selected node displays.&lt;br&gt;Change slider for new value for selected node(s).&lt;br&gt;Value in root node determines default.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.playTitle" VALUE="Play nodes"/>
<attribute NAME="addons.roan.stepTitle" VALUE="Step next or if playing cut delay."/>
<attribute NAME="addons.roan.stopTitle" VALUE="Stop playing"/>
<attribute NAME="addons.roan.attributes_OnTitle" VALUE="Hide attributes"/>
<attribute NAME="addons.roan.attributes_OffTitle" VALUE="Show attributes"/>
<attribute NAME="addons.roan.state_OnTitle" VALUE="Hide atrribute icons"/>
<attribute NAME="addons.roan.state_OffTitle" VALUE="Show attribute icons"/>
<attribute NAME="addons.roan.init" VALUE="Initialize mind map"/>
<attribute NAME="addons.roan.helpTitle" VALUE="Help"/>
<attribute NAME="addons.roan.homeTitle" VALUE="RoAn-Home: Select and fold root"/>
<attribute NAME="addons.roan.menuTitle" VALUE="RoAn-Presentation"/>
<attribute NAME="addons.roan.editTitle" VALUE="Roan-Edit"/>
<attribute NAME="addons.roan.imageTitle" VALUE="Insert inline image in selected node"/>
<attribute NAME="addons.roan.grey_OnTitle" VALUE="Grey background: set OFF"/>
<attribute NAME="addons.roan.grey_OffTitle" VALUE="Grey background: set ON"/>
<attribute NAME="addons.roan.backTitle" VALUE="Step back in sequence or during play stop"/>
<attribute NAME="addons.roan.tooltip_OnTitle" VALUE="Hide tooltip"/>
<attribute NAME="addons.roan.tooltip_OffTitle" VALUE="Show tooltip"/>
<attribute NAME="addons.roan.plusSizeTitle" VALUE="Minimize window"/>
<attribute NAME="addons.roan.minSizeTitle" VALUE="Maximize window"/>
<attribute NAME="addons.roan.action" VALUE="Action"/>
<attribute NAME="addons.roan.actionOnOpen" VALUE="On Open"/>
<attribute NAME="addons.roan.actionOnNext" VALUE="On Continue"/>
<attribute NAME="addons.roan.actionOnBack" VALUE="On Back"/>
<attribute NAME="addons.roan.currentNodeTitle" VALUE="Load"/>
<attribute NAME="addons.roan.currentNodeTitle_tooltip" VALUE="Load from selected node"/>
<attribute NAME="addons.roan.pasteSelectedsTitle" VALUE="... selecteds"/>
<attribute NAME="addons.roan.pasteCurrentTitle" VALUE="Paste"/>
<attribute NAME="addons.roan.pasteCurrentTitle_tooltip" VALUE="Current node is shown to the left."/>
<attribute NAME="addons.roan.scriptLabelTitle" VALUE="Script actions"/>
<attribute NAME="addons.roan.scriptButtonOpenTitle" VALUE="Open"/>
<attribute NAME="addons.roan.scriptButtonContinueTitle" VALUE="Continue"/>
<attribute NAME="addons.roan.scriptButtonBackTitle" VALUE="Back"/>
<attribute NAME="addons.roan.toggleScriptButton_tooltip" VALUE="Toggle Open - Continue - Back states."/>
<attribute NAME="addons.roan.currentNodeText_tooltip" VALUE="Node text of current node."/>
<attribute NAME="addons.roan.scriptActions_tooltip" VALUE="List of menu- and filter actions."/>
<attribute NAME="addons.roan.pasteSelecteds_tooltip" VALUE="Paste to all selected nodes. Replace old."/>
<attribute NAME="addons.roan.initMessage" VALUE="Added initialization code to Root attributes."/>
<attribute NAME="addons.roan.fullScreenOnTitle" VALUE="Screen - with Freeplane menu bars"/>
<attribute NAME="addons.roan.fullScreenOffTitle" VALUE="Screen - full without Freeplane menu bars"/>
<attribute NAME="OptionPanel.plugin.addons.roan" VALUE="RoAn-Presentation"/>
<attribute NAME="OptionPanel.separator.addons.roan.onOpenMaxMenu" VALUE="On open/maximize menu"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.screenModeMaxOff" VALUE="Screenmode: with menubars"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.greyBackgroundOff" VALUE="Grey backround: OFF"/>
<attribute NAME="OptionPanel.separator.addons.roan.onOpenMinMenu" VALUE="On minimize menu"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.screenModeMaxOn" VALUE="Screenmode: full screen"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.greyBackgroundOn" VALUE="Grey background: ON"/>
<attribute NAME="OptionPanel.separator.addons.roan.onCloseMenu" VALUE="On close menu"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu.screenModeMaxOff" VALUE="Screen mode: with menu bars:"/>
<attribute NAME="OptionPanel.separator.addons.roan.onPlay" VALUE="On Play"/>
<attribute NAME="OptionPanel.addons.roan.onPlay.screenModeMaxOn" VALUE="Screen mode: full screen"/>
<attribute NAME="OptionPanel.addons.roan.onPlay.greyBackgroundOn" VALUE="Grey background: ON"/>
<attribute NAME="OptionPanel.separator.addons.roan.finishPlay" VALUE="On finish/stop Play"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay.screenModeMaxOff" VALUE="Screen mode: with menu bars"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay.greyBackgroundOff" VALUE="Grey backround: OFF"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.tooltipsOn" VALUE="Show tooltips"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.attributesOff" VALUE="Hide attributes"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.attributesIconOff" VALUE="Hide icons for attributes"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.tooltipsOff" VALUE="Hide tootips"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.attributesIconOff" VALUE="Hide icons for attributes"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu_greyBackgroundOff" VALUE="Grey background: OFF"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu.tooltipsOn" VALUE="Show tooltips"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu_attributesOn" VALUE="Show attributes"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu_attributesIconOn" VALUE="Show icons for attributes"/>
<attribute NAME="OptionPanel.addons.roan.onPlay.tooltipsOff" VALUE="Hide tooltips"/>
<attribute NAME="OptionPanel.addons.roan.onPlay_attributesOff" VALUE="Hide attributes"/>
<attribute NAME="OptionPanel.addons.roan.onPlay_attributesIconOff" VALUE="Hide icon for attributes"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay_tooltipsOn" VALUE="Show tootips"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay_attributesOn" VALUE="Show attributes"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay_attributesIconOn" VALUE="Show icon for attributes"/>
<attribute NAME="OptionPanel.separator.addons.roan.whilePlay" VALUE="While playing"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.all" VALUE="Play all"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.cycle" VALUE="Keep playing"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.slowMove" VALUE="Slow move"/>
<attribute NAME="addons.inlineImage.invalidImageFile" VALUE="invalid image file : "/>
<attribute NAME="addons.inlineImage.cancel" VALUE="Cancel"/>
<attribute NAME="addons.inlineImage.mustBeSaved " VALUE="The map must be saved if you want to use relative paths"/>
<attribute NAME="addons.inlineImage.saveclipboardImageAsTitle" VALUE="Save clipboard image as"/>
<attribute NAME="addons.inlineImage.imageFiles" VALUE="Image files"/>
<attribute NAME="addons.inlineImage.insertModifyImage" VALUE="Insert/Modify Image"/>
<attribute NAME="addons.inlineImage.pasteImageFromClipboardTitle" VALUE="Paste image from Clipboard"/>
<attribute NAME="addons.inlineImage.la_width" VALUE="Width:"/>
<attribute NAME="addons.inlineImage.la_height" VALUE="Height:"/>
<attribute NAME="addons.inlineImage.imagePath" VALUE="image path"/>
<attribute NAME="addons.inlineImage.yourLink" VALUE="your link"/>
<attribute NAME="addons.inlineImage.asLegend" VALUE="as legend"/>
<attribute NAME="addons.inlineImage.noLink" VALUE="no link"/>
<attribute NAME="addons.inlineImage.proportionalImageResizing" VALUE="Proportional image resizing:"/>
<attribute NAME="addons.inlineImage.rb_core" VALUE="Core"/>
<attribute NAME="addons.inlineImage.rb_details" VALUE="Details"/>
<attribute NAME="addons.inlineImage.rb_note" VALUE="Note"/>
<attribute NAME="addons.inlineImage.rb_extension" VALUE="Extension"/>
<attribute NAME="addons.inlineImage.la_target" VALUE="Target:"/>
<attribute NAME="addons.inlineImage.linkTargetLabel" VALUE="Link target :"/>
<attribute NAME="addons.roan.filter_On" VALUE="Filter during presentation: set ON"/>
<attribute NAME="addons.roan.filter_Off" VALUE="Filter during presentation: set OFF"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.doFilter" VALUE="Filter"/>
<attribute NAME="addons.${name}.auto_setLibAndFileAction" VALUE="Activate addon"/>
<attribute NAME="addons.${name}.auto_clearUserDirFiles" VALUE="Clear unnessesary files"/>
<attribute NAME="addons.${name}.copyLinkToNodeInOtherMap" VALUE="Link to node in other map"/>
<attribute NAME="addons.roan.userdirfiles.remove1" VALUE="1. Remove files if not for language"/>
<attribute NAME="addons.roan.userdirfiles.remove2" VALUE="2. Remove log files ?"/>
<attribute NAME="addons.roan.userdirfiles.remove3" VALUE="3. Remove backup files ?"/>
<attribute NAME="addons.roan.userdirfiles.restart" VALUE="You may have to restart Freeplane."/>
<attribute NAME="addons.${name}.addon" VALUE="addons"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.doAutoZoom" VALUE="auto zoom"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.autoZoomMax" VALUE="auto zoom % maximum"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.autoZoomMin" VALUE="auto zoom % minimum"/>
<attribute NAME="addons.roan.autoZoom_On" VALUE="Zoom in and out: set ON"/>
<attribute NAME="addons.roan.autoZoom_Off" VALUE="Zoom in and out: set OFF"/>
<attribute NAME="OptionPanel.separator.addons.roan.windowSize" VALUE="Window size"/>
<attribute NAME="OptionPanel.addons.roan.windowWidth" VALUE="width (pixels)"/>
<attribute NAME="OptionPanel.addons.roan.windowHeight" VALUE="height (pixels)"/>
<attribute NAME="addons.${name}.presentation_windowSizeAction" VALUE="Set window size (recording)"/>
<attribute NAME="addons.roan.center" VALUE="Center"/>
<attribute NAME="addons.roan.center.tooltip" VALUE="Center currently selected node."/>
<attribute NAME="addons.roan.continuation" VALUE="Stop and Bounce"/>
<attribute NAME="addons.roan.continuation.STOP" VALUE="STOP"/>
<attribute NAME="addons.roan.continuation.BOUNCE" VALUE="BOUNCE"/>
<attribute NAME="addons.roan.continuation.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    STOP: finish presentation.&lt;br&gt;BOUNCE: continue with sibling.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.delay" VALUE="Delay"/>
<attribute NAME="addons.roan.delay.message" VALUE="Delay/wait seconds"/>
<attribute NAME="addons.roan.delay.tooltip" VALUE="Display seconds"/>
<attribute NAME="addons.roan.detailsVisible.key" VALUE="Details"/>
<attribute NAME="addons.roan.detailsVisible.show" VALUE="SHOW"/>
<attribute NAME="addons.roan.detailsVisible.hide" VALUE="HIDE"/>
<attribute NAME="addons.roan.detailsVisible.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Set details for node of this action (default) or&lt;br&gt;for currently selected node(s)&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.toggleEditDialog" VALUE="Toggle Edit dialog"/>
<attribute NAME="addons.roan.toggleEditDialog.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Show or hide RoAns Edit dialog.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.filtering" VALUE="Filtering"/>
<attribute NAME="addons.roan.filtering.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Virtually click automatic-filter button for&lt;br&gt;filtering nodes of current branch.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.filterNamed" VALUE="Filter (named)"/>
<attribute NAME="addons.roan.filterNamed.dialogTitle" VALUE="Apply predefined named filter."/>
<attribute NAME="addons.roan.filterNamed.error" VALUE="You must first define a named filter with the freeplane Compose filter editor."/>
<attribute NAME="addons.roan.filterNamed.hideAncestorsTitle" VALUE="Hide ancestors"/>
<attribute NAME="addons.roan.filterNamed.showAncestorsTitle" VALUE="Show ancestors"/>
<attribute NAME="addons.roan.filterNamed.ancestorsNULL" VALUE="As Freeplane menusetting."/>
<attribute NAME="addons.roan.filterNamed.hideDesendantsTitle" VALUE="Hide descendants"/>
<attribute NAME="addons.roan.filterNamed.showDescendantsTitle" VALUE="Show descendants"/>
<attribute NAME="addons.roan.filterNamed.descendantsNULL" VALUE="As Freeplane menu setting"/>
<attribute NAME="addons.roan.filterNamed.applyToAllNodesTitle" VALUE="Apply to all nodes "/>
<attribute NAME="addons.roan.filterNamed.applyToVisibleNodesOnlyTitle" VALUE="Apply to visible nodes only"/>
<attribute NAME="addons.roan.filterNamed.visibleNodesOnlyNULLTitle" VALUE="As freeplane menu seeting."/>
<attribute NAME="addons.roan.filterNamed.selectCurrentTitle" VALUE="Select current node"/>
<attribute NAME="addons.roan.filterNamed.selectCurrentlySelectedsTitle" VALUE="Select currently selected nodes"/>
<attribute NAME="addons.roan.filterNamed.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Set named filter.&lt;br&gt;Select for dialog.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.folding" VALUE="Folding"/>
<attribute NAME="addons.roan.folding.fold" VALUE="Fold"/>
<attribute NAME="addons.roan.folding.unfold" VALUE="Unfold"/>
<attribute NAME="addons.roan.folding.current" VALUE="Action node"/>
<attribute NAME="addons.roan.folding.selecteds" VALUE="Currently selected nodes"/>
<attribute NAME="addons.roan.folding.root" VALUE="Root node"/>
<attribute NAME="addons.roan.folding.all" VALUE="All"/>
<attribute NAME="addons.roan.folding.level1" VALUE="First level"/>
<attribute NAME="addons.roan.folding.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Fold or unfold node(s).&lt;br&gt;Select for dialog.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.followLink" VALUE="Follow link"/>
<attribute NAME="addons.roan.followLink.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Open and display link.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.fullScreen" VALUE="Full screen"/>
<attribute NAME="addons.roan.fullScreen.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Virtually click full screen button to hide or show menu bars&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.greyedSurround" VALUE="Greyed surround"/>
<attribute NAME="addons.roan.greyedSurround.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Virtually click greyed surround button&lt;br&gt;to enhance presentation focus.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.homeRoAn" VALUE="Home RoAn"/>
<attribute NAME="addons.roan.homeRoAn.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Virtually click RoAn button home.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.jump" VALUE="Jump"/>
<attribute NAME="addons.roan.jump.tooltip" VALUE="Jump to currently selected node"/>
<attribute NAME="addons.roan.jump.warningMessage" VALUE="You have to select a node to jump to not being the current node."/>
<attribute NAME="addons.roan.menuFreeplane" VALUE="Menu action"/>
<attribute NAME="addons.roan.menuFreeplane.dialog_message" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Execute freeplane menu action.&lt;br&gt;Get with addon Developer tools and paste here:&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.menuFreeplane.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Execute freeplane menu action.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.menuRoan" VALUE="Menu RoAn size"/>
<attribute NAME="addons.roan.menuRoan.maximum" VALUE="Maximum"/>
<attribute NAME="addons.roan.menuRoan.minimum" VALUE="Minimum"/>
<attribute NAME="addons.roan.menuRoan.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Virtually click sizing button of Roan menu.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.scrolling" VALUE="Scrolling"/>
<attribute NAME="addons.roan.scrolling.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Move the current scroll position delta XY pixels.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.selecteds" VALUE="Selected nodes"/>
<attribute NAME="addons.roan.selecteds.addingCurrentlySelected" VALUE="Adding currently selected nodes:"/>
<attribute NAME="addons.roan.selecteds.change" VALUE="To change selection: press Cancel."/>
<attribute NAME="addons.roan.selecteds.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    The currently selected nodes will be selected.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.zoom" VALUE="Zoom %"/>
<attribute NAME="addons.roan.zoom.dialog_message" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Set zoom %&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.zoom.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Set zoom action for this node.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.zooming" VALUE="Zooming"/>
<attribute NAME="addons.roan.zooming.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Virtually click automatic-zoom button for zooming in and out while stepping.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.actionBoolean.allSelectedsMessage" VALUE="By default node with action.\nApply to currently selected node(s) ?"/>
<attribute NAME="addons.roan.actionBoolean.ON" VALUE="ON"/>
<attribute NAME="addons.roan.actionBoolean.OFF" VALUE="OFF"/>
<attribute NAME="addons.roan.EditDialog.addActions" VALUE="Menu with actions"/>
<attribute NAME="OptionPanel.separator.addons.roan.imageinline" VALUE="Insert inline images"/>
<attribute NAME="OptionPanel.addons.roan.imageinline.widthMax" VALUE="maximum width"/>
<attribute NAME="OptionPanel.addons.roan.imageinline.heightMax" VALUE="maximum height"/>
<attribute NAME="addons.roan.imageinline.locationImageLabelTitle" VALUE="Location image"/>
<attribute NAME="addons.roan.imageinline.widthMaxTitle" VALUE="maximum width"/>
<attribute NAME="addons.roan.imageinline.heightMaxTitle" VALUE="maximum height"/>
<attribute NAME="addons.roan.imageinline.Current" VALUE="Current node"/>
<attribute NAME="addons.roan.imageinline.Parent" VALUE="Parent node"/>
<attribute NAME="addons.roan.imageinline.dialogTitle" VALUE="Add inline image(s)"/>
<attribute NAME="addons.roan.imageinline.fromParentDirectoryTitle" VALUE="Add images from map-directory"/>
<attribute NAME="addons.roan.imageinline.fromRedArrowLinksTitle" VALUE="Images from selected red-arrow links"/>
<attribute NAME="addons.roan.imageinline.fromAddonInsertInlineImageTitle" VALUE="Image by addon Insert Inline Image"/>
<attribute NAME="addons.roan.imageinline.subMenuTitle" VALUE="SubMenu"/>
<attribute NAME="addons.roan.imageinline.isResizeExisitingTitle" VALUE="Resize existing"/>
<attribute NAME="addons.roan.indexTitle" VALUE="Index: add links to folders and files in the directory the mindmap is in"/>
<attribute NAME="addons.roan.nodelib.CORE" VALUE="CORE"/>
<attribute NAME="addons.roan.nodelib.DETAILS" VALUE="DETAILS"/>
<attribute NAME="addons.roan.nodelib.NOTE" VALUE="NOTE"/>
<attribute NAME="addons.roan.nodelib.ARROW" VALUE="ARROW"/>
<attribute NAME="addons.roan.lockTitle" VALUE="Set password on map (encrypt)"/>
<attribute NAME="addons.roan.index.directoryTitle" VALUE="directory"/>
<attribute NAME="addons.roan.index.isDirectoryIconTitle" VALUE="Icon for directory"/>
<attribute NAME="addons.roan.index.locationLinkDirectoryLabelTitle" VALUE="Location directory link"/>
<attribute NAME="addons.roan.index.locationLinkFileLabelTitle" VALUE="Location file link"/>
<attribute NAME="addons.roan.index.dialogTitle" VALUE="Add node and link for each folder and file"/>
<attribute NAME="addons.roan.index.sortLabelTitle" VALUE="Sort"/>
<attribute NAME="addons.roan.index.divisionRootLabelTitle" VALUE="Divide nodes left-right"/>
<attribute NAME="addons.roan.index.divisionRootRIGHTTitle" VALUE="RIGHT"/>
<attribute NAME="addons.roan.index.divisionRootLEFTRIGHTTitle" VALUE="LEFT-RIGHT"/>
<attribute NAME="addons.roan.index.divisionRootRIGHTLEFTTitle" VALUE="RIGHT-LEFT"/>
<attribute NAME="addons.roan.index.divisionRootMAPFILETitle" VALUE="MAPS-FILES"/>
<attribute NAME="addons.roan.index.divisionRootFILEMAPTitle" VALUE="FILES-MAPS"/>
<attribute NAME="addons.roan.index.sortNONETitle" VALUE="NONE"/>
<attribute NAME="addons.roan.index.sortFOREWARDTitle" VALUE="FOREWARD"/>
<attribute NAME="addons.roan.index.sortBACKWARDTitle" VALUE="BACKWARD"/>
<attribute NAME="addons.roan.index.showFileExtensionTitle" VALUE="Show file extension"/>
<attribute NAME="addons.roan.index.isDirectoryNodesTitle" VALUE="Directory nodes"/>
<node TEXT="tools" FOLDED="true" ID="ID_1632488322" CREATED="1403185437178" MODIFIED="1403807522413">
<font BOLD="true"/>
<richcontent TYPE="DETAILS" HIDDEN="true">

<html>
  <head>
    
  </head>
  <body>
    <p>
      support for filling attributes in translation node
    </p>
  </body>
</html>
</richcontent>
<node TEXT="Instruction for translation" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1000712996" CREATED="1403185903209" MODIFIED="1403185991547">
<node TEXT="Copy node &quot;en&quot;" ID="ID_1819148369" CREATED="1403185951531" MODIFIED="1403185979449"/>
<node TEXT="Paste on &quot;translations&quot;" ID="ID_1079652504" CREATED="1403185997590" MODIFIED="1403186024605"/>
<node TEXT="Rename &quot;en&quot;: replace by your language code" ID="ID_1479376942" CREATED="1403186013883" MODIFIED="1403190406511" LINK="#ID_624507685"/>
<node TEXT="unfold &quot;tools&quot;" ID="ID_975600690" CREATED="1403186071667" MODIFIED="1403186092567"/>
<node TEXT="Click button in node &quot;table to source&quot;" ID="ID_1043310304" CREATED="1403201292918" MODIFIED="1403201319516"/>
<node TEXT="Unfold &quot;source&quot;" ID="ID_566050949" CREATED="1403186093144" MODIFIED="1403201329866"/>
<node TEXT="Replace English text in grandchildren of source,&#xa;by text in your language." ID="ID_1666482741" CREATED="1403186105449" MODIFIED="1403186143108"/>
<node TEXT="Click the button in node &quot;source to table&quot;" ID="ID_523656523" CREATED="1403186151156" MODIFIED="1403186212220"/>
<node TEXT="Save and Reinstall the addon to test it." ID="ID_1462186539" CREATED="1403187561836" MODIFIED="1403187635304"/>
<node TEXT="If all works fine, children of source may be deleted." ID="ID_346965012" CREATED="1403250428994" MODIFIED="1403250458852"/>
</node>
<node TEXT="Click icon to find language code for translation" LOCALIZED_STYLE_REF="styles.topic" ID="ID_624507685" CREATED="1389967159453" MODIFIED="1406228972036" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="import org.freeplane.core.resources.ResourceController&#xd;&#xa;ResourceController resourceController = ResourceController.resourceController&#xd;&#xa;String dir=resourceController.freeplaneUserDirectory&#xd;&#xa;String languageCode = resourceController.languageCode&#xd;&#xa;node.details=languageCode"/>
</node>
<node TEXT="table to source" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_233164537" CREATED="1403184244360" MODIFIED="1406228972036" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="def translation=node.parent.parent&#xa;  def tools=node.parent&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xa;  def source=li[0]&#xa;  source.children.each{it.delete()}&#xa;    &#xa;    li=translation.attributes.getAttributeNames()&#xa;&#x9;li.each{&#xa;&#x9;&#x9;def attr=source.createChild()&#xa;&#x9;&#x9;attr.text=it&#xa;        &#xa;        def child=attr.createChild()&#xa;&#x9;&#x9;child.text=translation[it]&#x9;&#x9;&#xa;&#x9;}"/>
<node TEXT="first action" ID="ID_1779218534" CREATED="1403250403517" MODIFIED="1403250410383"/>
</node>
<node TEXT="source to table" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_929232867" CREATED="1403184244360" MODIFIED="1406228972026" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="def translation=node.parent.parent&#xa;  def tools=node.parent&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xa;  def source=li[0]&#xa;&#xa;translation.attributes.clear()&#xa;source.children.each{ &#xa;    def valNode=it.children[0]&#xa;    translation[it.text]=valNode.text&#xa;    }"/>
<node TEXT="final action" ID="ID_867029381" CREATED="1403250392808" MODIFIED="1403250400173"/>
</node>
<node TEXT="filter source" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_736232974" CREATED="1403180253094" MODIFIED="1406228972026" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="String strip(String s){ &#xd;&#xa;    s-=&apos;&quot;&apos;;   s-=&apos;&quot;&apos;&#xd;&#xa;     s-=&quot;&apos;&quot;;   s-=&quot;&apos;&quot;&#xd;&#xa;     s-=&apos;,&apos;&#xd;&#xa;     return s&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;  def tools=node.parent&#xd;&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xd;&#xa;  def source=li[0]&#xd;&#xa;  &#xd;&#xa;  source.children.each{&#xd;&#xa;  it.text=strip(it.text)&#xd;&#xa;  def details=it.children[0]&#xd;&#xa;  details.text=strip(details.text)&#xd;&#xa;}"/>
<node TEXT="For developer only: removes unnessary &quot;, &apos; and , after copy to source from .groovy" ID="ID_1085057492" CREATED="1403250344052" MODIFIED="1403250505044"/>
</node>
<node TEXT="source" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1721512162" CREATED="1403179064996" MODIFIED="1411654876905" BACKGROUND_COLOR="#ffff99" STYLE="bubble">
<node TEXT="addons.${name}" FOLDED="true" ID="ID_1924407860" CREATED="1405837823421" MODIFIED="1405837823421">
<node TEXT="roan" ID="ID_867194243" CREATED="1405837823421" MODIFIED="1405837823453"/>
</node>
<node TEXT="addons.${name}.presentation" FOLDED="true" ID="ID_588442412" CREATED="1405837823453" MODIFIED="1405837823453">
<node TEXT="RoAn-Presentation" ID="ID_26059706" CREATED="1405837823453" MODIFIED="1405837823453"/>
</node>
<node TEXT="addons.${name}.presentation_playAction" FOLDED="true" ID="ID_1635134050" CREATED="1405837823453" MODIFIED="1405837823468">
<node TEXT="Play" ID="ID_1899623890" CREATED="1405837823468" MODIFIED="1405837823468"/>
</node>
<node TEXT="addons.${name}.presentation_stepAction" FOLDED="true" ID="ID_945766580" CREATED="1405837823468" MODIFIED="1405837823468">
<node TEXT="Step" ID="ID_1009104501" CREATED="1405837823468" MODIFIED="1405837823468"/>
</node>
<node TEXT="addons.${name}.presentation_menuAction" FOLDED="true" ID="ID_1233458112" CREATED="1405837823468" MODIFIED="1405837823468">
<node TEXT="Menu" ID="ID_1102275327" CREATED="1405837823468" MODIFIED="1405837823468"/>
</node>
<node TEXT="addons.${name}.presentation_editDialogAction" FOLDED="true" ID="ID_1936336677" CREATED="1405837823468" MODIFIED="1405837823468">
<node TEXT="Edit" ID="ID_1789124782" CREATED="1405837823468" MODIFIED="1405837823468"/>
</node>
<node TEXT="addons.${name}.presentation_helpAction" FOLDED="true" ID="ID_1962387934" CREATED="1405837823468" MODIFIED="1405837823468">
<node TEXT="Help" ID="ID_1909401989" CREATED="1405837823484" MODIFIED="1405837823484"/>
</node>
<node TEXT="addons.${name}.insertInlineImage" FOLDED="true" ID="ID_1683582213" CREATED="1405837823484" MODIFIED="1405837823484">
<node TEXT="Inser inline image" ID="ID_1015692721" CREATED="1405837823484" MODIFIED="1405837823484"/>
</node>
<node TEXT="addons.roan.sliderTooltip" FOLDED="true" ID="ID_1439148912" CREATED="1405837823484" MODIFIED="1405837823484">
<node ID="ID_121314775" CREATED="1405837823484" MODIFIED="1405837823515"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Nr of seconds selected node displays.<br/>Change slider for new value for selected node(s).<br/>Value in root node determines default.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.playTitle" FOLDED="true" ID="ID_1370757311" CREATED="1405837823515" MODIFIED="1405837823515">
<node TEXT="Play nodes" ID="ID_531210899" CREATED="1405837823515" MODIFIED="1405837823515"/>
</node>
<node TEXT="addons.roan.stepTitle" FOLDED="true" ID="ID_1185594498" CREATED="1405837823515" MODIFIED="1405837823515">
<node TEXT="Step next or if playing cut delay." ID="ID_1092399027" CREATED="1405837823515" MODIFIED="1405837823515"/>
</node>
<node TEXT="addons.roan.stopTitle" FOLDED="true" ID="ID_1107832876" CREATED="1405837823531" MODIFIED="1405837823531">
<node TEXT="Stop playing" ID="ID_1912258349" CREATED="1405837823531" MODIFIED="1405837823531"/>
</node>
<node TEXT="addons.roan.attributes_OnTitle" FOLDED="true" ID="ID_245969374" CREATED="1405837823531" MODIFIED="1405837823531">
<node TEXT="Hide attributes" ID="ID_1093114983" CREATED="1405837823531" MODIFIED="1405837823531"/>
</node>
<node TEXT="addons.roan.attributes_OffTitle" FOLDED="true" ID="ID_399211463" CREATED="1405837823531" MODIFIED="1405837823531">
<node TEXT="Show attributes" ID="ID_442622832" CREATED="1405837823531" MODIFIED="1405837823531"/>
</node>
<node TEXT="addons.roan.state_OnTitle" FOLDED="true" ID="ID_790398426" CREATED="1405837823531" MODIFIED="1405837823531">
<node TEXT="Hide atrribute icons" ID="ID_176538242" CREATED="1405837823531" MODIFIED="1405837823546"/>
</node>
<node TEXT="addons.roan.state_OffTitle" FOLDED="true" ID="ID_1298265311" CREATED="1405837823546" MODIFIED="1405837823546">
<node TEXT="Show attribute icons" ID="ID_944540153" CREATED="1405837823546" MODIFIED="1405837823546"/>
</node>
<node TEXT="addons.roan.init" FOLDED="true" ID="ID_606058043" CREATED="1405837823546" MODIFIED="1405837823546">
<node TEXT="Initialize mind map" ID="ID_183703855" CREATED="1405837823546" MODIFIED="1405837823546"/>
</node>
<node TEXT="addons.roan.helpTitle" FOLDED="true" ID="ID_482534033" CREATED="1405837823546" MODIFIED="1405837823546">
<node TEXT="Help" ID="ID_370165765" CREATED="1405837823546" MODIFIED="1405837823546"/>
</node>
<node TEXT="addons.roan.homeTitle" FOLDED="true" ID="ID_991828189" CREATED="1405837823546" MODIFIED="1405837823546">
<node TEXT="RoAn-Home: Select and fold root" ID="ID_47573986" CREATED="1405837823546" MODIFIED="1405837823562"/>
</node>
<node TEXT="addons.roan.menuTitle" FOLDED="true" ID="ID_1577763152" CREATED="1405837823562" MODIFIED="1405837823562">
<node TEXT="RoAn-Presentation" ID="ID_703385730" CREATED="1405837823562" MODIFIED="1405837823562"/>
</node>
<node TEXT="addons.roan.editTitle" FOLDED="true" ID="ID_32089857" CREATED="1405837823562" MODIFIED="1405837823562">
<node TEXT="Roan-Edit" ID="ID_1031578661" CREATED="1405837823562" MODIFIED="1405837823562"/>
</node>
<node TEXT="addons.roan.imageTitle" FOLDED="true" ID="ID_684870305" CREATED="1405837823562" MODIFIED="1405837823562">
<node TEXT="Insert inline image in selected node" ID="ID_707555277" CREATED="1405837823562" MODIFIED="1405837823562"/>
</node>
<node TEXT="addons.roan.grey_OnTitle" FOLDED="true" ID="ID_1690220646" CREATED="1405837823562" MODIFIED="1405837823562">
<node TEXT="Grey background: set OFF" ID="ID_1834065170" CREATED="1405837823562" MODIFIED="1406924905221"/>
</node>
<node TEXT="addons.roan.grey_OffTitle" FOLDED="true" ID="ID_1465703877" CREATED="1405837823577" MODIFIED="1405837823577">
<node TEXT="Grey background: set ON" ID="ID_357976051" CREATED="1405837823577" MODIFIED="1406924938263"/>
</node>
<node TEXT="addons.roan.backTitle" FOLDED="true" ID="ID_1681830493" CREATED="1405837823577" MODIFIED="1405837823577">
<node TEXT="Step back in sequence or during play stop" ID="ID_1540641142" CREATED="1405837823577" MODIFIED="1405837823577"/>
</node>
<node TEXT="addons.roan.tooltip_OnTitle" FOLDED="true" ID="ID_254484805" CREATED="1405837823577" MODIFIED="1405837823577">
<node TEXT="Hide tooltip" ID="ID_882142631" CREATED="1405837823577" MODIFIED="1405837823593"/>
</node>
<node TEXT="addons.roan.tooltip_OffTitle" FOLDED="true" ID="ID_646373838" CREATED="1405837823593" MODIFIED="1405837823593">
<node TEXT="Show tooltip" ID="ID_1362376103" CREATED="1405837823593" MODIFIED="1405837823593"/>
</node>
<node TEXT="addons.roan.plusSizeTitle" FOLDED="true" ID="ID_236928589" CREATED="1405837823593" MODIFIED="1405837823593">
<node TEXT="Minimize window" ID="ID_408580089" CREATED="1405837823593" MODIFIED="1405837823593"/>
</node>
<node TEXT="addons.roan.minSizeTitle" FOLDED="true" ID="ID_819640503" CREATED="1405837823593" MODIFIED="1405837823593">
<node TEXT="Maximize window" ID="ID_1681713773" CREATED="1405837823593" MODIFIED="1405837823609"/>
</node>
<node TEXT="addons.roan.action" FOLDED="true" ID="ID_1347324329" CREATED="1405837823624" MODIFIED="1405837823624">
<node TEXT="Action" ID="ID_181955222" CREATED="1405837823624" MODIFIED="1405837823624"/>
</node>
<node TEXT="addons.roan.actionOnOpen" FOLDED="true" ID="ID_1143529210" CREATED="1405837823624" MODIFIED="1405837823624">
<node TEXT="On Open" ID="ID_1823600485" CREATED="1405837823624" MODIFIED="1409843594837"/>
</node>
<node TEXT="addons.roan.actionOnNext" FOLDED="true" ID="ID_793570981" CREATED="1405837823624" MODIFIED="1405837823624">
<node TEXT="On Continue" ID="ID_160838092" CREATED="1405837823624" MODIFIED="1409843577302"/>
</node>
<node TEXT="addons.roan.actionOnBack" FOLDED="true" ID="ID_586451504" CREATED="1405837823640" MODIFIED="1405837823640">
<node TEXT="On Back" ID="ID_918597563" CREATED="1405837823640" MODIFIED="1409843589845"/>
</node>
<node TEXT="addons.roan.currentNodeTitle" FOLDED="true" ID="ID_1995938366" CREATED="1405837823671" MODIFIED="1405837823671">
<node TEXT="Load" ID="ID_1547334314" CREATED="1405837823671" MODIFIED="1405839771748"/>
</node>
<node TEXT="addons.roan.currentNodeTitle_tooltip" FOLDED="true" ID="ID_967275418" CREATED="1405837823671" MODIFIED="1405837823671">
<node TEXT="Load from selected node" ID="ID_1373559778" CREATED="1405837823671" MODIFIED="1405837823671"/>
</node>
<node TEXT="addons.roan.pasteSelectedsTitle" FOLDED="true" ID="ID_1800035764" CREATED="1405837823671" MODIFIED="1405837823671">
<node TEXT="... selecteds" ID="ID_625977691" CREATED="1405837823671" MODIFIED="1405839832213"/>
</node>
<node TEXT="addons.roan.pasteCurrentTitle" FOLDED="true" ID="ID_786326332" CREATED="1405837823687" MODIFIED="1405837823687">
<node TEXT="Paste" ID="ID_1646890461" CREATED="1405837823687" MODIFIED="1405839781279"/>
</node>
<node TEXT="addons.roan.pasteCurrentTitle_tooltip" FOLDED="true" ID="ID_1943100356" CREATED="1405837823687" MODIFIED="1405837823687">
<node TEXT="Current node is shown to the left." ID="ID_13155478" CREATED="1405837823687" MODIFIED="1405837823687"/>
</node>
<node TEXT="addons.roan.scriptLabelTitle" FOLDED="true" ID="ID_838337099" CREATED="1405837823687" MODIFIED="1405837823687">
<node TEXT="Script actions" ID="ID_633836873" CREATED="1405837823687" MODIFIED="1407569025123"/>
</node>
<node TEXT="addons.roan.scriptButtonOpenTitle" FOLDED="true" ID="ID_793170196" CREATED="1405837823687" MODIFIED="1405837823687">
<node TEXT="Open" ID="ID_450123724" CREATED="1405837823687" MODIFIED="1405837823687"/>
</node>
<node TEXT="addons.roan.scriptButtonContinueTitle" FOLDED="true" ID="ID_481492346" CREATED="1405837823687" MODIFIED="1405837823702">
<node TEXT="Continue" ID="ID_1336977961" CREATED="1405837823702" MODIFIED="1405837823702"/>
</node>
<node TEXT="addons.roan.scriptButtonBackTitle" FOLDED="true" ID="ID_1492001267" CREATED="1405837823702" MODIFIED="1405837823702">
<node TEXT="Back" ID="ID_360897634" CREATED="1405837823702" MODIFIED="1405837823702"/>
</node>
<node TEXT="addons.roan.toggleScriptButton_tooltip" FOLDED="true" ID="ID_819019521" CREATED="1405837823702" MODIFIED="1405837823702">
<node TEXT="Toggle Open - Continue - Back states." ID="ID_663123591" CREATED="1405837823702" MODIFIED="1405837823702"/>
</node>
<node TEXT="addons.roan.currentNodeText_tooltip" FOLDED="true" ID="ID_1170689234" CREATED="1405837823702" MODIFIED="1405837823702">
<node TEXT="Node text of current node." ID="ID_1722361933" CREATED="1405837823702" MODIFIED="1405837823702"/>
</node>
<node TEXT="addons.roan.scriptActions_tooltip" FOLDED="true" ID="ID_81878419" CREATED="1405837823702" MODIFIED="1405837823702">
<node TEXT="List of menu- and filter actions." ID="ID_500028284" CREATED="1405837823718" MODIFIED="1405837823718"/>
</node>
<node TEXT="addons.roan.pasteSelecteds_tooltip" FOLDED="true" ID="ID_323275865" CREATED="1405837823718" MODIFIED="1405837823718">
<node TEXT="Paste to all selected nodes. Replace old." ID="ID_250099165" CREATED="1405837823718" MODIFIED="1405837823718"/>
</node>
<node TEXT="addons.roan.initMessage" FOLDED="true" ID="ID_1235964409" CREATED="1405837823718" MODIFIED="1405837823718">
<node TEXT="Added initialization code to Root attributes." ID="ID_1413989731" CREATED="1405837823718" MODIFIED="1405837823718"/>
</node>
<node TEXT="addons.roan.fullScreenOnTitle" FOLDED="true" ID="ID_201399574" CREATED="1405837823718" MODIFIED="1405837823718">
<node TEXT="Screen - with Freeplane menu bars" ID="ID_435378731" CREATED="1405837823718" MODIFIED="1405837823718"/>
</node>
<node TEXT="addons.roan.fullScreenOffTitle" FOLDED="true" ID="ID_1180274152" CREATED="1405837823718" MODIFIED="1405837823718">
<node TEXT="Screen - full without Freeplane menu bars" ID="ID_1576131861" CREATED="1405837823718" MODIFIED="1405837823733"/>
</node>
<node TEXT="OptionPanel.plugin.addons.roan" FOLDED="true" ID="ID_1636575327" CREATED="1405837823733" MODIFIED="1405837823733">
<node TEXT="RoAn-Presentation" ID="ID_1779931690" CREATED="1405837823733" MODIFIED="1405837823733"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onOpenMaxMenu" FOLDED="true" ID="ID_1054869659" CREATED="1405837823733" MODIFIED="1405837823733">
<node TEXT="On open/maximize menu" ID="ID_913490638" CREATED="1405837823733" MODIFIED="1405837823733"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.screenModeMaxOff" FOLDED="true" ID="ID_521222536" CREATED="1405837823733" MODIFIED="1405837823733">
<node TEXT="Screenmode: with menubars" ID="ID_403768520" CREATED="1405837823733" MODIFIED="1405837823733"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.greyBackgroundOff" FOLDED="true" ID="ID_393847197" CREATED="1405837823749" MODIFIED="1405837823749">
<node TEXT="Grey backround: OFF" ID="ID_1372497446" CREATED="1405837823749" MODIFIED="1406925019867"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onOpenMinMenu" FOLDED="true" ID="ID_10434083" CREATED="1405837823749" MODIFIED="1405837823749">
<node TEXT="On minimize menu" ID="ID_1752032823" CREATED="1405837823749" MODIFIED="1405837823749"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.screenModeMaxOn" FOLDED="true" ID="ID_1853752126" CREATED="1405837823749" MODIFIED="1405837823749">
<node TEXT="Screenmode: full screen" ID="ID_867533035" CREATED="1405837823749" MODIFIED="1405837823749"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.greyBackgroundOn" FOLDED="true" ID="ID_1696316783" CREATED="1405837823765" MODIFIED="1405837823765">
<node TEXT="Grey background: ON" ID="ID_537158673" CREATED="1405837823765" MODIFIED="1406925050708"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onCloseMenu" FOLDED="true" ID="ID_672377092" CREATED="1405837823765" MODIFIED="1405837823765">
<node TEXT="On close menu" ID="ID_546927881" CREATED="1405837823765" MODIFIED="1405837823765"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu.screenModeMaxOff" FOLDED="true" ID="ID_1145607263" CREATED="1405837823765" MODIFIED="1405837823765">
<node TEXT="Screen mode: with menu bars:" ID="ID_1753905558" CREATED="1405837823765" MODIFIED="1405837823780"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onPlay" FOLDED="true" ID="ID_409048016" CREATED="1405837823780" MODIFIED="1405837823780">
<node TEXT="On Play" ID="ID_1352652710" CREATED="1405837823780" MODIFIED="1405837823780"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay.screenModeMaxOn" FOLDED="true" ID="ID_1072662594" CREATED="1405837823780" MODIFIED="1405837823780">
<node TEXT="Screen mode: full screen" ID="ID_1856124432" CREATED="1405837823780" MODIFIED="1405837823780"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay.greyBackgroundOn" FOLDED="true" ID="ID_1294591375" CREATED="1405837823780" MODIFIED="1405837823780">
<node TEXT="Grey background: ON" ID="ID_165059403" CREATED="1405837823780" MODIFIED="1406925072049"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.finishPlay" FOLDED="true" ID="ID_203526675" CREATED="1405837823780" MODIFIED="1405837823780">
<node TEXT="On finish/stop Play" ID="ID_849887063" CREATED="1405837823780" MODIFIED="1405837823780"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay.screenModeMaxOff" FOLDED="true" ID="ID_181419673" CREATED="1405837823796" MODIFIED="1405837823796">
<node TEXT="Screen mode: with menu bars" ID="ID_784395068" CREATED="1405837823796" MODIFIED="1405837823796"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay.greyBackgroundOff" FOLDED="true" ID="ID_1077453919" CREATED="1405837823796" MODIFIED="1405837823796">
<node TEXT="Grey backround: OFF" ID="ID_1697692273" CREATED="1405837823796" MODIFIED="1406925094856"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.tooltipsOn" FOLDED="true" ID="ID_1474451113" CREATED="1405837823796" MODIFIED="1405837823796">
<node TEXT="Show tooltips" ID="ID_862513640" CREATED="1405837823796" MODIFIED="1405837823796"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.attributesOff" FOLDED="true" ID="ID_228077007" CREATED="1405837823796" MODIFIED="1405837823796">
<node TEXT="Hide attributes" ID="ID_796843089" CREATED="1405837823811" MODIFIED="1405837823811"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.attributesIconOff" FOLDED="true" ID="ID_1927736185" CREATED="1405837823811" MODIFIED="1405837823811">
<node TEXT="Hide icons for attributes" ID="ID_852599931" CREATED="1405837823811" MODIFIED="1405837823811"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.tooltipsOff" FOLDED="true" ID="ID_1755249233" CREATED="1405837823811" MODIFIED="1405837823811">
<node TEXT="Hide tootips" ID="ID_1904575680" CREATED="1405837823811" MODIFIED="1405837823811"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.attributesIconOff" FOLDED="true" ID="ID_136232698" CREATED="1405837823811" MODIFIED="1405837823811">
<node TEXT="Hide icons for attributes" ID="ID_1610837393" CREATED="1405837823811" MODIFIED="1405837823811"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu_greyBackgroundOff" FOLDED="true" ID="ID_1014873319" CREATED="1405837823811" MODIFIED="1405837823811">
<node TEXT="Grey background: OFF" ID="ID_1178821977" CREATED="1405837823811" MODIFIED="1406925119598"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu.tooltipsOn" FOLDED="true" ID="ID_161808173" CREATED="1405837823827" MODIFIED="1405837823827">
<node TEXT="Show tooltips" ID="ID_1914564870" CREATED="1405837823827" MODIFIED="1405837823827"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu_attributesOn" FOLDED="true" ID="ID_240135180" CREATED="1405837823827" MODIFIED="1405837823827">
<node TEXT="Show attributes" ID="ID_582178478" CREATED="1405837823827" MODIFIED="1405837823827"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu_attributesIconOn" FOLDED="true" ID="ID_1066930593" CREATED="1405837823827" MODIFIED="1405837823827">
<node TEXT="Show icons for attributes" ID="ID_218002153" CREATED="1405837823827" MODIFIED="1405837823827"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay.tooltipsOff" FOLDED="true" ID="ID_1267415742" CREATED="1405837823827" MODIFIED="1405837823827">
<node TEXT="Hide tooltips" ID="ID_53583241" CREATED="1405837823827" MODIFIED="1405837823827"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay_attributesOff" FOLDED="true" ID="ID_759782537" CREATED="1405837823827" MODIFIED="1405837823827">
<node TEXT="Hide attributes" ID="ID_893242255" CREATED="1405837823843" MODIFIED="1405837823843"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay_attributesIconOff" FOLDED="true" ID="ID_1513199661" CREATED="1405837823843" MODIFIED="1405837823843">
<node TEXT="Hide icon for attributes" ID="ID_423690829" CREATED="1405837823843" MODIFIED="1405837823843"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay_tooltipsOn" FOLDED="true" ID="ID_729958265" CREATED="1405837823843" MODIFIED="1405837823843">
<node TEXT="Show tootips" ID="ID_1974522563" CREATED="1405837823843" MODIFIED="1405837823843"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay_attributesOn" FOLDED="true" ID="ID_518537214" CREATED="1405837823843" MODIFIED="1405837823843">
<node TEXT="Show attributes" ID="ID_203865210" CREATED="1405837823843" MODIFIED="1405837823843"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay_attributesIconOn" FOLDED="true" ID="ID_1482051005" CREATED="1405837823843" MODIFIED="1405837823843">
<node TEXT="Show icon for attributes" ID="ID_793709595" CREATED="1405837823843" MODIFIED="1405837823858"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.whilePlay" FOLDED="true" ID="ID_949454140" CREATED="1405837823858" MODIFIED="1405837823858">
<node TEXT="While playing" ID="ID_134370383" CREATED="1405837823858" MODIFIED="1405837823858"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.all" FOLDED="true" ID="ID_1985846358" CREATED="1405837823858" MODIFIED="1405837823858">
<node TEXT="Play all" ID="ID_1032750694" CREATED="1405837823858" MODIFIED="1405837823858"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.cycle" FOLDED="true" ID="ID_1600233948" CREATED="1405837823858" MODIFIED="1405837823858">
<node TEXT="Keep playing" ID="ID_821476489" CREATED="1405837823858" MODIFIED="1405837823858"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.slowMove" FOLDED="true" ID="ID_1563514258" CREATED="1405837823858" MODIFIED="1405837823858">
<node TEXT="Slow move" ID="ID_1577123905" CREATED="1405837823874" MODIFIED="1405837823874"/>
</node>
<node TEXT="addons.inlineImage.invalidImageFile" FOLDED="true" ID="ID_67007723" CREATED="1405837823874" MODIFIED="1405837823874">
<node TEXT="invalid image file : " ID="ID_617350730" CREATED="1405837823874" MODIFIED="1405837823874"/>
</node>
<node TEXT="addons.inlineImage.cancel" FOLDED="true" ID="ID_1127887943" CREATED="1405837823874" MODIFIED="1405837823874">
<node TEXT="Cancel" ID="ID_158172105" CREATED="1405837823874" MODIFIED="1405837823874"/>
</node>
<node TEXT="addons.inlineImage.mustBeSaved " FOLDED="true" ID="ID_631028054" CREATED="1405837823874" MODIFIED="1405837823874">
<node TEXT="The map must be saved if you want to use relative paths" ID="ID_289747221" CREATED="1405837823874" MODIFIED="1405837823874"/>
</node>
<node TEXT="addons.inlineImage.saveclipboardImageAsTitle" FOLDED="true" ID="ID_1458825388" CREATED="1405837823874" MODIFIED="1405837823874">
<node TEXT="Save clipboard image as" ID="ID_1608698730" CREATED="1405837823874" MODIFIED="1405837823874"/>
</node>
<node TEXT="addons.inlineImage.imageFiles" FOLDED="true" ID="ID_1776525142" CREATED="1405837823889" MODIFIED="1405837823889">
<node TEXT="Image files" ID="ID_911980790" CREATED="1405837823889" MODIFIED="1405837823889"/>
</node>
<node TEXT="addons.inlineImage.insertModifyImage" FOLDED="true" ID="ID_928196819" CREATED="1405837823889" MODIFIED="1405837823889">
<node TEXT="Insert/Modify Image" ID="ID_460448214" CREATED="1405837823889" MODIFIED="1405837823889"/>
</node>
<node TEXT="addons.inlineImage.pasteImageFromClipboardTitle" FOLDED="true" ID="ID_1899254390" CREATED="1405837823889" MODIFIED="1405837823889">
<node TEXT="Paste image from Clipboard" ID="ID_1640670398" CREATED="1405837823889" MODIFIED="1405837823889"/>
</node>
<node TEXT="addons.inlineImage.la_width" FOLDED="true" ID="ID_1570901703" CREATED="1405837823889" MODIFIED="1405837823889">
<node TEXT="Width:" ID="ID_1803915026" CREATED="1405837823889" MODIFIED="1405837823889"/>
</node>
<node TEXT="addons.inlineImage.la_height" FOLDED="true" ID="ID_1870239298" CREATED="1405837823889" MODIFIED="1405837823889">
<node TEXT="Height:" ID="ID_1592587884" CREATED="1405837823905" MODIFIED="1405837823905"/>
</node>
<node TEXT="addons.inlineImage.imagePath" FOLDED="true" ID="ID_780533310" CREATED="1405837823905" MODIFIED="1405837823905">
<node TEXT="image path" ID="ID_339887274" CREATED="1405837823905" MODIFIED="1405837823905"/>
</node>
<node TEXT="addons.inlineImage.yourLink" FOLDED="true" ID="ID_1347175310" CREATED="1405837823905" MODIFIED="1405837823905">
<node TEXT="your link" ID="ID_1326415784" CREATED="1405837823905" MODIFIED="1405837823905"/>
</node>
<node TEXT="addons.inlineImage.asLegend" FOLDED="true" ID="ID_1033628667" CREATED="1405837823905" MODIFIED="1405837823905">
<node TEXT="as legend" ID="ID_1931696901" CREATED="1405837823905" MODIFIED="1405837823905"/>
</node>
<node TEXT="addons.inlineImage.noLink" FOLDED="true" ID="ID_378933344" CREATED="1405837823905" MODIFIED="1405837823905">
<node TEXT="no link" ID="ID_1494498408" CREATED="1405837823905" MODIFIED="1405837823921"/>
</node>
<node TEXT="addons.inlineImage.proportionalImageResizing" FOLDED="true" ID="ID_1657503939" CREATED="1405837823921" MODIFIED="1405837823921">
<node TEXT="Proportional image resizing:" ID="ID_1329959379" CREATED="1405837823921" MODIFIED="1405837823921"/>
</node>
<node TEXT="addons.inlineImage.rb_core" FOLDED="true" ID="ID_1086893179" CREATED="1405837823921" MODIFIED="1405837823921">
<node TEXT="Core" ID="ID_1405449653" CREATED="1405837823921" MODIFIED="1405837823921"/>
</node>
<node TEXT="addons.inlineImage.rb_details" FOLDED="true" ID="ID_935277049" CREATED="1405837823921" MODIFIED="1410618643566">
<node TEXT="Details" ID="ID_1704715682" CREATED="1405837823921" MODIFIED="1405837823921"/>
</node>
<node TEXT="addons.inlineImage.rb_note" FOLDED="true" ID="ID_1909841032" CREATED="1405837823921" MODIFIED="1405837823921">
<node TEXT="Note" ID="ID_379129480" CREATED="1405837823921" MODIFIED="1405837823921"/>
</node>
<node TEXT="addons.inlineImage.rb_extension" FOLDED="true" ID="ID_1316424152" CREATED="1405837823921" MODIFIED="1405837823936">
<node TEXT="Extension" ID="ID_1724574864" CREATED="1405837823936" MODIFIED="1405837823936"/>
</node>
<node TEXT="addons.inlineImage.la_target" FOLDED="true" ID="ID_1828052451" CREATED="1405837823936" MODIFIED="1405837823936">
<node TEXT="Target:" ID="ID_352877774" CREATED="1405837823936" MODIFIED="1405837823936"/>
</node>
<node TEXT="addons.inlineImage.linkTargetLabel" FOLDED="true" ID="ID_692943181" CREATED="1405837823936" MODIFIED="1405837823936">
<node TEXT="Link target :" ID="ID_1723337755" CREATED="1405837823936" MODIFIED="1405837823936"/>
</node>
<node TEXT="addons.roan.filter_On" FOLDED="true" ID="ID_254283915" CREATED="1405837823936" MODIFIED="1405837823936">
<node TEXT="Filter during presentation: set ON" ID="ID_1688284527" CREATED="1405837823936" MODIFIED="1406924258678"/>
</node>
<node TEXT="addons.roan.filter_Off" FOLDED="true" ID="ID_1209858580" CREATED="1405837823936" MODIFIED="1405837823936">
<node TEXT="Filter during presentation: set OFF" ID="ID_1913514105" CREATED="1405837823936" MODIFIED="1406924253608"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.doFilter" FOLDED="true" ID="ID_1995459355" CREATED="1405837823952" MODIFIED="1411654876885">
<node TEXT="Filter" ID="ID_1749844636" CREATED="1405837823952" MODIFIED="1405837823952"/>
</node>
<node TEXT="addons.${name}.auto_setLibAndFileAction" FOLDED="true" ID="ID_775093423" CREATED="1406182145525" MODIFIED="1406388521546">
<node TEXT="Activate addon" ID="ID_822517153" CREATED="1406182162317" MODIFIED="1406182171445"/>
</node>
<node TEXT="addons.${name}.auto_clearUserDirFiles" FOLDED="true" ID="ID_283672523" CREATED="1406388642867" MODIFIED="1406388642867">
<node TEXT="Clear unnessesary files" ID="ID_1553406394" CREATED="1406388657720" MODIFIED="1406388685967"/>
</node>
<node TEXT="addons.${name}.copyLinkToNodeInOtherMap" FOLDED="true" ID="ID_1145191423" CREATED="1406228724145" MODIFIED="1406390141657">
<node TEXT="Link to node in other map" ID="ID_1953240449" CREATED="1406228759055" MODIFIED="1406228936236"/>
</node>
<node TEXT="addons.roan.userdirfiles.remove1" FOLDED="true" ID="ID_277456933" CREATED="1406387279965" MODIFIED="1406387409075">
<node TEXT="1. Remove files if not for language" ID="ID_361281031" CREATED="1406387279965" MODIFIED="1406387433095"/>
</node>
<node TEXT="addons.roan.userdirfiles.remove2" FOLDED="true" ID="ID_1872063949" CREATED="1406387303965" MODIFIED="1406387403345">
<node TEXT="2. Remove log files ?" ID="ID_866693773" CREATED="1406387303965" MODIFIED="1406387444135"/>
</node>
<node TEXT="addons.roan.userdirfiles.remove3" FOLDED="true" ID="ID_1056345133" CREATED="1406387320939" MODIFIED="1406387398315">
<node TEXT="3. Remove backup files ?" ID="ID_532825073" CREATED="1406387320939" MODIFIED="1406387456225"/>
</node>
<node TEXT="addons.roan.userdirfiles.restart" FOLDED="true" ID="ID_1178403159" CREATED="1406387337839" MODIFIED="1406387421665">
<node TEXT="You may have to restart Freeplane." ID="ID_582286101" CREATED="1406387337839" MODIFIED="1406387465275"/>
</node>
<node TEXT="addons.${name}.addon" FOLDED="true" ID="ID_949093301" CREATED="1406388272330" MODIFIED="1406388293569">
<node TEXT="addons" ID="ID_20852580" CREATED="1406388293580" MODIFIED="1406388316090"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.doAutoZoom" FOLDED="true" ID="ID_1944947512" CREATED="1406894400601" MODIFIED="1407240637499">
<node TEXT="auto zoom" ID="ID_640042452" CREATED="1406894494931" MODIFIED="1406894507033"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.autoZoomMax" FOLDED="true" ID="ID_1129719470" CREATED="1406894424533" MODIFIED="1406894750223">
<node TEXT="auto zoom % maximum" ID="ID_128196931" CREATED="1406894424533" MODIFIED="1406894729103"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.autoZoomMin" FOLDED="true" ID="ID_511750648" CREATED="1406894459323" MODIFIED="1406896644017">
<node TEXT="auto zoom % minimum" ID="ID_1889167198" CREATED="1406894459323" MODIFIED="1406896644017"/>
</node>
<node TEXT="addons.roan.autoZoom_On" FOLDED="true" ID="ID_1854220726" CREATED="1406896574077" MODIFIED="1406896630377">
<node TEXT="Zoom in and out: set ON" ID="ID_1497892874" CREATED="1406896574077" MODIFIED="1406924561347"/>
</node>
<node TEXT="addons.roan.autoZoom_Off" FOLDED="true" ID="ID_1043281091" CREATED="1406896600177" MODIFIED="1406896642477">
<node TEXT="Zoom in and out: set OFF" ID="ID_837029502" CREATED="1406896600177" MODIFIED="1406924536012"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.windowSize" FOLDED="true" ID="ID_365104678" CREATED="1407010324591" MODIFIED="1407010566400">
<node TEXT="Window size" ID="ID_607696242" CREATED="1407010369465" MODIFIED="1407010377764"/>
</node>
<node TEXT="OptionPanel.addons.roan.windowWidth" FOLDED="true" ID="ID_967906457" CREATED="1407010105091" MODIFIED="1407010267254">
<node TEXT="width (pixels)" ID="ID_1852226524" CREATED="1407010105091" MODIFIED="1407010409541"/>
</node>
<node TEXT="OptionPanel.addons.roan.windowHeight" FOLDED="true" ID="ID_603923810" CREATED="1407010181157" MODIFIED="1407010297518">
<node TEXT="height (pixels)" ID="ID_1425355640" CREATED="1407010181157" MODIFIED="1407010418246"/>
</node>
<node TEXT="addons.${name}.presentation_windowSizeAction" FOLDED="true" ID="ID_628154847" CREATED="1407011994139" MODIFIED="1407011994139">
<node TEXT="Set window size (recording)" ID="ID_1383898644" CREATED="1407012026096" MODIFIED="1407046428784"/>
</node>
<node TEXT="addons.roan.center" FOLDED="true" ID="ID_1313758911" CREATED="1410553449351" MODIFIED="1410592428134">
<node TEXT="Center" ID="ID_878947721" CREATED="1410553449351" MODIFIED="1410592428134"/>
</node>
<node TEXT="addons.roan.center.tooltip" FOLDED="true" ID="ID_1364856066" CREATED="1410553497375" MODIFIED="1410592428134">
<node TEXT="Center currently selected node." ID="ID_1621718577" CREATED="1410553497375" MODIFIED="1410592428134"/>
</node>
<node TEXT="addons.roan.continuation" FOLDED="true" ID="ID_1999834634" CREATED="1410553568223" MODIFIED="1410592428134">
<node TEXT="Stop and Bounce" ID="ID_208526497" CREATED="1410553568223" MODIFIED="1410592428134"/>
</node>
<node TEXT="addons.roan.continuation.STOP" FOLDED="true" ID="ID_1044505644" CREATED="1410553676230" MODIFIED="1410592428134">
<node TEXT="STOP" ID="ID_1115732227" CREATED="1410553676230" MODIFIED="1410592428134"/>
</node>
<node TEXT="addons.roan.continuation.BOUNCE" FOLDED="true" ID="ID_453154514" CREATED="1410553705799" MODIFIED="1410592428134">
<node TEXT="BOUNCE" ID="ID_704386494" CREATED="1410553705799" MODIFIED="1410592428134"/>
</node>
<node TEXT="addons.roan.continuation.tooltip" FOLDED="true" ID="ID_864337399" CREATED="1410553738411" MODIFIED="1410592428134">
<node ID="ID_1410970076" CREATED="1410553738411" MODIFIED="1410592428165"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    STOP: finish presentation.<br/>BOUNCE: continue with sibling.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.delay" FOLDED="true" ID="ID_336035946" CREATED="1410553877712" MODIFIED="1410592428165">
<node TEXT="Delay" ID="ID_1060868344" CREATED="1410553877712" MODIFIED="1410592428165"/>
</node>
<node TEXT="addons.roan.delay.message" FOLDED="true" ID="ID_1240057043" CREATED="1410553904770" MODIFIED="1410592428165">
<node TEXT="Delay/wait seconds" ID="ID_345774546" CREATED="1410553904770" MODIFIED="1410592428165"/>
</node>
<node TEXT="addons.roan.delay.tooltip" FOLDED="true" ID="ID_395202702" CREATED="1410553944402" MODIFIED="1410592428165">
<node TEXT="Display seconds" ID="ID_1845152257" CREATED="1410553944402" MODIFIED="1410592428181"/>
</node>
<node TEXT="addons.roan.detailsVisible.key" FOLDED="true" ID="ID_1065811491" CREATED="1410554077774" MODIFIED="1410592428181">
<node TEXT="Details" ID="ID_484728584" CREATED="1410554077774" MODIFIED="1410592428181"/>
</node>
<node TEXT="addons.roan.detailsVisible.show" FOLDED="true" ID="ID_1883559106" CREATED="1410554099950" MODIFIED="1410592428181">
<node TEXT="SHOW" ID="ID_1174736022" CREATED="1410554099950" MODIFIED="1410592428181"/>
</node>
<node TEXT="addons.roan.detailsVisible.hide" FOLDED="true" ID="ID_1510113991" CREATED="1410554127070" MODIFIED="1410592428181">
<node TEXT="HIDE" ID="ID_1498198897" CREATED="1410554127070" MODIFIED="1410592428181"/>
</node>
<node TEXT="addons.roan.detailsVisible.tooltip" FOLDED="true" ID="ID_317699812" CREATED="1410554156047" MODIFIED="1410592428181">
<node ID="ID_1139611153" CREATED="1410554156047" MODIFIED="1410592428196"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Set details for node of this action (default) or<br/>for currently selected node(s)
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.toggleEditDialog" FOLDED="true" ID="ID_869860787" CREATED="1410554248813" MODIFIED="1410592428196">
<node TEXT="Toggle Edit dialog" ID="ID_18252139" CREATED="1410554248813" MODIFIED="1410592428196"/>
</node>
<node TEXT="addons.roan.toggleEditDialog.tooltip" FOLDED="true" ID="ID_294583835" CREATED="1410554275029" MODIFIED="1410592428196">
<node ID="ID_1084032653" CREATED="1410554275029" MODIFIED="1410592428196"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Show or hide RoAns Edit dialog.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.filtering" FOLDED="true" ID="ID_123102758" CREATED="1410554628793" MODIFIED="1410592428196">
<node TEXT="Filtering" ID="ID_1543073086" CREATED="1410554628793" MODIFIED="1410592428196"/>
</node>
<node TEXT="addons.roan.filtering.tooltip" FOLDED="true" ID="ID_1084405888" CREATED="1410554650657" MODIFIED="1410592428196">
<node ID="ID_1006919287" CREATED="1410554650657" MODIFIED="1410592428212"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Virtually click automatic-filter button for<br/>filtering nodes of current branch.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.filterNamed" FOLDED="true" ID="ID_893680123" CREATED="1410554754202" MODIFIED="1410592428212">
<node TEXT="Filter (named)" ID="ID_364901171" CREATED="1410554754202" MODIFIED="1410592428212"/>
</node>
<node TEXT="addons.roan.filterNamed.dialogTitle" FOLDED="true" ID="ID_1761547447" CREATED="1410554781276" MODIFIED="1410592428212">
<node TEXT="Apply predefined named filter." ID="ID_1407696506" CREATED="1410554781276" MODIFIED="1410592428212"/>
</node>
<node TEXT="addons.roan.filterNamed.error" FOLDED="true" ID="ID_881113890" CREATED="1410554804465" MODIFIED="1410592428212">
<node TEXT="You must first define a named filter with the freeplane Compose filter editor." ID="ID_1042721520" CREATED="1410554804465" MODIFIED="1410592428212"/>
</node>
<node TEXT="addons.roan.filterNamed.hideAncestorsTitle" FOLDED="true" ID="ID_82592144" CREATED="1410554829464" MODIFIED="1410592428227">
<node TEXT="Hide ancestors" ID="ID_1103986275" CREATED="1410554829464" MODIFIED="1410592428227"/>
</node>
<node TEXT="addons.roan.filterNamed.showAncestorsTitle" FOLDED="true" ID="ID_1649615526" CREATED="1410554855945" MODIFIED="1410592428227">
<node TEXT="Show ancestors" ID="ID_1935658840" CREATED="1410554855945" MODIFIED="1410592428227"/>
</node>
<node TEXT="addons.roan.filterNamed.ancestorsNULL" FOLDED="true" ID="ID_1448805663" CREATED="1410554904906" MODIFIED="1410592428227">
<node TEXT="As Freeplane menusetting." ID="ID_611744630" CREATED="1410554904906" MODIFIED="1410610844373"/>
</node>
<node TEXT="addons.roan.filterNamed.hideDesendantsTitle" FOLDED="true" ID="ID_804533616" CREATED="1410554964568" MODIFIED="1410592428227">
<node TEXT="Hide descendants" ID="ID_74494551" CREATED="1410554964568" MODIFIED="1410592428227"/>
</node>
<node TEXT="addons.roan.filterNamed.showDescendantsTitle" FOLDED="true" ID="ID_921398799" CREATED="1410555003280" MODIFIED="1410592428227">
<node TEXT="Show descendants" ID="ID_439128391" CREATED="1410555003280" MODIFIED="1410592428227"/>
</node>
<node TEXT="addons.roan.filterNamed.descendantsNULL" FOLDED="true" ID="ID_697649929" CREATED="1410555166543" MODIFIED="1410592428227">
<node TEXT="As Freeplane menu setting" ID="ID_1351557675" CREATED="1410555166543" MODIFIED="1410610875760"/>
</node>
<node TEXT="addons.roan.filterNamed.applyToAllNodesTitle" FOLDED="true" ID="ID_1523490025" CREATED="1410555229107" MODIFIED="1410592428227">
<node TEXT="Apply to all nodes " ID="ID_1063931808" CREATED="1410555229107" MODIFIED="1410592428243"/>
</node>
<node TEXT="addons.roan.filterNamed.applyToVisibleNodesOnlyTitle" FOLDED="true" ID="ID_1780528955" CREATED="1410555252234" MODIFIED="1410592428243">
<node TEXT="Apply to visible nodes only" ID="ID_38890614" CREATED="1410555252234" MODIFIED="1410592428243"/>
</node>
<node TEXT="addons.roan.filterNamed.visibleNodesOnlyNULLTitle" FOLDED="true" ID="ID_87027459" CREATED="1410555297248" MODIFIED="1410592428243">
<node TEXT="As freeplane menu seeting." ID="ID_913944277" CREATED="1410555297248" MODIFIED="1410610901516"/>
</node>
<node TEXT="addons.roan.filterNamed.selectCurrentTitle" FOLDED="true" ID="ID_619406615" CREATED="1410555327660" MODIFIED="1410592428243">
<node TEXT="Select current node" ID="ID_154775561" CREATED="1410555327660" MODIFIED="1410592428243"/>
</node>
<node TEXT="addons.roan.filterNamed.selectCurrentlySelectedsTitle" FOLDED="true" ID="ID_1276967327" CREATED="1410555355545" MODIFIED="1410592428243">
<node TEXT="Select currently selected nodes" ID="ID_1732826373" CREATED="1410555355545" MODIFIED="1410592428243"/>
</node>
<node TEXT="addons.roan.filterNamed.tooltip" FOLDED="true" ID="ID_1773463031" CREATED="1410555384803" MODIFIED="1410592428243">
<node ID="ID_29127793" CREATED="1410555384803" MODIFIED="1410592428259"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Set named filter.<br/>Select for dialog.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.folding" FOLDED="true" ID="ID_415018087" CREATED="1410591237095" MODIFIED="1410592428259">
<node TEXT="Folding" ID="ID_1756276361" CREATED="1410591237095" MODIFIED="1410592428259"/>
</node>
<node TEXT="addons.roan.folding.fold" FOLDED="true" ID="ID_267836506" CREATED="1410591255355" MODIFIED="1410592428259">
<node TEXT="Fold" ID="ID_537828337" CREATED="1410591255355" MODIFIED="1410592428259"/>
</node>
<node TEXT="addons.roan.folding.unfold" FOLDED="true" ID="ID_601775531" CREATED="1410591269746" MODIFIED="1410592428259">
<node TEXT="Unfold" ID="ID_388909582" CREATED="1410591269746" MODIFIED="1410592428259"/>
</node>
<node TEXT="addons.roan.folding.current" FOLDED="true" ID="ID_1691064052" CREATED="1410591282593" MODIFIED="1410592428259">
<node TEXT="Action node" ID="ID_442374341" CREATED="1410591282593" MODIFIED="1410592428259"/>
</node>
<node TEXT="addons.roan.folding.selecteds" FOLDED="true" ID="ID_1886426196" CREATED="1410591308403" MODIFIED="1410592428259">
<node TEXT="Currently selected nodes" ID="ID_1340213983" CREATED="1410591308403" MODIFIED="1410592428259"/>
</node>
<node TEXT="addons.roan.folding.root" FOLDED="true" ID="ID_1203515550" CREATED="1410591325056" MODIFIED="1410592428274">
<node TEXT="Root node" ID="ID_793130370" CREATED="1410591325056" MODIFIED="1410592428274"/>
</node>
<node TEXT="addons.roan.folding.all" FOLDED="true" ID="ID_270663408" CREATED="1410591339197" MODIFIED="1410592428274">
<node TEXT="All" ID="ID_1123476100" CREATED="1410591339197" MODIFIED="1410592428274"/>
</node>
<node TEXT="addons.roan.folding.level1" FOLDED="true" ID="ID_1172584521" CREATED="1410591354368" MODIFIED="1410592428274">
<node TEXT="First level" ID="ID_404300323" CREATED="1410591354368" MODIFIED="1410592428274"/>
</node>
<node TEXT="addons.roan.folding.tooltip" FOLDED="true" ID="ID_1052662309" CREATED="1410591376107" MODIFIED="1410592428274">
<node ID="ID_55133049" CREATED="1410591376107" MODIFIED="1410592428274"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Fold or unfold node(s).<br/>Select for dialog.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.followLink" FOLDED="true" ID="ID_159359948" CREATED="1410591422431" MODIFIED="1410592428290">
<node TEXT="Follow link" ID="ID_1667322305" CREATED="1410591422431" MODIFIED="1410592428290"/>
</node>
<node TEXT="addons.roan.followLink.tooltip" FOLDED="true" ID="ID_1210099514" CREATED="1410591441268" MODIFIED="1410592428290">
<node ID="ID_293902470" CREATED="1410591441268" MODIFIED="1410592428290"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Open and display link.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.fullScreen" FOLDED="true" ID="ID_745698048" CREATED="1410591482772" MODIFIED="1410592428290">
<node TEXT="Full screen" ID="ID_1417150298" CREATED="1410591482772" MODIFIED="1410592428290"/>
</node>
<node TEXT="addons.roan.fullScreen.tooltip" FOLDED="true" ID="ID_275015822" CREATED="1410591499347" MODIFIED="1410592428305">
<node ID="ID_1709876743" CREATED="1410591499347" MODIFIED="1410592428305"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Virtually click full screen button to hide or show menu bars
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.greyedSurround" FOLDED="true" ID="ID_1457958386" CREATED="1410591537918" MODIFIED="1410592428305">
<node TEXT="Greyed surround" ID="ID_764739748" CREATED="1410591537918" MODIFIED="1410592428305"/>
</node>
<node TEXT="addons.roan.greyedSurround.tooltip" FOLDED="true" ID="ID_1763381984" CREATED="1410591552356" MODIFIED="1410592428305">
<node ID="ID_1164771234" CREATED="1410591552356" MODIFIED="1410592428321"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Virtually click greyed surround button<br/>to enhance presentation focus.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.homeRoAn" FOLDED="true" ID="ID_1183847120" CREATED="1410591578806" MODIFIED="1410592428321">
<node TEXT="Home RoAn" ID="ID_1664347770" CREATED="1410591578806" MODIFIED="1410592428321"/>
</node>
<node TEXT="addons.roan.homeRoAn.tooltip" FOLDED="true" ID="ID_309233578" CREATED="1410591592011" MODIFIED="1410592428321">
<node ID="ID_31772237" CREATED="1410591592011" MODIFIED="1410592428321"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Virtually click RoAn button home.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.jump" FOLDED="true" ID="ID_457863164" CREATED="1410591622673" MODIFIED="1410592428321">
<node TEXT="Jump" ID="ID_610136870" CREATED="1410591622673" MODIFIED="1410592428321"/>
</node>
<node TEXT="addons.roan.jump.tooltip" FOLDED="true" ID="ID_1316406985" CREATED="1410591636674" MODIFIED="1410592428337">
<node TEXT="Jump to currently selected node" ID="ID_482901072" CREATED="1410591636674" MODIFIED="1410592428337"/>
</node>
<node TEXT="addons.roan.jump.warningMessage" FOLDED="true" ID="ID_1327657761" CREATED="1410591650972" MODIFIED="1410592428337">
<node TEXT="You have to select a node to jump to not being the current node." ID="ID_1622288813" CREATED="1410591650972" MODIFIED="1410592428337"/>
</node>
<node TEXT="addons.roan.menuFreeplane" FOLDED="true" ID="ID_822641497" CREATED="1410591762161" MODIFIED="1410592428337">
<node TEXT="Menu action" ID="ID_104411343" CREATED="1410591762161" MODIFIED="1410592428337"/>
</node>
<node TEXT="addons.roan.menuFreeplane.dialog_message" FOLDED="true" ID="ID_124679063" CREATED="1410591891306" MODIFIED="1410592428337">
<node ID="ID_851955803" CREATED="1410591891306" MODIFIED="1410592428337"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Execute freeplane menu action.<br/>Get with addon Developer tools and paste here:
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.menuFreeplane.tooltip" FOLDED="true" ID="ID_1241960235" CREATED="1410591907116" MODIFIED="1410592428337">
<node ID="ID_467879723" CREATED="1410591907116" MODIFIED="1410592428352"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Execute freeplane menu action.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.menuRoan" FOLDED="true" ID="ID_720938148" CREATED="1410591962130" MODIFIED="1410592428352">
<node TEXT="Menu RoAn size" ID="ID_1006952705" CREATED="1410591962130" MODIFIED="1410592428352"/>
</node>
<node TEXT="addons.roan.menuRoan.maximum" FOLDED="true" ID="ID_1638739548" CREATED="1410591975507" MODIFIED="1410592428352">
<node TEXT="Maximum" ID="ID_1901456" CREATED="1410591975507" MODIFIED="1410592428352"/>
</node>
<node TEXT="addons.roan.menuRoan.minimum" FOLDED="true" ID="ID_585442214" CREATED="1410591987012" MODIFIED="1410592428352">
<node TEXT="Minimum" ID="ID_1912853710" CREATED="1410591987012" MODIFIED="1410592428352"/>
</node>
<node TEXT="addons.roan.menuRoan.tooltip" FOLDED="true" ID="ID_1798900372" CREATED="1410592003571" MODIFIED="1410592428352">
<node ID="ID_789233322" CREATED="1410592003571" MODIFIED="1410592428368"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Virtually click sizing button of Roan menu.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.scrolling" FOLDED="true" ID="ID_1054770262" CREATED="1410592044514" MODIFIED="1410592428368">
<node TEXT="Scrolling" ID="ID_1206181848" CREATED="1410592044514" MODIFIED="1410592428368"/>
</node>
<node TEXT="addons.roan.scrolling.tooltip" FOLDED="true" ID="ID_315939447" CREATED="1410592058171" MODIFIED="1410592428368">
<node ID="ID_1434427076" CREATED="1410592058171" MODIFIED="1410592428368"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Move the current scroll position delta XY pixels.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.selecteds" FOLDED="true" ID="ID_1570751925" CREATED="1410592100424" MODIFIED="1410592428383">
<node TEXT="Selected nodes" ID="ID_321843768" CREATED="1410592100424" MODIFIED="1410592428383"/>
</node>
<node TEXT="addons.roan.selecteds.addingCurrentlySelected" FOLDED="true" ID="ID_1766235205" CREATED="1410592113598" MODIFIED="1410592428383">
<node TEXT="Adding currently selected nodes:" ID="ID_592808653" CREATED="1410592113598" MODIFIED="1410592428383"/>
</node>
<node TEXT="addons.roan.selecteds.change" FOLDED="true" ID="ID_757879306" CREATED="1410592133075" MODIFIED="1410592428383">
<node TEXT="To change selection: press Cancel." ID="ID_62183297" CREATED="1410592133075" MODIFIED="1410592428383"/>
</node>
<node TEXT="addons.roan.selecteds.tooltip" FOLDED="true" ID="ID_367701304" CREATED="1410592156842" MODIFIED="1410592428383">
<node ID="ID_1943495082" CREATED="1410592156842" MODIFIED="1410592428383"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    The currently selected nodes will be selected.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.zoom" FOLDED="true" ID="ID_362014040" CREATED="1410592211418" MODIFIED="1410592428415">
<node TEXT="Zoom %" ID="ID_1461259888" CREATED="1410592211418" MODIFIED="1410592428415"/>
</node>
<node TEXT="addons.roan.zoom.dialog_message" FOLDED="true" ID="ID_988803519" CREATED="1410592224124" MODIFIED="1410592428415">
<node ID="ID_1265719559" CREATED="1410592224124" MODIFIED="1410592428415"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Set zoom %
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.zoom.tooltip" FOLDED="true" ID="ID_30419849" CREATED="1410592236316" MODIFIED="1410592428415">
<node ID="ID_1542036218" CREATED="1410592236316" MODIFIED="1410592428430"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Set zoom action for this node.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.zooming" FOLDED="true" ID="ID_1326877745" CREATED="1410592286369" MODIFIED="1410592428430">
<node TEXT="Zooming" ID="ID_39938794" CREATED="1410592286369" MODIFIED="1410592428430"/>
</node>
<node TEXT="addons.roan.zooming.tooltip" FOLDED="true" ID="ID_183917105" CREATED="1410592307452" MODIFIED="1410592428430">
<node ID="ID_904597857" CREATED="1410592307452" MODIFIED="1410592428430"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Virtually click automatic-zoom button for zooming in and out while stepping.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.actionBoolean.allSelectedsMessage" FOLDED="true" ID="ID_1651097230" CREATED="1410607952271" MODIFIED="1410608007183">
<node TEXT="By default node with action.\nApply to currently selected node(s) ?" ID="ID_349503001" CREATED="1410607952271" MODIFIED="1410608007183"/>
</node>
<node TEXT="addons.roan.actionBoolean.ON" FOLDED="true" ID="ID_1325967071" CREATED="1410607965679" MODIFIED="1410608007183">
<node TEXT="ON" ID="ID_1714509411" CREATED="1410607965679" MODIFIED="1410608007199"/>
</node>
<node TEXT="addons.roan.actionBoolean.OFF" FOLDED="true" ID="ID_797725424" CREATED="1410607978308" MODIFIED="1410608007199">
<node TEXT="OFF" ID="ID_108844596" CREATED="1410607978308" MODIFIED="1410608007199"/>
</node>
<node TEXT="addons.roan.EditDialog.addActions" FOLDED="true" ID="ID_1208794949" CREATED="1410618566635" MODIFIED="1410618588257">
<node TEXT="Menu with actions" ID="ID_367071836" CREATED="1410618566635" MODIFIED="1410618763538"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.imageinline" FOLDED="true" ID="ID_626669353" CREATED="1411650284303" MODIFIED="1411717688554">
<node TEXT="Insert inline images" ID="ID_1862630161" CREATED="1411650314263" MODIFIED="1411650326493"/>
</node>
<node TEXT="OptionPanel.addons.roan.imageinline.widthMax" FOLDED="true" ID="ID_1536728833" CREATED="1411650006597" MODIFIED="1411717481945">
<node TEXT="maximum width" ID="ID_1850781845" CREATED="1407010181157" MODIFIED="1411650195133"/>
</node>
<node TEXT="OptionPanel.addons.roan.imageinline.heightMax" FOLDED="true" ID="ID_572388719" CREATED="1411650006597" MODIFIED="1411717495813">
<node TEXT="maximum height" ID="ID_226377920" CREATED="1407010181157" MODIFIED="1411650205713"/>
</node>
<node TEXT="addons.roan.imageinline.locationImageLabelTitle" FOLDED="true" ID="ID_1682789479" CREATED="1411654493290" MODIFIED="1412587497640">
<node TEXT="Location image" ID="ID_1241598890" CREATED="1411654493290" MODIFIED="1412587504411"/>
</node>
<node TEXT="addons.roan.imageinline.widthMaxTitle" FOLDED="true" ID="ID_1938832012" CREATED="1411654532476" MODIFIED="1411654821257">
<node TEXT="maximum width" ID="ID_782773019" CREATED="1411654532476" MODIFIED="1411654821257"/>
</node>
<node TEXT="addons.roan.imageinline.heightMaxTitle" FOLDED="true" ID="ID_256200046" CREATED="1411654961439" MODIFIED="1411655011413">
<node TEXT="maximum height" ID="ID_1699561789" CREATED="1411654961439" MODIFIED="1411655019893"/>
</node>
<node TEXT="addons.roan.imageinline.Current" FOLDED="true" ID="ID_1805280729" CREATED="1411654668489" MODIFIED="1411654821267">
<node TEXT="Current node" ID="ID_785760008" CREATED="1411654668489" MODIFIED="1411654821267"/>
</node>
<node TEXT="addons.roan.imageinline.Parent" FOLDED="true" ID="ID_689868257" CREATED="1411654681159" MODIFIED="1411654821267">
<node TEXT="Parent node" ID="ID_1717003834" CREATED="1411654681159" MODIFIED="1411654821267"/>
</node>
<node TEXT="addons.roan.imageinline.dialogTitle" FOLDED="true" ID="ID_1973502211" CREATED="1411654697659" MODIFIED="1411654821267">
<node TEXT="Add inline image(s)" ID="ID_3121906" CREATED="1411654697659" MODIFIED="1412588413284"/>
</node>
<node TEXT="addons.roan.imageinline.fromParentDirectoryTitle" FOLDED="true" ID="ID_251940967" CREATED="1411654709839" MODIFIED="1411654821267">
<node TEXT="Add images from map-directory" ID="ID_378315017" CREATED="1411654709839" MODIFIED="1412539143899"/>
</node>
<node TEXT="addons.roan.imageinline.fromRedArrowLinksTitle" FOLDED="true" ID="ID_1006955834" CREATED="1411654721859" MODIFIED="1411654821267">
<node TEXT="Images from selected red-arrow links" ID="ID_327869405" CREATED="1411654721859" MODIFIED="1412588439632"/>
</node>
<node TEXT="addons.roan.imageinline.fromAddonInsertInlineImageTitle" FOLDED="true" ID="ID_640848896" CREATED="1411654753401" MODIFIED="1411654821277">
<node TEXT="Image by addon Insert Inline Image" ID="ID_1561372133" CREATED="1411654753401" MODIFIED="1411654821277"/>
</node>
<node TEXT="addons.roan.imageinline.subMenuTitle" FOLDED="true" ID="ID_998677722" CREATED="1412183621276" MODIFIED="1412183767113">
<node TEXT="SubMenu" ID="ID_1430460438" CREATED="1412183621276" MODIFIED="1412183767128"/>
</node>
<node TEXT="addons.roan.imageinline.isResizeExisitingTitle" FOLDED="true" ID="ID_153177617" CREATED="1412587896018" MODIFIED="1412588232316">
<node TEXT="Resize existing" ID="ID_462077639" CREATED="1412587896018" MODIFIED="1412588232332"/>
</node>
<node TEXT="addons.roan.indexTitle" FOLDED="true" ID="ID_1815734880" CREATED="1412253073968" MODIFIED="1412588232332">
<node TEXT="Index: add links to folders and files in the directory the mindmap is in" ID="ID_790944855" CREATED="1412253073968" MODIFIED="1412588687267"/>
</node>
<node TEXT="addons.roan.nodelib.CORE" FOLDED="true" ID="ID_1802748447" CREATED="1412253178277" MODIFIED="1412588312383">
<node TEXT="CORE" ID="ID_742022562" CREATED="1412253178277" MODIFIED="1412588312383"/>
</node>
<node TEXT="addons.roan.nodelib.DETAILS" FOLDED="true" ID="ID_627967921" CREATED="1412253190812" MODIFIED="1412588312383">
<node TEXT="DETAILS" ID="ID_1733326458" CREATED="1412253190812" MODIFIED="1412588312399"/>
</node>
<node TEXT="addons.roan.nodelib.NOTE" FOLDED="true" ID="ID_657101922" CREATED="1412253208775" MODIFIED="1412588312399">
<node TEXT="NOTE" ID="ID_1861414216" CREATED="1412253208775" MODIFIED="1412588312399"/>
</node>
<node TEXT="addons.roan.nodelib.ARROW" FOLDED="true" ID="ID_998182481" CREATED="1412253224664" MODIFIED="1412588312399">
<node TEXT="ARROW" ID="ID_326367199" CREATED="1412253224664" MODIFIED="1412588312399"/>
</node>
<node TEXT="addons.roan.lockTitle" FOLDED="true" ID="ID_738014516" CREATED="1412540480917" MODIFIED="1412588312399">
<node TEXT="Set password on map (encrypt)" ID="ID_1421488568" CREATED="1412540480917" MODIFIED="1412588312399"/>
</node>
<node TEXT="addons.roan.index.directoryTitle" FOLDED="true" ID="ID_262600633" CREATED="1412588003994" MODIFIED="1412588312399">
<node TEXT="directory" ID="ID_1959489721" CREATED="1412588003994" MODIFIED="1412588312399"/>
</node>
<node TEXT="addons.roan.index.isDirectoryIconTitle" FOLDED="true" ID="ID_605282938" CREATED="1412588022082" MODIFIED="1412588312399">
<node TEXT="Icon for directory" ID="ID_1824645222" CREATED="1412588022082" MODIFIED="1412588312414"/>
</node>
<node TEXT="addons.roan.index.locationLinkDirectoryLabelTitle" FOLDED="true" ID="ID_804532260" CREATED="1412588038064" MODIFIED="1412588312414">
<node TEXT="Location directory link" ID="ID_677011042" CREATED="1412588038064" MODIFIED="1412588312414"/>
</node>
<node TEXT="addons.roan.index.locationLinkFileLabelTitle" FOLDED="true" ID="ID_674509580" CREATED="1412588049148" MODIFIED="1412588312414">
<node TEXT="Location file link" ID="ID_561853986" CREATED="1412588049148" MODIFIED="1412588312414"/>
</node>
<node TEXT="addons.roan.index.dialogTitle" FOLDED="true" ID="ID_648882359" CREATED="1412588066846" MODIFIED="1412588312414">
<node TEXT="Add node and link for each folder and file" ID="ID_1520572685" CREATED="1412588066846" MODIFIED="1412588312414"/>
</node>
<node TEXT="addons.roan.index.sortLabelTitle" FOLDED="true" ID="ID_632177809" CREATED="1412588087290" MODIFIED="1412588312414">
<node TEXT="Sort" ID="ID_310630955" CREATED="1412588087290" MODIFIED="1412588784596"/>
</node>
<node TEXT="addons.roan.index.divisionRootLabelTitle" FOLDED="true" ID="ID_1637053670" CREATED="1412588102258" MODIFIED="1412588312414">
<node TEXT="Divide nodes left-right" ID="ID_1777009586" CREATED="1412588102258" MODIFIED="1412588312414"/>
</node>
<node TEXT="addons.roan.index.divisionRootRIGHTTitle" FOLDED="true" ID="ID_1463014107" CREATED="1412588113623" MODIFIED="1412588312414">
<node TEXT="RIGHT" ID="ID_1787486712" CREATED="1412588113623" MODIFIED="1412588312414"/>
</node>
<node TEXT="addons.roan.index.divisionRootLEFTRIGHTTitle" FOLDED="true" ID="ID_350430656" CREATED="1412588123927" MODIFIED="1412588312414">
<node TEXT="LEFT-RIGHT" ID="ID_599150158" CREATED="1412588123927" MODIFIED="1412588312430"/>
</node>
<node TEXT="addons.roan.index.divisionRootRIGHTLEFTTitle" FOLDED="true" ID="ID_796406483" CREATED="1412588136446" MODIFIED="1412588312430">
<node TEXT="RIGHT-LEFT" ID="ID_1044486279" CREATED="1412588136446" MODIFIED="1412588312430"/>
</node>
<node TEXT="addons.roan.index.divisionRootMAPFILETitle" FOLDED="true" ID="ID_1130402108" CREATED="1412588136446" MODIFIED="1412618779092">
<node TEXT="MAPS-FILES" ID="ID_1434943384" CREATED="1412588136446" MODIFIED="1412618997012"/>
</node>
<node TEXT="addons.roan.index.divisionRootFILEMAPTitle" FOLDED="true" ID="ID_1216965586" CREATED="1412588136446" MODIFIED="1412618888616">
<node TEXT="FILES-MAPS" ID="ID_1345828015" CREATED="1412588136446" MODIFIED="1412619012544"/>
</node>
<node TEXT="addons.roan.index.sortNONETitle" FOLDED="true" ID="ID_1706484745" CREATED="1412588161164" MODIFIED="1412588312430">
<node TEXT="NONE" ID="ID_1556639475" CREATED="1412588161164" MODIFIED="1412588312430"/>
</node>
<node TEXT="addons.roan.index.sortFOREWARDTitle" FOLDED="true" ID="ID_923011873" CREATED="1412588173200" MODIFIED="1412588312430">
<node TEXT="FOREWARD" ID="ID_1612176067" CREATED="1412588173200" MODIFIED="1412588312430"/>
</node>
<node TEXT="addons.roan.index.sortBACKWARDTitle" FOLDED="true" ID="ID_1926582773" CREATED="1412588182489" MODIFIED="1412588312430">
<node TEXT="BACKWARD" ID="ID_434166265" CREATED="1412588182489" MODIFIED="1412588312430"/>
</node>
<node TEXT="addons.roan.index.showFileExtensionTitle" FOLDED="true" ID="ID_470003061" CREATED="1412588191982" MODIFIED="1412588312430">
<node TEXT="Show file extension" ID="ID_1670418052" CREATED="1412588191982" MODIFIED="1412588312430"/>
</node>
<node TEXT="addons.roan.index.isDirectoryNodesTitle" FOLDED="true" ID="ID_1474284370" CREATED="1412588202083" MODIFIED="1412588312430">
<node TEXT="Directory nodes" ID="ID_282425969" CREATED="1412588202083" MODIFIED="1412588312430"/>
</node>
</node>
</node>
</node>
<node TEXT="nl" FOLDED="true" ID="ID_364081803" CREATED="1399926585775" MODIFIED="1412619119742">
<attribute_layout NAME_WIDTH="329" VALUE_WIDTH="329"/>
<attribute NAME="addons.${name}" VALUE="roan"/>
<attribute NAME="addons.${name}.presentation" VALUE="RoAn-Presentatie"/>
<attribute NAME="addons.${name}.presentation_playAction" VALUE="Afspelen"/>
<attribute NAME="addons.${name}.presentation_stepAction" VALUE="Stap"/>
<attribute NAME="addons.${name}.presentation_menuAction" VALUE="Menu"/>
<attribute NAME="addons.${name}.presentation_editDialogAction" VALUE="Bewerken"/>
<attribute NAME="addons.${name}.presentation_helpAction" VALUE="Help"/>
<attribute NAME="addons.${name}.insertInlineImage" VALUE="Invoegen inline afbeelding"/>
<attribute NAME="addons.roan.sliderTooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Aantal seconden vertoning van geselecteerde knoop.&#xa;&#xa;    &lt;p&gt;&#xa;      Verplaast schuifje voor nieuwe waarde.&lt;br&gt;&#xa;    &lt;/p&gt;&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.playTitle" VALUE="Afspelen"/>
<attribute NAME="addons.roan.stepTitle" VALUE="Stap voorwaarts of, bij spelen, direkt naar volgende."/>
<attribute NAME="addons.roan.stopTitle" VALUE="Stoppen afspelen"/>
<attribute NAME="addons.roan.attributes_OnTitle" VALUE="Verbergen attributen"/>
<attribute NAME="addons.roan.attributes_OffTitle" VALUE="Tonen attributen"/>
<attribute NAME="addons.roan.state_OnTitle" VALUE="Verbergen icoontje bij attributen"/>
<attribute NAME="addons.roan.state_OffTitle" VALUE="Tonen icoontje bij attributen"/>
<attribute NAME="addons.roan.init" VALUE="Initialiseer mindmap"/>
<attribute NAME="addons.roan.helpTitle" VALUE="Help"/>
<attribute NAME="addons.roan.homeTitle" VALUE="RoAn-Start: Selecteren stamknoop en kinderen verbergen."/>
<attribute NAME="addons.roan.menuTitle" VALUE="RoAn-Presenteren"/>
<attribute NAME="addons.roan.editTitle" VALUE="Roan-Bewerken"/>
<attribute NAME="addons.roan.imageTitle" VALUE="Invoegen plaatje"/>
<attribute NAME="addons.roan.grey_OnTitle" VALUE="Grjze achtergrond: zet UIT"/>
<attribute NAME="addons.roan.grey_OffTitle" VALUE="Grijze achtergrond: zet AAN"/>
<attribute NAME="addons.roan.backTitle" VALUE="Stap terug of, bij spelen, stop."/>
<attribute NAME="addons.roan.tooltip_OnTitle" VALUE="Verbergen tooltip"/>
<attribute NAME="addons.roan.tooltip_OffTitle" VALUE="Tonen tooltip"/>
<attribute NAME="addons.roan.plusSizeTitle" VALUE="Minimaliseren menuvenster voor afspelen"/>
<attribute NAME="addons.roan.minSizeTitle" VALUE="Maximaliseren menuvenster voor bewerken"/>
<attribute NAME="addons.roan.action" VALUE="Actie"/>
<attribute NAME="addons.roan.actionOnOpen" VALUE="Bij Open"/>
<attribute NAME="addons.roan.actionOnNext" VALUE="Bij Vervolg"/>
<attribute NAME="addons.roan.actionOnBack" VALUE="Bij Terug"/>
<attribute NAME="addons.roan.currentNodeTitle" VALUE="Laden"/>
<attribute NAME="addons.roan.currentNodeTitle_tooltip" VALUE="Laden van geselecteerde knoop"/>
<attribute NAME="addons.roan.pasteSelectedsTitle" VALUE="... naar selectie"/>
<attribute NAME="addons.roan.pasteCurrentTitle" VALUE="Plakken"/>
<attribute NAME="addons.roan.pasteCurrentTitle_tooltip" VALUE="Zie links voor titel huidige knoop."/>
<attribute NAME="addons.roan.scriptLabelTitle" VALUE="Script acties"/>
<attribute NAME="addons.roan.scriptButtonOpenTitle" VALUE="Open"/>
<attribute NAME="addons.roan.scriptButtonContinueTitle" VALUE="Vervolg"/>
<attribute NAME="addons.roan.scriptButtonBackTitle" VALUE="Terug"/>
<attribute NAME="addons.roan.toggleScriptButton_tooltip" VALUE="Schakel tussen Open - Vervolg - Terug"/>
<attribute NAME="addons.roan.currentNodeText_tooltip" VALUE="Knooptekst huidige knoop."/>
<attribute NAME="addons.roan.scriptActions_tooltip" VALUE="Lijst menu- en filter acties."/>
<attribute NAME="addons.roan.pasteSelecteds_tooltip" VALUE="Plak in all geselecteerde knopen."/>
<attribute NAME="addons.roan.initMessage" VALUE="Mindmap ingesteld in attributen van wortelknoop."/>
<attribute NAME="addons.roan.fullScreenOnTitle" VALUE="Scherm - met Freeplane menubalken"/>
<attribute NAME="addons.roan.fullScreenOffTitle" VALUE="Scherm - volledig, zonder Freeplane menubalken"/>
<attribute NAME="OptionPanel.plugin.addons.roan" VALUE="RoAn-Presentatie"/>
<attribute NAME="OptionPanel.separator.addons.roan.onOpenMaxMenu" VALUE="Bij openen/maximimaliseren menu"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.screenModeMaxOff" VALUE="Scherm mode: met menubalken"/>
<attribute NAME="OptionPanel.separator.addons.roan.onOpenMinMenu" VALUE="Bij minimaliseren menu"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.screenModeMaxOn" VALUE="Scherm mode: volledig scherm"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.greyBackgroundOff" VALUE="Grijze achtergrond: UIT"/>
<attribute NAME="OptionPanel.separator.addons.roan.onCloseMenu" VALUE="Bij sluiten menu"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu.screenModeMaxOff" VALUE="Scherm mode: met menubalken"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.greyBackgroundOn" VALUE="Grijze achtergrond: AAN"/>
<attribute NAME="OptionPanel.separator.addons.roan.onPlay" VALUE="Bij afspelen"/>
<attribute NAME="OptionPanel.addons.roan.onPlay.screenModeMaxOn" VALUE="Scherm mode: volledig scherm"/>
<attribute NAME="OptionPanel.addons.roan.onPlay.greyBackgroundOn" VALUE="Grijze achtergrond: AAN"/>
<attribute NAME="OptionPanel.separator.addons.roan.finishPlay" VALUE="Bij stoppen afspelen"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay.screenModeMaxOff" VALUE="Scherm mode: met menubalken"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay.greyBackgroundOff" VALUE="Grijze achtergrond: UIT"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.tooltipsOn" VALUE="Tonen tooltips"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.attributesOff" VALUE="Verbergen attributen"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMaxMenu.attributesIconOff" VALUE="Verbergen icoontje voor attributen"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.tooltipsOff" VALUE="Verbergen tootips"/>
<attribute NAME="OptionPanel.addons.roan.onOpenMinMenu.attributesIconOff" VALUE="Verbergen icoontje voor attributen"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu_greyBackgroundOff" VALUE="Grijze achtergrond: UIT"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu.tooltipsOn" VALUE="Tonen tooltips"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu_attributesOn" VALUE="Tonen attributen"/>
<attribute NAME="OptionPanel.addons.roan.onCloseMenu_attributesIconOn" VALUE="Tonen icoontje voor attributen"/>
<attribute NAME="OptionPanel.addons.roan.onPlay.tooltipsOff" VALUE="Verbergen tooltips"/>
<attribute NAME="OptionPanel.addons.roan.onPlay_attributesOff" VALUE="Verbergen attributen"/>
<attribute NAME="OptionPanel.addons.roan.onPlay_attributesIconOff" VALUE="Verbergen icoontje voor attributen"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay_tooltipsOn" VALUE="Tonen tootips"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay_attributesOn" VALUE="Tonen attributen"/>
<attribute NAME="OptionPanel.addons.roan.finishPlay_attributesIconOn" VALUE="Tonen icoontjes voor attributen"/>
<attribute NAME="OptionPanel.separator.addons.roan.whilePlay" VALUE="Tijdens afspelen"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.all" VALUE="Alles afspelenl"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.cycle" VALUE="Blijven afspelen"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.slowMove" VALUE="Langzame beweging"/>
<attribute NAME="addons.inlineImage.invalidImageFile" VALUE="ongeldig afbeeldingsbestand :"/>
<attribute NAME="addons.inlineImage.cancel" VALUE="Negeren"/>
<attribute NAME="addons.inlineImage.mustBeSaved " VALUE="De mindmap moet eerst worden bewaard voordat relatieve hyperlinks mogelijk zijn."/>
<attribute NAME="addons.inlineImage.saveclipboardImageAsTitle" VALUE="Bewaar afbeelidng in clipboard als"/>
<attribute NAME="addons.inlineImage.imageFiles" VALUE="Afbeeldingsbestanden"/>
<attribute NAME="addons.inlineImage.insertModifyImage" VALUE="Invoegen/Modificeren afbeelding"/>
<attribute NAME="addons.inlineImage.pasteImageFromClipboardTitle" VALUE="Plak afbeelding uit Clipboard"/>
<attribute NAME="addons.inlineImage.la_width" VALUE="Breedte:"/>
<attribute NAME="addons.inlineImage.la_height" VALUE="Hoogte:"/>
<attribute NAME="addons.inlineImage.imagePath" VALUE="afbeeldingspad"/>
<attribute NAME="addons.inlineImage.yourLink" VALUE="jouw koppeling"/>
<attribute NAME="addons.inlineImage.asLegend" VALUE="als legenda"/>
<attribute NAME="addons.inlineImage.noLink" VALUE="geen koppeling"/>
<attribute NAME="addons.inlineImage.proportionalImageResizing" VALUE="Proportioneel schalen:"/>
<attribute NAME="addons.inlineImage.rb_core" VALUE="Kern"/>
<attribute NAME="addons.inlineImage.rb_details" VALUE="Details"/>
<attribute NAME="addons.inlineImage.rb_note" VALUE="Notitie"/>
<attribute NAME="addons.inlineImage.rb_extension" VALUE="Uitbreiding"/>
<attribute NAME="addons.inlineImage.la_target" VALUE="Doel:"/>
<attribute NAME="addons.inlineImage.linkTargetLabel" VALUE="Link doel:"/>
<attribute NAME="addons.roan.filter_On" VALUE="Filteren tijdens presenteren: zet AAN"/>
<attribute NAME="addons.roan.filter_Off" VALUE="Filteren tijdens presenteren: zet UIT"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.doFilter" VALUE="Filter"/>
<attribute NAME="addons.${name}.auto_setLibAndFileAction" VALUE="Aktiveren addon"/>
<attribute NAME="addons.${name}.auto_clearUserDirFiles" VALUE="Wis onnodige bestanden"/>
<attribute NAME="addons.${name}.copyLinkToNodeInOtherMap" VALUE="Koppeling naar knoop in andere mindmap"/>
<attribute NAME="addons.roan.userdirfiles.remove1" VALUE="1. Bestanden verwijderen die niet de volgende taal hebben:"/>
<attribute NAME="addons.roan.userdirfiles.remove2" VALUE="2. Log besstanden verwijderen ?"/>
<attribute NAME="addons.roan.userdirfiles.remove3" VALUE="3. Backup bestanden verwijderen ?"/>
<attribute NAME="addons.roan.userdirfiles.restart" VALUE="U zult mogelijk Freeplane moeten herstarten"/>
<attribute NAME="addons.${name}.addon" VALUE="addons"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.doAutoZoom" VALUE="auto zoom"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.autoZoomMax" VALUE="auto zoom % maximum"/>
<attribute NAME="OptionPanel.addons.roan.whilePlay.autoZoomMin" VALUE="auto zoom % minimum"/>
<attribute NAME="addons.roan.autoZoom_On" VALUE="Zoom in en uit: zet AAN"/>
<attribute NAME="addons.roan.autoZoom_Off" VALUE="Zoom in en uit: zet UIT"/>
<attribute NAME="OptionPanel.separator.addons.roan.windowSize" VALUE="Venstergrootte (bij opnemen)"/>
<attribute NAME="OptionPanel.addons.roan.windowWidth" VALUE="breedte (pixels)"/>
<attribute NAME="OptionPanel.addons.roan.windowHeight" VALUE="hoogte (pixels)"/>
<attribute NAME="addons.${name}.presentation_windowSizeAction" VALUE="Zet venstergrootte (opname)"/>
<attribute NAME="addons.roan.center" VALUE="Centreer"/>
<attribute NAME="addons.roan.center.tooltip" VALUE="Centreer nu geselecteerde knoop"/>
<attribute NAME="addons.roan.continuation" VALUE="Stop of Kaats"/>
<attribute NAME="addons.roan.continuation.STOP" VALUE="STOP"/>
<attribute NAME="addons.roan.continuation.BOUNCE" VALUE="KAATS"/>
<attribute NAME="addons.roan.continuation.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    STOP: eindig afspelen.&lt;br&gt;KAATS: ga door met onderliggende knoop.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.delay" VALUE="Wacht"/>
<attribute NAME="addons.roan.delay.message" VALUE="Wacht seconden"/>
<attribute NAME="addons.roan.delay.tooltip" VALUE="Toon seconden"/>
<attribute NAME="addons.roan.detailsVisible.key" VALUE="Details"/>
<attribute NAME="addons.roan.detailsVisible.show" VALUE="TONEN"/>
<attribute NAME="addons.roan.detailsVisible.hide" VALUE="VERBERGEN"/>
<attribute NAME="addons.roan.detailsVisible.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Toon details van de actieknoop (default) of&lt;br&gt;van de nu geselecteerde knopen.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.toggleEditDialog" VALUE="Bewerken venster AAN/UIT"/>
<attribute NAME="addons.roan.toggleEditDialog.tooltip" VALUE="Tonen of verbergen RoAns Bewerken venster."/>
<attribute NAME="addons.roan.filtering" VALUE="Filteren"/>
<attribute NAME="addons.roan.filtering.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Virtually click automatic-filter button for&lt;br&gt;filtering nodes of current branch.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.filterNamed" VALUE="Filter (met naam)"/>
<attribute NAME="addons.roan.filterNamed.dialogTitle" VALUE="Pas filter met naam toe."/>
<attribute NAME="addons.roan.filterNamed.error" VALUE="Definieer eerst een filter-met-naam met Freeplane&apos;s Componeren filter editor."/>
<attribute NAME="addons.roan.filterNamed.hideAncestorsTitle" VALUE="Verbergen voorouders"/>
<attribute NAME="addons.roan.filterNamed.showAncestorsTitle" VALUE="Tonen voorouders"/>
<attribute NAME="addons.roan.filterNamed.ancestorsNULL" VALUE="Als Freeplane instelling."/>
<attribute NAME="addons.roan.filterNamed.hideDesendantsTitle" VALUE="Verbergen afstammelingen"/>
<attribute NAME="addons.roan.filterNamed.showDescendantsTitle" VALUE="Verbergen afstammelingen"/>
<attribute NAME="addons.roan.filterNamed.descendantsNULL" VALUE="Als Freelane instelling."/>
<attribute NAME="addons.roan.filterNamed.applyToAllNodesTitle" VALUE="Op alle knopen toepassen"/>
<attribute NAME="addons.roan.filterNamed.applyToVisibleNodesOnlyTitle" VALUE="Alleen op zichbare knopen toepassen"/>
<attribute NAME="addons.roan.filterNamed.visibleNodesOnlyNULLTitle" VALUE="Als Freeplane instelling."/>
<attribute NAME="addons.roan.filterNamed.selectCurrentTitle" VALUE="Selecteer de huidige knoop."/>
<attribute NAME="addons.roan.filterNamed.selectCurrentlySelectedsTitle" VALUE="Selecteer de nu geselecteerde knopen."/>
<attribute NAME="addons.roan.filterNamed.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Kies filter met naam.&lt;br&gt;Selecteer om dialoog te openen.&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.folding" VALUE="Tonen/Verbergen kinderen"/>
<attribute NAME="addons.roan.folding.fold" VALUE="Verbergen (invouwen)"/>
<attribute NAME="addons.roan.folding.unfold" VALUE="Tonen (uitvouwen)"/>
<attribute NAME="addons.roan.folding.current" VALUE="Actieknoop"/>
<attribute NAME="addons.roan.folding.selecteds" VALUE="Nu geselecteerde knopen"/>
<attribute NAME="addons.roan.folding.root" VALUE="Wortelknoop"/>
<attribute NAME="addons.roan.folding.all" VALUE="Alle"/>
<attribute NAME="addons.roan.folding.level1" VALUE="Eerste niveau"/>
<attribute NAME="addons.roan.folding.tooltip" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    In/uitvouwen knopen.&lt;br&gt;Kies voor dialoog venster..&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.followLink" VALUE="Volg hyperlink"/>
<attribute NAME="addons.roan.followLink.tooltip" VALUE="Open en toon inhoud waar hyperlink naar verwijst"/>
<attribute NAME="addons.roan.fullScreen" VALUE="Volledig scherm"/>
<attribute NAME="addons.roan.fullScreen.tooltip" VALUE="Klik schijnbaar op RoAn button voor volledig scherm."/>
<attribute NAME="addons.roan.greyedSurround" VALUE="Gegrijsde omgeving"/>
<attribute NAME="addons.roan.greyedSurround.tooltip" VALUE="Klik schijnbaar op RoAn knop voor gegrijsde actergrond."/>
<attribute NAME="addons.roan.homeRoAn" VALUE="Home RoAn"/>
<attribute NAME="addons.roan.homeRoAn.tooltip" VALUE="Klik schijnbaar op RoAn knop Home."/>
<attribute NAME="addons.roan.jump" VALUE="Spring"/>
<attribute NAME="addons.roan.jump.tooltip" VALUE="Spring naar nu geselecteerde knoop"/>
<attribute NAME="addons.roan.jump.warningMessage" VALUE="Je moet een te selecteren knoop kiezen die niet de actieknoop is."/>
<attribute NAME="addons.roan.menuFreeplane" VALUE="Menu actie"/>
<attribute NAME="addons.roan.menuFreeplane.dialog_message" VALUE="&lt;html&gt;&#xa;  &lt;head&gt;&#xa;    &#xa;  &lt;/head&gt;&#xa;  &lt;body&gt;&#xa;    Voor een freeplane menu actie of script uit.&lt;br&gt;Gebruik addon Developer tools om naam te vinden:&#xa;  &lt;/body&gt;&#xa;&lt;/html&gt;"/>
<attribute NAME="addons.roan.menuFreeplane.tooltip" VALUE="Uitvoeren Freeplane menu actie"/>
<attribute NAME="addons.roan.menuRoan" VALUE="Menu RoAn min/max"/>
<attribute NAME="addons.roan.menuRoan.maximum" VALUE="Maximum"/>
<attribute NAME="addons.roan.menuRoan.minimum" VALUE="Minimum"/>
<attribute NAME="addons.roan.menuRoan.tooltip" VALUE="Klik schijnbaar op gelijknamige knop in RoAn menu"/>
<attribute NAME="addons.roan.scrolling" VALUE="Scrollen"/>
<attribute NAME="addons.roan.scrolling.tooltip" VALUE="Verplaats de huidige scrollpositie delta XY pixels."/>
<attribute NAME="addons.roan.selecteds" VALUE="Geselecteerde knopen"/>
<attribute NAME="addons.roan.selecteds.addingCurrentlySelected" VALUE="Voeg nu geselecteerde knopen toe:"/>
<attribute NAME="addons.roan.selecteds.change" VALUE="Om de selectie te veranderen, druk Cancel."/>
<attribute NAME="addons.roan.selecteds.tooltip" VALUE="De nu geselecteerde knopen straks selecteren"/>
<attribute NAME="addons.roan.zoom" VALUE="Zoom %"/>
<attribute NAME="addons.roan.zoom.dialog_message" VALUE="Zet zoom %"/>
<attribute NAME="addons.roan.zoom.tooltip" VALUE="Zet zoomactie voor deze knoop"/>
<attribute NAME="addons.roan.zooming" VALUE="Zoomen"/>
<attribute NAME="addons.roan.zooming.tooltip" VALUE="Kies Roan knop om automatisch in/uitzoomen bij stappen/afspelen.."/>
<attribute NAME="addons.roan.actionBoolean.allSelectedsMessage" VALUE="Standaard actieknoop.\nToepassen op nu geselecteerde knopen?"/>
<attribute NAME="addons.roan.actionBoolean.ON" VALUE="AAN"/>
<attribute NAME="addons.roan.actionBoolean.OFF" VALUE="UIT"/>
<attribute NAME="addons.roan.EditDialog.addActions" VALUE="Menu met acties"/>
<attribute NAME="OptionPanel.separator.addons.roan.imageinline" VALUE="Afbeeldingen toevoegen"/>
<attribute NAME="OptionPanel.addons.roan.imageinline.widthMax" VALUE="maximum breedte"/>
<attribute NAME="OptionPanel.addons.roan.imageinline.heightMax" VALUE="maximum hoogte"/>
<attribute NAME="addons.roan.imageinline.locationImageLabelTitle" VALUE="Locatie afbeelding"/>
<attribute NAME="addons.roan.imageinline.locationLabelTitle" VALUE="Locatie"/>
<attribute NAME="addons.roan.imageinline.widthMaxTitle" VALUE="maximum breedte"/>
<attribute NAME="addons.roan.imageinline.heightMaxTitle" VALUE="maximum hoogte"/>
<attribute NAME="addons.roan.imageinline.Current" VALUE="Huidige knoop"/>
<attribute NAME="addons.roan.imageinline.Parent" VALUE="Ouderknoop"/>
<attribute NAME="addons.roan.imageinline.dialogTitle" VALUE="Afbeeldingen toevoegen"/>
<attribute NAME="addons.roan.imageinline.fromParentDirectoryTitle" VALUE="Afbeeldingen uit mindmap directory"/>
<attribute NAME="addons.roan.imageinline.fromRedArrowLinksTitle" VALUE="Afbeeldingen van rode-pijl hyperlinks"/>
<attribute NAME="addons.roan.imageinline.fromAddonInsertInlineImageTitle" VALUE="Afbeelding via addon Insert Inline Image"/>
<attribute NAME="addons.roan.imageinline.subMenuTitle" VALUE="SubMenu"/>
<attribute NAME="addons.roan.imageinline.isResizeExisitingTitle" VALUE="Aanpassen bestaande grootte"/>
<attribute NAME="addons.roan.indexTitle" VALUE="Index: toevoegen kopplingen naar bestanden en mappen in de directory van de mindmap"/>
<attribute NAME="addons.roan.nodelib.CORE" VALUE="KERN"/>
<attribute NAME="addons.roan.nodelib.DETAILS" VALUE="DETAILS"/>
<attribute NAME="addons.roan.nodelib.NOTE" VALUE="NOTITIE"/>
<attribute NAME="addons.roan.nodelib.ARROW" VALUE="PIJL"/>
<attribute NAME="addons.roan.lockTitle" VALUE="Voer wachtwoord in (encryptie)"/>
<attribute NAME="addons.roan.index.directoryTitle" VALUE="map"/>
<attribute NAME="addons.roan.index.isDirectoryIconTitle" VALUE="Icon voor map"/>
<attribute NAME="addons.roan.index.locationLinkDirectoryLabelTitle" VALUE="Locatie mapkoppeling"/>
<attribute NAME="addons.roan.index.locationLinkFileLabelTitle" VALUE="Locatie bestandskoppeling"/>
<attribute NAME="addons.roan.index.dialogTitle" VALUE="Toevoegen knoop met koppeling naar elke map en bestand"/>
<attribute NAME="addons.roan.index.sortLabelTitle" VALUE="Sorteren"/>
<attribute NAME="addons.roan.index.divisionRootLabelTitle" VALUE="Verdelen knopen links-rechts"/>
<attribute NAME="addons.roan.index.divisionRootRIGHTTitle" VALUE="RECHTS"/>
<attribute NAME="addons.roan.index.divisionRootLEFTRIGHTTitle" VALUE="LINKS-RECHTS"/>
<attribute NAME="addons.roan.index.divisionRootRIGHTLEFTTitle" VALUE="RECHTS-LINKS"/>
<attribute NAME="addons.roan.index.divisionRootMAPFILETitle" VALUE="MAPPEN-BESTANDEN"/>
<attribute NAME="addons.roan.index.divisionRootFILEMAPTitle" VALUE="BESTANDEN-MAPPEN"/>
<attribute NAME="addons.roan.index.sortNONETitle" VALUE="GEEN"/>
<attribute NAME="addons.roan.index.sortFOREWARDTitle" VALUE="VOORWAARTS"/>
<attribute NAME="addons.roan.index.sortBACKWARDTitle" VALUE="ACHTERWAARTS"/>
<attribute NAME="addons.roan.index.showFileExtensionTitle" VALUE="Toon bestandsextensie"/>
<attribute NAME="addons.roan.index.isDirectoryNodesTitle" VALUE="Map-knopen"/>
<node TEXT="tools" FOLDED="true" ID="ID_1398221811" CREATED="1403179041931" MODIFIED="1403186598887">
<font BOLD="true"/>
<node TEXT="Instruction for translation" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1359960992" CREATED="1403185903209" MODIFIED="1403185991547">
<node TEXT="Copy node &quot;en&quot;" ID="ID_920384965" CREATED="1403185951531" MODIFIED="1403185979449"/>
<node TEXT="Paste on &quot;translations&quot;" ID="ID_1604543832" CREATED="1403185997590" MODIFIED="1403186024605"/>
<node TEXT="Rename &quot;en&quot;: replace by your language code" ID="ID_1991014839" CREATED="1403186013883" MODIFIED="1403190406511" LINK="#ID_624507685"/>
<node TEXT="unfold &quot;tools&quot;" ID="ID_996445752" CREATED="1403186071667" MODIFIED="1403186092567"/>
<node TEXT="Click button in node &quot;table to source&quot;" ID="ID_488553965" CREATED="1403201292918" MODIFIED="1403201319516"/>
<node TEXT="Unfold &quot;source&quot;" ID="ID_972641252" CREATED="1403186093144" MODIFIED="1403201329866"/>
<node TEXT="Replace English text in grandchildren of source,&#xa;by text in your language." ID="ID_543541007" CREATED="1403186105449" MODIFIED="1403186143108"/>
<node TEXT="Click the button in node &quot;source to table&quot;" ID="ID_1862696548" CREATED="1403186151156" MODIFIED="1403186212220"/>
<node TEXT="Save and Reinstall the addon to test it." ID="ID_361954342" CREATED="1403187561836" MODIFIED="1403187635304"/>
<node TEXT="If all works fine, children of source may be deleted." ID="ID_1568473721" CREATED="1403250428994" MODIFIED="1403250458852"/>
</node>
<node TEXT="table to source" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1650635059" CREATED="1403184244360" MODIFIED="1407240728619" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="def translation=node.parent.parent&#xa;  def tools=node.parent&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xa;  def source=li[0]&#xa;  source.children.each{it.delete()}&#xa;    &#xa;    li=translation.attributes.getAttributeNames()&#xa;&#x9;li.each{&#xa;&#x9;&#x9;def attr=source.createChild()&#xa;&#x9;&#x9;attr.text=it&#xa;        &#xa;        def child=attr.createChild()&#xa;&#x9;&#x9;child.text=translation[it]&#x9;&#x9;&#xa;&#x9;}"/>
<node TEXT="first action" ID="ID_1787373857" CREATED="1403250403517" MODIFIED="1403250410383"/>
</node>
<node TEXT="source to table" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1589177753" CREATED="1403184244360" MODIFIED="1407240728619" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="def translation=node.parent.parent&#xa;  def tools=node.parent&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xa;  def source=li[0]&#xa;&#xa;translation.attributes.clear()&#xa;source.children.each{ &#xa;    def valNode=it.children[0]&#xa;    translation[it.text]=valNode.text&#xa;    }"/>
<node TEXT="final action" ID="ID_734717998" CREATED="1403250392808" MODIFIED="1403250400173"/>
<node TEXT="&quot;addons.roan.nodelib.CORE&quot;," FOLDED="true" ID="ID_1552296253" CREATED="1412253138006" MODIFIED="1412253138006">
<node TEXT="&quot;CORE&quot;" ID="ID_1365232394" CREATED="1412253138006" MODIFIED="1412253138006"/>
</node>
</node>
<node TEXT="filter source" LOCALIZED_STYLE_REF="styles.topic" FOLDED="true" ID="ID_1584182874" CREATED="1403180253094" MODIFIED="1407240728619" LINK="menuitem:_$ExecuteScriptForSelectionAction$0">
<attribute NAME="script1" VALUE="String strip(String s){ &#xd;&#xa;    s-=&apos;&quot;&apos;;   s-=&apos;&quot;&apos;&#xd;&#xa;     s-=&quot;&apos;&quot;;   s-=&quot;&apos;&quot;&#xd;&#xa;     s-=&apos;,&apos;&#xd;&#xa;     return s&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;  def tools=node.parent&#xd;&#xa;  def li=tools.children.findAll({it.text==&quot;source&quot;})&#xd;&#xa;  def source=li[0]&#xd;&#xa;  &#xd;&#xa;  source.children.each{&#xd;&#xa;  it.text=strip(it.text)&#xd;&#xa;  def details=it.children[0]&#xd;&#xa;  details.text=strip(details.text)&#xd;&#xa;}"/>
<node TEXT="For developer only: removes unnessary &quot;, &apos; and , after copy to source from .groovy" ID="ID_1802376304" CREATED="1403250344052" MODIFIED="1403250505044"/>
</node>
<node TEXT="source" FOLDED="true" ID="ID_1085523313" CREATED="1403179064996" MODIFIED="1406925281214" BACKGROUND_COLOR="#ffff99" STYLE="bubble">
<node TEXT="addons.${name}" FOLDED="true" ID="ID_177959316" CREATED="1403202288275" MODIFIED="1403202288275">
<node TEXT="roan" ID="ID_1367531508" CREATED="1403202288275" MODIFIED="1403202288276"/>
</node>
<node TEXT="addons.${name}.presentation" FOLDED="true" ID="ID_720356370" CREATED="1403202288276" MODIFIED="1403202288277">
<node TEXT="RoAn-Presentatie" ID="ID_1222863869" CREATED="1403202288277" MODIFIED="1403202288277"/>
</node>
<node TEXT="addons.${name}.presentation_playAction" FOLDED="true" ID="ID_306629805" CREATED="1403202288278" MODIFIED="1403202288278">
<node TEXT="Afspelen" ID="ID_322259370" CREATED="1403202288278" MODIFIED="1403202288279"/>
</node>
<node TEXT="addons.${name}.presentation_stepAction" FOLDED="true" ID="ID_1790963589" CREATED="1403202288279" MODIFIED="1403202288280">
<node TEXT="Stap" ID="ID_1318433245" CREATED="1403202288280" MODIFIED="1403202288280"/>
</node>
<node TEXT="addons.${name}.presentation_menuAction" FOLDED="true" ID="ID_1318756640" CREATED="1403202288281" MODIFIED="1403202288281">
<node TEXT="Menu" ID="ID_168950027" CREATED="1403202288281" MODIFIED="1403202288282"/>
</node>
<node TEXT="addons.${name}.presentation_editDialogAction" FOLDED="true" ID="ID_181058223" CREATED="1403202288282" MODIFIED="1403202288282">
<node TEXT="Bewerken" ID="ID_1380803465" CREATED="1403202288283" MODIFIED="1403202288283"/>
</node>
<node TEXT="addons.${name}.presentation_helpAction" FOLDED="true" ID="ID_1502601591" CREATED="1403202288283" MODIFIED="1403202288284">
<node TEXT="Help" ID="ID_839772946" CREATED="1403202288284" MODIFIED="1403202288284"/>
</node>
<node TEXT="addons.${name}.insertInlineImage" FOLDED="true" ID="ID_1090440457" CREATED="1403202288285" MODIFIED="1403202288285">
<node TEXT="Invoegen inline afbeelding" ID="ID_924766230" CREATED="1403202288285" MODIFIED="1403202288286"/>
</node>
<node TEXT="addons.roan.sliderTooltip" FOLDED="true" ID="ID_669231056" CREATED="1403202288286" MODIFIED="1403202288286">
<node ID="ID_151590996" CREATED="1403202288287" MODIFIED="1403202288290"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Aantal seconden vertoning van geselecteerde knoop.

    <p>
      Verplaast schuifje voor nieuwe waarde.<br/>
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.playTitle" FOLDED="true" ID="ID_1260834262" CREATED="1403202288291" MODIFIED="1403202288291">
<node TEXT="Afspelen" ID="ID_1140820088" CREATED="1403202288291" MODIFIED="1403202288292"/>
</node>
<node TEXT="addons.roan.stepTitle" FOLDED="true" ID="ID_1288238969" CREATED="1403202288292" MODIFIED="1403202288293">
<node TEXT="Stap voorwaarts of, bij spelen, direkt naar volgende." ID="ID_459685781" CREATED="1403202288293" MODIFIED="1403725313343"/>
</node>
<node TEXT="addons.roan.stopTitle" FOLDED="true" ID="ID_102879313" CREATED="1403202288294" MODIFIED="1403202288294">
<node TEXT="Stoppen afspelen" ID="ID_1521625446" CREATED="1403202288294" MODIFIED="1403202288295"/>
</node>
<node TEXT="addons.roan.attributes_OnTitle" FOLDED="true" ID="ID_1275510308" CREATED="1403202288295" MODIFIED="1403202288295">
<node TEXT="Verbergen attributen" ID="ID_1566803830" CREATED="1403202288296" MODIFIED="1403697511919"/>
</node>
<node TEXT="addons.roan.attributes_OffTitle" FOLDED="true" ID="ID_100538484" CREATED="1403202288297" MODIFIED="1403202288297">
<node TEXT="Tonen attributen" ID="ID_1580310874" CREATED="1403202288297" MODIFIED="1403202288298"/>
</node>
<node TEXT="addons.roan.state_OnTitle" FOLDED="true" ID="ID_1549954759" CREATED="1403202288298" MODIFIED="1403202288298">
<node TEXT="Verbergen icoontje bij attributen" ID="ID_110512460" CREATED="1403202288299" MODIFIED="1403697538819"/>
</node>
<node TEXT="addons.roan.state_OffTitle" FOLDED="true" ID="ID_1467949671" CREATED="1403202288300" MODIFIED="1403202288300">
<node TEXT="Tonen icoontje bij attributen" ID="ID_1159959732" CREATED="1403202288301" MODIFIED="1403697554215"/>
</node>
<node TEXT="addons.roan.init" FOLDED="true" ID="ID_1403203603" CREATED="1403202288302" MODIFIED="1403202288302">
<node TEXT="Initialiseer mindmap" ID="ID_260011789" CREATED="1403202288302" MODIFIED="1403202288303"/>
</node>
<node TEXT="addons.roan.helpTitle" FOLDED="true" ID="ID_586970756" CREATED="1403202288303" MODIFIED="1403202288303">
<node TEXT="Help" ID="ID_1248961022" CREATED="1403202288304" MODIFIED="1403202288304"/>
</node>
<node TEXT="addons.roan.homeTitle" FOLDED="true" ID="ID_872364174" CREATED="1403202288304" MODIFIED="1403202288305">
<node TEXT="RoAn-Start: Selecteren stamknoop en kinderen verbergen." ID="ID_500379236" CREATED="1403202288305" MODIFIED="1403619757261"/>
</node>
<node TEXT="addons.roan.menuTitle" FOLDED="true" ID="ID_1167422467" CREATED="1403202288306" MODIFIED="1403202288306">
<node TEXT="RoAn-Presenteren" ID="ID_1898145866" CREATED="1403202288307" MODIFIED="1403202288307"/>
</node>
<node TEXT="addons.roan.editTitle" FOLDED="true" ID="ID_268735055" CREATED="1403202288307" MODIFIED="1403202288308">
<node TEXT="Roan-Bewerken" ID="ID_1776626404" CREATED="1403202288308" MODIFIED="1403202288308"/>
</node>
<node TEXT="addons.roan.imageTitle" FOLDED="true" ID="ID_286186567" CREATED="1403202288309" MODIFIED="1403202288309">
<node TEXT="Invoegen plaatje" ID="ID_1427067320" CREATED="1403202288309" MODIFIED="1411657991979"/>
</node>
<node TEXT="addons.roan.grey_OnTitle" FOLDED="true" ID="ID_665329749" CREATED="1403202288310" MODIFIED="1403202288311">
<node TEXT="Grjze achtergrond: zet UIT" ID="ID_399829336" CREATED="1403202288311" MODIFIED="1406924656373"/>
</node>
<node TEXT="addons.roan.grey_OffTitle" FOLDED="true" ID="ID_384927940" CREATED="1403202288312" MODIFIED="1403202288312">
<node TEXT="Grijze achtergrond: zet AAN" ID="ID_1578517524" CREATED="1403202288312" MODIFIED="1406924670122"/>
</node>
<node TEXT="addons.roan.backTitle" FOLDED="true" ID="ID_716791685" CREATED="1403202288313" MODIFIED="1403202288313">
<node TEXT="Stap terug of, bij spelen, stop." ID="ID_883912249" CREATED="1403202288314" MODIFIED="1403725302403"/>
</node>
<node TEXT="addons.roan.tooltip_OnTitle" FOLDED="true" ID="ID_357455243" CREATED="1403202288314" MODIFIED="1403202288315">
<node TEXT="Verbergen tooltip" ID="ID_669630777" CREATED="1403202288315" MODIFIED="1403202288315"/>
</node>
<node TEXT="addons.roan.tooltip_OffTitle" FOLDED="true" ID="ID_1501686387" CREATED="1403202288316" MODIFIED="1403202288316">
<node TEXT="Tonen tooltip" ID="ID_1657005023" CREATED="1403202288316" MODIFIED="1403202288317"/>
</node>
<node TEXT="addons.roan.plusSizeTitle" FOLDED="true" ID="ID_1038613916" CREATED="1403202288317" MODIFIED="1403202288318">
<node TEXT="Minimaliseren menuvenster voor afspelen" ID="ID_1266044924" CREATED="1403202288318" MODIFIED="1403202288318"/>
</node>
<node TEXT="addons.roan.minSizeTitle" FOLDED="true" ID="ID_269724902" CREATED="1403202288319" MODIFIED="1403202288319">
<node TEXT="Maximaliseren menuvenster voor bewerken" ID="ID_418945728" CREATED="1403202288319" MODIFIED="1403202288320"/>
</node>
<node TEXT="addons.roan.action" FOLDED="true" ID="ID_94419705" CREATED="1403202288324" MODIFIED="1403202288324">
<node TEXT="Actie" ID="ID_1791437949" CREATED="1403202288325" MODIFIED="1403202288325"/>
</node>
<node TEXT="addons.roan.actionOnOpen" FOLDED="true" ID="ID_1293266046" CREATED="1403202288325" MODIFIED="1403202288326">
<node TEXT="Bij Open" ID="ID_949136467" CREATED="1403202288326" MODIFIED="1409843644187"/>
</node>
<node TEXT="addons.roan.actionOnNext" FOLDED="true" ID="ID_1178603415" CREATED="1403202288327" MODIFIED="1403202288327">
<node TEXT="Bij Vervolg" ID="ID_1665061796" CREATED="1403202288327" MODIFIED="1409843648820"/>
</node>
<node TEXT="addons.roan.actionOnBack" FOLDED="true" ID="ID_1090838151" CREATED="1403202288328" MODIFIED="1403202288328">
<node TEXT="Bij Terug" ID="ID_409755055" CREATED="1403202288329" MODIFIED="1409843660536"/>
</node>
<node TEXT="addons.roan.currentNodeTitle" FOLDED="true" ID="ID_1620841823" CREATED="1403202288344" MODIFIED="1403202288345">
<node TEXT="Laden" ID="ID_1492727443" CREATED="1403202288345" MODIFIED="1405837601018"/>
</node>
<node TEXT="addons.roan.currentNodeTitle_tooltip" FOLDED="true" ID="ID_181582333" CREATED="1403202288346" MODIFIED="1403202288346">
<node TEXT="Laden van geselecteerde knoop" ID="ID_1321522165" CREATED="1403202288346" MODIFIED="1403202288347"/>
</node>
<node TEXT="addons.roan.pasteSelectedsTitle" FOLDED="true" ID="ID_1795156967" CREATED="1403202288347" MODIFIED="1403202288347">
<node TEXT="... naar selectie" ID="ID_1750253684" CREATED="1403202288348" MODIFIED="1405839876486"/>
</node>
<node TEXT="addons.roan.pasteCurrentTitle" FOLDED="true" ID="ID_619343544" CREATED="1403202288348" MODIFIED="1403202288348">
<node TEXT="Plakken" ID="ID_1909128284" CREATED="1403202288349" MODIFIED="1405837693386"/>
</node>
<node TEXT="addons.roan.pasteCurrentTitle_tooltip" FOLDED="true" ID="ID_909080785" CREATED="1403202288349" MODIFIED="1403202288349">
<node TEXT="Zie links voor titel huidige knoop." ID="ID_1549546518" CREATED="1403202288349" MODIFIED="1403202288350"/>
</node>
<node TEXT="addons.roan.scriptLabelTitle" FOLDED="true" ID="ID_1245828702" CREATED="1403202288350" MODIFIED="1405450032381">
<node TEXT="Script acties" ID="ID_521183878" CREATED="1403202288350" MODIFIED="1407569075857"/>
</node>
<node TEXT="addons.roan.scriptButtonOpenTitle" FOLDED="true" ID="ID_1574666460" CREATED="1403202288351" MODIFIED="1405449459095">
<node TEXT="Open" ID="ID_432826213" CREATED="1403202288351" MODIFIED="1403202288351"/>
</node>
<node TEXT="addons.roan.scriptButtonContinueTitle" FOLDED="true" ID="ID_698210984" CREATED="1403202288351" MODIFIED="1405449349081">
<node TEXT="Vervolg" ID="ID_1019513761" CREATED="1403202288352" MODIFIED="1403202288352"/>
</node>
<node TEXT="addons.roan.scriptButtonBackTitle" FOLDED="true" ID="ID_829151832" CREATED="1403202288353" MODIFIED="1405449224593">
<node TEXT="Terug" ID="ID_1353820013" CREATED="1403202288353" MODIFIED="1403202288354"/>
</node>
<node TEXT="addons.roan.toggleScriptButton_tooltip" FOLDED="true" ID="ID_991247020" CREATED="1403202288354" MODIFIED="1405449833373">
<node TEXT="Schakel tussen Open - Vervolg - Terug" ID="ID_37257277" CREATED="1403202288354" MODIFIED="1403202288355"/>
</node>
<node TEXT="addons.roan.currentNodeText_tooltip" FOLDED="true" ID="ID_1117422087" CREATED="1403202288355" MODIFIED="1403202288355">
<node TEXT="Knooptekst huidige knoop." ID="ID_1167370384" CREATED="1403202288356" MODIFIED="1403202288356"/>
</node>
<node TEXT="addons.roan.scriptActions_tooltip" FOLDED="true" ID="ID_154988431" CREATED="1403202288356" MODIFIED="1405449722561">
<node TEXT="Lijst menu- en filter acties." ID="ID_844634140" CREATED="1403202288357" MODIFIED="1405487200079"/>
</node>
<node TEXT="addons.roan.pasteSelecteds_tooltip" FOLDED="true" ID="ID_257416221" CREATED="1403202288357" MODIFIED="1403202288358">
<node TEXT="Plak in all geselecteerde knopen." ID="ID_1676148836" CREATED="1403202288358" MODIFIED="1403202288358"/>
</node>
<node TEXT="addons.roan.initMessage" FOLDED="true" ID="ID_1760664799" CREATED="1403202602549" MODIFIED="1403202657187">
<node TEXT="Mindmap ingesteld in attributen van wortelknoop." ID="ID_1233637310" CREATED="1403202602549" MODIFIED="1403207558225"/>
</node>
<node TEXT="addons.roan.fullScreenOnTitle" FOLDED="true" ID="ID_1836909436" CREATED="1403676056655" MODIFIED="1403676083347">
<node TEXT="Scherm - met Freeplane menubalken" ID="ID_378913303" CREATED="1403676056655" MODIFIED="1403699012096"/>
</node>
<node TEXT="addons.roan.fullScreenOffTitle" FOLDED="true" ID="ID_141761495" CREATED="1403676126972" MODIFIED="1403676146722">
<node TEXT="Scherm - volledig, zonder Freeplane menubalken" ID="ID_1524607178" CREATED="1403676126972" MODIFIED="1403699033424"/>
</node>
<node TEXT="OptionPanel.plugin.addons.roan" FOLDED="true" ID="ID_530674260" CREATED="1403798379854" MODIFIED="1403807662892">
<node TEXT="RoAn-Presentatie" ID="ID_411803536" CREATED="1403798810543" MODIFIED="1403799639224"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onOpenMaxMenu" FOLDED="true" ID="ID_1579927021" CREATED="1403798349909" MODIFIED="1403807688741">
<node TEXT="Bij openen/maximimaliseren menu" ID="ID_1778740690" CREATED="1403798837321" MODIFIED="1403799663561"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.screenModeMaxOff" FOLDED="true" ID="ID_1862066079" CREATED="1403798422551" MODIFIED="1403811684941">
<node TEXT="Scherm mode: met menubalken" ID="ID_1135543877" CREATED="1403799007789" MODIFIED="1403799694932"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onOpenMinMenu" FOLDED="true" ID="ID_1149501486" CREATED="1403798422582" MODIFIED="1403807718927">
<node TEXT="Bij minimaliseren menu" ID="ID_792823853" CREATED="1403798904658" MODIFIED="1403799717345"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.screenModeMaxOn" FOLDED="true" ID="ID_1889040797" CREATED="1403798422598" MODIFIED="1403811693786">
<node TEXT="Scherm mode: volledig scherm" ID="ID_161552712" CREATED="1403799145328" MODIFIED="1403799736208"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.greyBackgroundOff" FOLDED="true" ID="ID_286925789" CREATED="1403815083943" MODIFIED="1406925281214">
<node TEXT="Grijze achtergrond: UIT" ID="ID_236300530" CREATED="1403799436510" MODIFIED="1406924729402"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onCloseMenu" FOLDED="true" ID="ID_241525345" CREATED="1403798422629" MODIFIED="1403807754152">
<node TEXT="Bij sluiten menu" ID="ID_643963295" CREATED="1403798924556" MODIFIED="1403799759936"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu.screenModeMaxOff" FOLDED="true" ID="ID_90332583" CREATED="1403798422644" MODIFIED="1403807768629">
<node TEXT="Scherm mode: met menubalken" ID="ID_372656599" CREATED="1403799187876" MODIFIED="1403799778204"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.greyBackgroundOn" FOLDED="true" ID="ID_1905372985" CREATED="1403814988892" MODIFIED="1403816125698">
<node TEXT="Grijze achtergrond: AAN" ID="ID_1216221289" CREATED="1403815155584" MODIFIED="1406924769229"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.onPlay" FOLDED="true" ID="ID_288082225" CREATED="1403798422676" MODIFIED="1403807785945">
<node TEXT="Bij afspelen" ID="ID_1295961221" CREATED="1403798935639" MODIFIED="1403799788047"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay.screenModeMaxOn" FOLDED="true" ID="ID_854979733" CREATED="1403798422691" MODIFIED="1403807797972">
<node TEXT="Scherm mode: volledig scherm" ID="ID_1307189588" CREATED="1403799338642" MODIFIED="1403799809341"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay.greyBackgroundOn" FOLDED="true" ID="ID_1955426193" CREATED="1403798422707" MODIFIED="1403808027293">
<node TEXT="Grijze achtergrond: AAN" ID="ID_1659553306" CREATED="1403815155584" MODIFIED="1406924769229"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.finishPlay" FOLDED="true" ID="ID_1242335229" CREATED="1403798422738" MODIFIED="1403808058696">
<node TEXT="Bij stoppen afspelen" ID="ID_56826279" CREATED="1403798948158" MODIFIED="1403799842148"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay.screenModeMaxOff" FOLDED="true" ID="ID_1244474736" CREATED="1403798422754" MODIFIED="1403808084872">
<node TEXT="Scherm mode: met menubalken" ID="ID_244460244" CREATED="1403799392244" MODIFIED="1403799865283"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay.greyBackgroundOff" FOLDED="true" ID="ID_1353308002" CREATED="1403798422785" MODIFIED="1403808101190">
<node TEXT="Grijze achtergrond: UIT" ID="ID_515593505" CREATED="1403799436510" MODIFIED="1406924729402"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.tooltipsOn" FOLDED="true" ID="ID_1709871462" CREATED="1403854990338" MODIFIED="1403856425167">
<node TEXT="Tonen tooltips" ID="ID_646676510" CREATED="1403854996445" MODIFIED="1403857048247"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.attributesOff" FOLDED="true" ID="ID_864456842" CREATED="1403855045711" MODIFIED="1403856433637">
<node TEXT="Verbergen attributen" ID="ID_1822939372" CREATED="1403855051334" MODIFIED="1403857128494"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMaxMenu.attributesIconOff" FOLDED="true" ID="ID_439456882" CREATED="1403855100428" MODIFIED="1403856463465">
<node TEXT="Verbergen icoontje voor attributen" ID="ID_1316701332" CREATED="1403855104866" MODIFIED="1403857089821"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.tooltipsOff" FOLDED="true" ID="ID_881579550" CREATED="1403855166198" MODIFIED="1403856494641">
<node TEXT="Verbergen tootips" ID="ID_309811307" CREATED="1403855104866" MODIFIED="1403857100804"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.attributesOff" FOLDED="true" ID="ID_1175908182" CREATED="1403855196134" MODIFIED="1403856528330">
<node TEXT="Verbergen attributen" ID="ID_1841262777" CREATED="1403855104866" MODIFIED="1403857118682"/>
</node>
<node TEXT="OptionPanel.addons.roan.onOpenMinMenu.attributesIconOff" FOLDED="true" ID="ID_156483392" CREATED="1403855223450" MODIFIED="1403856580208">
<node TEXT="Verbergen icoontje voor attributen" ID="ID_314372232" CREATED="1403855104866" MODIFIED="1403857089821"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu_greyBackgroundOff" FOLDED="true" ID="ID_422641855" CREATED="1403855920966" MODIFIED="1403856623123">
<node TEXT="Grijze achtergrond: UIT" ID="ID_12337850" CREATED="1403799436510" MODIFIED="1406924729402"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu.tooltipsOn" FOLDED="true" ID="ID_1521787144" CREATED="1403855272839" MODIFIED="1403856641718">
<node TEXT="Tonen tooltips" ID="ID_1810816641" CREATED="1403854996445" MODIFIED="1403857048247"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu_attributesOn" FOLDED="true" ID="ID_1794133012" CREATED="1403855341940" MODIFIED="1403856679252">
<node TEXT="Tonen attributen" ID="ID_930411393" CREATED="1403855348265" MODIFIED="1403857272896"/>
</node>
<node TEXT="OptionPanel.addons.roan.onCloseMenu_attributesIconOn" FOLDED="true" ID="ID_135868555" CREATED="1403855386977" MODIFIED="1403856726590">
<node TEXT="Tonen icoontje voor attributen" ID="ID_1670288734" CREATED="1403855104866" MODIFIED="1403857308284"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay.tooltipsOff" FOLDED="true" ID="ID_1475130891" CREATED="1403855773000" MODIFIED="1403856857256">
<node TEXT="Verbergen tooltips" ID="ID_255614998" CREATED="1403855777125" MODIFIED="1403857322449"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay_attributesOff" FOLDED="true" ID="ID_256642753" CREATED="1403855799738" MODIFIED="1403856881468">
<node TEXT="Verbergen attributen" ID="ID_873359944" CREATED="1403855777125" MODIFIED="1403857352378"/>
</node>
<node TEXT="OptionPanel.addons.roan.onPlay_attributesIconOff" FOLDED="true" ID="ID_613988441" CREATED="1403855829597" MODIFIED="1403856902184">
<node TEXT="Verbergen icoontje voor attributen" ID="ID_694302920" CREATED="1403855104866" MODIFIED="1403857089821"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay_tooltipsOn" FOLDED="true" ID="ID_1746407798" CREATED="1403858719961" MODIFIED="1403859531506">
<node TEXT="Tonen tootips" ID="ID_1108652933" CREATED="1403858725631" MODIFIED="1403859135865"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay_attributesOn" FOLDED="true" ID="ID_467692708" CREATED="1403858757947" MODIFIED="1403858919095">
<node TEXT="Tonen attributen" ID="ID_913808406" CREATED="1403858761870" MODIFIED="1403859149079"/>
</node>
<node TEXT="OptionPanel.addons.roan.finishPlay_attributesIconOn" FOLDED="true" ID="ID_717141523" CREATED="1403858794919" MODIFIED="1403859079690">
<node TEXT="Tonen icoontjes voor attributen" ID="ID_677133237" CREATED="1403855834049" MODIFIED="1403859176246"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.whilePlay" FOLDED="true" ID="ID_440013236" CREATED="1404467606169" MODIFIED="1404467781825">
<node TEXT="Tijdens afspelen" ID="ID_193906603" CREATED="1404467796692" MODIFIED="1404468365274"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.all" FOLDED="true" ID="ID_838284791" CREATED="1404467606169" MODIFIED="1404467968098">
<node TEXT="Alles afspelenl" ID="ID_61698972" CREATED="1404467816231" MODIFIED="1404468381077"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.cycle" FOLDED="true" ID="ID_75226983" CREATED="1404467606169" MODIFIED="1404467738535">
<node TEXT="Blijven afspelen" ID="ID_1125684127" CREATED="1404467816231" MODIFIED="1404468393744"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.slowMove" FOLDED="true" ID="ID_7024299" CREATED="1404467606169" MODIFIED="1404468021481">
<node TEXT="Langzame beweging" ID="ID_696062224" CREATED="1404467816231" MODIFIED="1404468408424"/>
</node>
<node TEXT="addons.inlineImage.invalidImageFile" FOLDED="true" ID="ID_46688367" CREATED="1404496129779" MODIFIED="1404496608926">
<node TEXT="ongeldig afbeeldingsbestand :" ID="ID_1668372458" CREATED="1404496129779" MODIFIED="1404496786197"/>
</node>
<node TEXT="addons.inlineImage.cancel" FOLDED="true" ID="ID_1113722189" CREATED="1404496168319" MODIFIED="1404496608942">
<node TEXT="Negeren" ID="ID_584874140" CREATED="1404496168319" MODIFIED="1404497076640"/>
</node>
<node TEXT="addons.inlineImage.mustBeSaved " FOLDED="true" ID="ID_1184189300" CREATED="1404496186080" MODIFIED="1404496608942">
<node TEXT="De mindmap moet eerst worden bewaard voordat relatieve hyperlinks mogelijk zijn." ID="ID_1571390892" CREATED="1404496186080" MODIFIED="1404496873420"/>
</node>
<node TEXT="addons.inlineImage.saveclipboardImageAsTitle" FOLDED="true" ID="ID_40677048" CREATED="1404496213918" MODIFIED="1404496608957">
<node TEXT="Bewaar afbeelidng in clipboard als" ID="ID_1615246662" CREATED="1404496213918" MODIFIED="1404497103472"/>
</node>
<node TEXT="addons.inlineImage.imageFiles" FOLDED="true" ID="ID_484658149" CREATED="1404496235204" MODIFIED="1404496608957">
<node TEXT="Afbeeldingsbestanden" ID="ID_1860575082" CREATED="1404496235204" MODIFIED="1404497128260"/>
</node>
<node TEXT="addons.inlineImage.insertModifyImage" FOLDED="true" ID="ID_582934525" CREATED="1404496274680" MODIFIED="1404496608973">
<node TEXT="Invoegen/Modificeren afbeelding" ID="ID_266169773" CREATED="1404496274680" MODIFIED="1404497149918"/>
</node>
<node TEXT="addons.inlineImage.pasteImageFromClipboardTitle" FOLDED="true" ID="ID_1756930172" CREATED="1404496293377" MODIFIED="1404496608973">
<node TEXT="Plak afbeelding uit Clipboard" ID="ID_681213591" CREATED="1404496293377" MODIFIED="1404497176485"/>
</node>
<node TEXT="addons.inlineImage.la_width" FOLDED="true" ID="ID_1971809428" CREATED="1404496316223" MODIFIED="1404496608989">
<node TEXT="Breedte:" ID="ID_1610860293" CREATED="1404496316223" MODIFIED="1404497191430"/>
</node>
<node TEXT="addons.inlineImage.la_height" FOLDED="true" ID="ID_362117926" CREATED="1404496337727" MODIFIED="1404496608989">
<node TEXT="Hoogte:" ID="ID_296991763" CREATED="1404496337727" MODIFIED="1404497198278"/>
</node>
<node TEXT="addons.inlineImage.imagePath" FOLDED="true" ID="ID_214169502" CREATED="1404496358124" MODIFIED="1404496608989">
<node TEXT="afbeeldingspad" ID="ID_957495692" CREATED="1404496358124" MODIFIED="1404497230305"/>
</node>
<node TEXT="addons.inlineImage.yourLink" FOLDED="true" ID="ID_1485076402" CREATED="1404496385011" MODIFIED="1404496609004">
<node TEXT="jouw koppeling" ID="ID_1568199937" CREATED="1404496385011" MODIFIED="1404497244642"/>
</node>
<node TEXT="addons.inlineImage.asLegend" FOLDED="true" ID="ID_367219152" CREATED="1404496400416" MODIFIED="1404496609004">
<node TEXT="als legenda" ID="ID_697936681" CREATED="1404496400416" MODIFIED="1404497260959"/>
</node>
<node TEXT="addons.inlineImage.noLink" FOLDED="true" ID="ID_618195411" CREATED="1404496415072" MODIFIED="1404496609020">
<node TEXT="geen koppeling" ID="ID_284344778" CREATED="1404496415072" MODIFIED="1404497269742"/>
</node>
<node TEXT="addons.inlineImage.proportionalImageResizing" FOLDED="true" ID="ID_1324565442" CREATED="1404496430914" MODIFIED="1404496609020">
<node TEXT="Proportioneel schalen:" ID="ID_461692845" CREATED="1404496430914" MODIFIED="1404497320988"/>
</node>
<node TEXT="addons.inlineImage.rb_core" FOLDED="true" ID="ID_952560083" CREATED="1404496461545" MODIFIED="1404496609035">
<node TEXT="Kern" ID="ID_1032504006" CREATED="1404496461545" MODIFIED="1404497326589"/>
</node>
<node TEXT="addons.inlineImage.rb_details" FOLDED="true" ID="ID_1100819691" CREATED="1404496475655" MODIFIED="1404496609035">
<node TEXT="Details" ID="ID_927524982" CREATED="1404496475655" MODIFIED="1404496609035"/>
</node>
<node TEXT="addons.inlineImage.rb_note" FOLDED="true" ID="ID_1944017428" CREATED="1404496497581" MODIFIED="1404496609035">
<node TEXT="Notitie" ID="ID_1590221881" CREATED="1404496497581" MODIFIED="1404497346190"/>
</node>
<node TEXT="addons.inlineImage.rb_extension" FOLDED="true" ID="ID_1082784615" CREATED="1404496511676" MODIFIED="1404496609051">
<node TEXT="Uitbreiding" ID="ID_588707244" CREATED="1404496511676" MODIFIED="1404497355425"/>
</node>
<node TEXT="addons.inlineImage.la_target" FOLDED="true" ID="ID_876038981" CREATED="1404496528204" MODIFIED="1404496609051">
<node TEXT="Doel:" ID="ID_619582426" CREATED="1404496528204" MODIFIED="1404497367734"/>
</node>
<node TEXT="addons.inlineImage.linkTargetLabel" FOLDED="true" ID="ID_1316604492" CREATED="1404496543640" MODIFIED="1404496609051">
<node TEXT="Link doel:" ID="ID_144969690" CREATED="1404496543640" MODIFIED="1404497383568"/>
</node>
<node TEXT="addons.roan.filter_On" FOLDED="true" ID="ID_135641463" CREATED="1405278612769" MODIFIED="1405278674834">
<node TEXT="Filteren tijdens presenteren: zet AAN" ID="ID_1304562686" CREATED="1405278612769" MODIFIED="1406924351374"/>
</node>
<node TEXT="addons.roan.filter_Off" FOLDED="true" ID="ID_1156236860" CREATED="1405278637378" MODIFIED="1405278686003">
<node TEXT="Filteren tijdens presenteren: zet UIT" ID="ID_1487738641" CREATED="1405278637378" MODIFIED="1406924360952"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.doFilter" FOLDED="true" ID="ID_1530048891" CREATED="1405278767646" MODIFIED="1405278884295">
<node TEXT="Filter" ID="ID_1885228618" CREATED="1405278767646" MODIFIED="1405278948490"/>
</node>
<node TEXT="addons.${name}.auto_setLibAndFileAction" FOLDED="true" ID="ID_375846899" CREATED="1406182252313" MODIFIED="1406388741823">
<node TEXT="Aktiveren addon" ID="ID_1612706590" CREATED="1406182269200" MODIFIED="1406182277673"/>
</node>
<node TEXT="addons.${name}.auto_clearUserDirFiles" FOLDED="true" ID="ID_1852000252" CREATED="1406388642867" MODIFIED="1406388642867">
<node TEXT="Wis onnodige bestanden" ID="ID_1090417353" CREATED="1406388657720" MODIFIED="1406388766015"/>
</node>
<node TEXT="addons.${name}.copyLinkToNodeInOtherMap" FOLDED="true" ID="ID_1641642997" CREATED="1406228734773" MODIFIED="1406390171877">
<node TEXT="Koppeling naar knoop in andere mindmap" ID="ID_1406168719" CREATED="1406228834513" MODIFIED="1406228880089"/>
</node>
<node TEXT="addons.roan.userdirfiles.remove1" FOLDED="true" ID="ID_1592175997" CREATED="1406387279965" MODIFIED="1406387409075">
<node TEXT="1. Bestanden verwijderen die niet de volgende taal hebben:" ID="ID_1909147316" CREATED="1406387279965" MODIFIED="1406387563449"/>
</node>
<node TEXT="addons.roan.userdirfiles.remove2" FOLDED="true" ID="ID_1502280060" CREATED="1406387303965" MODIFIED="1406387403345">
<node TEXT="2. Log besstanden verwijderen ?" ID="ID_1310909915" CREATED="1406387303965" MODIFIED="1406387591049"/>
</node>
<node TEXT="addons.roan.userdirfiles.remove3" FOLDED="true" ID="ID_1294292737" CREATED="1406387320939" MODIFIED="1406387398315">
<node TEXT="3. Backup bestanden verwijderen ?" ID="ID_1563802281" CREATED="1406387320939" MODIFIED="1406387613570"/>
</node>
<node TEXT="addons.roan.userdirfiles.restart" FOLDED="true" ID="ID_411202315" CREATED="1406387337839" MODIFIED="1406387421665">
<node TEXT="U zult mogelijk Freeplane moeten herstarten" ID="ID_1826227141" CREATED="1406387337839" MODIFIED="1406387636620"/>
</node>
<node TEXT="addons.${name}.addon" FOLDED="true" ID="ID_1666264085" CREATED="1406388272330" MODIFIED="1406388293569">
<node TEXT="addons" ID="ID_770691795" CREATED="1406388293580" MODIFIED="1406388316090"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.doAutoZoom" FOLDED="true" ID="ID_855319796" CREATED="1406894400601" MODIFIED="1407240648856">
<node TEXT="auto zoom" ID="ID_1093519314" CREATED="1406894494931" MODIFIED="1406894507033"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.autoZoomMax" FOLDED="true" ID="ID_263563500" CREATED="1406894424533" MODIFIED="1406894750223">
<node TEXT="auto zoom % maximum" ID="ID_223908029" CREATED="1406894424533" MODIFIED="1406894729103"/>
</node>
<node TEXT="OptionPanel.addons.roan.whilePlay.autoZoomMin" FOLDED="true" ID="ID_340464345" CREATED="1406894459323" MODIFIED="1406894767933">
<node TEXT="auto zoom % minimum" ID="ID_1786401044" CREATED="1406894459323" MODIFIED="1406894721813"/>
</node>
<node TEXT="addons.roan.autoZoom_On" FOLDED="true" ID="ID_1588641703" CREATED="1406896574077" MODIFIED="1406896630377">
<node TEXT="Zoom in en uit: zet AAN" ID="ID_1026831811" CREATED="1406896574077" MODIFIED="1406924419593"/>
</node>
<node TEXT="addons.roan.autoZoom_Off" FOLDED="true" ID="ID_772147156" CREATED="1406896600177" MODIFIED="1406896642477">
<node TEXT="Zoom in en uit: zet UIT" ID="ID_1246823713" CREATED="1406896600177" MODIFIED="1406924429873"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.windowSize" FOLDED="true" ID="ID_221856782" CREATED="1407010324591" MODIFIED="1411657747770">
<node TEXT="Venstergrootte (bij opnemen)" ID="ID_1386061784" CREATED="1407010369465" MODIFIED="1411657777663"/>
</node>
<node TEXT="OptionPanel.addons.roan.windowWidth" FOLDED="true" ID="ID_1154596536" CREATED="1407010105091" MODIFIED="1407010267254">
<node TEXT="breedte (pixels)" ID="ID_855082229" CREATED="1407010105091" MODIFIED="1407010487276"/>
</node>
<node TEXT="OptionPanel.addons.roan.windowHeight" FOLDED="true" ID="ID_1862596865" CREATED="1407010181157" MODIFIED="1407010297518">
<node TEXT="hoogte (pixels)" ID="ID_29918517" CREATED="1407010181157" MODIFIED="1407010496293"/>
</node>
<node TEXT="addons.${name}.presentation_windowSizeAction" FOLDED="true" ID="ID_287638928" CREATED="1407011994139" MODIFIED="1407011994139">
<node TEXT="Zet venstergrootte (opname)" ID="ID_1490417603" CREATED="1407012026096" MODIFIED="1407046511136"/>
</node>
<node TEXT="addons.roan.center" FOLDED="true" ID="ID_1644105122" CREATED="1410553449351" MODIFIED="1410592428134">
<node TEXT="Centreer" ID="ID_1955966826" CREATED="1410553449351" MODIFIED="1410592738379"/>
</node>
<node TEXT="addons.roan.center.tooltip" FOLDED="true" ID="ID_1773695110" CREATED="1410553497375" MODIFIED="1410592428134">
<node TEXT="Centreer nu geselecteerde knoop" ID="ID_165084097" CREATED="1410553497375" MODIFIED="1410592775884"/>
</node>
<node TEXT="addons.roan.continuation" FOLDED="true" ID="ID_169140490" CREATED="1410553568223" MODIFIED="1410592428134">
<node TEXT="Stop of Kaats" ID="ID_561756561" CREATED="1410553568223" MODIFIED="1410592796398"/>
</node>
<node TEXT="addons.roan.continuation.STOP" FOLDED="true" ID="ID_1803210640" CREATED="1410553676230" MODIFIED="1410592428134">
<node TEXT="STOP" ID="ID_1607059146" CREATED="1410553676230" MODIFIED="1410592428134"/>
</node>
<node TEXT="addons.roan.continuation.BOUNCE" FOLDED="true" ID="ID_538705684" CREATED="1410553705799" MODIFIED="1410592428134">
<node TEXT="KAATS" ID="ID_1091936348" CREATED="1410553705799" MODIFIED="1410592817489"/>
</node>
<node TEXT="addons.roan.continuation.tooltip" FOLDED="true" ID="ID_1547230220" CREATED="1410553738411" MODIFIED="1410592428134">
<node ID="ID_1677559688" CREATED="1410553738411" MODIFIED="1410592873260"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    STOP: eindig afspelen.<br/>KAATS: ga door met onderliggende knoop.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.delay" FOLDED="true" ID="ID_369742981" CREATED="1410553877712" MODIFIED="1410592428165">
<node TEXT="Wacht" ID="ID_1930384863" CREATED="1410553877712" MODIFIED="1410592886192"/>
</node>
<node TEXT="addons.roan.delay.message" FOLDED="true" ID="ID_238789603" CREATED="1410553904770" MODIFIED="1410608496589">
<node TEXT="Wacht seconden" ID="ID_548539486" CREATED="1410553904770" MODIFIED="1410608544005"/>
</node>
<node TEXT="addons.roan.delay.tooltip" FOLDED="true" ID="ID_421913927" CREATED="1410553944402" MODIFIED="1410592428165">
<node TEXT="Toon seconden" ID="ID_307695237" CREATED="1410553944402" MODIFIED="1410592937360"/>
</node>
<node TEXT="addons.roan.detailsVisible.key" FOLDED="true" ID="ID_1268457794" CREATED="1410554077774" MODIFIED="1410592428181">
<node TEXT="Details" ID="ID_1551354642" CREATED="1410554077774" MODIFIED="1410592428181"/>
</node>
<node TEXT="addons.roan.detailsVisible.show" FOLDED="true" ID="ID_510481938" CREATED="1410554099950" MODIFIED="1410592428181">
<node TEXT="TONEN" ID="ID_1038457461" CREATED="1410554099950" MODIFIED="1410592952695"/>
</node>
<node TEXT="addons.roan.detailsVisible.hide" FOLDED="true" ID="ID_1983010134" CREATED="1410554127070" MODIFIED="1410592428181">
<node TEXT="VERBERGEN" ID="ID_1956273665" CREATED="1410554127070" MODIFIED="1410592977998"/>
</node>
<node TEXT="addons.roan.detailsVisible.tooltip" FOLDED="true" ID="ID_1417488054" CREATED="1410554156047" MODIFIED="1410592428181">
<node ID="ID_839889681" CREATED="1410554156047" MODIFIED="1410593066591"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Toon details van de actieknoop (default) of<br/>van de nu geselecteerde knopen.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.toggleEditDialog" FOLDED="true" ID="ID_1253577893" CREATED="1410554248813" MODIFIED="1410592428196">
<node TEXT="Bewerken venster AAN/UIT" ID="ID_624976499" CREATED="1410554248813" MODIFIED="1410593108383"/>
</node>
<node TEXT="addons.roan.toggleEditDialog.tooltip" FOLDED="true" ID="ID_175736582" CREATED="1410554275029" MODIFIED="1410592428196">
<node TEXT="Tonen of verbergen RoAns Bewerken venster." ID="ID_587685528" CREATED="1410554275029" MODIFIED="1410593145262"/>
</node>
<node TEXT="addons.roan.filtering" FOLDED="true" ID="ID_1009078372" CREATED="1410554628793" MODIFIED="1410592428196">
<node TEXT="Filteren" ID="ID_826584043" CREATED="1410554628793" MODIFIED="1410593156774"/>
</node>
<node TEXT="addons.roan.filtering.tooltip" FOLDED="true" ID="ID_1016380753" CREATED="1410554650657" MODIFIED="1410592428196">
<node ID="ID_524504550" CREATED="1410554650657" MODIFIED="1410592428212"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Virtually click automatic-filter button for<br/>filtering nodes of current branch.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.filterNamed" FOLDED="true" ID="ID_1971267693" CREATED="1410554754202" MODIFIED="1410592428212">
<node TEXT="Filter (met naam)" ID="ID_87834212" CREATED="1410554754202" MODIFIED="1410593173669"/>
</node>
<node TEXT="addons.roan.filterNamed.dialogTitle" FOLDED="true" ID="ID_1680633214" CREATED="1410554781276" MODIFIED="1410592428212">
<node TEXT="Pas filter met naam toe." ID="ID_235642146" CREATED="1410554781276" MODIFIED="1410593206414"/>
</node>
<node TEXT="addons.roan.filterNamed.error" FOLDED="true" ID="ID_802525699" CREATED="1410554804465" MODIFIED="1410592428212">
<node TEXT="Definieer eerst een filter-met-naam met Freeplane&apos;s Componeren filter editor." ID="ID_1134054967" CREATED="1410554804465" MODIFIED="1410593418637"/>
</node>
<node TEXT="addons.roan.filterNamed.hideAncestorsTitle" FOLDED="true" ID="ID_1104225067" CREATED="1410554829464" MODIFIED="1410592428227">
<node TEXT="Verbergen voorouders" ID="ID_815403420" CREATED="1410554829464" MODIFIED="1410593434268"/>
</node>
<node TEXT="addons.roan.filterNamed.showAncestorsTitle" FOLDED="true" ID="ID_718759739" CREATED="1410554855945" MODIFIED="1410592428227">
<node TEXT="Tonen voorouders" ID="ID_1788182582" CREATED="1410554855945" MODIFIED="1410593458214"/>
</node>
<node TEXT="addons.roan.filterNamed.ancestorsNULL" FOLDED="true" ID="ID_1508972634" CREATED="1410554904906" MODIFIED="1410592428227">
<node TEXT="Als Freeplane instelling." ID="ID_274670792" CREATED="1410554904906" MODIFIED="1410610195083"/>
</node>
<node TEXT="addons.roan.filterNamed.hideDesendantsTitle" FOLDED="true" ID="ID_1870403464" CREATED="1410554964568" MODIFIED="1410592428227">
<node TEXT="Verbergen afstammelingen" ID="ID_1670383461" CREATED="1410554964568" MODIFIED="1410593574606"/>
</node>
<node TEXT="addons.roan.filterNamed.showDescendantsTitle" FOLDED="true" ID="ID_680809349" CREATED="1410555003280" MODIFIED="1410592428227">
<node TEXT="Verbergen afstammelingen" ID="ID_862690493" CREATED="1410555003280" MODIFIED="1410593613247"/>
</node>
<node TEXT="addons.roan.filterNamed.descendantsNULL" FOLDED="true" ID="ID_1825420715" CREATED="1410555166543" MODIFIED="1410592428227">
<node TEXT="Als Freelane instelling." ID="ID_1016968726" CREATED="1410555166543" MODIFIED="1410608908398"/>
</node>
<node TEXT="addons.roan.filterNamed.applyToAllNodesTitle" FOLDED="true" ID="ID_471120329" CREATED="1410555229107" MODIFIED="1410592428227">
<node TEXT="Op alle knopen toepassen" ID="ID_713536377" CREATED="1410555229107" MODIFIED="1410593696099"/>
</node>
<node TEXT="addons.roan.filterNamed.applyToVisibleNodesOnlyTitle" FOLDED="true" ID="ID_692661806" CREATED="1410555252234" MODIFIED="1410592428243">
<node TEXT="Alleen op zichbare knopen toepassen" ID="ID_458620739" CREATED="1410555252234" MODIFIED="1410593723414"/>
</node>
<node TEXT="addons.roan.filterNamed.visibleNodesOnlyNULLTitle" FOLDED="true" ID="ID_1886748223" CREATED="1410555297248" MODIFIED="1410592428243">
<node TEXT="Als Freeplane instelling." ID="ID_1057564875" CREATED="1410555297248" MODIFIED="1410608929130"/>
</node>
<node TEXT="addons.roan.filterNamed.selectCurrentTitle" FOLDED="true" ID="ID_181675019" CREATED="1410555327660" MODIFIED="1410592428243">
<node TEXT="Selecteer de huidige knoop." ID="ID_638743437" CREATED="1410555327660" MODIFIED="1410593830696"/>
</node>
<node TEXT="addons.roan.filterNamed.selectCurrentlySelectedsTitle" FOLDED="true" ID="ID_1922626666" CREATED="1410555355545" MODIFIED="1410592428243">
<node TEXT="Selecteer de nu geselecteerde knopen." ID="ID_1223182561" CREATED="1410555355545" MODIFIED="1410593852099"/>
</node>
<node TEXT="addons.roan.filterNamed.tooltip" FOLDED="true" ID="ID_348697961" CREATED="1410555384803" MODIFIED="1410592428243">
<node ID="ID_546296786" CREATED="1410555384803" MODIFIED="1410593924779"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Kies filter met naam.<br/>Selecteer om dialoog te openen.
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.folding" FOLDED="true" ID="ID_428070856" CREATED="1410591237095" MODIFIED="1410592428259">
<node TEXT="Tonen/Verbergen kinderen" ID="ID_1679395462" CREATED="1410591237095" MODIFIED="1410593944451"/>
</node>
<node TEXT="addons.roan.folding.fold" FOLDED="true" ID="ID_1627353957" CREATED="1410591255355" MODIFIED="1410592428259">
<node TEXT="Verbergen (invouwen)" ID="ID_1450982027" CREATED="1410591255355" MODIFIED="1410593973062"/>
</node>
<node TEXT="addons.roan.folding.unfold" FOLDED="true" ID="ID_708460407" CREATED="1410591269746" MODIFIED="1410592428259">
<node TEXT="Tonen (uitvouwen)" ID="ID_1813295280" CREATED="1410591269746" MODIFIED="1410593993373"/>
</node>
<node TEXT="addons.roan.folding.current" FOLDED="true" ID="ID_1637499885" CREATED="1410591282593" MODIFIED="1410592428259">
<node TEXT="Actieknoop" ID="ID_641953122" CREATED="1410591282593" MODIFIED="1410594011750"/>
</node>
<node TEXT="addons.roan.folding.selecteds" FOLDED="true" ID="ID_204255163" CREATED="1410591308403" MODIFIED="1410592428259">
<node TEXT="Nu geselecteerde knopen" ID="ID_1626465133" CREATED="1410591308403" MODIFIED="1410594047271"/>
</node>
<node TEXT="addons.roan.folding.root" FOLDED="true" ID="ID_1547863259" CREATED="1410591325056" MODIFIED="1410592428274">
<node TEXT="Wortelknoop" ID="ID_688738928" CREATED="1410591325056" MODIFIED="1410594055149"/>
</node>
<node TEXT="addons.roan.folding.all" FOLDED="true" ID="ID_1642994621" CREATED="1410591339197" MODIFIED="1410592428274">
<node TEXT="Alle" ID="ID_1095544158" CREATED="1410591339197" MODIFIED="1410594075523"/>
</node>
<node TEXT="addons.roan.folding.level1" FOLDED="true" ID="ID_438820207" CREATED="1410591354368" MODIFIED="1410592428274">
<node TEXT="Eerste niveau" ID="ID_882355568" CREATED="1410591354368" MODIFIED="1410594118783"/>
</node>
<node TEXT="addons.roan.folding.tooltip" FOLDED="true" ID="ID_203940076" CREATED="1410591376107" MODIFIED="1410592428274">
<node ID="ID_303243916" CREATED="1410591376107" MODIFIED="1410594160030"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    In/uitvouwen knopen.<br/>Kies voor dialoog venster..
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.followLink" FOLDED="true" ID="ID_1437123267" CREATED="1410591422431" MODIFIED="1410592428290">
<node TEXT="Volg hyperlink" ID="ID_305104374" CREATED="1410591422431" MODIFIED="1410594173259"/>
</node>
<node TEXT="addons.roan.followLink.tooltip" FOLDED="true" ID="ID_498906978" CREATED="1410591441268" MODIFIED="1410592428290">
<node TEXT="Open en toon inhoud waar hyperlink naar verwijst" ID="ID_823894067" CREATED="1410591441268" MODIFIED="1410594214926"/>
</node>
<node TEXT="addons.roan.fullScreen" FOLDED="true" ID="ID_1717523941" CREATED="1410591482772" MODIFIED="1410592428290">
<node TEXT="Volledig scherm" ID="ID_537511365" CREATED="1410591482772" MODIFIED="1410594225987"/>
</node>
<node TEXT="addons.roan.fullScreen.tooltip" FOLDED="true" ID="ID_1078320395" CREATED="1410591499347" MODIFIED="1410592428305">
<node TEXT="Klik schijnbaar op RoAn button voor volledig scherm." ID="ID_667282632" CREATED="1410591499347" MODIFIED="1410594365318"/>
</node>
<node TEXT="addons.roan.greyedSurround" FOLDED="true" ID="ID_1128828189" CREATED="1410591537918" MODIFIED="1410592428305">
<node TEXT="Gegrijsde omgeving" ID="ID_13071526" CREATED="1410591537918" MODIFIED="1410594339953"/>
</node>
<node TEXT="addons.roan.greyedSurround.tooltip" FOLDED="true" ID="ID_194358016" CREATED="1410591552356" MODIFIED="1410592428305">
<node TEXT="Klik schijnbaar op RoAn knop voor gegrijsde actergrond." ID="ID_340739302" CREATED="1410591552356" MODIFIED="1410594410589"/>
</node>
<node TEXT="addons.roan.homeRoAn" FOLDED="true" ID="ID_215345076" CREATED="1410591578806" MODIFIED="1410592428321">
<node TEXT="Home RoAn" ID="ID_645469831" CREATED="1410591578806" MODIFIED="1410592428321"/>
</node>
<node TEXT="addons.roan.homeRoAn.tooltip" FOLDED="true" ID="ID_1616696774" CREATED="1410591592011" MODIFIED="1410592428321">
<node TEXT="Klik schijnbaar op RoAn knop Home." ID="ID_208676033" CREATED="1410591592011" MODIFIED="1410594455970"/>
</node>
<node TEXT="addons.roan.jump" FOLDED="true" ID="ID_1485894296" CREATED="1410591622673" MODIFIED="1410592428321">
<node TEXT="Spring" ID="ID_694310425" CREATED="1410591622673" MODIFIED="1410594476172"/>
</node>
<node TEXT="addons.roan.jump.tooltip" FOLDED="true" ID="ID_191528614" CREATED="1410591636674" MODIFIED="1410592428337">
<node TEXT="Spring naar nu geselecteerde knoop" ID="ID_342845666" CREATED="1410591636674" MODIFIED="1410594498745"/>
</node>
<node TEXT="addons.roan.jump.warningMessage" FOLDED="true" ID="ID_1940264218" CREATED="1410591650972" MODIFIED="1410592428337">
<node TEXT="Je moet een te selecteren knoop kiezen die niet de actieknoop is." ID="ID_233044734" CREATED="1410591650972" MODIFIED="1410594580065"/>
</node>
<node TEXT="addons.roan.menuFreeplane" FOLDED="true" ID="ID_1325818560" CREATED="1410591762161" MODIFIED="1410592428337">
<node TEXT="Menu actie" ID="ID_1282055771" CREATED="1410591762161" MODIFIED="1410595429424"/>
</node>
<node TEXT="addons.roan.menuFreeplane.dialog_message" FOLDED="true" ID="ID_1747410409" CREATED="1410591891306" MODIFIED="1410592428337">
<node ID="ID_281930029" CREATED="1410591891306" MODIFIED="1410595516971"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    Voor een freeplane menu actie of script uit.<br/>Gebruik addon Developer tools om naam te vinden:
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="addons.roan.menuFreeplane.tooltip" FOLDED="true" ID="ID_438586124" CREATED="1410591907116" MODIFIED="1410592428337">
<node TEXT="Uitvoeren Freeplane menu actie" ID="ID_80825397" CREATED="1410591907116" MODIFIED="1410595546034"/>
</node>
<node TEXT="addons.roan.menuRoan" FOLDED="true" ID="ID_1496410932" CREATED="1410591962130" MODIFIED="1410592428352">
<node TEXT="Menu RoAn min/max" ID="ID_1672420689" CREATED="1410591962130" MODIFIED="1410595620836"/>
</node>
<node TEXT="addons.roan.menuRoan.maximum" FOLDED="true" ID="ID_1939253472" CREATED="1410591975507" MODIFIED="1410592428352">
<node TEXT="Maximum" ID="ID_1349027313" CREATED="1410591975507" MODIFIED="1410592428352"/>
</node>
<node TEXT="addons.roan.menuRoan.minimum" FOLDED="true" ID="ID_402043084" CREATED="1410591987012" MODIFIED="1410592428352">
<node TEXT="Minimum" ID="ID_1267401943" CREATED="1410591987012" MODIFIED="1410592428352"/>
</node>
<node TEXT="addons.roan.menuRoan.tooltip" FOLDED="true" ID="ID_1815405920" CREATED="1410592003571" MODIFIED="1410592428352">
<node TEXT="Klik schijnbaar op gelijknamige knop in RoAn menu" ID="ID_436862167" CREATED="1410592003571" MODIFIED="1410595691692"/>
</node>
<node TEXT="addons.roan.scrolling" FOLDED="true" ID="ID_1922479339" CREATED="1410592044514" MODIFIED="1410592428368">
<node TEXT="Scrollen" ID="ID_1245961286" CREATED="1410592044514" MODIFIED="1410595723375"/>
</node>
<node TEXT="addons.roan.scrolling.tooltip" FOLDED="true" ID="ID_181149551" CREATED="1410592058171" MODIFIED="1410592428368">
<node TEXT="Verplaats de huidige scrollpositie delta XY pixels." ID="ID_1859095380" CREATED="1410592058171" MODIFIED="1410595755589"/>
</node>
<node TEXT="addons.roan.selecteds" FOLDED="true" ID="ID_111428411" CREATED="1410592100424" MODIFIED="1410592428383">
<node TEXT="Geselecteerde knopen" ID="ID_1286234301" CREATED="1410592100424" MODIFIED="1410595793997"/>
</node>
<node TEXT="addons.roan.selecteds.addingCurrentlySelected" FOLDED="true" ID="ID_1482595526" CREATED="1410592113598" MODIFIED="1410592428383">
<node TEXT="Voeg nu geselecteerde knopen toe:" ID="ID_716463274" CREATED="1410592113598" MODIFIED="1410595830267"/>
</node>
<node TEXT="addons.roan.selecteds.change" FOLDED="true" ID="ID_991605321" CREATED="1410592133075" MODIFIED="1410592428383">
<node TEXT="Om de selectie te veranderen, druk Cancel." ID="ID_1749657502" CREATED="1410592133075" MODIFIED="1410595882051"/>
</node>
<node TEXT="addons.roan.selecteds.tooltip" FOLDED="true" ID="ID_338036710" CREATED="1410592156842" MODIFIED="1410592428383">
<node TEXT="De nu geselecteerde knopen straks selecteren" ID="ID_263122147" CREATED="1410592156842" MODIFIED="1410595914764"/>
</node>
<node TEXT="addons.roan.zoom" FOLDED="true" ID="ID_945828969" CREATED="1410592211418" MODIFIED="1410592428415">
<node TEXT="Zoom %" ID="ID_23624694" CREATED="1410592211418" MODIFIED="1410592428415"/>
</node>
<node TEXT="addons.roan.zoom.dialog_message" FOLDED="true" ID="ID_46065106" CREATED="1410592224124" MODIFIED="1410592428415">
<node TEXT="Zet zoom %" ID="ID_1399708473" CREATED="1410592224124" MODIFIED="1410595932299"/>
</node>
<node TEXT="addons.roan.zoom.tooltip" FOLDED="true" ID="ID_139918880" CREATED="1410592236316" MODIFIED="1410592428415">
<node TEXT="Zet zoomactie voor deze knoop" ID="ID_1435083089" CREATED="1410592236316" MODIFIED="1410595954263"/>
</node>
<node TEXT="addons.roan.zooming" FOLDED="true" ID="ID_417304502" CREATED="1410592286369" MODIFIED="1410592428430">
<node TEXT="Zoomen" ID="ID_1322616120" CREATED="1410592286369" MODIFIED="1410595961845"/>
</node>
<node TEXT="addons.roan.zooming.tooltip" FOLDED="true" ID="ID_1734155308" CREATED="1410592307452" MODIFIED="1410592428430">
<node TEXT="Kies Roan knop om automatisch in/uitzoomen bij stappen/afspelen.." ID="ID_211523599" CREATED="1410592307452" MODIFIED="1410596041608"/>
</node>
<node TEXT="addons.roan.actionBoolean.allSelectedsMessage" FOLDED="true" ID="ID_149939803" CREATED="1410607952271" MODIFIED="1410608007183">
<node TEXT="Standaard actieknoop.\nToepassen op nu geselecteerde knopen?" ID="ID_988676635" CREATED="1410607952271" MODIFIED="1410608195922"/>
</node>
<node TEXT="addons.roan.actionBoolean.ON" FOLDED="true" ID="ID_931958901" CREATED="1410607965679" MODIFIED="1410608007183">
<node TEXT="AAN" ID="ID_1250722740" CREATED="1410607965679" MODIFIED="1410608201288"/>
</node>
<node TEXT="addons.roan.actionBoolean.OFF" FOLDED="true" ID="ID_1830936216" CREATED="1410607978308" MODIFIED="1410608007199">
<node TEXT="UIT" ID="ID_228653896" CREATED="1410607978308" MODIFIED="1410608208511"/>
</node>
<node TEXT="addons.roan.EditDialog.addActions" FOLDED="true" ID="ID_853311485" CREATED="1410618566635" MODIFIED="1410618588257">
<node TEXT="Menu met acties" ID="ID_1955905528" CREATED="1410618566635" MODIFIED="1410618725833"/>
</node>
<node TEXT="OptionPanel.separator.addons.roan.imageinline" FOLDED="true" ID="ID_256097796" CREATED="1411650284303" MODIFIED="1411717706369">
<node TEXT="Afbeeldingen toevoegen" ID="ID_818613584" CREATED="1411650314263" MODIFIED="1411656617854"/>
</node>
<node TEXT="OptionPanel.addons.roan.imageinline.widthMax" FOLDED="true" ID="ID_464412552" CREATED="1411650006597" MODIFIED="1411717420309">
<node TEXT="maximum breedte" ID="ID_568127301" CREATED="1407010181157" MODIFIED="1411656627864"/>
</node>
<node TEXT="OptionPanel.addons.roan.imageinline.heightMax" FOLDED="true" ID="ID_1574323562" CREATED="1411650006597" MODIFIED="1411717436128">
<node TEXT="maximum hoogte" ID="ID_616499107" CREATED="1407010181157" MODIFIED="1411656637994"/>
</node>
<node TEXT="addons.roan.imageinline.locationImageLabelTitle" FOLDED="true" ID="ID_1188214619" CREATED="1411654493290" MODIFIED="1412587497640">
<node TEXT="Locatie afbeelding" ID="ID_184116461" CREATED="1411654493290" MODIFIED="1412591715027"/>
</node>
<node TEXT="addons.roan.imageinline.locationLabelTitle" FOLDED="true" ID="ID_1955390749" CREATED="1411654493290" MODIFIED="1411654821257">
<node TEXT="Locatie" ID="ID_323786340" CREATED="1411654493290" MODIFIED="1411654912875"/>
</node>
<node TEXT="addons.roan.imageinline.widthMaxTitle" FOLDED="true" ID="ID_1468220710" CREATED="1411654532476" MODIFIED="1411654821257">
<node TEXT="maximum breedte" ID="ID_440690251" CREATED="1411654532476" MODIFIED="1411654926117"/>
</node>
<node TEXT="addons.roan.imageinline.heightMaxTitle" FOLDED="true" ID="ID_1886510653" CREATED="1411654961439" MODIFIED="1411655011413">
<node TEXT="maximum hoogte" ID="ID_571482601" CREATED="1411654961439" MODIFIED="1411656454353"/>
</node>
<node TEXT="addons.roan.imageinline.Current" FOLDED="true" ID="ID_1437151187" CREATED="1411654668489" MODIFIED="1411654821267">
<node TEXT="Huidige knoop" ID="ID_1696750374" CREATED="1411654668489" MODIFIED="1411656692124"/>
</node>
<node TEXT="addons.roan.imageinline.Parent" FOLDED="true" ID="ID_113598877" CREATED="1411654681159" MODIFIED="1411654821267">
<node TEXT="Ouderknoop" ID="ID_7549587" CREATED="1411654681159" MODIFIED="1411656702964"/>
</node>
<node TEXT="addons.roan.imageinline.dialogTitle" FOLDED="true" ID="ID_226947723" CREATED="1411654697659" MODIFIED="1411654821267">
<node TEXT="Afbeeldingen toevoegen" ID="ID_591251695" CREATED="1411654697659" MODIFIED="1411656713294"/>
</node>
<node TEXT="addons.roan.imageinline.fromParentDirectoryTitle" FOLDED="true" ID="ID_826480385" CREATED="1411654709839" MODIFIED="1411654821267">
<node TEXT="Afbeeldingen uit mindmap directory" ID="ID_1932589142" CREATED="1411654709839" MODIFIED="1412539216045"/>
</node>
<node TEXT="addons.roan.imageinline.fromRedArrowLinksTitle" FOLDED="true" ID="ID_477916030" CREATED="1411654721859" MODIFIED="1411654821267">
<node TEXT="Afbeeldingen van rode-pijl hyperlinks" ID="ID_1613042223" CREATED="1411654721859" MODIFIED="1411656794736"/>
</node>
<node TEXT="addons.roan.imageinline.fromAddonInsertInlineImageTitle" FOLDED="true" ID="ID_1833767147" CREATED="1411654753401" MODIFIED="1411654821277">
<node TEXT="Afbeelding via addon Insert Inline Image" ID="ID_693969403" CREATED="1411654753401" MODIFIED="1411656830306"/>
</node>
<node TEXT="addons.roan.imageinline.subMenuTitle" FOLDED="true" ID="ID_1053701499" CREATED="1412183621276" MODIFIED="1412183767113">
<node TEXT="SubMenu" ID="ID_412696589" CREATED="1412183621276" MODIFIED="1412183767128"/>
</node>
<node TEXT="addons.roan.imageinline.isResizeExisitingTitle" FOLDED="true" ID="ID_1556765235" CREATED="1412587896018" MODIFIED="1412588232316">
<node TEXT="Aanpassen bestaande grootte" ID="ID_260886248" CREATED="1412587896018" MODIFIED="1412591587232"/>
</node>
<node TEXT="addons.roan.indexTitle" FOLDED="true" ID="ID_403175055" CREATED="1412253073968" MODIFIED="1412588232332">
<node TEXT="Index: toevoegen kopplingen naar bestanden en mappen in de directory van de mindmap" ID="ID_1130427266" CREATED="1412253073968" MODIFIED="1412589170886"/>
</node>
<node TEXT="addons.roan.nodelib.CORE" FOLDED="true" ID="ID_162891146" CREATED="1412253178277" MODIFIED="1412588312383">
<node TEXT="KERN" ID="ID_970448275" CREATED="1412253178277" MODIFIED="1412589178265"/>
</node>
<node TEXT="addons.roan.nodelib.DETAILS" FOLDED="true" ID="ID_1982552566" CREATED="1412253190812" MODIFIED="1412588312383">
<node TEXT="DETAILS" ID="ID_1508174740" CREATED="1412253190812" MODIFIED="1412588312399"/>
</node>
<node TEXT="addons.roan.nodelib.NOTE" FOLDED="true" ID="ID_1354242388" CREATED="1412253208775" MODIFIED="1412588312399">
<node TEXT="NOTITIE" ID="ID_1335108256" CREATED="1412253208775" MODIFIED="1412589186034"/>
</node>
<node TEXT="addons.roan.nodelib.ARROW" FOLDED="true" ID="ID_540705082" CREATED="1412253224664" MODIFIED="1412588312399">
<node TEXT="PIJL" ID="ID_744888441" CREATED="1412253224664" MODIFIED="1412589196548"/>
</node>
<node TEXT="addons.roan.lockTitle" FOLDED="true" ID="ID_1126078371" CREATED="1412540480917" MODIFIED="1412588312399">
<node TEXT="Voer wachtwoord in (encryptie)" ID="ID_1283249186" CREATED="1412540480917" MODIFIED="1412589233996"/>
</node>
<node TEXT="addons.roan.index.directoryTitle" FOLDED="true" ID="ID_112713082" CREATED="1412588003994" MODIFIED="1412588312399">
<node TEXT="map" ID="ID_1578119208" CREATED="1412588003994" MODIFIED="1412589245493"/>
</node>
<node TEXT="addons.roan.index.isDirectoryIconTitle" FOLDED="true" ID="ID_1941367603" CREATED="1412588022082" MODIFIED="1412588312399">
<node TEXT="Icon voor map" ID="ID_1364489975" CREATED="1412588022082" MODIFIED="1412589260407"/>
</node>
<node TEXT="addons.roan.index.locationLinkDirectoryLabelTitle" FOLDED="true" ID="ID_346693156" CREATED="1412588038064" MODIFIED="1412588312414">
<node TEXT="Locatie mapkoppeling" ID="ID_1526723436" CREATED="1412588038064" MODIFIED="1412589279080"/>
</node>
<node TEXT="addons.roan.index.locationLinkFileLabelTitle" FOLDED="true" ID="ID_136571563" CREATED="1412588049148" MODIFIED="1412588312414">
<node TEXT="Locatie bestandskoppeling" ID="ID_942777931" CREATED="1412588049148" MODIFIED="1412589304258"/>
</node>
<node TEXT="addons.roan.index.dialogTitle" FOLDED="true" ID="ID_470600139" CREATED="1412588066846" MODIFIED="1412588312414">
<node TEXT="Toevoegen knoop met koppeling naar elke map en bestand" ID="ID_938911205" CREATED="1412588066846" MODIFIED="1412589342267"/>
</node>
<node TEXT="addons.roan.index.sortLabelTitle" FOLDED="true" ID="ID_1603803007" CREATED="1412588087290" MODIFIED="1412588312414">
<node TEXT="Sorteren" ID="ID_1737486010" CREATED="1412588087290" MODIFIED="1412589348616"/>
</node>
<node TEXT="addons.roan.index.divisionRootLabelTitle" FOLDED="true" ID="ID_1330886459" CREATED="1412588102258" MODIFIED="1412588312414">
<node TEXT="Verdelen knopen links-rechts" ID="ID_892900872" CREATED="1412588102258" MODIFIED="1412589368132"/>
</node>
<node TEXT="addons.roan.index.divisionRootRIGHTTitle" FOLDED="true" ID="ID_1305844915" CREATED="1412588113623" MODIFIED="1412588312414">
<node TEXT="RECHTS" ID="ID_629664673" CREATED="1412588113623" MODIFIED="1412589379520"/>
</node>
<node TEXT="addons.roan.index.divisionRootLEFTRIGHTTitle" FOLDED="true" ID="ID_252087521" CREATED="1412588123927" MODIFIED="1412588312414">
<node TEXT="LINKS-RECHTS" ID="ID_441575632" CREATED="1412588123927" MODIFIED="1412618731336"/>
</node>
<node TEXT="addons.roan.index.divisionRootRIGHTLEFTTitle" FOLDED="true" ID="ID_1451996413" CREATED="1412588136446" MODIFIED="1412588312430">
<node TEXT="RECHTS-LINKS" ID="ID_1091003147" CREATED="1412588136446" MODIFIED="1412589399410"/>
</node>
<node TEXT="addons.roan.index.divisionRootMAPFILETitle" FOLDED="true" ID="ID_1720184802" CREATED="1412588136446" MODIFIED="1412618779092">
<node TEXT="MAPPEN-BESTANDEN" ID="ID_479353250" CREATED="1412588136446" MODIFIED="1412619095683"/>
</node>
<node TEXT="addons.roan.index.divisionRootFILEMAPTitle" FOLDED="true" ID="ID_14478110" CREATED="1412588136446" MODIFIED="1412618888616">
<node TEXT="BESTANDEN-MAPPEN" ID="ID_1154816460" CREATED="1412588136446" MODIFIED="1412618857326"/>
</node>
<node TEXT="addons.roan.index.sortNONETitle" FOLDED="true" ID="ID_471934880" CREATED="1412588161164" MODIFIED="1412588312430">
<node TEXT="GEEN" ID="ID_1565788028" CREATED="1412588161164" MODIFIED="1412589405432"/>
</node>
<node TEXT="addons.roan.index.sortFOREWARDTitle" FOLDED="true" ID="ID_1815122936" CREATED="1412588173200" MODIFIED="1412588312430">
<node TEXT="VOORWAARTS" ID="ID_1771810659" CREATED="1412588173200" MODIFIED="1412589411718"/>
</node>
<node TEXT="addons.roan.index.sortBACKWARDTitle" FOLDED="true" ID="ID_542148506" CREATED="1412588182489" MODIFIED="1412588312430">
<node TEXT="ACHTERWAARTS" ID="ID_1471933839" CREATED="1412588182489" MODIFIED="1412589428098"/>
</node>
<node TEXT="addons.roan.index.showFileExtensionTitle" FOLDED="true" ID="ID_100559105" CREATED="1412588191982" MODIFIED="1412588312430">
<node TEXT="Toon bestandsextensie" ID="ID_162779715" CREATED="1412588191982" MODIFIED="1412589443387"/>
</node>
<node TEXT="addons.roan.index.isDirectoryNodesTitle" FOLDED="true" ID="ID_1855291293" CREATED="1412588202083" MODIFIED="1412588312430">
<node TEXT="Map-knopen" ID="ID_386405617" CREATED="1412588202083" MODIFIED="1412589449971"/>
</node>
</node>
</node>
</node>
</node>
<node TEXT="preferences.xml" FOLDED="true" POSITION="left" ID="ID_340334716" CREATED="1399926585715" MODIFIED="1468364519477">
<edge COLOR="#ff00ff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      <font color="#000000" face="SansSerif, sans-serif">The child node contains the add-on configuration as an extension to mindmapmodemenu.xml (in Tools-&gt;Preferences-&gt;Add-ons). </font>
    </p>
    <p>
      <font color="#000000" face="SansSerif, sans-serif">Every property in the configuration should receive a default value in <i>default.properties</i>&#160;node.</font>
    </p>
  </body>
</html>
</richcontent>
<node TEXT="&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;&#xa;&lt;preferences_structure&gt;&#xa;&lt;tabbed_pane&gt;&#xa;&lt;tab name=&quot;plugin.addons.roan&quot;&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.windowSize&quot;&gt;&#xa;  &lt;number name=&quot;addons.roan.windowWidth&quot; min=&quot;100&quot; /&gt;&#xa;  &lt;number name=&quot;addons.roan.windowHeight&quot; min=&quot;100&quot;/&gt;&#xa;&lt;/separator&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.imageinline&quot;&gt;&#xa;      &lt;number name=&quot;addons.roan.imageinline.widthMax&quot; min=&quot;10&quot;/&gt;&#xa;      &lt;number name=&quot;addons.roan.imageinline.heightMax&quot; min=&quot;10&quot;/&gt;&#xa;&lt;/separator&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.onOpenMaxMenu&quot;&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMaxMenu.screenModeMaxOff&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMaxMenu.screenModeMaxOff&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMaxMenu.tooltipsOn&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMinMenu.attributesOff&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMaxMenu.attributesIconOff&quot;/&gt;&#xa;&lt;/separator&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.onOpenMinMenu&quot;&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMinMenu.screenModeMaxOn&quot;/&gt;&#xa;    &lt;boolean name=&quot;addons.roan.onOpenMinMenu.greyBackgroundOn&quot;/&gt;&#xa;      &lt;boolean name=&quot;addons.roan.onOpenMinMenu.tooltipsOff&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMinMenu.attributesOff&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onOpenMinMenu.attributesIconOff&quot;/&gt;&#xa;&#xa;&lt;/separator&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.onCloseMenu&quot;&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onCloseMenu.screenModeMaxOff&quot;/&gt;&#xa;      &lt;boolean name=&quot;addons.roan.onCloseMenu_greyBackgroundOff&quot;/&gt;&#xa;      &lt;boolean name=&quot;addons.roan.onCloseMenu.tooltipsOn&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onCloseMenu_attributesOn&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onCloseMenu_attributesIconOn&quot;/&gt;&#xa;&lt;/separator&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.onPlay&quot;&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onPlay.screenModeMaxOn&quot;/&gt;&#xa;    &lt;boolean name=&quot;addons.roan.onPlay.greyBackgroundOn&quot;/&gt;&#xa;      &lt;boolean name=&quot;addons.roan.onPlay.tooltipsOff&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onPlay_attributesOff&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.onPlay_attributesIconOff&quot;/&gt;&#xa;&lt;/separator&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.whilePlay&quot;&gt;&#xa;     &lt;boolean name=&quot;addons.roan.whilePlay.doAutoZoom&quot;/&gt;&#xa;     &lt;number name=&quot;addons.roan.whilePlay.autoZoomMax&quot; min=&quot;10&quot;/&gt;&#xa;     &lt;number name=&quot;addons.roan.whilePlay.autoZoomMin&quot; min=&quot;10&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.whilePlay.doFilter&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.whilePlay.cycle&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.whilePlay.all&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.whilePlay.slowMove&quot;/&gt;&#xa;&lt;/separator&gt;&#xa;&#xa;&lt;separator name=&quot;addons.roan.finishPlay&quot;&gt;&#xa;     &lt;boolean name=&quot;addons.roan.finishPlay.screenModeMaxOff&quot;/&gt;&#xa;    &lt;boolean name=&quot;addons.roan.finishPlay.greyBackgroundOff&quot;/&gt;&#xa;&#xa;    &lt;boolean name=&quot;addons.roan.finishPlay_tooltipsOn&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.finishPlay_attributesOn&quot;/&gt;&#xa;     &lt;boolean name=&quot;addons.roan.finishPlay_attributesIconOn&quot;/&gt;&#xa;&lt;/separator&gt;&#xa;&#xa;&#xa;&lt;/tab&gt;&#xa;&lt;/tabbed_pane&gt;&#xa;&lt;/preferences_structure&gt;" ID="ID_1650452431" CREATED="1403796819201" MODIFIED="1411759843856" HGAP="30" VSHIFT="-20">
<arrowlink SHAPE="CUBIC_CURVE" COLOR="#000000" WIDTH="2" TRANSPARENCY="80" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1650452431" STARTINCLINATION="40;0;" ENDINCLINATION="40;45;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
</node>
</node>
</node>
</map>
