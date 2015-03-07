<%@ include file="/jcore/doInitPage.jspf" %>
<% String lorem = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "; %>

<section id="layout">
	<div class="page-header">
	  <h1>Layout <small>Popin, Message, Modal, ...</small></h1>
	</div>
  
  
  <h2>Collapse</h2>
  
  <p><a href="docs/lib/bootstrap/javascript.html#collapse">Collapse</a> component used for Accordion layout has been patched to work with Prototype and Ajax-Refresh.</p>
  
  <h2>Modals</h2>
  <div class="br">

	  <p>The JCMS modal framework <strong>has been deprecated</strong> since JCMS 8. Developers must use <a href="http://twitter.github.com/bootstrap/javascript.html#modals" target="_blank">Bootstrap Modals</a>.</p>
	    
	    <p>Now, modals relies on ajax-refresh to display content
	      <ol>
	        <li>a Bootstrap modal is opened</li>
	        <li>then an Ajax-Refresh is performed to retrieve html</li>
	      </ol>
	    </p>
	    
	    <p>Large modals must set an inline width <code>style="width: 900px;"</code></p>
	    
	    <p>
	      A <a href="docs/jsdoc/$.jalios.ui.Modal.jsp">jQuery wrapper</a> ensure backward compatibility. 
	      Developpers should use new function in their code.
	      See also JavaSript code: <a href="docs/jsdoc/$.jalios.ui.Modal.jsp">jalios-modal.js</a>
	    </p>
	    
	    <h3>Modal Forms and Steps</h3>
	    
	    <p>
	      JCMS improve bootstrap's modal with <code>modal-steps</code> generated by <code>jcore/doSteps.jspf</code>.
	
	      Modal Form are basic JCMS FormHandler with <code>&lt;form&gt;</code> wrapping all <code>modal-*</code>. 
	      The class <code>modal-form</code> define custom styles. 
	    </p>
	
		  <div class="modal ajax-refresh-div" style="position: static; margin: 0; width: inherit;">
			  <div class="modal-form">
	      <form name="form" method="post" action="path/to/form.jsp">
			      <div class="modal-header">
			        <img class="visual" src="images/jalios/logos/jalios130x130.gif" alt="" />
			        <h3>Title</h3>
			      </div>
			      <% int stepCount = 4; int step = 2; request.setAttribute("custom-steps-labels", new String[]{"Step A","Step B","Step C","Step D"}); String stepPrefixProp = ""; %>
			      <div class="modal-body">
			        <h4>Form</h4>
			        <p><%= lorem %></p>
			      </div> 
			      <div class="modal-footer">
			        <input type="submit" value="Close" name="opCancel" class="btn btn-default" data-dismiss="modal" />
			        <input type="submit" value="Ok" name="opChange" class="btn btn-primary ajax-refresh" />
			      </div>
	      </form>
			  </div> 
			</div>

  </div>
  <div class="row br">
    <div class="col-md-8">
<pre style="white-space: pre; overflow-x: scroll; word-wrap: normal;">
&lt;%@ include file="/jcore/doInitPage.jspf" %&gt;

&lt;jsp:useBean id="formHandler" scope="page" class="com.jalios.jcmsplugin.Handler"&gt;
  &lt;jsp:setProperty name="formHandler" property="request"  value="&lt;%= request %&gt;"/&gt;
  &lt;jsp:setProperty name="formHandler" property="response" value="&lt;%= response %&gt;"/&gt;
  &lt;jsp:setProperty name="formHandler" property="*" /&gt;
&lt;/jsp:useBean&gt;

&lt;% if (formHandler.validate()) { %&gt;
&lt;% request.setAttribute("modal.redirect", formHandler.getUrl()); %&gt;
&lt;%@ include file="/jcore/modal/modalRedirect.jspf" %&gt;
&lt;% } %&gt;

&lt;div class="modal ajax-refresh-div"&gt;
  &lt;div class="modal-form"&gt
    &lt;form name="form" method="post" action="path/to/form.jsp"&gt;
      &lt;div class="modal-header"&gt;
        &lt;img class="visual" src="path/to/image32.png" /&gt;
        &lt;h3&gt;Title&lt;/h3&gt;
      &lt;/div&gt;
      &lt;% String stepPrefixProp = "jcmsplugin.plugin.steps."; %&gt;
      &lt;%@ include file="/jcore/doSteps.jspf" %&gt;
      &lt;div class="modal-body"&gt;
        &lt;%@ include file="/jcore/doMessageBox.jspf" %&gt;
        &lt;h4&gt;Form&lt;/h4&gt;
      &lt;/div&gt;
      &lt;div class="modal-footer"&gt;
        &lt;input type="button" class="btn btn-default" onClick="jQuery.jalios.ui.Modal.close(true)" /&gt;
        &lt;input type="submit" value="Close" name="opCancel" class="btn btn-default" data-dismiss="modal" /&gt;
        &lt;input type="submit" value="Ok" name="opChange" class="btn btn-primary ajax-refresh" /&gt;
      &lt;/div&gt;
    &lt;/form&gt;
  &lt;/div&gt;
  &lt;%@ include file="/jcore/doAjaxFooter.jspf" %&gt;
