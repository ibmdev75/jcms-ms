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


public class _0005fType_0005fhbm$jsp extends HttpJspBase {


    static {
    }
    public _0005fType_0005fhbm$jsp( ) {
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
            			"", true, 0, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="/_Type_hbm.jsp";from=(0,0);to=(6,0)]
                out.write("<?xml version=\"1.0\"?>\n<!DOCTYPE hibernate-mapping PUBLIC\n        \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"\n        \"classpath://org/hibernate/hibernate-mapping-3.0.dtd\">\n\n<hibernate-mapping>\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(11,6);to=(90,0)]
                
                  request.setCharacterEncoding("UTF-8");
                  
                final Channel channel = Channel.getChannel();
                
                // Uncomment this to test template under JCMS without the need to restart
                // session.setAttribute("typeElt", channel.getTypeEntry(generated.DBComment.class).getXmlElement());
                
                Element typeElt = (Element)session.getAttribute("typeElt");
                String className = typeElt.getAttributeValue("name");
                
                int limit = 30; // Oracle tables are limited to 30 chars
                
                String table = Util.truncate("G_" + className.toUpperCase(), limit, ""); 
                
                String tablePrefix = table + "_"; 
                
                String indexPrefix = "IG_" + className.toUpperCase() + "_";
                
                //Get the fields (and the inherited fields)                             
                ArrayList fieldList = new ArrayList();
                TypeUtil.buildInheritedFieldList(typeElt, fieldList, true);
                
                boolean isForm = typeElt.getAttribute("formAuthor") != null;
                
                boolean isContent = TypeUtil.isSubTypeOf(typeElt, com.jalios.jcms.Content.class);
                boolean isUserContent = TypeUtil.isSubTypeOf(typeElt, com.jalios.jcms.UserContent.class);
                
                boolean isDBFileDocument = TypeUtil.isSubTypeOf(typeElt, com.jalios.jcms.DBFileDocument.class);
                
                boolean openRole = Util.toBoolean(typeElt.getAttributeValue("openRole"), false);
                
                boolean addReadRights = isContent;
                boolean addVersion = isContent;
                
                String[] customInterfaces = Util.split(Util.getString(typeElt.getAttributeValue("interfaces"), ""), ", ");
                
                if (!addVersion) {
                  if (Util.toBoolean(typeElt.getAttributeValue("revision"), false)) {
                	  addVersion = true;
                  } else {
                	  for(String customInterface: customInterfaces) {
                	    if (customInterface.endsWith(".HistorizedDBData")) {
                	      addVersion = true;
                	      break;
                	    }
                	  }
                  }
                }
                
                boolean addCategories = isContent;
                if (!addCategories) {
                  for(String customInterface: customInterfaces) {
                    if (customInterface.endsWith(".CategorizedDBData")) {
                      addCategories = true;
                      break;
                    }
                  }
                  
                  TypeFieldEntry[] allTFE = channel.getAllTypeFieldEntries(TypeProcessor.PACKAGE_NAME + "." + className);
                  for(TypeFieldEntry fieldEntry: allTFE) {
                    String editor = fieldEntry.getEditor();    
                    if ("category".equals(editor)) {
                      addCategories = true;
                      break;      
                    }
                  }
                }
                
                boolean addReaderTracker = isContent;
                if (!addReaderTracker) {
                  for(String customInterface: customInterfaces) {
                    if (customInterface.endsWith(".TrackedDBData")) {
                      addReaderTracker = true;
                      break;
                    }
                  }  
                }
                List fieldEntryList = Arrays.asList(channel.getAllTypeFieldEntries(TypeProcessor.PACKAGE_NAME + "." + className));
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(90,2);to=(91,25)]
                out.write("\n  <class name=\"generated.");

