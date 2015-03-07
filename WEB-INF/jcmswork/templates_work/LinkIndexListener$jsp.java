import com.jalios.util.*;
import  java.io.*;
import  java.util.*;
import  java.text.*;
import  java.net.*;
import  org.jdom.*;
import  com.jalios.jcms.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jalios.jspengine.runtime.*;


public class LinkIndexListener$jsp extends HttpJspBase {


    static {
    }
    public LinkIndexListener$jsp( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws com.jalios.jspengine.runtime.JspException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws java.io.IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                synchronized (this) {
                    if (_jspx_inited == false) {
                        _jspx_init();
                        _jspx_inited = true;
                    }
                }
            }
            _jspxFactory = com.jalios.jspengine.runtime.JspFactoryImpl.getInstance();
            response.setContentType("text/plain; charset=UTF-8");
            pageContext = _jspxFactory.getPageContext(this, request, response,
            			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="/LinkIndexListener.jsp";from=(0,50);to=(1,0)]
                out.write("\n");

            // end
            // HTML // begin [file="/LinkIndexListener.jsp";from=(1,118);to=(2,0)]
                out.write("\n");

            // end
            // HTML // begin [file="/LinkIndexListener.jsp";from=(2,44);to=(3,0)]
                out.write("\n");

            // end
            // begin [file="/LinkIndexListener.jsp";from=(3,2);to=(31,0)]
                
                  request.setCharacterEncoding("UTF-8");
                  
                List typeList = (List)session.getAttribute("typeList");
                List extendedTypes = (List)session.getAttribute("extendedTypeList");
                // Extract Type that have at least one link or link[] field
                List linkTypeList = new ArrayList();
                Set dblinkSet = new HashSet();
                for(Iterator it1 = typeList.iterator(); it1.hasNext();) {
                  Element itType = (Element)it1.next();
                  
                  // Skip DBData
                  if (Util.toBoolean(itType.getAttributeValue("database"),false)) {
                    continue;
                  }
                  
                  List fieldList = new ArrayList();
                  TypeUtil.buildInheritedFieldList(itType, fieldList, true, extendedTypes);
                  for(Iterator it2 = fieldList.iterator(); it2.hasNext();) {
                    Element itField = (Element)it2.next();
                    String editor = itField.getAttributeValue("editor");
                    boolean isLinkEditor = editor != null && editor.startsWith("member") || editor.startsWith("group") || editor.startsWith("link");
                    if (isLinkEditor) {
                      linkTypeList.add(itType);
                      break;
                    }
                  }
                }
            // end
            // HTML // begin [file="/LinkIndexListener.jsp";from=(31,2);to=(33,21)]
                out.write("\n// This file was automatically generated. Please, do not edit.\n// Generation date : ");

            // end
            // begin [file="/LinkIndexListener.jsp";from=(33,24);to=(33,36)]
                out.print( new Date() );
            // end
            // HTML // begin [file="/LinkIndexListener.jsp";from=(33,38);to=(49,0)]
                out.write("\npackage generated;\n\nimport java.util.TreeMap;\n\nimport com.jalios.jcms.AbstractLinkIndexListener;\nimport com.jalios.jstore.Storable;\n\n@SuppressWarnings({\"unchecked\"})\npublic class LinkIndexListener extends AbstractLinkIndexListener {\n  \n  public LinkIndexListener(TreeMap index) {\n    super(index);\n  }\n  \n  public void handleCreate(Storable storable, boolean firstTime) {\n");