&lt;/div&gt;
</pre>
    </div>
    <div class="col-md-4">
<pre style="white-space: pre; overflow-x: hidden; word-wrap: normal;">
<= Init JCMS variables, imports, ...

<= Bean of the Form Handler


<= Override attributes after '*'


<= Validate the Form Handler




<= Ajax-Refresh will inject modal's content
<= Style ModalForm or use ajax-refresh-url
<= Form of the modal (optional)

<= Visual (optional)


<= Generate a &lt;div class="modal-steps"&gt;&lt;/div&gt; 
   with bootstrap nav-pills (optional)





<= Close and ... <a href="docs/jsdoc/$.jalios.ui.Modal.jsp">Follow, Refresh, Redirect, ...</a>
<= data-dismiss="modal" close bootstrap's modal
<= ajax-refresh is fully compliant



<= Setup ajax-refresh framework

</pre>
    </div>
  </div>
  
  <h2>Tooltip</h2>
  <% Publication itPub =  (Publication) channel.getPublicationSet(Content.class, loggedMember).first(); %>
  <div class="row br">
    The JCMS modal framework <strong>has been deprecated</strong> since JCMS 8. 
    Jalios tooltips is now an improved version of <a href="docs/lib/bootstrap/javascript.html#popovers">Bootstrap's popover</a>
    
    The tag <code>jalios:tooltip</code> provides all attributes to write valid html.  
  </div>
  <div class="row">
    <div class="col-md-6">Body     <jalios:tooltip>Lorem ipsum dolor sit amet</jalios:tooltip></div>
    <div class="col-md-6">Property <jalios:tooltip property="ui.com.foot.hello" /></div>
  </div>  
  <div class="row br">
    <div class="col-md-6"><pre>&lt;jalios:tooltip&gt;Lorem ipsum dolor sit amet&lt;/jalios:tooltip&gt;</pre></div>
    <div class="col-md-6"><pre>&lt;jalios:tooltip property="ui.com.foot.hello" /&gt;</pre></div>
  </div>
  
  <div class="row">
    <div class="col-md-6">Longdesc <jalios:tooltip longdesc="jcore/tooltip/tooltip.jsp?glp=ui.com.foot.hello" /></div>
    <div class="col-md-4">Anything    <img longdesc="jcore/tooltip/ttPublicationLock.jsp?id=<%= itPub.getId()  %>" class="icon ctxTooltipMenu" src="images/jalios/icons/lockStrong.gif" alt="" /></div>
  </div>
  <div class="row">
    <div class="col-md-6"><pre>&lt;jalios:tooltip longdesc="jcore/tooltip/tooltip.jsp?glp=ui.com.foot.hello" /&gt;</pre></div>
    <div class="col-md-6"><pre>&lt;img longdesc="jcore/tooltip/ttPublicationLock.jsp?id=<%= itPub.getId()  %>" class="icon ctxTooltipMenu" src="..." /&gt;</pre></div>
  </div>
  
  <p>
    Links can also open a tooltip using <code>data-jalios-tt-url</code> attribute for tooltip's url.
  </p>
  
  
  <h2>Tooltip Card</h2>
  
  <div class="row br">
  
    <p>
      Displays popover information of a given JCMS Data with a given id. 
      Tag <code>jalios:link</code> and <code>jalios:wiki</code> add convenient attributs to display ttCards.
    </p>
    
    <p>
      Wrapping block with class <code>noTooltipCard</code> prevent from displaying card.
      The JCMS property <code>jcms.resource.tt-card.enabled</code> prevent all ttCard from displaying.
    </p>
    
    <p>
      The JCMS modal framework <strong>has been deprecated</strong> since JCMS 8. 
      Jalios ttCard is now an improved version of <a href="docs/lib/bootstrap/javascript.html#popovers">Bootstrap's popover</a>.
      Card are now displayed using <strong>ajax-refresh</strong> framework.
    </p>
    
    <strong>New features:</strong>
    <ul>
      <li>Click in ttCard no longer close ttCard. This allow refresh of the card.</li>
      <li>Click on DIV or SPAN is available</li>
      <li>Click on trigger close the opened ttCard</li>
    </ul>
    
    <strong>Custom ttCard:</Strong>
	  <ul>
	    <li>Add property <code>jcms.resource.tt-card.(hook)</code> targeting the custom JSP</li>
	    <li>Create a link with classes <code>ctxTooltipCard ID_hook</code></li>
	    <li>All other classes are provided throught parameter <code>ttContext</code> to provide ids, ...</li>
	  </ul>
  </div>
  <div class="row">
    <div class="col-md-6">Member      <jalios:link data="<%= loggedMember %>"/></div>
    <div class="col-md-6">Publication <jalios:link data="<%= itPub %>"/></div>
  </div>
  <div class="row br">
    <div class="col-md-6"><pre>&lt;jalios:link data="&lt;%= loggedMember %&gt;"/&gt;</pre></div>
    <div class="col-md-6"><pre>&lt;jalios:link data="&lt;%= ... %&gt;"/&gt;</pre></div>
  </div>
  
  <h2>Popin</h2>
  <div class="row br">
    <div class="col-md-6">
      
	    <p>
	      The JCMS popin / notification framework <strong>has been deprecated</strong> since JCMS 8. 
	      Developers must use <a href="http://nijikokun.github.com/bootstrap-notify/" target="_blank">Bootstrap Notify</a>.
	    </p>
	  
	    <p>Now, modals relies on ajax-refresh to display content
	      <ol>
	        <li>a Bootstrap Notify is opened in bottom left</li>
	        <li>then an Ajax-Refresh is performed to retrieve html</li>
	      </ol>
	    </p>
	    
	    <h3>Style</h3>
	    <p>Default style is defined in <code>jalios-popin.less</code></p>
        
			<div class="box">
				<div class="box-body">
				  <a href="#" data-dismiss="alert" class="close pull-right">×</a>
				  <h3>Popin title</h3>
				  <p><%= lorem %></p>
				</div>
			</div>

        <p>A custom style is append for popin with <code>caddy</code> class. See also JavaSript code: <a href="docs/jsdoc/$.jalios.ui.Popin.jsp">jalios-popin.js</a></p>
      </div>
      <div class="col-md-6">

        <h3>Usage</h3>
        <p>Declare a link with a <code>data-jalios-action="popin"</code> to trigger the popin. It will be used as Ajax-Refresh Trigger.</p>