            // end
            // begin [file="/_Type_hbm.jsp";from=(91,28);to=(91,39)]
                out.print( className );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(91,41);to=(91,50)]
                out.write("\" table=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(91,53);to=(91,60)]
                out.print( table );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(91,62);to=(97,50)]
                out.write("\">\n    <cache usage=\"read-write\" />  \n    <id name=\"rowId\" column=\"rowId\">\n      <generator class=\"native\"/>\n    </id>\n    <property name=\"cdate\" not-null=\"true\" />\n    <property name=\"mdate\" not-null=\"true\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(97,53);to=(97,103)]
                out.print( Util.truncate(indexPrefix + "MDATE", limit, "")  );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(97,105);to=(98,49)]
                out.write("\" />\n    <property name=\"authorId\" length=\"32\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(98,52);to=(98,105)]
                out.print( Util.truncate(indexPrefix + "AUTHORID", limit, "")  );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(98,107);to=(100,52)]
                out.write("\" />\n    \n    <property name=\"pstatus\" not-null=\"true\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(100,55);to=(100,106)]
                out.print( Util.truncate(indexPrefix + "PSTATUS", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(100,108);to=(101,68)]
                out.write("\" />\n    <property name=\"workspaceId\" not-null=\"true\" length=\"32\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(101,71);to=(101,119)]
                out.print( Util.truncate(indexPrefix + "WSID", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(101,121);to=(103,0)]
                out.write("\" />\n    \n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(103,2);to=(103,20)]
                 if (isContent) { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(103,22);to=(104,35)]
                out.write("\n    <property name=\"pdate\"  index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(104,38);to=(104,88)]
                out.print( Util.truncate(indexPrefix + "PDATE", limit, "")  );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(104,90);to=(105,0)]
                out.write("\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(105,2);to=(105,12)]
                 } else { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(105,14);to=(107,0)]
                out.write("\n    <property name=\"pdate\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(107,2);to=(107,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(107,7);to=(111,68)]
                out.write("\n    <property name=\"edate\" />\n    <property name=\"adate\" />\n    <property name=\"title\" />\n    <property name=\"workflowId\" not-null=\"false\" length=\"32\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(111,71);to=(111,119)]
                out.print( Util.truncate(indexPrefix + "WFID", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(111,121);to=(112,0)]
                out.write("\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(112,2);to=(112,21)]
                 if (addVersion) { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(112,23);to=(116,0)]
                out.write("\n    <property name=\"udate\" />\n    <property name=\"majorVersion\" />\n    <property name=\"minorVersion\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(116,2);to=(116,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(116,7);to=(117,0)]
                out.write("\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(117,2);to=(117,20)]
                 if (isContent) { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(117,22);to=(118,44)]
                out.write("\n    <property name=\"hasNoReadRights\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(118,47);to=(118,106)]
                out.print( Util.truncate(indexPrefix + "HASNOREADRIGHTS", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(118,108);to=(119,0)]
                out.write("\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(119,2);to=(119,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(119,7);to=(120,0)]
                out.write("\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(120,2);to=(120,27)]
                 if (addReaderTracker) { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(120,29);to=(122,40)]
                out.write("\n    <property name=\"tracked\" />\n    <property name=\"readerCount\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(122,43);to=(122,98)]
                out.print( Util.truncate(indexPrefix + "READERCOUNT", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(122,100);to=(123,0)]
                out.write("\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(123,2);to=(123,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(123,7);to=(124,0)]
                out.write("\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(124,2);to=(124,35)]
                 if(isUserContent || isContent){ 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(124,37);to=(125,55)]
                out.write("\n    <property name=\"voteCount\" not-null=\"false\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(125,58);to=(125,111)]
                out.print( Util.truncate(indexPrefix + "VOTECOUNT", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(125,113);to=(126,55)]
                out.write("\" />\n    <property name=\"voteScore\" not-null=\"false\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(126,58);to=(126,111)]
                out.print( Util.truncate(indexPrefix + "VOTESCORE", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(126,113);to=(127,0)]
                out.write("\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(127,2);to=(127,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(127,7);to=(128,0)]
                out.write("\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(128,2);to=(128,27)]
                 if (isDBFileDocument) { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(128,29);to=(129,37)]
                out.write("\n    <property name=\"filename\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(129,40);to=(129,92)]
                out.print( Util.truncate(indexPrefix + "FILENAME", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(129,94);to=(134,0)]
                out.write("\" />\n    <property name=\"originalFilename\" />\n    <property name=\"contentType\" />\n    <property name=\"uploadDate\" />\n    <property name=\"pdfUploadDate\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(134,2);to=(134,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(134,7);to=(135,0)]
                out.write("    \n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(135,2);to=(135,17)]
                 if (isForm) { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(135,19);to=(136,43)]
                out.write("\n    <property name=\"submitMemberId\" index=\"");

            // end
            // begin [file="/_Type_hbm.jsp";from=(136,46);to=(136,96)]
                out.print( Util.truncate(indexPrefix + "SUBMID", limit, "") );
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(136,98);to=(138,0)]
                out.write("\" />\n    <property name=\"submitRemoteAddr\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(138,2);to=(138,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(138,7);to=(139,0)]
                out.write("\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(139,2);to=(139,19)]
                 if (openRole) { 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(139,21);to=(141,0)]
                out.write("\n    <property name=\"roleMapStr\" type=\"text\" length=\"65536\" />\n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(141,2);to=(141,5)]
                 } 
            // end
            // HTML // begin [file="/_Type_hbm.jsp";from=(141,7);to=(142,0)]
                out.write("    \n");

            // end
            // begin [file="/_Type_hbm.jsp";from=(142,0);to=(142,88)]
                /* ----  jalios:foreach ---- */
                com.jalios.jtaglib.ForeachTag _jspx_th_jalios_foreach_0 = new com.jalios.jtaglib.ForeachTag();
                _jspx_th_jalios_foreach_0.setPageContext(pageContext);
                _jspx_th_jalios_foreach_0.setParent(null);
                _jspx_th_jalios_foreach_0.setCollection( fieldEntryList );
                _jspx_th_jalios_foreach_0.setName("itField");
                _jspx_th_jalios_foreach_0.setType("TypeFieldEntry");
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
                              TypeFieldEntry itField = null;
                              itField = (TypeFieldEntry) pageContext.findAttribute("itField");
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(142,88);to=(143,0)]
                              out.write("\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(143,2);to=(165,0)]
                               
                              String name       = itField.getName();
                              String editor     = itField.getEditor();
                              String type       = itField.getType();
                              boolean isAnyLink = itField.isAnyLink();
                              
                              boolean isLargeText = "textarea".equals(editor) || "wysiwyg".equals(editor);
                              
                              
                              String indexName = Util.truncate(indexPrefix + name.toUpperCase(), limit, "");
                              
                              String attributes = "";
                              if (isLargeText) { 
                                attributes = " type=\"text\" length=\"65536\"";
                              }
                              else if (isAnyLink) {
                                attributes = " length=\"64\" index=\"" + indexName + "\"";
                              }
                              
                              String propertyName = isAnyLink ? name + "Id" : name;
                              
                              if (!editor.equals("category")) {
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(165,2);to=(166,0)]
                              out.write("\n");

                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(166,16);to=(167,0)]
                              out.write("\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(167,2);to=(167,35)]
                                 if (itField.isTypeScalar()) { 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(167,37);to=(168,20)]
                              out.write("\n    <property name=\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(168,23);to=(168,37)]
                              out.print( propertyName );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(168,39);to=(168,40)]
                              out.write("\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(168,43);to=(168,55)]
                              out.print( attributes );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(168,57);to=(169,4)]
                              out.write(" />\n    ");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(169,6);to=(169,39)]
                               if(editor.equals("sqlquery")) { 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(169,41);to=(170,20)]
                              out.write("\n    <property name=\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(170,23);to=(170,37)]
                              out.print( propertyName );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(170,39);to=(171,20)]
                              out.write("DataSource\" />\n    <property name=\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(171,23);to=(171,37)]
                              out.print( propertyName );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(171,39);to=(172,4)]
                              out.write("MaxRows\" />\n    ");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(172,6);to=(172,9)]
                               } 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(172,11);to=(173,0)]
                              out.write("\n");

                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(173,18);to=(174,0)]
                              out.write("\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(174,2);to=(174,14)]
                                 } else { 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(174,16);to=(175,0)]
                              out.write("\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(175,2);to=(179,0)]
                              
                              String collection = itField.isTypeList() ? "list" : "set";
                              String collectionTable = Util.truncate(tablePrefix + name.toUpperCase(), limit, "");
                              String collectionType = isLargeText ? "text" : itField.getCollectionTypeMapping();
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(179,2);to=(180,5)]
                              out.write("\n    <");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(180,8);to=(180,20)]
                              out.print( collection );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(180,22);to=(180,29)]
                              out.write(" name=\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(180,32);to=(180,46)]
                              out.print( propertyName );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(180,48);to=(180,57)]
                              out.write("\" table=\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(180,60);to=(180,77)]
                              out.print( collectionTable );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(180,79);to=(183,38)]
                              out.write("\">\n      <cache usage=\"read-write\" />\n      <key>\n        <column name=\"ITEM_ID\" index=\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(183,41);to=(183,89)]
                              out.print( Util.truncate(indexName, limit - 2, "") + "_I" );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(183,91);to=(185,0)]
                              out.write("\"/>\n      </key>      \n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(185,2);to=(185,33)]
                                 if (itField.isTypeList()) { 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(185,35);to=(187,0)]
                              out.write("\n      <list-index column=\"POSITION\" />\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(187,2);to=(187,7)]
                                 } 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(187,9);to=(188,21)]
                              out.write("\n      <element type=\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(188,24);to=(188,40)]
                              out.print( collectionType );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(188,42);to=(188,43)]
                              out.write("\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(188,46);to=(188,86)]
                              out.print( isLargeText ? " length=\"65536\"" : "" );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(188,88);to=(189,28)]
                              out.write(">\n        <column name=\"VALUE\"");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(189,31);to=(189,94)]
                              out.print( isAnyLink ? " length=\"64\" index=\"" + indexName + "\"" : "" );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(189,96);to=(191,6)]
                              out.write("/>\n      </element>      \n    </");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(191,9);to=(191,21)]
                              out.print( collection );
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(191,23);to=(192,0)]
                              out.write(">\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(192,2);to=(192,7)]
                                 } 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(192,9);to=(193,0)]
                              out.write("\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(193,2);to=(193,5)]
                               } 
                          // end
                          // HTML // begin [file="/_Type_hbm.jsp";from=(193,7);to=(194,0)]
                              out.write("\n");

                          // end
                          // begin [file="/_Type_hbm.jsp";from=(194,0);to=(194,17)]
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
          // HTML // begin [file="/_Type_hbm.jsp";from=(194,17);to=(196,0)]
              out.write("\n\n");

          // end
          // begin [file="/_Type_hbm.jsp";from=(196,2);to=(196,24)]
               if (addCategories) { 
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(196,26);to=(199,32)]
              out.write("\n    \n    <!--  COLLECTIONS FOR CATEGORIES -->\n    <set name=\"catIdSet\" table=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(199,35);to=(199,85)]
              out.print( Util.truncate(tablePrefix + "CATSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(199,87);to=(202,38)]
              out.write("\" lazy=\"true\">\n      <cache usage=\"read-write\" />\n      <key>\n        <column name=\"ITEM_ID\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(202,41);to=(202,93)]
              out.print( Util.truncate(indexPrefix + "CATSET_I", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(202,95);to=(205,48)]
              out.write("\"/>\n      </key>\n      <element type=\"string\">\n        <column name=\"VALUE\" length=\"64\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(205,51);to=(205,101)]
              out.print( Util.truncate(indexPrefix + "CATSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(205,103);to=(209,35)]
              out.write("\"/>\n      </element>      \n    </set>\n    \n    <set name=\"allCatIdSet\" table=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(209,38);to=(209,91)]
              out.print( Util.truncate(tablePrefix + "ALLCATSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(209,93);to=(212,38)]
              out.write("\"  lazy=\"true\">\n      <cache usage=\"read-write\" />\n      <key>\n        <column name=\"ITEM_ID\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(212,41);to=(212,96)]
              out.print( Util.truncate(indexPrefix + "ALLCATSET_I", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(212,98);to=(215,48)]
              out.write("\"/>\n      </key>\n      <element type=\"string\">\n        <column name=\"VALUE\" length=\"64\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(215,51);to=(215,104)]
              out.print( Util.truncate(indexPrefix + "ALLCATSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(215,106);to=(218,0)]
              out.write("\"/>\n      </element>      \n    </set>\n");

          // end
          // begin [file="/_Type_hbm.jsp";from=(218,2);to=(218,5)]
               } 
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(218,7);to=(220,0)]
              out.write("\n\n");

          // end
          // begin [file="/_Type_hbm.jsp";from=(220,2);to=(220,24)]
               if (addReadRights) { 
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(220,26);to=(223,36)]
              out.write("\n    \n    <!--  COLLECTIONS FOR READ-RIGHTS -->\n    <set name=\"authGrpIdSet\" table=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(223,39);to=(223,93)]
              out.print( Util.truncate(tablePrefix + "AUTHGRPSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(223,95);to=(226,38)]
              out.write("\" lazy=\"true\">\n      <cache usage=\"read-write\" />\n      <key>\n        <column name=\"ITEM_ID\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(226,41);to=(226,97)]
              out.print( Util.truncate(indexPrefix + "AUTHGRPSET_I", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(226,99);to=(229,48)]
              out.write("\"/>\n      </key>\n      <element type=\"string\">\n        <column name=\"VALUE\" length=\"64\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(229,51);to=(229,105)]
              out.print( Util.truncate(indexPrefix + "AUTHGRPSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(229,107);to=(233,36)]
              out.write("\"/>\n      </element>      \n    </set>    \n    \n    <set name=\"authMbrIdSet\" table=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(233,39);to=(233,93)]
              out.print( Util.truncate(tablePrefix + "AUTHMBRSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(233,95);to=(236,38)]
              out.write("\" lazy=\"true\">\n      <cache usage=\"read-write\" />\n      <key>\n        <column name=\"ITEM_ID\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(236,41);to=(236,97)]
              out.print( Util.truncate(indexPrefix + "AUTHMBRSET_I", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(236,99);to=(239,48)]
              out.write("\"/>\n      </key>\n      <element type=\"string\">\n        <column name=\"VALUE\" length=\"64\" index=\"");

          // end
          // begin [file="/_Type_hbm.jsp";from=(239,51);to=(239,105)]
              out.print( Util.truncate(indexPrefix + "AUTHMBRSET", limit, "") );
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(239,107);to=(242,0)]
              out.write("\"/>\n      </element>      \n    </set>\n");

          // end
          // begin [file="/_Type_hbm.jsp";from=(242,2);to=(242,5)]
               } 
          // end
          // HTML // begin [file="/_Type_hbm.jsp";from=(242,7);to=(246,0)]
              out.write("\n\n  </class>\n</hibernate-mapping>\n");

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
