// Generated from Uppaal2C.g4 by ANTLR 4.13.1

package Uppaal2CTransformations;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Uppaal2CParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, UPPAAL_COMMENT_WITH_TEXT=6, UPPAAL_COMMENT=7, 
		ARRAY_SV=8, CONST=9, VOID=10, DATATYPE=11, ID=12, LBRACK=13, RBRACK=14, 
		LPAREN=15, RPAREN=16, LBRACE=17, RBRACE=18, OPEN_DECLARATION=19, OPEN_TEMPLATE=20, 
		OPEN_TEMPLATE_NAME=21, CLOSE_TEMPLATE_NAME=22, OPEN_PARAMETER=23, CLOSE_PARAMETER=24, 
		OPEN_LOCATION=25, EQUAL=26, STRING=27, INT=28, CLOSE_LOCATION=29, INIT=30, 
		SEMICOLON=31, COLON=32, COMMA=33, DOT=34, PLUS=35, PLUSPLUS=36, MINUS=37, 
		MINUSMINUS=38, MINUSEQUAL=39, PLUSEQUAL=40, EQUALMINUS=41, EQUALPLUS=42, 
		STAR=43, SLASH=44, PERCENT=45, LT=46, GT=47, LE=48, GE=49, EQEQ=50, NOTEQ=51, 
		QUOTE=52, DOLLAR=53, HEX_INT=54, LT_TAG=55, GT_TAG=56, AND=57, OR=58, 
		NTA_OPEN=59, NTA_CLOSE=60, CLOSE_DECLARATION=61, CLOSE_SOURCE_TARGET=62, 
		CLOSE_TEMPLATE=63, OPEN_SYSTEM=64, CLOSE_SYSTEM=65, OPEN_QUERIES=66, CLOSE_QUERIES=67, 
		OPEN_TRANSITION=68, CLOSE_TRANSITION=69, OPEN_LABEL=70, CLOSE_LABEL=71, 
		OPEN_SOURCE=72, OPEN_TARGET=73, OPEN_QUERY=74, CLOSE_QUERY=75, OPEN_FORMULA=76, 
		CLOSE_FORMULA=77, OPEN_COMMENT=78, CLOSE_COMMENT=79, WS=80;
	public static final int
		RULE_file = 0, RULE_ntaSection = 1, RULE_ntaItem = 2, RULE_declaration = 3, 
		RULE_declarationItem = 4, RULE_declarationVar = 5, RULE_declarationFunc = 6, 
		RULE_parameterList = 7, RULE_parameter = 8, RULE_template = 9, RULE_templateParameter = 10, 
		RULE_nameSection = 11, RULE_system = 12, RULE_queries = 13, RULE_location = 14, 
		RULE_inItLocation = 15, RULE_transition = 16, RULE_label = 17, RULE_expression = 18, 
		RULE_operator = 19, RULE_source = 20, RULE_target = 21, RULE_query = 22, 
		RULE_comment = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "ntaSection", "ntaItem", "declaration", "declarationItem", "declarationVar", 
			"declarationFunc", "parameterList", "parameter", "template", "templateParameter", 
			"nameSection", "system", "queries", "location", "inItLocation", "transition", 
			"label", "expression", "operator", "source", "target", "query", "comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'system'", "'id'", "'x'", "'y'", "'kind'", null, null, "':0'", 
			"'const'", "'void'", null, null, "'['", "']'", "'('", "')'", "'{'", "'}'", 
			"'<declaration>'", "'<template>'", "'<name>'", "'</name>'", "'<parameter>'", 
			"'</parameter>'", "'<location'", "'='", null, null, "'</location>'", 
			"'<init ref=\"id0\"/>'", "';'", "':'", "','", "'.'", "'+'", "'++'", "'-'", 
			"'--'", "'-='", "'+='", "'=-'", "'=+'", "'*'", "'/'", "'%'", "'<'", "'>'", 
			"'<='", "'>='", "'=='", "'!='", null, "'$'", null, "'&lt;'", "'&gt;'", 
			"'&amp;&amp;'", "'||'", "'<nta>'", "'</nta>'", "'</declaration>'", "'/>'", 
			"'</template>'", "'<system>'", "'</system>'", "'<queries>'", "'</queries>'", 
			"'<transition>'", "'</transition>'", "'<label'", "'</label>'", "'<source ref='", 
			"'<target ref='", "'<query>'", "'</query>'", "'<formula>'", "'</formula>'", 
			"'<comment>'", "'</comment>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "UPPAAL_COMMENT_WITH_TEXT", "UPPAAL_COMMENT", 
			"ARRAY_SV", "CONST", "VOID", "DATATYPE", "ID", "LBRACK", "RBRACK", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "OPEN_DECLARATION", "OPEN_TEMPLATE", "OPEN_TEMPLATE_NAME", 
			"CLOSE_TEMPLATE_NAME", "OPEN_PARAMETER", "CLOSE_PARAMETER", "OPEN_LOCATION", 
			"EQUAL", "STRING", "INT", "CLOSE_LOCATION", "INIT", "SEMICOLON", "COLON", 
			"COMMA", "DOT", "PLUS", "PLUSPLUS", "MINUS", "MINUSMINUS", "MINUSEQUAL", 
			"PLUSEQUAL", "EQUALMINUS", "EQUALPLUS", "STAR", "SLASH", "PERCENT", "LT", 
			"GT", "LE", "GE", "EQEQ", "NOTEQ", "QUOTE", "DOLLAR", "HEX_INT", "LT_TAG", 
			"GT_TAG", "AND", "OR", "NTA_OPEN", "NTA_CLOSE", "CLOSE_DECLARATION", 
			"CLOSE_SOURCE_TARGET", "CLOSE_TEMPLATE", "OPEN_SYSTEM", "CLOSE_SYSTEM", 
			"OPEN_QUERIES", "CLOSE_QUERIES", "OPEN_TRANSITION", "CLOSE_TRANSITION", 
			"OPEN_LABEL", "CLOSE_LABEL", "OPEN_SOURCE", "OPEN_TARGET", "OPEN_QUERY", 
			"CLOSE_QUERY", "OPEN_FORMULA", "CLOSE_FORMULA", "OPEN_COMMENT", "CLOSE_COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Uppaal2C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Uppaal2CParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Uppaal2CParser.EOF, 0); }
		public NtaSectionContext ntaSection() {
			return getRuleContext(NtaSectionContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(48);
			ntaSection();
			}
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NtaSectionContext extends ParserRuleContext {
		public TerminalNode NTA_OPEN() { return getToken(Uppaal2CParser.NTA_OPEN, 0); }
		public TerminalNode NTA_CLOSE() { return getToken(Uppaal2CParser.NTA_CLOSE, 0); }
		public List<NtaItemContext> ntaItem() {
			return getRuleContexts(NtaItemContext.class);
		}
		public NtaItemContext ntaItem(int i) {
			return getRuleContext(NtaItemContext.class,i);
		}
		public NtaSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ntaSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterNtaSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitNtaSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitNtaSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NtaSectionContext ntaSection() throws RecognitionException {
		NtaSectionContext _localctx = new NtaSectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ntaSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(NTA_OPEN);
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				ntaItem();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 1441151880758583299L) != 0) );
			setState(57);
			match(NTA_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NtaItemContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TemplateContext> template() {
			return getRuleContexts(TemplateContext.class);
		}
		public TemplateContext template(int i) {
			return getRuleContext(TemplateContext.class,i);
		}
		public SystemContext system() {
			return getRuleContext(SystemContext.class,0);
		}
		public QueriesContext queries() {
			return getRuleContext(QueriesContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public NtaItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ntaItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterNtaItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitNtaItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitNtaItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NtaItemContext ntaItem() throws RecognitionException {
		NtaItemContext _localctx = new NtaItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ntaItem);
		try {
			int _alt;
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_DECLARATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(59);
						declaration();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(62); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case OPEN_TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(65); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(64);
						template();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(67); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case OPEN_SYSTEM:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				system();
				}
				break;
			case OPEN_QUERIES:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				queries();
				}
				break;
			case UPPAAL_COMMENT_WITH_TEXT:
			case UPPAAL_COMMENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				comment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode OPEN_DECLARATION() { return getToken(Uppaal2CParser.OPEN_DECLARATION, 0); }
		public TerminalNode CLOSE_DECLARATION() { return getToken(Uppaal2CParser.CLOSE_DECLARATION, 0); }
		public List<DeclarationItemContext> declarationItem() {
			return getRuleContexts(DeclarationItemContext.class);
		}
		public DeclarationItemContext declarationItem(int i) {
			return getRuleContext(DeclarationItemContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(OPEN_DECLARATION);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				declarationItem();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3776L) != 0) );
			setState(80);
			match(CLOSE_DECLARATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationItemContext extends ParserRuleContext {
		public DeclarationVarContext declarationVar() {
			return getRuleContext(DeclarationVarContext.class,0);
		}
		public DeclarationFuncContext declarationFunc() {
			return getRuleContext(DeclarationFuncContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public DeclarationItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterDeclarationItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitDeclarationItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitDeclarationItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationItemContext declarationItem() throws RecognitionException {
		DeclarationItemContext _localctx = new DeclarationItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationItem);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				declarationVar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				declarationFunc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				comment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationVarContext extends ParserRuleContext {
		public Token initValue;
		public TerminalNode DATATYPE() { return getToken(Uppaal2CParser.DATATYPE, 0); }
		public List<TerminalNode> ID() { return getTokens(Uppaal2CParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2CParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(Uppaal2CParser.SEMICOLON, 0); }
		public TerminalNode CONST() { return getToken(Uppaal2CParser.CONST, 0); }
		public TerminalNode LBRACK() { return getToken(Uppaal2CParser.LBRACK, 0); }
		public List<TerminalNode> INT() { return getTokens(Uppaal2CParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(Uppaal2CParser.INT, i);
		}
		public TerminalNode RBRACK() { return getToken(Uppaal2CParser.RBRACK, 0); }
		public TerminalNode EQUAL() { return getToken(Uppaal2CParser.EQUAL, 0); }
		public TerminalNode ARRAY_SV() { return getToken(Uppaal2CParser.ARRAY_SV, 0); }
		public DeclarationVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterDeclarationVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitDeclarationVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitDeclarationVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationVarContext declarationVar() throws RecognitionException {
		DeclarationVarContext _localctx = new DeclarationVarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declarationVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(87);
				match(CONST);
				}
			}

			setState(90);
			match(DATATYPE);
			setState(91);
			match(ID);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(92);
				match(LBRACK);
				setState(93);
				match(INT);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARRAY_SV) {
					{
					setState(94);
					match(ARRAY_SV);
					}
				}

				setState(97);
				match(RBRACK);
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(100);
				match(EQUAL);
				}
			}

			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(103);
				((DeclarationVarContext)_localctx).initValue = match(ID);
				}
				break;
			case INT:
				{
				setState(104);
				((DeclarationVarContext)_localctx).initValue = match(INT);
				}
				break;
			case SEMICOLON:
				break;
			default:
				break;
			}
			setState(107);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationFuncContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Uppaal2CParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(Uppaal2CParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Uppaal2CParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(Uppaal2CParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Uppaal2CParser.RBRACE, 0); }
		public TerminalNode DATATYPE() { return getToken(Uppaal2CParser.DATATYPE, 0); }
		public TerminalNode VOID() { return getToken(Uppaal2CParser.VOID, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Uppaal2CParser.SEMICOLON, 0); }
		public DeclarationFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterDeclarationFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitDeclarationFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitDeclarationFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationFuncContext declarationFunc() throws RecognitionException {
		DeclarationFuncContext _localctx = new DeclarationFuncContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declarationFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==DATATYPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(110);
			match(ID);
			setState(111);
			match(LPAREN);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOID || _la==ID) {
				{
				setState(112);
				parameterList();
				}
			}

			setState(115);
			match(RPAREN);
			setState(116);
			match(LBRACE);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2147487936L) != 0)) {
				{
				setState(117);
				expression();
				setState(118);
				match(SEMICOLON);
				}
			}

			setState(122);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2CParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2CParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			parameter();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(125);
				match(COMMA);
				setState(126);
				parameter();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Uppaal2CParser.ID, 0); }
		public TerminalNode VOID() { return getToken(Uppaal2CParser.VOID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateContext extends ParserRuleContext {
		public TerminalNode OPEN_TEMPLATE() { return getToken(Uppaal2CParser.OPEN_TEMPLATE, 0); }
		public NameSectionContext nameSection() {
			return getRuleContext(NameSectionContext.class,0);
		}
		public TerminalNode CLOSE_TEMPLATE() { return getToken(Uppaal2CParser.CLOSE_TEMPLATE, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TemplateParameterContext templateParameter() {
			return getRuleContext(TemplateParameterContext.class,0);
		}
		public List<LocationContext> location() {
			return getRuleContexts(LocationContext.class);
		}
		public LocationContext location(int i) {
			return getRuleContext(LocationContext.class,i);
		}
		public List<TerminalNode> INIT() { return getTokens(Uppaal2CParser.INIT); }
		public TerminalNode INIT(int i) {
			return getToken(Uppaal2CParser.INIT, i);
		}
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(OPEN_TEMPLATE);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UPPAAL_COMMENT_WITH_TEXT || _la==UPPAAL_COMMENT) {
				{
				setState(135);
				comment();
				}
			}

			setState(138);
			nameSection();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PARAMETER) {
				{
				setState(139);
				templateParameter();
				}
			}

			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 4611686018444689411L) != 0)) {
				{
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN_LOCATION:
					{
					setState(142);
					location();
					}
					break;
				case INIT:
					{
					setState(143);
					match(INIT);
					}
					break;
				case OPEN_TRANSITION:
					{
					setState(144);
					transition();
					}
					break;
				case UPPAAL_COMMENT_WITH_TEXT:
				case UPPAAL_COMMENT:
					{
					setState(145);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(CLOSE_TEMPLATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateParameterContext extends ParserRuleContext {
		public TerminalNode OPEN_PARAMETER() { return getToken(Uppaal2CParser.OPEN_PARAMETER, 0); }
		public TerminalNode CLOSE_PARAMETER() { return getToken(Uppaal2CParser.CLOSE_PARAMETER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2CParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2CParser.COMMA, i);
		}
		public List<TerminalNode> CONST() { return getTokens(Uppaal2CParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(Uppaal2CParser.CONST, i);
		}
		public List<TerminalNode> ID() { return getTokens(Uppaal2CParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2CParser.ID, i);
		}
		public List<TerminalNode> DATATYPE() { return getTokens(Uppaal2CParser.DATATYPE); }
		public TerminalNode DATATYPE(int i) {
			return getToken(Uppaal2CParser.DATATYPE, i);
		}
		public List<TerminalNode> VOID() { return getTokens(Uppaal2CParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(Uppaal2CParser.VOID, i);
		}
		public TemplateParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterTemplateParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitTemplateParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitTemplateParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateParameterContext templateParameter() throws RecognitionException {
		TemplateParameterContext _localctx = new TemplateParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_templateParameter);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(OPEN_PARAMETER);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(154);
				match(CONST);
				}
			}

			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOID || _la==DATATYPE) {
				{
				setState(157);
				_la = _input.LA(1);
				if ( !(_la==VOID || _la==DATATYPE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(160);
				match(ID);
				}
			}

			}
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(163);
					match(COMMA);
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==CONST) {
						{
						setState(164);
						match(CONST);
						}
					}

					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==VOID || _la==DATATYPE) {
						{
						setState(167);
						_la = _input.LA(1);
						if ( !(_la==VOID || _la==DATATYPE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
					}

					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(170);
						match(ID);
						}
					}

					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(178);
			match(CLOSE_PARAMETER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NameSectionContext extends ParserRuleContext {
		public TerminalNode OPEN_TEMPLATE_NAME() { return getToken(Uppaal2CParser.OPEN_TEMPLATE_NAME, 0); }
		public TerminalNode ID() { return getToken(Uppaal2CParser.ID, 0); }
		public TerminalNode CLOSE_TEMPLATE_NAME() { return getToken(Uppaal2CParser.CLOSE_TEMPLATE_NAME, 0); }
		public NameSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterNameSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitNameSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitNameSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameSectionContext nameSection() throws RecognitionException {
		NameSectionContext _localctx = new NameSectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nameSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(OPEN_TEMPLATE_NAME);
			setState(181);
			match(ID);
			setState(182);
			match(CLOSE_TEMPLATE_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SystemContext extends ParserRuleContext {
		public TerminalNode OPEN_SYSTEM() { return getToken(Uppaal2CParser.OPEN_SYSTEM, 0); }
		public List<TerminalNode> ID() { return getTokens(Uppaal2CParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2CParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(Uppaal2CParser.SEMICOLON, 0); }
		public TerminalNode CLOSE_SYSTEM() { return getToken(Uppaal2CParser.CLOSE_SYSTEM, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2CParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2CParser.COMMA, i);
		}
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitSystem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitSystem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemContext system() throws RecognitionException {
		SystemContext _localctx = new SystemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_system);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(OPEN_SYSTEM);
			setState(185);
			match(T__0);
			setState(186);
			match(ID);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(187);
					match(COMMA);
					setState(188);
					match(ID);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(194);
			match(SEMICOLON);
			setState(195);
			match(CLOSE_SYSTEM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueriesContext extends ParserRuleContext {
		public TerminalNode OPEN_QUERIES() { return getToken(Uppaal2CParser.OPEN_QUERIES, 0); }
		public TerminalNode CLOSE_QUERIES() { return getToken(Uppaal2CParser.CLOSE_QUERIES, 0); }
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public QueriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterQueries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitQueries(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitQueries(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueriesContext queries() throws RecognitionException {
		QueriesContext _localctx = new QueriesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_queries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(OPEN_QUERIES);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_QUERY) {
				{
				{
				setState(198);
				query();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			match(CLOSE_QUERIES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationContext extends ParserRuleContext {
		public TerminalNode OPEN_LOCATION() { return getToken(Uppaal2CParser.OPEN_LOCATION, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(Uppaal2CParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(Uppaal2CParser.EQUAL, i);
		}
		public List<TerminalNode> STRING() { return getTokens(Uppaal2CParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(Uppaal2CParser.STRING, i);
		}
		public TerminalNode GT() { return getToken(Uppaal2CParser.GT, 0); }
		public TerminalNode CLOSE_LOCATION() { return getToken(Uppaal2CParser.CLOSE_LOCATION, 0); }
		public NameSectionContext nameSection() {
			return getRuleContext(NameSectionContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_location);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(OPEN_LOCATION);
			setState(207);
			match(T__1);
			setState(208);
			match(EQUAL);
			setState(209);
			match(STRING);
			setState(210);
			match(T__2);
			setState(211);
			match(EQUAL);
			setState(212);
			match(STRING);
			setState(213);
			match(T__3);
			setState(214);
			match(EQUAL);
			setState(215);
			match(STRING);
			setState(216);
			match(GT);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_TEMPLATE_NAME) {
				{
				setState(217);
				nameSection();
				}
			}

			setState(220);
			match(CLOSE_LOCATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InItLocationContext extends ParserRuleContext {
		public TerminalNode INIT() { return getToken(Uppaal2CParser.INIT, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2CParser.STRING, 0); }
		public TerminalNode CLOSE_SOURCE_TARGET() { return getToken(Uppaal2CParser.CLOSE_SOURCE_TARGET, 0); }
		public InItLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inItLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterInItLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitInItLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitInItLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InItLocationContext inItLocation() throws RecognitionException {
		InItLocationContext _localctx = new InItLocationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inItLocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(INIT);
			setState(223);
			match(STRING);
			setState(224);
			match(CLOSE_SOURCE_TARGET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TransitionContext extends ParserRuleContext {
		public TerminalNode OPEN_TRANSITION() { return getToken(Uppaal2CParser.OPEN_TRANSITION, 0); }
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode CLOSE_TRANSITION() { return getToken(Uppaal2CParser.CLOSE_TRANSITION, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_transition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(OPEN_TRANSITION);
			setState(227);
			source();
			setState(228);
			target();
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(229);
				comment();
				}
				break;
			}
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(234);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OPEN_LABEL:
						{
						setState(232);
						label();
						}
						break;
					case UPPAAL_COMMENT_WITH_TEXT:
					case UPPAAL_COMMENT:
						{
						setState(233);
						comment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(239);
			match(CLOSE_TRANSITION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode OPEN_LABEL() { return getToken(Uppaal2CParser.OPEN_LABEL, 0); }
		public TerminalNode GT() { return getToken(Uppaal2CParser.GT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_LABEL() { return getToken(Uppaal2CParser.CLOSE_LABEL, 0); }
		public TerminalNode EQUAL() { return getToken(Uppaal2CParser.EQUAL, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2CParser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(OPEN_LABEL);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(242);
				match(T__4);
				setState(243);
				match(EQUAL);
				setState(244);
				match(STRING);
				}
			}

			setState(247);
			match(GT);
			setState(248);
			expression();
			setState(249);
			match(CLOSE_LABEL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(Uppaal2CParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2CParser.ID, i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Uppaal2CParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Uppaal2CParser.LBRACK, i);
		}
		public List<TerminalNode> INT() { return getTokens(Uppaal2CParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(Uppaal2CParser.INT, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Uppaal2CParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Uppaal2CParser.RBRACK, i);
		}
		public List<TerminalNode> EQEQ() { return getTokens(Uppaal2CParser.EQEQ); }
		public TerminalNode EQEQ(int i) {
			return getToken(Uppaal2CParser.EQEQ, i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(Uppaal2CParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(Uppaal2CParser.EQUAL, i);
		}
		public List<TerminalNode> GE() { return getTokens(Uppaal2CParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(Uppaal2CParser.GE, i);
		}
		public List<TerminalNode> AND() { return getTokens(Uppaal2CParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(Uppaal2CParser.AND, i);
		}
		public List<TerminalNode> LT_TAG() { return getTokens(Uppaal2CParser.LT_TAG); }
		public TerminalNode LT_TAG(int i) {
			return getToken(Uppaal2CParser.LT_TAG, i);
		}
		public List<TerminalNode> GT_TAG() { return getTokens(Uppaal2CParser.GT_TAG); }
		public TerminalNode GT_TAG(int i) {
			return getToken(Uppaal2CParser.GT_TAG, i);
		}
		public List<TerminalNode> PLUSPLUS() { return getTokens(Uppaal2CParser.PLUSPLUS); }
		public TerminalNode PLUSPLUS(int i) {
			return getToken(Uppaal2CParser.PLUSPLUS, i);
		}
		public List<TerminalNode> MINUSMINUS() { return getTokens(Uppaal2CParser.MINUSMINUS); }
		public TerminalNode MINUSMINUS(int i) {
			return getToken(Uppaal2CParser.MINUSMINUS, i);
		}
		public List<TerminalNode> MINUSEQUAL() { return getTokens(Uppaal2CParser.MINUSEQUAL); }
		public TerminalNode MINUSEQUAL(int i) {
			return getToken(Uppaal2CParser.MINUSEQUAL, i);
		}
		public List<TerminalNode> PLUSEQUAL() { return getTokens(Uppaal2CParser.PLUSEQUAL); }
		public TerminalNode PLUSEQUAL(int i) {
			return getToken(Uppaal2CParser.PLUSEQUAL, i);
		}
		public List<TerminalNode> EQUALMINUS() { return getTokens(Uppaal2CParser.EQUALMINUS); }
		public TerminalNode EQUALMINUS(int i) {
			return getToken(Uppaal2CParser.EQUALMINUS, i);
		}
		public List<TerminalNode> EQUALPLUS() { return getTokens(Uppaal2CParser.EQUALPLUS); }
		public TerminalNode EQUALPLUS(int i) {
			return getToken(Uppaal2CParser.EQUALPLUS, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(Uppaal2CParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(Uppaal2CParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(Uppaal2CParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(Uppaal2CParser.RPAREN, i);
		}
		public List<TerminalNode> NOTEQ() { return getTokens(Uppaal2CParser.NOTEQ); }
		public TerminalNode NOTEQ(int i) {
			return getToken(Uppaal2CParser.NOTEQ, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2CParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2CParser.COMMA, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(Uppaal2CParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(Uppaal2CParser.PLUS, i);
		}
		public List<TerminalNode> STRING() { return getTokens(Uppaal2CParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(Uppaal2CParser.STRING, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(Uppaal2CParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(Uppaal2CParser.PERCENT, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(Uppaal2CParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(Uppaal2CParser.SLASH, i);
		}
		public List<TerminalNode> HEX_INT() { return getTokens(Uppaal2CParser.HEX_INT); }
		public TerminalNode HEX_INT(int i) {
			return getToken(Uppaal2CParser.HEX_INT, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(Uppaal2CParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(Uppaal2CParser.MINUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						setState(251);
						match(ID);
						setState(253);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
						case 1:
							{
							setState(252);
							match(ID);
							}
							break;
						}
						setState(258);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LBRACK) {
							{
							setState(255);
							match(LBRACK);
							setState(256);
							match(INT);
							setState(257);
							match(RBRACK);
							}
						}

						setState(296);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
						case 1:
							{
							setState(260);
							match(EQEQ);
							}
							break;
						case 2:
							{
							setState(261);
							match(EQUAL);
							}
							break;
						case 3:
							{
							setState(262);
							match(GE);
							}
							break;
						case 4:
							{
							setState(263);
							match(AND);
							}
							break;
						case 5:
							{
							setState(264);
							match(LT_TAG);
							}
							break;
						case 6:
							{
							setState(265);
							match(GT_TAG);
							}
							break;
						case 7:
							{
							setState(266);
							match(PLUSPLUS);
							}
							break;
						case 8:
							{
							setState(267);
							match(MINUSMINUS);
							}
							break;
						case 9:
							{
							setState(268);
							match(MINUSEQUAL);
							}
							break;
						case 10:
							{
							setState(269);
							match(PLUSEQUAL);
							}
							break;
						case 11:
							{
							setState(270);
							match(EQUALMINUS);
							}
							break;
						case 12:
							{
							setState(271);
							match(EQUALPLUS);
							}
							break;
						case 13:
							{
							setState(272);
							match(LPAREN);
							setState(290);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
							while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1+1 ) {
									{
									{
									setState(283);
									_errHandler.sync(this);
									switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
									case 1:
										{
										setState(273);
										match(HEX_INT);
										}
										break;
									case 2:
										{
										{
										setState(274);
										match(ID);
										setState(275);
										match(MINUS);
										setState(276);
										match(LPAREN);
										setState(277);
										match(ID);
										setState(278);
										match(MINUS);
										setState(279);
										match(ID);
										setState(280);
										match(RPAREN);
										}
										}
										break;
									case 3:
										{
										setState(281);
										match(ID);
										}
										break;
									case 4:
										{
										setState(282);
										match(INT);
										}
										break;
									}
									setState(286);
									_errHandler.sync(this);
									_la = _input.LA(1);
									if (_la==COMMA) {
										{
										setState(285);
										match(COMMA);
										}
									}

									}
									} 
								}
								setState(292);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
							}
							setState(293);
							match(RPAREN);
							}
							break;
						case 14:
							{
							setState(294);
							match(NOTEQ);
							}
							break;
						case 15:
							{
							setState(295);
							match(PLUSPLUS);
							}
							break;
						}
						setState(327);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
						case 1:
							{
							{
							setState(299);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LPAREN) {
								{
								setState(298);
								match(LPAREN);
								}
							}

							setState(301);
							match(ID);
							setState(302);
							_la = _input.LA(1);
							if ( !(_la==SLASH || _la==PERCENT) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(303);
							match(INT);
							setState(305);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==RPAREN) {
								{
								setState(304);
								match(RPAREN);
								}
							}

							setState(308);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==SLASH) {
								{
								setState(307);
								match(SLASH);
								}
							}

							setState(311);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==INT) {
								{
								setState(310);
								match(INT);
								}
							}

							setState(313);
							match(PLUS);
							setState(314);
							match(STRING);
							}
							}
							break;
						case 2:
							{
							{
							setState(315);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 201330688L) != 0)) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
							}
							break;
						case 3:
							{
							{
							setState(316);
							match(ID);
							setState(317);
							match(PLUS);
							setState(318);
							match(INT);
							}
							}
							break;
						case 4:
							{
							setState(319);
							match(ID);
							}
							break;
						case 5:
							{
							setState(320);
							match(INT);
							}
							break;
						case 6:
							{
							setState(321);
							match(ID);
							setState(322);
							match(LPAREN);
							setState(324);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==ID) {
								{
								setState(323);
								match(ID);
								}
							}

							setState(326);
							match(RPAREN);
							}
							break;
						}
						setState(330);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(329);
							match(COMMA);
							}
						}

						}
						break;
					case 2:
						{
						setState(332);
						comment();
						}
						break;
					case 3:
						{
						{
						setState(333);
						match(ID);
						setState(334);
						operator();
						setState(335);
						match(ID);
						setState(337);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(336);
							match(COMMA);
							}
						}

						}
						}
						break;
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(Uppaal2CParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Uppaal2CParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(Uppaal2CParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(Uppaal2CParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(Uppaal2CParser.PERCENT, 0); }
		public TerminalNode LT() { return getToken(Uppaal2CParser.LT, 0); }
		public TerminalNode GT() { return getToken(Uppaal2CParser.GT, 0); }
		public TerminalNode LE() { return getToken(Uppaal2CParser.LE, 0); }
		public TerminalNode GE() { return getToken(Uppaal2CParser.GE, 0); }
		public TerminalNode EQEQ() { return getToken(Uppaal2CParser.EQEQ, 0); }
		public TerminalNode NOTEQ() { return getToken(Uppaal2CParser.NOTEQ, 0); }
		public TerminalNode AND() { return getToken(Uppaal2CParser.AND, 0); }
		public TerminalNode OR() { return getToken(Uppaal2CParser.OR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 436840539560607744L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceContext extends ParserRuleContext {
		public TerminalNode OPEN_SOURCE() { return getToken(Uppaal2CParser.OPEN_SOURCE, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2CParser.STRING, 0); }
		public TerminalNode CLOSE_SOURCE_TARGET() { return getToken(Uppaal2CParser.CLOSE_SOURCE_TARGET, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(OPEN_SOURCE);
			setState(347);
			match(STRING);
			setState(348);
			match(CLOSE_SOURCE_TARGET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TargetContext extends ParserRuleContext {
		public TerminalNode OPEN_TARGET() { return getToken(Uppaal2CParser.OPEN_TARGET, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2CParser.STRING, 0); }
		public TerminalNode CLOSE_SOURCE_TARGET() { return getToken(Uppaal2CParser.CLOSE_SOURCE_TARGET, 0); }
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(OPEN_TARGET);
			setState(351);
			match(STRING);
			setState(352);
			match(CLOSE_SOURCE_TARGET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryContext extends ParserRuleContext {
		public TerminalNode OPEN_QUERY() { return getToken(Uppaal2CParser.OPEN_QUERY, 0); }
		public TerminalNode OPEN_FORMULA() { return getToken(Uppaal2CParser.OPEN_FORMULA, 0); }
		public TerminalNode CLOSE_FORMULA() { return getToken(Uppaal2CParser.CLOSE_FORMULA, 0); }
		public TerminalNode OPEN_COMMENT() { return getToken(Uppaal2CParser.OPEN_COMMENT, 0); }
		public TerminalNode CLOSE_COMMENT() { return getToken(Uppaal2CParser.CLOSE_COMMENT, 0); }
		public TerminalNode CLOSE_QUERY() { return getToken(Uppaal2CParser.CLOSE_QUERY, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(OPEN_QUERY);
			setState(355);
			match(OPEN_FORMULA);
			setState(356);
			match(CLOSE_FORMULA);
			setState(357);
			match(OPEN_COMMENT);
			setState(358);
			match(CLOSE_COMMENT);
			setState(359);
			match(CLOSE_QUERY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode UPPAAL_COMMENT_WITH_TEXT() { return getToken(Uppaal2CParser.UPPAAL_COMMENT_WITH_TEXT, 0); }
		public TerminalNode UPPAAL_COMMENT() { return getToken(Uppaal2CParser.UPPAAL_COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2CListener ) ((Uppaal2CListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2CVisitor ) return ((Uppaal2CVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if ( !(_la==UPPAAL_COMMENT_WITH_TEXT || _la==UPPAAL_COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001P\u016c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u00016\b\u0001\u000b\u0001"+
		"\f\u00017\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002=\b\u0002\u000b"+
		"\u0002\f\u0002>\u0001\u0002\u0004\u0002B\b\u0002\u000b\u0002\f\u0002C"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002I\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0004\u0003M\b\u0003\u000b\u0003\f\u0003N\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004V\b\u0004\u0001"+
		"\u0005\u0003\u0005Y\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005`\b\u0005\u0001\u0005\u0003\u0005c\b\u0005"+
		"\u0001\u0005\u0003\u0005f\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"j\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006r\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006y\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0080\b\u0007\n\u0007"+
		"\f\u0007\u0083\t\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u0089\b"+
		"\t\u0001\t\u0001\t\u0003\t\u008d\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u0093\b\t\n\t\f\t\u0096\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n"+
		"\u009c\b\n\u0001\n\u0003\n\u009f\b\n\u0001\n\u0003\n\u00a2\b\n\u0001\n"+
		"\u0001\n\u0003\n\u00a6\b\n\u0001\n\u0003\n\u00a9\b\n\u0001\n\u0003\n\u00ac"+
		"\b\n\u0005\n\u00ae\b\n\n\n\f\n\u00b1\t\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00be\b\f\n\f\f\f\u00c1\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0005\r\u00c8\b\r\n\r\f\r\u00cb\t\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00db"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00e7"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00eb\b\u0010\n\u0010\f\u0010"+
		"\u00ee\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00f6\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u00fe\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0103\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u011c\b\u0012\u0001\u0012"+
		"\u0003\u0012\u011f\b\u0012\u0005\u0012\u0121\b\u0012\n\u0012\f\u0012\u0124"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0129\b\u0012"+
		"\u0001\u0012\u0003\u0012\u012c\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u0132\b\u0012\u0001\u0012\u0003\u0012\u0135\b"+
		"\u0012\u0001\u0012\u0003\u0012\u0138\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0145\b\u0012\u0001\u0012\u0003"+
		"\u0012\u0148\b\u0012\u0001\u0012\u0003\u0012\u014b\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0152\b\u0012"+
		"\u0005\u0012\u0154\b\u0012\n\u0012\f\u0012\u0157\t\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u00af\u00bf\u00ec\u0122\u0155\u0000\u0018\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.\u0000\u0006\u0001\u0000\n\u000b\u0002\u0000\n\n\f\f\u0001\u0000"+
		",-\u0002\u0000\f\f\u001a\u001b\u0004\u0000##%%+39:\u0001\u0000\u0006\u0007"+
		"\u01a0\u00000\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u0004"+
		"H\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\bU\u0001\u0000"+
		"\u0000\u0000\nX\u0001\u0000\u0000\u0000\fm\u0001\u0000\u0000\u0000\u000e"+
		"|\u0001\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012\u0086"+
		"\u0001\u0000\u0000\u0000\u0014\u0099\u0001\u0000\u0000\u0000\u0016\u00b4"+
		"\u0001\u0000\u0000\u0000\u0018\u00b8\u0001\u0000\u0000\u0000\u001a\u00c5"+
		"\u0001\u0000\u0000\u0000\u001c\u00ce\u0001\u0000\u0000\u0000\u001e\u00de"+
		"\u0001\u0000\u0000\u0000 \u00e2\u0001\u0000\u0000\u0000\"\u00f1\u0001"+
		"\u0000\u0000\u0000$\u0155\u0001\u0000\u0000\u0000&\u0158\u0001\u0000\u0000"+
		"\u0000(\u015a\u0001\u0000\u0000\u0000*\u015e\u0001\u0000\u0000\u0000,"+
		"\u0162\u0001\u0000\u0000\u0000.\u0169\u0001\u0000\u0000\u000001\u0003"+
		"\u0002\u0001\u000012\u0005\u0000\u0000\u00012\u0001\u0001\u0000\u0000"+
		"\u000035\u0005;\u0000\u000046\u0003\u0004\u0002\u000054\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u00009:\u0005<\u0000\u0000:\u0003\u0001"+
		"\u0000\u0000\u0000;=\u0003\u0006\u0003\u0000<;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?I\u0001\u0000\u0000\u0000@B\u0003\u0012\t\u0000A@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DI\u0001\u0000\u0000\u0000EI\u0003\u0018\f\u0000FI\u0003\u001a"+
		"\r\u0000GI\u0003.\u0017\u0000H<\u0001\u0000\u0000\u0000HA\u0001\u0000"+
		"\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001"+
		"\u0000\u0000\u0000I\u0005\u0001\u0000\u0000\u0000JL\u0005\u0013\u0000"+
		"\u0000KM\u0003\b\u0004\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PQ\u0005=\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000RV\u0003"+
		"\n\u0005\u0000SV\u0003\f\u0006\u0000TV\u0003.\u0017\u0000UR\u0001\u0000"+
		"\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000V\t\u0001"+
		"\u0000\u0000\u0000WY\u0005\t\u0000\u0000XW\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005\u000b\u0000\u0000"+
		"[b\u0005\f\u0000\u0000\\]\u0005\r\u0000\u0000]_\u0005\u001c\u0000\u0000"+
		"^`\u0005\b\u0000\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000ac\u0005\u000e\u0000\u0000b\\\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000df\u0005\u001a"+
		"\u0000\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fi\u0001"+
		"\u0000\u0000\u0000gj\u0005\f\u0000\u0000hj\u0005\u001c\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000kl\u0005\u001f\u0000\u0000l\u000b\u0001\u0000"+
		"\u0000\u0000mn\u0007\u0000\u0000\u0000no\u0005\f\u0000\u0000oq\u0005\u000f"+
		"\u0000\u0000pr\u0003\u000e\u0007\u0000qp\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005\u0010\u0000\u0000"+
		"tx\u0005\u0011\u0000\u0000uv\u0003$\u0012\u0000vw\u0005\u001f\u0000\u0000"+
		"wy\u0001\u0000\u0000\u0000xu\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u0012\u0000\u0000{\r\u0001\u0000"+
		"\u0000\u0000|\u0081\u0003\u0010\b\u0000}~\u0005!\u0000\u0000~\u0080\u0003"+
		"\u0010\b\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000"+
		"\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0007\u0001\u0000\u0000\u0085\u0011\u0001\u0000"+
		"\u0000\u0000\u0086\u0088\u0005\u0014\u0000\u0000\u0087\u0089\u0003.\u0017"+
		"\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008c\u0003\u0016\u000b"+
		"\u0000\u008b\u008d\u0003\u0014\n\u0000\u008c\u008b\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0094\u0001\u0000\u0000\u0000"+
		"\u008e\u0093\u0003\u001c\u000e\u0000\u008f\u0093\u0005\u001e\u0000\u0000"+
		"\u0090\u0093\u0003 \u0010\u0000\u0091\u0093\u0003.\u0017\u0000\u0092\u008e"+
		"\u0001\u0000\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0096"+
		"\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0094"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005?\u0000\u0000\u0098\u0013\u0001"+
		"\u0000\u0000\u0000\u0099\u009b\u0005\u0017\u0000\u0000\u009a\u009c\u0005"+
		"\t\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u009f\u0007\u0000"+
		"\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000"+
		"\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u00a2\u0005\f\u0000"+
		"\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00af\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005!\u0000\u0000"+
		"\u00a4\u00a6\u0005\t\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a9\u0007\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ac\u0005\f\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00a3"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0005\u0018\u0000\u0000\u00b3\u0015\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0005\u0015\u0000\u0000\u00b5\u00b6\u0005\f\u0000\u0000\u00b6\u00b7\u0005"+
		"\u0016\u0000\u0000\u00b7\u0017\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005"+
		"@\u0000\u0000\u00b9\u00ba\u0005\u0001\u0000\u0000\u00ba\u00bf\u0005\f"+
		"\u0000\u0000\u00bb\u00bc\u0005!\u0000\u0000\u00bc\u00be\u0005\f\u0000"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005\u001f\u0000\u0000\u00c3\u00c4\u0005A\u0000\u0000"+
		"\u00c4\u0019\u0001\u0000\u0000\u0000\u00c5\u00c9\u0005B\u0000\u0000\u00c6"+
		"\u00c8\u0003,\u0016\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u00cb"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005C\u0000\u0000\u00cd\u001b\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0005\u0019\u0000\u0000\u00cf\u00d0\u0005"+
		"\u0002\u0000\u0000\u00d0\u00d1\u0005\u001a\u0000\u0000\u00d1\u00d2\u0005"+
		"\u001b\u0000\u0000\u00d2\u00d3\u0005\u0003\u0000\u0000\u00d3\u00d4\u0005"+
		"\u001a\u0000\u0000\u00d4\u00d5\u0005\u001b\u0000\u0000\u00d5\u00d6\u0005"+
		"\u0004\u0000\u0000\u00d6\u00d7\u0005\u001a\u0000\u0000\u00d7\u00d8\u0005"+
		"\u001b\u0000\u0000\u00d8\u00da\u0005/\u0000\u0000\u00d9\u00db\u0003\u0016"+
		"\u000b\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005\u001d"+
		"\u0000\u0000\u00dd\u001d\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u001e"+
		"\u0000\u0000\u00df\u00e0\u0005\u001b\u0000\u0000\u00e0\u00e1\u0005>\u0000"+
		"\u0000\u00e1\u001f\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005D\u0000\u0000"+
		"\u00e3\u00e4\u0003(\u0014\u0000\u00e4\u00e6\u0003*\u0015\u0000\u00e5\u00e7"+
		"\u0003.\u0017\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e7\u00ec\u0001\u0000\u0000\u0000\u00e8\u00eb\u0003"+
		"\"\u0011\u0000\u00e9\u00eb\u0003.\u0017\u0000\u00ea\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0005E\u0000\u0000\u00f0!\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f5\u0005F\u0000\u0000\u00f2\u00f3\u0005\u0005\u0000\u0000\u00f3"+
		"\u00f4\u0005\u001a\u0000\u0000\u00f4\u00f6\u0005\u001b\u0000\u0000\u00f5"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005/\u0000\u0000\u00f8\u00f9"+
		"\u0003$\u0012\u0000\u00f9\u00fa\u0005G\u0000\u0000\u00fa#\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fd\u0005\f\u0000\u0000\u00fc\u00fe\u0005\f\u0000"+
		"\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fe\u0102\u0001\u0000\u0000\u0000\u00ff\u0100\u0005\r\u0000\u0000"+
		"\u0100\u0101\u0005\u001c\u0000\u0000\u0101\u0103\u0005\u000e\u0000\u0000"+
		"\u0102\u00ff\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000"+
		"\u0103\u0128\u0001\u0000\u0000\u0000\u0104\u0129\u00052\u0000\u0000\u0105"+
		"\u0129\u0005\u001a\u0000\u0000\u0106\u0129\u00051\u0000\u0000\u0107\u0129"+
		"\u00059\u0000\u0000\u0108\u0129\u00057\u0000\u0000\u0109\u0129\u00058"+
		"\u0000\u0000\u010a\u0129\u0005$\u0000\u0000\u010b\u0129\u0005&\u0000\u0000"+
		"\u010c\u0129\u0005\'\u0000\u0000\u010d\u0129\u0005(\u0000\u0000\u010e"+
		"\u0129\u0005)\u0000\u0000\u010f\u0129\u0005*\u0000\u0000\u0110\u0122\u0005"+
		"\u000f\u0000\u0000\u0111\u011c\u00056\u0000\u0000\u0112\u0113\u0005\f"+
		"\u0000\u0000\u0113\u0114\u0005%\u0000\u0000\u0114\u0115\u0005\u000f\u0000"+
		"\u0000\u0115\u0116\u0005\f\u0000\u0000\u0116\u0117\u0005%\u0000\u0000"+
		"\u0117\u0118\u0005\f\u0000\u0000\u0118\u011c\u0005\u0010\u0000\u0000\u0119"+
		"\u011c\u0005\f\u0000\u0000\u011a\u011c\u0005\u001c\u0000\u0000\u011b\u0111"+
		"\u0001\u0000\u0000\u0000\u011b\u0112\u0001\u0000\u0000\u0000\u011b\u0119"+
		"\u0001\u0000\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c\u011e"+
		"\u0001\u0000\u0000\u0000\u011d\u011f\u0005!\u0000\u0000\u011e\u011d\u0001"+
		"\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0121\u0001"+
		"\u0000\u0000\u0000\u0120\u011b\u0001\u0000\u0000\u0000\u0121\u0124\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u0122\u0001"+
		"\u0000\u0000\u0000\u0125\u0129\u0005\u0010\u0000\u0000\u0126\u0129\u0005"+
		"3\u0000\u0000\u0127\u0129\u0005$\u0000\u0000\u0128\u0104\u0001\u0000\u0000"+
		"\u0000\u0128\u0105\u0001\u0000\u0000\u0000\u0128\u0106\u0001\u0000\u0000"+
		"\u0000\u0128\u0107\u0001\u0000\u0000\u0000\u0128\u0108\u0001\u0000\u0000"+
		"\u0000\u0128\u0109\u0001\u0000\u0000\u0000\u0128\u010a\u0001\u0000\u0000"+
		"\u0000\u0128\u010b\u0001\u0000\u0000\u0000\u0128\u010c\u0001\u0000\u0000"+
		"\u0000\u0128\u010d\u0001\u0000\u0000\u0000\u0128\u010e\u0001\u0000\u0000"+
		"\u0000\u0128\u010f\u0001\u0000\u0000\u0000\u0128\u0110\u0001\u0000\u0000"+
		"\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0127\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u0147\u0001\u0000\u0000"+
		"\u0000\u012a\u012c\u0005\u000f\u0000\u0000\u012b\u012a\u0001\u0000\u0000"+
		"\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0005\f\u0000\u0000\u012e\u012f\u0007\u0002\u0000\u0000"+
		"\u012f\u0131\u0005\u001c\u0000\u0000\u0130\u0132\u0005\u0010\u0000\u0000"+
		"\u0131\u0130\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000"+
		"\u0132\u0134\u0001\u0000\u0000\u0000\u0133\u0135\u0005,\u0000\u0000\u0134"+
		"\u0133\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0137\u0001\u0000\u0000\u0000\u0136\u0138\u0005\u001c\u0000\u0000\u0137"+
		"\u0136\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138"+
		"\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0005#\u0000\u0000\u013a\u0148"+
		"\u0005\u001b\u0000\u0000\u013b\u0148\u0007\u0003\u0000\u0000\u013c\u013d"+
		"\u0005\f\u0000\u0000\u013d\u013e\u0005#\u0000\u0000\u013e\u0148\u0005"+
		"\u001c\u0000\u0000\u013f\u0148\u0005\f\u0000\u0000\u0140\u0148\u0005\u001c"+
		"\u0000\u0000\u0141\u0142\u0005\f\u0000\u0000\u0142\u0144\u0005\u000f\u0000"+
		"\u0000\u0143\u0145\u0005\f\u0000\u0000\u0144\u0143\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000"+
		"\u0146\u0148\u0005\u0010\u0000\u0000\u0147\u012b\u0001\u0000\u0000\u0000"+
		"\u0147\u013b\u0001\u0000\u0000\u0000\u0147\u013c\u0001\u0000\u0000\u0000"+
		"\u0147\u013f\u0001\u0000\u0000\u0000\u0147\u0140\u0001\u0000\u0000\u0000"+
		"\u0147\u0141\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000"+
		"\u0148\u014a\u0001\u0000\u0000\u0000\u0149\u014b\u0005!\u0000\u0000\u014a"+
		"\u0149\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b"+
		"\u0154\u0001\u0000\u0000\u0000\u014c\u0154\u0003.\u0017\u0000\u014d\u014e"+
		"\u0005\f\u0000\u0000\u014e\u014f\u0003&\u0013\u0000\u014f\u0151\u0005"+
		"\f\u0000\u0000\u0150\u0152\u0005!\u0000\u0000\u0151\u0150\u0001\u0000"+
		"\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0154\u0001\u0000"+
		"\u0000\u0000\u0153\u00fb\u0001\u0000\u0000\u0000\u0153\u014c\u0001\u0000"+
		"\u0000\u0000\u0153\u014d\u0001\u0000\u0000\u0000\u0154\u0157\u0001\u0000"+
		"\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000"+
		"\u0000\u0000\u0156%\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000"+
		"\u0000\u0158\u0159\u0007\u0004\u0000\u0000\u0159\'\u0001\u0000\u0000\u0000"+
		"\u015a\u015b\u0005H\u0000\u0000\u015b\u015c\u0005\u001b\u0000\u0000\u015c"+
		"\u015d\u0005>\u0000\u0000\u015d)\u0001\u0000\u0000\u0000\u015e\u015f\u0005"+
		"I\u0000\u0000\u015f\u0160\u0005\u001b\u0000\u0000\u0160\u0161\u0005>\u0000"+
		"\u0000\u0161+\u0001\u0000\u0000\u0000\u0162\u0163\u0005J\u0000\u0000\u0163"+
		"\u0164\u0005L\u0000\u0000\u0164\u0165\u0005M\u0000\u0000\u0165\u0166\u0005"+
		"N\u0000\u0000\u0166\u0167\u0005O\u0000\u0000\u0167\u0168\u0005K\u0000"+
		"\u0000\u0168-\u0001\u0000\u0000\u0000\u0169\u016a\u0007\u0005\u0000\u0000"+
		"\u016a/\u0001\u0000\u0000\u000007>CHNUX_beiqx\u0081\u0088\u008c\u0092"+
		"\u0094\u009b\u009e\u00a1\u00a5\u00a8\u00ab\u00af\u00bf\u00c9\u00da\u00e6"+
		"\u00ea\u00ec\u00f5\u00fd\u0102\u011b\u011e\u0122\u0128\u012b\u0131\u0134"+
		"\u0137\u0144\u0147\u014a\u0151\u0153\u0155";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}