<pre>
 &lt;a href="path/to/popin.jsp"&gt;click me&lt;/a&gt;
</pre>

<pre>
&lt;div class="ajax-refresh-div"&gt;
  &lt;div class="box caddy"&gt;
    &lt;div class="box-body"&gt;
      &lt;a href="#" data-dismiss="alert" class="close pull-right"&gt;×&lt;/a&gt;
      &lt;h3&gt;Title&lt;/h3&gt;
      &lt;p&gt;Text&lt;/p&gt;
    &lt;/div&gt;
  &lt;/div&gt;
  &lt;%@ include file="/jcore/doAjaxFooter.jspf" %&gt;
&lt;/div&gt;
</pre>
      
      </div>
    </div>
    
    <h2>Message Box</h2>
    <div class="row">
      <div class="col-md-6">
        <h3>Usage</h3>
        <ol>
          <li>All message box reads Request, Session or pageContext custom attribute.</li>
          <li>2. You must include <code>doMessageBox.jsp</code> to provide the HTML</li>
        </ol>
        <p>
          All JSP should contains a MsgBox to display warning messages. 
          If filesystem is corrupted the databased is locked and this message must pop to users if they trigger a write action.  
        </p>
      </div>
      <div class="col-md-6">
        <h3>Information</h3>
          <p>Wrapped with custom class <code>mboxInfo</code> and attribute <code>JcmsConstants.INFORMATION_MSG</code>
          <% request.setAttribute(JcmsConstants.INFORMATION_MSG, "A sample information message"); %>
          <%@ include file="/jcore/doMessageBox.jspf" %>
          <% request.removeAttribute(JcmsConstants.INFORMATION_MSG); %>
      </div>
    </div>
    <div class="row br">
      <div class="col-md-6">
        <h3>Warning</h3>
        <p>Wrapped with custom class <code>mboxWarning</code> and attribute <code>JcmsConstants.WARNING_MSG</code>
        <% request.setAttribute(JcmsConstants.WARNING_MSG, "A sample warning message"); %>
        <%@ include file="/jcore/doMessageBox.jspf" %>
        <% request.removeAttribute(JcmsConstants.WARNING_MSG); %>
      </div>
      <div class="col-md-6">
        <h3>Error</h3>
        <p>Wrapped with custom class <code>mboxError</code> and attribute <code>JcmsConstants.ERROR_MSG</code>
        <% request.setAttribute(JcmsConstants.ERROR_MSG, "A sample error message"); %>
        <%@ include file="/jcore/doMessageBox.jspf" %>
        <% request.removeAttribute(JcmsConstants.ERROR_MSG); %>
      </div>      
    </div>
    <h2>Custom</h2>
    <div class="row br">
      <p>
      Sometimes grid layout do not match with a given component. JCMS provides 
      advanced layout un <code>jalios-layout-fluid.less</code> to layout colums. 
      It should be use with care but can sometimes be very convenient.
      </p>
      
			<div class="columns-stack" style="padding-bottom: 10px"> 
			   <div class="column-stack" style="border: 1px solid red; padding: 5px">Box One</div> 
			   <div class="column-stack" style="border: 1px solid red; padding: 5px">
			     A Tree Header
			     <ul id="tree">
			         <li>Box two</li>
			         <li>Box two very very very very very very long</li>
			     </ul>
			   </div>
			   <div class="column-stack" style="border: 1px solid red; padding: 5px">Box Three</div> 
			   <div class="column-stack" style="border: 1px solid red; padding: 5px">Box Four a little long</div> 
			</div>
      
      <p>CSS <code>width</code>, <code>min</code>, <code>max</code>, ... can be use to bend columns to a given behavior.</p>
      
    </div>
</section>