            // end
            // begin [file="/LinkIndexListener.jsp";from=(49,0);to=(49,87)]
                /* ----  jalios:foreach ---- */
                com.jalios.jtaglib.ForeachTag _jspx_th_jalios_foreach_0 = new com.jalios.jtaglib.ForeachTag();
                _jspx_th_jalios_foreach_0.setPageContext(pageContext);
                _jspx_th_jalios_foreach_0.setParent(null);
                _jspx_th_jalios_foreach_0.setCollection( linkTypeList );
                _jspx_th_jalios_foreach_0.setName("itType");
                _jspx_th_jalios_foreach_0.setType("org.jdom.Element");
                try {
                    int _jspx_eval_jalios_foreach_0 = _jspx_th_jalios_foreach_0.doStartTag();
                    if (_jspx_eval_jalios_foreach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        try {
                            if (_jspx_eval_jalios_foreach_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_foreach_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_foreach_0.doInitBody();
                          }
                          do {
                              Integer itCounter = null;
                              itCounter = (Integer) pageContext.findAttribute("itCounter");
                              org.jdom.Element itType = null;
                              itType = (org.jdom.Element) pageContext.findAttribute("itType");
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(49,87);to=(50,0)]
                              out.write("\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(50,2);to=(54,0)]
                               
                              String typeName = itType.getAttributeValue("name"); 
                              List fieldList = new ArrayList();
                              TypeUtil.buildInheritedFieldList(itType, fieldList, true, extendedTypes);
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(54,2);to=(55,7)]
                              out.write("\n    // ");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(55,10);to=(55,20)]
                              out.print( typeName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(55,22);to=(56,28)]
                              out.write("\n    if (storable instanceof ");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(56,31);to=(56,41)]
                              out.print( typeName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(56,43);to=(57,6)]
                              out.write(") {\n      ");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(57,9);to=(57,19)]
                              out.print( typeName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(57,21);to=(57,29)]
                              out.write(" obj = (");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(57,32);to=(57,42)]
                              out.print( typeName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(57,44);to=(59,0)]
                              out.write(")storable;\n      \n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(59,0);to=(59,106)]
                              /* ----  jalios:foreach ---- */
                              com.jalios.jtaglib.ForeachTag _jspx_th_jalios_foreach_1 = new com.jalios.jtaglib.ForeachTag();
                              _jspx_th_jalios_foreach_1.setPageContext(pageContext);
                              _jspx_th_jalios_foreach_1.setParent(_jspx_th_jalios_foreach_0);
                              _jspx_th_jalios_foreach_1.setCollection( fieldList );
                              _jspx_th_jalios_foreach_1.setName("itField");
                              _jspx_th_jalios_foreach_1.setType("org.jdom.Element");
                              _jspx_th_jalios_foreach_1.setCounter("itCounter2");
                              try {
                              int _jspx_eval_jalios_foreach_1 = _jspx_th_jalios_foreach_1.doStartTag();
                              if (_jspx_eval_jalios_foreach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              try {
                              if (_jspx_eval_jalios_foreach_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_foreach_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_foreach_1.doInitBody();
                          }
                          do {
                              Integer itCounter2 = null;
                              itCounter2 = (Integer) pageContext.findAttribute("itCounter2");
                              org.jdom.Element itField = null;
                              itField = (org.jdom.Element) pageContext.findAttribute("itField");
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(59,106);to=(60,0)]
                              out.write("\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(60,2);to=(77,0)]
                              
                                String fieldType = itField.getAttributeValue("type");
                                String fieldName = itField.getAttributeValue("name");
                                String fieldNameCap = Util.recapitalize(fieldName);
                                String fieldEditor = itField.getAttributeValue("editor");
                                boolean fieldML = Util.toBoolean(itField.getAttributeValue("ml"), false);
                                
                                String fieldTypeShort = fieldType;
                                if (fieldTypeShort.endsWith("[]")) {
                                  fieldTypeShort = fieldTypeShort.substring(0, fieldTypeShort.length() - 2);
                                }
                                
                                String getterParam="";
                                boolean isDBLink = TypeUtil.isDBType(itType.getParentElement(), fieldTypeShort);
                                if (isDBLink) {
                                  getterParam="false";
                                }
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(77,2);to=(79,0)]
                              out.write("\n\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(79,0);to=(79,132)]
                              /* ----  jalios:if ---- */
                              com.jalios.jtaglib.IfTag _jspx_th_jalios_if_0 = new com.jalios.jtaglib.IfTag();
                              _jspx_th_jalios_if_0.setPageContext(pageContext);
                              _jspx_th_jalios_if_0.setParent(_jspx_th_jalios_foreach_1);
                              _jspx_th_jalios_if_0.setPredicate( fieldEditor.startsWith("link") || fieldEditor.startsWith("member") || fieldEditor.startsWith("group") );
                              try {
                              int _jspx_eval_jalios_if_0 = _jspx_th_jalios_if_0.doStartTag();
                              if (_jspx_eval_jalios_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              try {
                              if (_jspx_eval_jalios_if_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_if_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_if_0.doInitBody();
                          }
                          do {
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(79,132);to=(80,9)]
                              out.write("\n      // ");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(80,12);to=(80,23)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(80,25);to=(81,22)]
                              out.write("\n      add(obj, obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(81,25);to=(81,39)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(81,41);to=(81,42)]
                              out.write("(");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(81,45);to=(81,58)]
                              out.print( getterParam );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(81,60);to=(81,64)]
                              out.write("), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(81,67);to=(81,78)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(81,80);to=(82,0)]
                              out.write("\");\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(82,0);to=(82,38)]
                              /* ----  jalios:if ---- */
                              com.jalios.jtaglib.IfTag _jspx_th_jalios_if_1 = new com.jalios.jtaglib.IfTag();
                              _jspx_th_jalios_if_1.setPageContext(pageContext);
                              _jspx_th_jalios_if_1.setParent(_jspx_th_jalios_if_0);
                              _jspx_th_jalios_if_1.setPredicate( fieldML );
                              try {
                              int _jspx_eval_jalios_if_1 = _jspx_th_jalios_if_1.doStartTag();
                              if (_jspx_eval_jalios_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              try {
                              if (_jspx_eval_jalios_if_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_if_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_if_1.doInitBody();
                          }
                          do {
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(82,38);to=(83,22)]
                              out.write("\n      add(obj, obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(83,25);to=(83,39)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(83,41);to=(83,48)]
                              out.write("ML(), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(83,51);to=(83,62)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(83,64);to=(84,0)]
                              out.write("\");\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(84,0);to=(84,12)]
                          } while (_jspx_th_jalios_if_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      } finally {
                          if (_jspx_eval_jalios_if_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                              out = pageContext.popBody();
                      }
                  }
                  if (_jspx_th_jalios_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
              } finally {
                  _jspx_th_jalios_if_1.release();
              }
          // end
          // HTML // begin [file="/LinkIndexListener.jsp";from=(84,12);to=(85,0)]
              out.write("\n");

          // end
          // begin [file="/LinkIndexListener.jsp";from=(85,0);to=(85,12)]
          } while (_jspx_th_jalios_if_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
      } finally {
          if (_jspx_eval_jalios_if_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = pageContext.popBody();
      }
  }
  if (_jspx_th_jalios_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return;
} finally {
    _jspx_th_jalios_if_0.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(85,12);to=(87,0)]
    out.write("\n\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(87,0);to=(87,17)]
} while (_jspx_th_jalios_foreach_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
} finally {
    if (_jspx_eval_jalios_foreach_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = pageContext.popBody();
}
}
if (_jspx_th_jalios_foreach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
    return;
} finally {
    _jspx_th_jalios_foreach_1.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(87,17);to=(89,0)]
    out.write("\n    }\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(89,0);to=(89,17)]
} while (_jspx_th_jalios_foreach_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
} finally {
    if (_jspx_eval_jalios_foreach_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = pageContext.popBody();
}
}
if (_jspx_th_jalios_foreach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
    return;
} finally {
    _jspx_th_jalios_foreach_0.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(89,17);to=(93,0)]
    out.write("\n  }\n  \n  public void handleCommitUpdate(Storable storable, Storable oldStorable, boolean firstTime) {\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(93,0);to=(93,87)]
    /* ----  jalios:foreach ---- */
    com.jalios.jtaglib.ForeachTag _jspx_th_jalios_foreach_2 = new com.jalios.jtaglib.ForeachTag();
    _jspx_th_jalios_foreach_2.setPageContext(pageContext);
    _jspx_th_jalios_foreach_2.setParent(null);
    _jspx_th_jalios_foreach_2.setCollection( linkTypeList );
    _jspx_th_jalios_foreach_2.setName("itType");
    _jspx_th_jalios_foreach_2.setType("org.jdom.Element");
    try {
        int _jspx_eval_jalios_foreach_2 = _jspx_th_jalios_foreach_2.doStartTag();
        if (_jspx_eval_jalios_foreach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            try {
                if (_jspx_eval_jalios_foreach_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                    out = pageContext.pushBody();
                    _jspx_th_jalios_foreach_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                    _jspx_th_jalios_foreach_2.doInitBody();
                }
                do {
                    Integer itCounter = null;
                    itCounter = (Integer) pageContext.findAttribute("itCounter");
                    org.jdom.Element itType = null;
                    itType = (org.jdom.Element) pageContext.findAttribute("itType");
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(93,87);to=(94,0)]
                    out.write("\n");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(94,2);to=(98,0)]
                     
                    String typeName = itType.getAttributeValue("name"); 
                    List fieldList = new ArrayList();
                    TypeUtil.buildInheritedFieldList(itType, fieldList, true, extendedTypes);
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(98,2);to=(99,7)]
                    out.write("\n    // ");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(99,10);to=(99,20)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(99,22);to=(100,28)]
                    out.write("    \n    if (storable instanceof ");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(100,31);to=(100,41)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(100,43);to=(101,6)]
                    out.write(") {\n      ");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(101,9);to=(101,19)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(101,21);to=(101,29)]
                    out.write(" obj = (");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(101,32);to=(101,42)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(101,44);to=(102,6)]
                    out.write(")storable;\n      ");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(102,9);to=(102,19)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(102,21);to=(102,32)]
                    out.write(" oldObj = (");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(102,35);to=(102,45)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(102,47);to=(104,0)]
                    out.write(")oldStorable;\n      \n");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(104,0);to=(104,106)]
                    /* ----  jalios:foreach ---- */
                    com.jalios.jtaglib.ForeachTag _jspx_th_jalios_foreach_3 = new com.jalios.jtaglib.ForeachTag();
                    _jspx_th_jalios_foreach_3.setPageContext(pageContext);
                    _jspx_th_jalios_foreach_3.setParent(_jspx_th_jalios_foreach_2);
                    _jspx_th_jalios_foreach_3.setCollection( fieldList );
                    _jspx_th_jalios_foreach_3.setName("itField");
                    _jspx_th_jalios_foreach_3.setType("org.jdom.Element");
                    _jspx_th_jalios_foreach_3.setCounter("itCounter2");
                    try {
                        int _jspx_eval_jalios_foreach_3 = _jspx_th_jalios_foreach_3.doStartTag();
                        if (_jspx_eval_jalios_foreach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            try {
                              if (_jspx_eval_jalios_foreach_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_foreach_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_foreach_3.doInitBody();
                          }
                          do {
                              Integer itCounter2 = null;
                              itCounter2 = (Integer) pageContext.findAttribute("itCounter2");
                              org.jdom.Element itField = null;
                              itField = (org.jdom.Element) pageContext.findAttribute("itField");
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(104,106);to=(105,0)]
                              out.write("\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(105,2);to=(122,0)]
                              
                                String fieldType    = itField.getAttributeValue("type");
                                String fieldName    = itField.getAttributeValue("name");
                                String fieldNameCap = Util.recapitalize(fieldName);
                                String fieldEditor  = itField.getAttributeValue("editor");
                                boolean fieldML     = Util.toBoolean(itField.getAttributeValue("ml"), false);
                                
                                String fieldTypeShort = fieldType;
                                if (fieldTypeShort.endsWith("[]")) {
                                  fieldTypeShort = fieldTypeShort.substring(0, fieldTypeShort.length() - 2);
                                }
                                
                                String getterParam="";
                                boolean isDBLink =  TypeUtil.isDBType(itType.getParentElement(), fieldTypeShort);
                                if (isDBLink) {
                                  getterParam="false";
                                }
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(122,2);to=(124,0)]
                              out.write("\n\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(124,0);to=(124,132)]
                              /* ----  jalios:if ---- */
                              com.jalios.jtaglib.IfTag _jspx_th_jalios_if_2 = new com.jalios.jtaglib.IfTag();
                              _jspx_th_jalios_if_2.setPageContext(pageContext);
                              _jspx_th_jalios_if_2.setParent(_jspx_th_jalios_foreach_3);
                              _jspx_th_jalios_if_2.setPredicate( fieldEditor.startsWith("link") || fieldEditor.startsWith("member") || fieldEditor.startsWith("group") );
                              try {
                              int _jspx_eval_jalios_if_2 = _jspx_th_jalios_if_2.doStartTag();
                              if (_jspx_eval_jalios_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              try {
                              if (_jspx_eval_jalios_if_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_if_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_if_2.doInitBody();
                          }
                          do {
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(124,132);to=(125,9)]
                              out.write("\n      // ");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(125,12);to=(125,23)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(125,25);to=(126,17)]
                              out.write("\n      if (obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(126,20);to=(126,34)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(126,36);to=(126,37)]
                              out.write("(");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(126,40);to=(126,53)]
                              out.print( getterParam );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(126,55);to=(126,70)]
                              out.write(") != oldObj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(126,73);to=(126,87)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(126,89);to=(126,90)]
                              out.write("(");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(126,93);to=(126,106)]
                              out.print( getterParam );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(126,108);to=(127,30)]
                              out.write(")) {\n        remove(obj, oldObj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(127,33);to=(127,47)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(127,49);to=(127,50)]
                              out.write("(");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(127,53);to=(127,66)]
                              out.print( getterParam );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(127,68);to=(127,72)]
                              out.write("), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(127,75);to=(127,86)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(127,88);to=(128,24)]
                              out.write("\");\n        add(obj, obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(128,27);to=(128,41)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(128,43);to=(128,44)]
                              out.write("(");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(128,47);to=(128,60)]
                              out.print( getterParam );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(128,62);to=(128,66)]
                              out.write("), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(128,69);to=(128,80)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(128,82);to=(130,0)]
                              out.write("\");\n      }\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(130,0);to=(130,38)]
                              /* ----  jalios:if ---- */
                              com.jalios.jtaglib.IfTag _jspx_th_jalios_if_3 = new com.jalios.jtaglib.IfTag();
                              _jspx_th_jalios_if_3.setPageContext(pageContext);
                              _jspx_th_jalios_if_3.setParent(_jspx_th_jalios_if_2);
                              _jspx_th_jalios_if_3.setPredicate( fieldML );
                              try {
                              int _jspx_eval_jalios_if_3 = _jspx_th_jalios_if_3.doStartTag();
                              if (_jspx_eval_jalios_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              try {
                              if (_jspx_eval_jalios_if_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_if_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_if_3.doInitBody();
                          }
                          do {
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(130,38);to=(131,17)]
                              out.write("\n      if (obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(131,20);to=(131,34)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(131,36);to=(131,54)]
                              out.write("ML() != oldObj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(131,57);to=(131,71)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(131,73);to=(132,30)]
                              out.write("ML()) {\n        remove(obj, oldObj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(132,33);to=(132,47)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(132,49);to=(132,56)]
                              out.write("ML(), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(132,59);to=(132,70)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(132,72);to=(133,24)]
                              out.write("\");\n        add(obj, obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(133,27);to=(133,41)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(133,43);to=(133,50)]
                              out.write("ML(), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(133,53);to=(133,64)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(133,66);to=(135,0)]
                              out.write("\");\n      }\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(135,0);to=(135,12)]
                          } while (_jspx_th_jalios_if_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      } finally {
                          if (_jspx_eval_jalios_if_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                              out = pageContext.popBody();
                      }
                  }
                  if (_jspx_th_jalios_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
              } finally {
                  _jspx_th_jalios_if_3.release();
              }
          // end
          // HTML // begin [file="/LinkIndexListener.jsp";from=(135,12);to=(136,0)]
              out.write("\n");

          // end
          // begin [file="/LinkIndexListener.jsp";from=(136,0);to=(136,12)]
          } while (_jspx_th_jalios_if_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
      } finally {
          if (_jspx_eval_jalios_if_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = pageContext.popBody();
      }
  }
  if (_jspx_th_jalios_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return;
} finally {
    _jspx_th_jalios_if_2.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(136,12);to=(138,0)]
    out.write("\n\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(138,0);to=(138,17)]
} while (_jspx_th_jalios_foreach_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
} finally {
    if (_jspx_eval_jalios_foreach_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = pageContext.popBody();
}
}
if (_jspx_th_jalios_foreach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
    return;
} finally {
    _jspx_th_jalios_foreach_3.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(138,17);to=(140,0)]
    out.write("\n    }\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(140,0);to=(140,17)]
} while (_jspx_th_jalios_foreach_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
} finally {
    if (_jspx_eval_jalios_foreach_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = pageContext.popBody();
}
}
if (_jspx_th_jalios_foreach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
    return;
} finally {
    _jspx_th_jalios_foreach_2.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(140,17);to=(144,0)]
    out.write("\n  }\n  \n  public void handleDelete(Storable storable, boolean firstTime) {\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(144,0);to=(144,87)]
    /* ----  jalios:foreach ---- */
    com.jalios.jtaglib.ForeachTag _jspx_th_jalios_foreach_4 = new com.jalios.jtaglib.ForeachTag();
    _jspx_th_jalios_foreach_4.setPageContext(pageContext);
    _jspx_th_jalios_foreach_4.setParent(null);
    _jspx_th_jalios_foreach_4.setCollection( linkTypeList );
    _jspx_th_jalios_foreach_4.setName("itType");
    _jspx_th_jalios_foreach_4.setType("org.jdom.Element");
    try {
        int _jspx_eval_jalios_foreach_4 = _jspx_th_jalios_foreach_4.doStartTag();
        if (_jspx_eval_jalios_foreach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            try {
                if (_jspx_eval_jalios_foreach_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                    out = pageContext.pushBody();
                    _jspx_th_jalios_foreach_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                    _jspx_th_jalios_foreach_4.doInitBody();
                }
                do {
                    Integer itCounter = null;
                    itCounter = (Integer) pageContext.findAttribute("itCounter");
                    org.jdom.Element itType = null;
                    itType = (org.jdom.Element) pageContext.findAttribute("itType");
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(144,87);to=(145,0)]
                    out.write("\n");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(145,2);to=(149,0)]
                     
                    String typeName = itType.getAttributeValue("name"); 
                    List fieldList = new ArrayList();
                    TypeUtil.buildInheritedFieldList(itType, fieldList, true, extendedTypes);
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(149,2);to=(150,7)]
                    out.write("\n    // ");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(150,10);to=(150,20)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(150,22);to=(151,28)]
                    out.write("   \n    if (storable instanceof ");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(151,31);to=(151,41)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(151,43);to=(152,6)]
                    out.write(") {\n      ");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(152,9);to=(152,19)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(152,21);to=(152,29)]
                    out.write(" obj = (");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(152,32);to=(152,42)]
                    out.print( typeName );
                // end
                // HTML // begin [file="/LinkIndexListener.jsp";from=(152,44);to=(154,0)]
                    out.write(")storable;\n    \n");

                // end
                // begin [file="/LinkIndexListener.jsp";from=(154,0);to=(154,106)]
                    /* ----  jalios:foreach ---- */
                    com.jalios.jtaglib.ForeachTag _jspx_th_jalios_foreach_5 = new com.jalios.jtaglib.ForeachTag();
                    _jspx_th_jalios_foreach_5.setPageContext(pageContext);
                    _jspx_th_jalios_foreach_5.setParent(_jspx_th_jalios_foreach_4);
                    _jspx_th_jalios_foreach_5.setCollection( fieldList );
                    _jspx_th_jalios_foreach_5.setName("itField");
                    _jspx_th_jalios_foreach_5.setType("org.jdom.Element");
                    _jspx_th_jalios_foreach_5.setCounter("itCounter2");
                    try {
                        int _jspx_eval_jalios_foreach_5 = _jspx_th_jalios_foreach_5.doStartTag();
                        if (_jspx_eval_jalios_foreach_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            try {
                              if (_jspx_eval_jalios_foreach_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_foreach_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_foreach_5.doInitBody();
                          }
                          do {
                              Integer itCounter2 = null;
                              itCounter2 = (Integer) pageContext.findAttribute("itCounter2");
                              org.jdom.Element itField = null;
                              itField = (org.jdom.Element) pageContext.findAttribute("itField");
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(154,106);to=(155,0)]
                              out.write("\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(155,2);to=(172,0)]
                              
                                String fieldType    = itField.getAttributeValue("type");
                                String fieldName    = itField.getAttributeValue("name");
                                String fieldNameCap = Util.recapitalize(fieldName);
                                String fieldEditor  = itField.getAttributeValue("editor");
                                boolean fieldML     = Util.toBoolean(itField.getAttributeValue("ml"), false);
                                
                                String fieldTypeShort = fieldType;
                                if (fieldTypeShort.endsWith("[]")) {
                                  fieldTypeShort = fieldTypeShort.substring(0, fieldTypeShort.length() - 2);
                                }
                                
                                String getterParam="";
                                boolean isDBLink =  TypeUtil.isDBType(itType.getParentElement(), fieldTypeShort);
                                if (isDBLink) {
                                  getterParam="false";
                                }
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(172,2);to=(174,0)]
                              out.write("\n\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(174,0);to=(174,132)]
                              /* ----  jalios:if ---- */
                              com.jalios.jtaglib.IfTag _jspx_th_jalios_if_4 = new com.jalios.jtaglib.IfTag();
                              _jspx_th_jalios_if_4.setPageContext(pageContext);
                              _jspx_th_jalios_if_4.setParent(_jspx_th_jalios_foreach_5);
                              _jspx_th_jalios_if_4.setPredicate( fieldEditor.startsWith("link") || fieldEditor.startsWith("member") || fieldEditor.startsWith("group") );
                              try {
                              int _jspx_eval_jalios_if_4 = _jspx_th_jalios_if_4.doStartTag();
                              if (_jspx_eval_jalios_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              try {
                              if (_jspx_eval_jalios_if_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_if_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_if_4.doInitBody();
                          }
                          do {
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(174,132);to=(175,9)]
                              out.write("\n      // ");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(175,12);to=(175,23)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(175,25);to=(176,25)]
                              out.write("\n      remove(obj, obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(176,28);to=(176,42)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(176,44);to=(176,45)]
                              out.write("(");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(176,48);to=(176,61)]
                              out.print( getterParam );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(176,63);to=(176,67)]
                              out.write("), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(176,70);to=(176,81)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(176,83);to=(177,0)]
                              out.write("\");\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(177,0);to=(177,38)]
                              /* ----  jalios:if ---- */
                              com.jalios.jtaglib.IfTag _jspx_th_jalios_if_5 = new com.jalios.jtaglib.IfTag();
                              _jspx_th_jalios_if_5.setPageContext(pageContext);
                              _jspx_th_jalios_if_5.setParent(_jspx_th_jalios_if_4);
                              _jspx_th_jalios_if_5.setPredicate( fieldML );
                              try {
                              int _jspx_eval_jalios_if_5 = _jspx_th_jalios_if_5.doStartTag();
                              if (_jspx_eval_jalios_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              try {
                              if (_jspx_eval_jalios_if_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = pageContext.pushBody();
                              _jspx_th_jalios_if_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_jalios_if_5.doInitBody();
                          }
                          do {
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(177,38);to=(178,25)]
                              out.write("\n      remove(obj, obj.get");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(178,28);to=(178,42)]
                              out.print( fieldNameCap );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(178,44);to=(178,51)]
                              out.write("ML(), \"");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(178,54);to=(178,65)]
                              out.print( fieldName );
                          // end
                          // HTML // begin [file="/LinkIndexListener.jsp";from=(178,67);to=(179,0)]
                              out.write("\");\n");

                          // end
                          // begin [file="/LinkIndexListener.jsp";from=(179,0);to=(179,12)]
                          } while (_jspx_th_jalios_if_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      } finally {
                          if (_jspx_eval_jalios_if_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                              out = pageContext.popBody();
                      }
                  }
                  if (_jspx_th_jalios_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
              } finally {
                  _jspx_th_jalios_if_5.release();
              }
          // end
          // HTML // begin [file="/LinkIndexListener.jsp";from=(179,12);to=(180,0)]
              out.write("\n");

          // end
          // begin [file="/LinkIndexListener.jsp";from=(180,0);to=(180,12)]
          } while (_jspx_th_jalios_if_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
      } finally {
          if (_jspx_eval_jalios_if_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = pageContext.popBody();
      }
  }
  if (_jspx_th_jalios_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return;
} finally {
    _jspx_th_jalios_if_4.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(180,12);to=(182,0)]
    out.write("\n\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(182,0);to=(182,17)]
} while (_jspx_th_jalios_foreach_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
} finally {
    if (_jspx_eval_jalios_foreach_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = pageContext.popBody();
}
}
if (_jspx_th_jalios_foreach_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
    return;
} finally {
    _jspx_th_jalios_foreach_5.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(182,17);to=(184,0)]
    out.write("\n    }    \n");

// end
// begin [file="/LinkIndexListener.jsp";from=(184,0);to=(184,17)]
} while (_jspx_th_jalios_foreach_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
} finally {
    if (_jspx_eval_jalios_foreach_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = pageContext.popBody();
}
}
if (_jspx_th_jalios_foreach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
    return;
} finally {
    _jspx_th_jalios_foreach_4.release();
}
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(184,17);to=(188,0)]
    out.write("\n  }\n  \n}\n");

// end
// begin [file="/LinkIndexListener.jsp";from=(188,2);to=(188,16)]
     out.flush(); 
// end
// HTML // begin [file="/LinkIndexListener.jsp";from=(188,18);to=(190,0)]
    out.write("\n\n");

// end

} catch (Throwable t) {
    if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
    if (pageContext != null) pageContext.handlePageException(t);
} finally {
    if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
}
}
}
