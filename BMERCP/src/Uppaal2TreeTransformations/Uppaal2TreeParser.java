// Generated from Uppaal2Tree.g4 by ANTLR 4.13.1

package Uppaal2TreeTransformations;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Uppaal2TreeParser extends Parser {
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
		RULE_op = 19, RULE_rightSide = 20, RULE_operator = 21, RULE_complex = 22, 
		RULE_source = 23, RULE_target = 24, RULE_query = 25, RULE_comment = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "ntaSection", "ntaItem", "declaration", "declarationItem", "declarationVar", 
			"declarationFunc", "parameterList", "parameter", "template", "templateParameter", 
			"nameSection", "system", "queries", "location", "inItLocation", "transition", 
			"label", "expression", "op", "rightSide", "operator", "complex", "source", 
			"target", "query", "comment"
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
	public String getGrammarFileName() { return "Uppaal2Tree.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Uppaal2TreeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Uppaal2TreeParser.EOF, 0); }
		public NtaSectionContext ntaSection() {
			return getRuleContext(NtaSectionContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitFile(this);
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
			setState(54);
			ntaSection();
			}
			setState(55);
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
		public TerminalNode NTA_OPEN() { return getToken(Uppaal2TreeParser.NTA_OPEN, 0); }
		public TerminalNode NTA_CLOSE() { return getToken(Uppaal2TreeParser.NTA_CLOSE, 0); }
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
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterNtaSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitNtaSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitNtaSection(this);
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
			setState(57);
			match(NTA_OPEN);
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				ntaItem();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 1441151880758583299L) != 0) );
			setState(63);
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
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterNtaItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitNtaItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitNtaItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NtaItemContext ntaItem() throws RecognitionException {
		NtaItemContext _localctx = new NtaItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ntaItem);
		try {
			int _alt;
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_DECLARATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(66); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(65);
						declaration();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(68); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case OPEN_TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(71); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(70);
						template();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(73); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case OPEN_SYSTEM:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				system();
				}
				break;
			case OPEN_QUERIES:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				queries();
				}
				break;
			case UPPAAL_COMMENT_WITH_TEXT:
			case UPPAAL_COMMENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
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
		public TerminalNode OPEN_DECLARATION() { return getToken(Uppaal2TreeParser.OPEN_DECLARATION, 0); }
		public TerminalNode CLOSE_DECLARATION() { return getToken(Uppaal2TreeParser.CLOSE_DECLARATION, 0); }
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
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitDeclaration(this);
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
			setState(80);
			match(OPEN_DECLARATION);
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				declarationItem();
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3776L) != 0) );
			setState(86);
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
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterDeclarationItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitDeclarationItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitDeclarationItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationItemContext declarationItem() throws RecognitionException {
		DeclarationItemContext _localctx = new DeclarationItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationItem);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				declarationVar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				declarationFunc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
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
		public TerminalNode DATATYPE() { return getToken(Uppaal2TreeParser.DATATYPE, 0); }
		public List<TerminalNode> ID() { return getTokens(Uppaal2TreeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2TreeParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(Uppaal2TreeParser.SEMICOLON, 0); }
		public TerminalNode CONST() { return getToken(Uppaal2TreeParser.CONST, 0); }
		public TerminalNode LBRACK() { return getToken(Uppaal2TreeParser.LBRACK, 0); }
		public List<TerminalNode> INT() { return getTokens(Uppaal2TreeParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(Uppaal2TreeParser.INT, i);
		}
		public TerminalNode RBRACK() { return getToken(Uppaal2TreeParser.RBRACK, 0); }
		public TerminalNode EQUAL() { return getToken(Uppaal2TreeParser.EQUAL, 0); }
		public TerminalNode ARRAY_SV() { return getToken(Uppaal2TreeParser.ARRAY_SV, 0); }
		public DeclarationVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterDeclarationVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitDeclarationVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitDeclarationVar(this);
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
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(93);
				match(CONST);
				}
			}

			setState(96);
			match(DATATYPE);
			setState(97);
			match(ID);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(98);
				match(LBRACK);
				setState(99);
				match(INT);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARRAY_SV) {
					{
					setState(100);
					match(ARRAY_SV);
					}
				}

				setState(103);
				match(RBRACK);
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(106);
				match(EQUAL);
				}
			}

			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(109);
				((DeclarationVarContext)_localctx).initValue = match(ID);
				}
				break;
			case INT:
				{
				setState(110);
				((DeclarationVarContext)_localctx).initValue = match(INT);
				}
				break;
			case SEMICOLON:
				break;
			default:
				break;
			}
			setState(113);
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
		public TerminalNode ID() { return getToken(Uppaal2TreeParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(Uppaal2TreeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Uppaal2TreeParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(Uppaal2TreeParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Uppaal2TreeParser.RBRACE, 0); }
		public TerminalNode DATATYPE() { return getToken(Uppaal2TreeParser.DATATYPE, 0); }
		public TerminalNode VOID() { return getToken(Uppaal2TreeParser.VOID, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Uppaal2TreeParser.SEMICOLON, 0); }
		public DeclarationFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterDeclarationFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitDeclarationFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitDeclarationFunc(this);
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
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==DATATYPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(116);
			match(ID);
			setState(117);
			match(LPAREN);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOID || _la==ID) {
				{
				setState(118);
				parameterList();
				}
			}

			setState(121);
			match(RPAREN);
			setState(122);
			match(LBRACE);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID || _la==SEMICOLON) {
				{
				setState(123);
				expression();
				setState(124);
				match(SEMICOLON);
				}
			}

			setState(128);
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
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2TreeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2TreeParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitParameterList(this);
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
			setState(130);
			parameter();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(131);
				match(COMMA);
				setState(132);
				parameter();
				}
				}
				setState(137);
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
		public TerminalNode ID() { return getToken(Uppaal2TreeParser.ID, 0); }
		public TerminalNode VOID() { return getToken(Uppaal2TreeParser.VOID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitParameter(this);
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
			setState(138);
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
		public TerminalNode OPEN_TEMPLATE() { return getToken(Uppaal2TreeParser.OPEN_TEMPLATE, 0); }
		public NameSectionContext nameSection() {
			return getRuleContext(NameSectionContext.class,0);
		}
		public TerminalNode CLOSE_TEMPLATE() { return getToken(Uppaal2TreeParser.CLOSE_TEMPLATE, 0); }
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
		public List<TerminalNode> INIT() { return getTokens(Uppaal2TreeParser.INIT); }
		public TerminalNode INIT(int i) {
			return getToken(Uppaal2TreeParser.INIT, i);
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
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitTemplate(this);
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
			setState(140);
			match(OPEN_TEMPLATE);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UPPAAL_COMMENT_WITH_TEXT || _la==UPPAAL_COMMENT) {
				{
				setState(141);
				comment();
				}
			}

			setState(144);
			nameSection();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PARAMETER) {
				{
				setState(145);
				templateParameter();
				}
			}

			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 4611686018444689411L) != 0)) {
				{
				setState(152);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN_LOCATION:
					{
					setState(148);
					location();
					}
					break;
				case INIT:
					{
					setState(149);
					match(INIT);
					}
					break;
				case OPEN_TRANSITION:
					{
					setState(150);
					transition();
					}
					break;
				case UPPAAL_COMMENT_WITH_TEXT:
				case UPPAAL_COMMENT:
					{
					setState(151);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
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
		public TerminalNode OPEN_PARAMETER() { return getToken(Uppaal2TreeParser.OPEN_PARAMETER, 0); }
		public TerminalNode CLOSE_PARAMETER() { return getToken(Uppaal2TreeParser.CLOSE_PARAMETER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2TreeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2TreeParser.COMMA, i);
		}
		public List<TerminalNode> CONST() { return getTokens(Uppaal2TreeParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(Uppaal2TreeParser.CONST, i);
		}
		public List<TerminalNode> ID() { return getTokens(Uppaal2TreeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2TreeParser.ID, i);
		}
		public List<TerminalNode> DATATYPE() { return getTokens(Uppaal2TreeParser.DATATYPE); }
		public TerminalNode DATATYPE(int i) {
			return getToken(Uppaal2TreeParser.DATATYPE, i);
		}
		public List<TerminalNode> VOID() { return getTokens(Uppaal2TreeParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(Uppaal2TreeParser.VOID, i);
		}
		public TemplateParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterTemplateParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitTemplateParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitTemplateParameter(this);
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
			setState(159);
			match(OPEN_PARAMETER);
			{
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(160);
				match(CONST);
				}
			}

			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOID || _la==DATATYPE) {
				{
				setState(163);
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

			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(166);
				match(ID);
				}
			}

			}
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(169);
					match(COMMA);
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==CONST) {
						{
						setState(170);
						match(CONST);
						}
					}

					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==VOID || _la==DATATYPE) {
						{
						setState(173);
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

					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(176);
						match(ID);
						}
					}

					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(184);
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
		public TerminalNode OPEN_TEMPLATE_NAME() { return getToken(Uppaal2TreeParser.OPEN_TEMPLATE_NAME, 0); }
		public TerminalNode ID() { return getToken(Uppaal2TreeParser.ID, 0); }
		public TerminalNode CLOSE_TEMPLATE_NAME() { return getToken(Uppaal2TreeParser.CLOSE_TEMPLATE_NAME, 0); }
		public NameSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterNameSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitNameSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitNameSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameSectionContext nameSection() throws RecognitionException {
		NameSectionContext _localctx = new NameSectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nameSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(OPEN_TEMPLATE_NAME);
			setState(187);
			match(ID);
			setState(188);
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
		public TerminalNode OPEN_SYSTEM() { return getToken(Uppaal2TreeParser.OPEN_SYSTEM, 0); }
		public List<TerminalNode> ID() { return getTokens(Uppaal2TreeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2TreeParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(Uppaal2TreeParser.SEMICOLON, 0); }
		public TerminalNode CLOSE_SYSTEM() { return getToken(Uppaal2TreeParser.CLOSE_SYSTEM, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2TreeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2TreeParser.COMMA, i);
		}
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitSystem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitSystem(this);
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
			setState(190);
			match(OPEN_SYSTEM);
			setState(191);
			match(T__0);
			setState(192);
			match(ID);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(193);
					match(COMMA);
					setState(194);
					match(ID);
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(200);
			match(SEMICOLON);
			setState(201);
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
		public TerminalNode OPEN_QUERIES() { return getToken(Uppaal2TreeParser.OPEN_QUERIES, 0); }
		public TerminalNode CLOSE_QUERIES() { return getToken(Uppaal2TreeParser.CLOSE_QUERIES, 0); }
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
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterQueries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitQueries(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitQueries(this);
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
			setState(203);
			match(OPEN_QUERIES);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_QUERY) {
				{
				{
				setState(204);
				query();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
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
		public TerminalNode OPEN_LOCATION() { return getToken(Uppaal2TreeParser.OPEN_LOCATION, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(Uppaal2TreeParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(Uppaal2TreeParser.EQUAL, i);
		}
		public List<TerminalNode> STRING() { return getTokens(Uppaal2TreeParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(Uppaal2TreeParser.STRING, i);
		}
		public TerminalNode GT() { return getToken(Uppaal2TreeParser.GT, 0); }
		public TerminalNode CLOSE_LOCATION() { return getToken(Uppaal2TreeParser.CLOSE_LOCATION, 0); }
		public NameSectionContext nameSection() {
			return getRuleContext(NameSectionContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitLocation(this);
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
			setState(212);
			match(OPEN_LOCATION);
			setState(213);
			match(T__1);
			setState(214);
			match(EQUAL);
			setState(215);
			match(STRING);
			setState(216);
			match(T__2);
			setState(217);
			match(EQUAL);
			setState(218);
			match(STRING);
			setState(219);
			match(T__3);
			setState(220);
			match(EQUAL);
			setState(221);
			match(STRING);
			setState(222);
			match(GT);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_TEMPLATE_NAME) {
				{
				setState(223);
				nameSection();
				}
			}

			setState(226);
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
		public TerminalNode INIT() { return getToken(Uppaal2TreeParser.INIT, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2TreeParser.STRING, 0); }
		public TerminalNode CLOSE_SOURCE_TARGET() { return getToken(Uppaal2TreeParser.CLOSE_SOURCE_TARGET, 0); }
		public InItLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inItLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterInItLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitInItLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitInItLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InItLocationContext inItLocation() throws RecognitionException {
		InItLocationContext _localctx = new InItLocationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inItLocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(INIT);
			setState(229);
			match(STRING);
			setState(230);
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
		public TerminalNode OPEN_TRANSITION() { return getToken(Uppaal2TreeParser.OPEN_TRANSITION, 0); }
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode CLOSE_TRANSITION() { return getToken(Uppaal2TreeParser.CLOSE_TRANSITION, 0); }
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
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitTransition(this);
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
			setState(232);
			match(OPEN_TRANSITION);
			setState(233);
			source();
			setState(234);
			target();
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(235);
				comment();
				}
				break;
			}
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(240);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OPEN_LABEL:
						{
						setState(238);
						label();
						}
						break;
					case UPPAAL_COMMENT_WITH_TEXT:
					case UPPAAL_COMMENT:
						{
						setState(239);
						comment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(245);
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
		public TerminalNode OPEN_LABEL() { return getToken(Uppaal2TreeParser.OPEN_LABEL, 0); }
		public TerminalNode GT() { return getToken(Uppaal2TreeParser.GT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_LABEL() { return getToken(Uppaal2TreeParser.CLOSE_LABEL, 0); }
		public TerminalNode EQUAL() { return getToken(Uppaal2TreeParser.EQUAL, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2TreeParser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitLabel(this);
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
			setState(247);
			match(OPEN_LABEL);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(248);
				match(T__4);
				setState(249);
				match(EQUAL);
				setState(250);
				match(STRING);
				}
			}

			setState(253);
			match(GT);
			setState(254);
			expression();
			setState(255);
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
		public List<TerminalNode> ID() { return getTokens(Uppaal2TreeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2TreeParser.ID, i);
		}
		public List<RightSideContext> rightSide() {
			return getRuleContexts(RightSideContext.class);
		}
		public RightSideContext rightSide(int i) {
			return getRuleContext(RightSideContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Uppaal2TreeParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Uppaal2TreeParser.LBRACK, i);
		}
		public List<TerminalNode> INT() { return getTokens(Uppaal2TreeParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(Uppaal2TreeParser.INT, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Uppaal2TreeParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Uppaal2TreeParser.RBRACK, i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitExpression(this);
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
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(257);
					match(ID);
					setState(259);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						setState(258);
						match(ID);
						}
						break;
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LBRACK) {
						{
						setState(261);
						match(LBRACK);
						setState(262);
						match(INT);
						setState(263);
						match(RBRACK);
						}
					}

					setState(267);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(266);
						op();
						}
						break;
					}
					setState(269);
					rightSide();
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
	public static class OpContext extends ParserRuleContext {
		public TerminalNode EQEQ() { return getToken(Uppaal2TreeParser.EQEQ, 0); }
		public TerminalNode EQUAL() { return getToken(Uppaal2TreeParser.EQUAL, 0); }
		public TerminalNode GE() { return getToken(Uppaal2TreeParser.GE, 0); }
		public TerminalNode AND() { return getToken(Uppaal2TreeParser.AND, 0); }
		public TerminalNode LT_TAG() { return getToken(Uppaal2TreeParser.LT_TAG, 0); }
		public TerminalNode GT_TAG() { return getToken(Uppaal2TreeParser.GT_TAG, 0); }
		public TerminalNode PLUSPLUS() { return getToken(Uppaal2TreeParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(Uppaal2TreeParser.MINUSMINUS, 0); }
		public TerminalNode MINUSEQUAL() { return getToken(Uppaal2TreeParser.MINUSEQUAL, 0); }
		public TerminalNode PLUSEQUAL() { return getToken(Uppaal2TreeParser.PLUSEQUAL, 0); }
		public TerminalNode EQUALMINUS() { return getToken(Uppaal2TreeParser.EQUALMINUS, 0); }
		public TerminalNode EQUALPLUS() { return getToken(Uppaal2TreeParser.EQUALPLUS, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(Uppaal2TreeParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(Uppaal2TreeParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(Uppaal2TreeParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(Uppaal2TreeParser.RPAREN, i);
		}
		public TerminalNode NOTEQ() { return getToken(Uppaal2TreeParser.NOTEQ, 0); }
		public List<TerminalNode> HEX_INT() { return getTokens(Uppaal2TreeParser.HEX_INT); }
		public TerminalNode HEX_INT(int i) {
			return getToken(Uppaal2TreeParser.HEX_INT, i);
		}
		public List<TerminalNode> ID() { return getTokens(Uppaal2TreeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2TreeParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(Uppaal2TreeParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(Uppaal2TreeParser.INT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Uppaal2TreeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Uppaal2TreeParser.COMMA, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(Uppaal2TreeParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(Uppaal2TreeParser.MINUS, i);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_op);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(275);
				match(EQEQ);
				}
				break;
			case 2:
				{
				setState(276);
				match(EQUAL);
				}
				break;
			case 3:
				{
				setState(277);
				match(GE);
				}
				break;
			case 4:
				{
				setState(278);
				match(AND);
				}
				break;
			case 5:
				{
				setState(279);
				match(LT_TAG);
				}
				break;
			case 6:
				{
				setState(280);
				match(GT_TAG);
				}
				break;
			case 7:
				{
				setState(281);
				match(PLUSPLUS);
				}
				break;
			case 8:
				{
				setState(282);
				match(MINUSMINUS);
				}
				break;
			case 9:
				{
				setState(283);
				match(MINUSEQUAL);
				}
				break;
			case 10:
				{
				setState(284);
				match(PLUSEQUAL);
				}
				break;
			case 11:
				{
				setState(285);
				match(EQUALMINUS);
				}
				break;
			case 12:
				{
				setState(286);
				match(EQUALPLUS);
				}
				break;
			case 13:
				{
				setState(287);
				match(LPAREN);
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(298);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
						case 1:
							{
							setState(288);
							match(HEX_INT);
							}
							break;
						case 2:
							{
							{
							setState(289);
							match(ID);
							setState(290);
							match(MINUS);
							setState(291);
							match(LPAREN);
							setState(292);
							match(ID);
							setState(293);
							match(MINUS);
							setState(294);
							match(ID);
							setState(295);
							match(RPAREN);
							}
							}
							break;
						case 3:
							{
							setState(296);
							match(ID);
							}
							break;
						case 4:
							{
							setState(297);
							match(INT);
							}
							break;
						}
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(300);
							match(COMMA);
							}
						}

						}
						} 
					}
					setState(307);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(308);
				match(RPAREN);
				}
				break;
			case 14:
				{
				setState(309);
				match(NOTEQ);
				}
				break;
			case 15:
				{
				setState(310);
				match(PLUSPLUS);
				}
				break;
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
	public static class RightSideContext extends ParserRuleContext {
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public ComplexContext complex() {
			return getRuleContext(ComplexContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Uppaal2TreeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2TreeParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(Uppaal2TreeParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(Uppaal2TreeParser.INT, i);
		}
		public TerminalNode LPAREN() { return getToken(Uppaal2TreeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Uppaal2TreeParser.RPAREN, 0); }
		public TerminalNode COMMA() { return getToken(Uppaal2TreeParser.COMMA, 0); }
		public TerminalNode PLUS() { return getToken(Uppaal2TreeParser.PLUS, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2TreeParser.STRING, 0); }
		public TerminalNode PERCENT() { return getToken(Uppaal2TreeParser.PERCENT, 0); }
		public List<TerminalNode> SLASH() { return getTokens(Uppaal2TreeParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(Uppaal2TreeParser.SLASH, i);
		}
		public TerminalNode EQUAL() { return getToken(Uppaal2TreeParser.EQUAL, 0); }
		public RightSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterRightSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitRightSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitRightSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightSideContext rightSide() throws RecognitionException {
		RightSideContext _localctx = new RightSideContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rightSide);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(342);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					{
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LPAREN) {
						{
						setState(313);
						match(LPAREN);
						}
					}

					setState(316);
					match(ID);
					setState(317);
					_la = _input.LA(1);
					if ( !(_la==SLASH || _la==PERCENT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(318);
					match(INT);
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==RPAREN) {
						{
						setState(319);
						match(RPAREN);
						}
					}

					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SLASH) {
						{
						setState(322);
						match(SLASH);
						}
					}

					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==INT) {
						{
						setState(325);
						match(INT);
						}
					}

					setState(328);
					match(PLUS);
					setState(329);
					match(STRING);
					}
					}
					break;
				case 2:
					{
					{
					setState(330);
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
					setState(331);
					match(ID);
					setState(332);
					match(PLUS);
					setState(333);
					match(INT);
					}
					}
					break;
				case 4:
					{
					setState(334);
					match(ID);
					}
					break;
				case 5:
					{
					setState(335);
					match(INT);
					}
					break;
				case 6:
					{
					setState(336);
					match(ID);
					setState(337);
					match(LPAREN);
					setState(339);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(338);
						match(ID);
						}
					}

					setState(341);
					match(RPAREN);
					}
					break;
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(344);
					match(COMMA);
					}
				}

				}
				break;
			case 2:
				{
				setState(347);
				comment();
				}
				break;
			case 3:
				{
				setState(348);
				complex();
				}
				break;
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
		public TerminalNode PLUS() { return getToken(Uppaal2TreeParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Uppaal2TreeParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(Uppaal2TreeParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(Uppaal2TreeParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(Uppaal2TreeParser.PERCENT, 0); }
		public TerminalNode LT() { return getToken(Uppaal2TreeParser.LT, 0); }
		public TerminalNode GT() { return getToken(Uppaal2TreeParser.GT, 0); }
		public TerminalNode LE() { return getToken(Uppaal2TreeParser.LE, 0); }
		public TerminalNode GE() { return getToken(Uppaal2TreeParser.GE, 0); }
		public TerminalNode EQEQ() { return getToken(Uppaal2TreeParser.EQEQ, 0); }
		public TerminalNode NOTEQ() { return getToken(Uppaal2TreeParser.NOTEQ, 0); }
		public TerminalNode AND() { return getToken(Uppaal2TreeParser.AND, 0); }
		public TerminalNode OR() { return getToken(Uppaal2TreeParser.OR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
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
	public static class ComplexContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(Uppaal2TreeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Uppaal2TreeParser.ID, i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Uppaal2TreeParser.COMMA, 0); }
		public ComplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterComplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitComplex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitComplex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexContext complex() throws RecognitionException {
		ComplexContext _localctx = new ComplexContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_complex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(353);
			match(ID);
			setState(354);
			operator();
			setState(355);
			match(ID);
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(356);
				match(COMMA);
				}
			}

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
		public TerminalNode OPEN_SOURCE() { return getToken(Uppaal2TreeParser.OPEN_SOURCE, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2TreeParser.STRING, 0); }
		public TerminalNode CLOSE_SOURCE_TARGET() { return getToken(Uppaal2TreeParser.CLOSE_SOURCE_TARGET, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(OPEN_SOURCE);
			setState(360);
			match(STRING);
			setState(361);
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
		public TerminalNode OPEN_TARGET() { return getToken(Uppaal2TreeParser.OPEN_TARGET, 0); }
		public TerminalNode STRING() { return getToken(Uppaal2TreeParser.STRING, 0); }
		public TerminalNode CLOSE_SOURCE_TARGET() { return getToken(Uppaal2TreeParser.CLOSE_SOURCE_TARGET, 0); }
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(OPEN_TARGET);
			setState(364);
			match(STRING);
			setState(365);
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
		public TerminalNode OPEN_QUERY() { return getToken(Uppaal2TreeParser.OPEN_QUERY, 0); }
		public TerminalNode OPEN_FORMULA() { return getToken(Uppaal2TreeParser.OPEN_FORMULA, 0); }
		public TerminalNode CLOSE_FORMULA() { return getToken(Uppaal2TreeParser.CLOSE_FORMULA, 0); }
		public TerminalNode OPEN_COMMENT() { return getToken(Uppaal2TreeParser.OPEN_COMMENT, 0); }
		public TerminalNode CLOSE_COMMENT() { return getToken(Uppaal2TreeParser.CLOSE_COMMENT, 0); }
		public TerminalNode CLOSE_QUERY() { return getToken(Uppaal2TreeParser.CLOSE_QUERY, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(OPEN_QUERY);
			setState(368);
			match(OPEN_FORMULA);
			setState(369);
			match(CLOSE_FORMULA);
			setState(370);
			match(OPEN_COMMENT);
			setState(371);
			match(CLOSE_COMMENT);
			setState(372);
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
		public TerminalNode UPPAAL_COMMENT_WITH_TEXT() { return getToken(Uppaal2TreeParser.UPPAAL_COMMENT_WITH_TEXT, 0); }
		public TerminalNode UPPAAL_COMMENT() { return getToken(Uppaal2TreeParser.UPPAAL_COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Uppaal2TreeListener ) ((Uppaal2TreeListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Uppaal2TreeVisitor ) return ((Uppaal2TreeVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
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
		"\u0004\u0001P\u0179\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001<\b\u0001\u000b\u0001"+
		"\f\u0001=\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002C\b\u0002\u000b"+
		"\u0002\f\u0002D\u0001\u0002\u0004\u0002H\b\u0002\u000b\u0002\f\u0002I"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002O\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0004\u0003S\b\u0003\u000b\u0003\f\u0003T\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\\\b\u0004\u0001"+
		"\u0005\u0003\u0005_\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005f\b\u0005\u0001\u0005\u0003\u0005i\b\u0005"+
		"\u0001\u0005\u0003\u0005l\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"p\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006x\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u007f\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0086\b\u0007\n\u0007"+
		"\f\u0007\u0089\t\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u008f\b"+
		"\t\u0001\t\u0001\t\u0003\t\u0093\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u0099\b\t\n\t\f\t\u009c\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n"+
		"\u00a2\b\n\u0001\n\u0003\n\u00a5\b\n\u0001\n\u0003\n\u00a8\b\n\u0001\n"+
		"\u0001\n\u0003\n\u00ac\b\n\u0001\n\u0003\n\u00af\b\n\u0001\n\u0003\n\u00b2"+
		"\b\n\u0005\n\u00b4\b\n\n\n\f\n\u00b7\t\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00c4\b\f\n\f\f\f\u00c7\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0005\r\u00ce\b\r\n\r\f\r\u00d1\t\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00e1"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ed"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00f1\b\u0010\n\u0010\f\u0010"+
		"\u00f4\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00fc\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u0104\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0109\b\u0012\u0001\u0012\u0003\u0012"+
		"\u010c\b\u0012\u0001\u0012\u0005\u0012\u010f\b\u0012\n\u0012\f\u0012\u0112"+
		"\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u012b\b\u0013\u0001\u0013\u0003\u0013\u012e\b\u0013\u0005\u0013"+
		"\u0130\b\u0013\n\u0013\f\u0013\u0133\t\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0138\b\u0013\u0001\u0014\u0003\u0014\u013b\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0141\b\u0014"+
		"\u0001\u0014\u0003\u0014\u0144\b\u0014\u0001\u0014\u0003\u0014\u0147\b"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0154\b\u0014\u0001\u0014\u0003\u0014\u0157\b\u0014\u0001\u0014"+
		"\u0003\u0014\u015a\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u015e\b"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0166\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0005\u00b5\u00c5\u00f2\u0110\u0131\u0000"+
		"\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.024\u0000\u0006\u0001\u0000\n\u000b\u0002\u0000"+
		"\n\n\f\f\u0001\u0000,-\u0002\u0000\f\f\u001a\u001b\u0004\u0000##%%+39"+
		":\u0001\u0000\u0006\u0007\u01aa\u00006\u0001\u0000\u0000\u0000\u00029"+
		"\u0001\u0000\u0000\u0000\u0004N\u0001\u0000\u0000\u0000\u0006P\u0001\u0000"+
		"\u0000\u0000\b[\u0001\u0000\u0000\u0000\n^\u0001\u0000\u0000\u0000\fs"+
		"\u0001\u0000\u0000\u0000\u000e\u0082\u0001\u0000\u0000\u0000\u0010\u008a"+
		"\u0001\u0000\u0000\u0000\u0012\u008c\u0001\u0000\u0000\u0000\u0014\u009f"+
		"\u0001\u0000\u0000\u0000\u0016\u00ba\u0001\u0000\u0000\u0000\u0018\u00be"+
		"\u0001\u0000\u0000\u0000\u001a\u00cb\u0001\u0000\u0000\u0000\u001c\u00d4"+
		"\u0001\u0000\u0000\u0000\u001e\u00e4\u0001\u0000\u0000\u0000 \u00e8\u0001"+
		"\u0000\u0000\u0000\"\u00f7\u0001\u0000\u0000\u0000$\u0110\u0001\u0000"+
		"\u0000\u0000&\u0137\u0001\u0000\u0000\u0000(\u015d\u0001\u0000\u0000\u0000"+
		"*\u015f\u0001\u0000\u0000\u0000,\u0161\u0001\u0000\u0000\u0000.\u0167"+
		"\u0001\u0000\u0000\u00000\u016b\u0001\u0000\u0000\u00002\u016f\u0001\u0000"+
		"\u0000\u00004\u0176\u0001\u0000\u0000\u000067\u0003\u0002\u0001\u0000"+
		"78\u0005\u0000\u0000\u00018\u0001\u0001\u0000\u0000\u00009;\u0005;\u0000"+
		"\u0000:<\u0003\u0004\u0002\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0005<\u0000\u0000@\u0003\u0001\u0000\u0000\u0000"+
		"AC\u0003\u0006\u0003\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EO\u0001\u0000"+
		"\u0000\u0000FH\u0003\u0012\t\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JO\u0001"+
		"\u0000\u0000\u0000KO\u0003\u0018\f\u0000LO\u0003\u001a\r\u0000MO\u0003"+
		"4\u001a\u0000NB\u0001\u0000\u0000\u0000NG\u0001\u0000\u0000\u0000NK\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000"+
		"O\u0005\u0001\u0000\u0000\u0000PR\u0005\u0013\u0000\u0000QS\u0003\b\u0004"+
		"\u0000RQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0005"+
		"=\u0000\u0000W\u0007\u0001\u0000\u0000\u0000X\\\u0003\n\u0005\u0000Y\\"+
		"\u0003\f\u0006\u0000Z\\\u00034\u001a\u0000[X\u0001\u0000\u0000\u0000["+
		"Y\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\t\u0001\u0000\u0000"+
		"\u0000]_\u0005\t\u0000\u0000^]\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`a\u0005\u000b\u0000\u0000ah\u0005\f\u0000"+
		"\u0000bc\u0005\r\u0000\u0000ce\u0005\u001c\u0000\u0000df\u0005\b\u0000"+
		"\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000gi\u0005\u000e\u0000\u0000hb\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000jl\u0005\u001a\u0000\u0000"+
		"kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000"+
		"\u0000mp\u0005\f\u0000\u0000np\u0005\u001c\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000on\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qr\u0005\u001f\u0000\u0000r\u000b\u0001\u0000\u0000\u0000"+
		"st\u0007\u0000\u0000\u0000tu\u0005\f\u0000\u0000uw\u0005\u000f\u0000\u0000"+
		"vx\u0003\u000e\u0007\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000yz\u0005\u0010\u0000\u0000z~\u0005\u0011"+
		"\u0000\u0000{|\u0003$\u0012\u0000|}\u0005\u001f\u0000\u0000}\u007f\u0001"+
		"\u0000\u0000\u0000~{\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0012\u0000"+
		"\u0000\u0081\r\u0001\u0000\u0000\u0000\u0082\u0087\u0003\u0010\b\u0000"+
		"\u0083\u0084\u0005!\u0000\u0000\u0084\u0086\u0003\u0010\b\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u000f\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0007\u0001\u0000\u0000\u008b\u0011\u0001\u0000\u0000\u0000\u008c"+
		"\u008e\u0005\u0014\u0000\u0000\u008d\u008f\u00034\u001a\u0000\u008e\u008d"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090\u0092\u0003\u0016\u000b\u0000\u0091\u0093"+
		"\u0003\u0014\n\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u009a\u0001\u0000\u0000\u0000\u0094\u0099\u0003"+
		"\u001c\u000e\u0000\u0095\u0099\u0005\u001e\u0000\u0000\u0096\u0099\u0003"+
		" \u0010\u0000\u0097\u0099\u00034\u001a\u0000\u0098\u0094\u0001\u0000\u0000"+
		"\u0000\u0098\u0095\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000"+
		"\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000"+
		"\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000"+
		"\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005?\u0000\u0000\u009e\u0013\u0001\u0000\u0000\u0000"+
		"\u009f\u00a1\u0005\u0017\u0000\u0000\u00a0\u00a2\u0005\t\u0000\u0000\u00a1"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a5\u0007\u0000\u0000\u0000\u00a4"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005\f\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00b5"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005!\u0000\u0000\u00aa\u00ac\u0005"+
		"\t\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00af\u0007\u0000"+
		"\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0\u00b2\u0005\f\u0000"+
		"\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00a9\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u0018\u0000"+
		"\u0000\u00b9\u0015\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0015\u0000"+
		"\u0000\u00bb\u00bc\u0005\f\u0000\u0000\u00bc\u00bd\u0005\u0016\u0000\u0000"+
		"\u00bd\u0017\u0001\u0000\u0000\u0000\u00be\u00bf\u0005@\u0000\u0000\u00bf"+
		"\u00c0\u0005\u0001\u0000\u0000\u00c0\u00c5\u0005\f\u0000\u0000\u00c1\u00c2"+
		"\u0005!\u0000\u0000\u00c2\u00c4\u0005\f\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005"+
		"\u001f\u0000\u0000\u00c9\u00ca\u0005A\u0000\u0000\u00ca\u0019\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cf\u0005B\u0000\u0000\u00cc\u00ce\u00032\u0019\u0000"+
		"\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0005C\u0000\u0000\u00d3\u001b\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0005\u0019\u0000\u0000\u00d5\u00d6\u0005\u0002\u0000\u0000\u00d6"+
		"\u00d7\u0005\u001a\u0000\u0000\u00d7\u00d8\u0005\u001b\u0000\u0000\u00d8"+
		"\u00d9\u0005\u0003\u0000\u0000\u00d9\u00da\u0005\u001a\u0000\u0000\u00da"+
		"\u00db\u0005\u001b\u0000\u0000\u00db\u00dc\u0005\u0004\u0000\u0000\u00dc"+
		"\u00dd\u0005\u001a\u0000\u0000\u00dd\u00de\u0005\u001b\u0000\u0000\u00de"+
		"\u00e0\u0005/\u0000\u0000\u00df\u00e1\u0003\u0016\u000b\u0000\u00e0\u00df"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u001d\u0000\u0000\u00e3\u001d"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u001e\u0000\u0000\u00e5\u00e6"+
		"\u0005\u001b\u0000\u0000\u00e6\u00e7\u0005>\u0000\u0000\u00e7\u001f\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0005D\u0000\u0000\u00e9\u00ea\u0003.\u0017"+
		"\u0000\u00ea\u00ec\u00030\u0018\u0000\u00eb\u00ed\u00034\u001a\u0000\u00ec"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		"\u00f2\u0001\u0000\u0000\u0000\u00ee\u00f1\u0003\"\u0011\u0000\u00ef\u00f1"+
		"\u00034\u001a\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005"+
		"E\u0000\u0000\u00f6!\u0001\u0000\u0000\u0000\u00f7\u00fb\u0005F\u0000"+
		"\u0000\u00f8\u00f9\u0005\u0005\u0000\u0000\u00f9\u00fa\u0005\u001a\u0000"+
		"\u0000\u00fa\u00fc\u0005\u001b\u0000\u0000\u00fb\u00f8\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0005/\u0000\u0000\u00fe\u00ff\u0003$\u0012\u0000\u00ff"+
		"\u0100\u0005G\u0000\u0000\u0100#\u0001\u0000\u0000\u0000\u0101\u0103\u0005"+
		"\f\u0000\u0000\u0102\u0104\u0005\f\u0000\u0000\u0103\u0102\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0108\u0001\u0000"+
		"\u0000\u0000\u0105\u0106\u0005\r\u0000\u0000\u0106\u0107\u0005\u001c\u0000"+
		"\u0000\u0107\u0109\u0005\u000e\u0000\u0000\u0108\u0105\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010b\u0001\u0000\u0000"+
		"\u0000\u010a\u010c\u0003&\u0013\u0000\u010b\u010a\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000"+
		"\u010d\u010f\u0003(\u0014\u0000\u010e\u0101\u0001\u0000\u0000\u0000\u010f"+
		"\u0112\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0110"+
		"\u010e\u0001\u0000\u0000\u0000\u0111%\u0001\u0000\u0000\u0000\u0112\u0110"+
		"\u0001\u0000\u0000\u0000\u0113\u0138\u00052\u0000\u0000\u0114\u0138\u0005"+
		"\u001a\u0000\u0000\u0115\u0138\u00051\u0000\u0000\u0116\u0138\u00059\u0000"+
		"\u0000\u0117\u0138\u00057\u0000\u0000\u0118\u0138\u00058\u0000\u0000\u0119"+
		"\u0138\u0005$\u0000\u0000\u011a\u0138\u0005&\u0000\u0000\u011b\u0138\u0005"+
		"\'\u0000\u0000\u011c\u0138\u0005(\u0000\u0000\u011d\u0138\u0005)\u0000"+
		"\u0000\u011e\u0138\u0005*\u0000\u0000\u011f\u0131\u0005\u000f\u0000\u0000"+
		"\u0120\u012b\u00056\u0000\u0000\u0121\u0122\u0005\f\u0000\u0000\u0122"+
		"\u0123\u0005%\u0000\u0000\u0123\u0124\u0005\u000f\u0000\u0000\u0124\u0125"+
		"\u0005\f\u0000\u0000\u0125\u0126\u0005%\u0000\u0000\u0126\u0127\u0005"+
		"\f\u0000\u0000\u0127\u012b\u0005\u0010\u0000\u0000\u0128\u012b\u0005\f"+
		"\u0000\u0000\u0129\u012b\u0005\u001c\u0000\u0000\u012a\u0120\u0001\u0000"+
		"\u0000\u0000\u012a\u0121\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000"+
		"\u0000\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012b\u012d\u0001\u0000"+
		"\u0000\u0000\u012c\u012e\u0005!\u0000\u0000\u012d\u012c\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u0130\u0001\u0000\u0000"+
		"\u0000\u012f\u012a\u0001\u0000\u0000\u0000\u0130\u0133\u0001\u0000\u0000"+
		"\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000"+
		"\u0000\u0132\u0134\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000"+
		"\u0000\u0134\u0138\u0005\u0010\u0000\u0000\u0135\u0138\u00053\u0000\u0000"+
		"\u0136\u0138\u0005$\u0000\u0000\u0137\u0113\u0001\u0000\u0000\u0000\u0137"+
		"\u0114\u0001\u0000\u0000\u0000\u0137\u0115\u0001\u0000\u0000\u0000\u0137"+
		"\u0116\u0001\u0000\u0000\u0000\u0137\u0117\u0001\u0000\u0000\u0000\u0137"+
		"\u0118\u0001\u0000\u0000\u0000\u0137\u0119\u0001\u0000\u0000\u0000\u0137"+
		"\u011a\u0001\u0000\u0000\u0000\u0137\u011b\u0001\u0000\u0000\u0000\u0137"+
		"\u011c\u0001\u0000\u0000\u0000\u0137\u011d\u0001\u0000\u0000\u0000\u0137"+
		"\u011e\u0001\u0000\u0000\u0000\u0137\u011f\u0001\u0000\u0000\u0000\u0137"+
		"\u0135\u0001\u0000\u0000\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0138"+
		"\'\u0001\u0000\u0000\u0000\u0139\u013b\u0005\u000f\u0000\u0000\u013a\u0139"+
		"\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c"+
		"\u0001\u0000\u0000\u0000\u013c\u013d\u0005\f\u0000\u0000\u013d\u013e\u0007"+
		"\u0002\u0000\u0000\u013e\u0140\u0005\u001c\u0000\u0000\u013f\u0141\u0005"+
		"\u0010\u0000\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0140\u0141\u0001"+
		"\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0144\u0005"+
		",\u0000\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000"+
		"\u0000\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145\u0147\u0005\u001c"+
		"\u0000\u0000\u0146\u0145\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000"+
		"\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0005#\u0000"+
		"\u0000\u0149\u0157\u0005\u001b\u0000\u0000\u014a\u0157\u0007\u0003\u0000"+
		"\u0000\u014b\u014c\u0005\f\u0000\u0000\u014c\u014d\u0005#\u0000\u0000"+
		"\u014d\u0157\u0005\u001c\u0000\u0000\u014e\u0157\u0005\f\u0000\u0000\u014f"+
		"\u0157\u0005\u001c\u0000\u0000\u0150\u0151\u0005\f\u0000\u0000\u0151\u0153"+
		"\u0005\u000f\u0000\u0000\u0152\u0154\u0005\f\u0000\u0000\u0153\u0152\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0155\u0001"+
		"\u0000\u0000\u0000\u0155\u0157\u0005\u0010\u0000\u0000\u0156\u013a\u0001"+
		"\u0000\u0000\u0000\u0156\u014a\u0001\u0000\u0000\u0000\u0156\u014b\u0001"+
		"\u0000\u0000\u0000\u0156\u014e\u0001\u0000\u0000\u0000\u0156\u014f\u0001"+
		"\u0000\u0000\u0000\u0156\u0150\u0001\u0000\u0000\u0000\u0156\u0157\u0001"+
		"\u0000\u0000\u0000\u0157\u0159\u0001\u0000\u0000\u0000\u0158\u015a\u0005"+
		"!\u0000\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000"+
		"\u0000\u0000\u015a\u015e\u0001\u0000\u0000\u0000\u015b\u015e\u00034\u001a"+
		"\u0000\u015c\u015e\u0003,\u0016\u0000\u015d\u0156\u0001\u0000\u0000\u0000"+
		"\u015d\u015b\u0001\u0000\u0000\u0000\u015d\u015c\u0001\u0000\u0000\u0000"+
		"\u015e)\u0001\u0000\u0000\u0000\u015f\u0160\u0007\u0004\u0000\u0000\u0160"+
		"+\u0001\u0000\u0000\u0000\u0161\u0162\u0005\f\u0000\u0000\u0162\u0163"+
		"\u0003*\u0015\u0000\u0163\u0165\u0005\f\u0000\u0000\u0164\u0166\u0005"+
		"!\u0000\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000"+
		"\u0000\u0000\u0166-\u0001\u0000\u0000\u0000\u0167\u0168\u0005H\u0000\u0000"+
		"\u0168\u0169\u0005\u001b\u0000\u0000\u0169\u016a\u0005>\u0000\u0000\u016a"+
		"/\u0001\u0000\u0000\u0000\u016b\u016c\u0005I\u0000\u0000\u016c\u016d\u0005"+
		"\u001b\u0000\u0000\u016d\u016e\u0005>\u0000\u0000\u016e1\u0001\u0000\u0000"+
		"\u0000\u016f\u0170\u0005J\u0000\u0000\u0170\u0171\u0005L\u0000\u0000\u0171"+
		"\u0172\u0005M\u0000\u0000\u0172\u0173\u0005N\u0000\u0000\u0173\u0174\u0005"+
		"O\u0000\u0000\u0174\u0175\u0005K\u0000\u0000\u01753\u0001\u0000\u0000"+
		"\u0000\u0176\u0177\u0007\u0005\u0000\u0000\u01775\u0001\u0000\u0000\u0000"+
		"1=DINT[^ehkow~\u0087\u008e\u0092\u0098\u009a\u00a1\u00a4\u00a7\u00ab\u00ae"+
		"\u00b1\u00b5\u00c5\u00cf\u00e0\u00ec\u00f0\u00f2\u00fb\u0103\u0108\u010b"+
		"\u0110\u012a\u012d\u0131\u0137\u013a\u0140\u0143\u0146\u0153\u0156\u0159"+
		"\u015d\u0165";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}