// Generated from /home/emi/Documentos/TC/c-compiler-antlr/src/app/reglas.g4 by ANTLR 4.8

package app;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class reglasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PA=1, PC=2, CA=3, CC=4, LA=5, LC=6, PYC=7, COMA=8, EQ=9, MAY=10, MAYEQ=11, 
		MEN=12, MENEQ=13, EQL=14, DST=15, SUM=16, RES=17, MUL=18, DIV=19, MOD=20, 
		OR=21, AND=22, NOT=23, FOR=24, WHILE=25, IF=26, ELSE=27, INT=28, CHAR=29, 
		DOUBLE=30, VOID=31, RETURN=32, ID=33, INTEGER=34, DECIMAL=35, CHARACTER=36, 
		WS=37, OTRO=38;
	public static final int
		RULE_prog = 0, RULE_instructions = 1, RULE_block = 2, RULE_instruction = 3, 
		RULE_retorno = 4, RULE_declaration = 5, RULE_asign = 6, RULE_datatype = 7, 
		RULE_assignment = 8, RULE_cyclefor = 9, RULE_cyclewhile = 10, RULE_condif = 11, 
		RULE_prototype = 12, RULE_function = 13, RULE_parameters = 14, RULE_param = 15, 
		RULE_callfunction = 16, RULE_arguments = 17, RULE_arg = 18, RULE_operation = 19, 
		RULE_opal = 20, RULE_disjunction = 21, RULE_disy = 22, RULE_conjunction = 23, 
		RULE_conj = 24, RULE_comparison = 25, RULE_comp = 26, RULE_opcomp = 27, 
		RULE_expression = 28, RULE_exp = 29, RULE_term = 30, RULE_ter = 31, RULE_factor = 32, 
		RULE_f = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "instructions", "block", "instruction", "retorno", "declaration", 
			"asign", "datatype", "assignment", "cyclefor", "cyclewhile", "condif", 
			"prototype", "function", "parameters", "param", "callfunction", "arguments", 
			"arg", "operation", "opal", "disjunction", "disy", "conjunction", "conj", 
			"comparison", "comp", "opcomp", "expression", "exp", "term", "ter", "factor", 
			"f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'='", 
			"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'||'", "'&&'", "'!'", "'for'", "'while'", "'if'", "'else'", "'int'", 
			"'char'", "'double'", "'void'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "EQ", "MAY", 
			"MAYEQ", "MEN", "MENEQ", "EQL", "DST", "SUM", "RES", "MUL", "DIV", "MOD", 
			"OR", "AND", "NOT", "FOR", "WHILE", "IF", "ELSE", "INT", "CHAR", "DOUBLE", 
			"VOID", "RETURN", "ID", "INTEGER", "DECIMAL", "CHARACTER", "WS", "OTRO"
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
	public String getGrammarFileName() { return "reglas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public reglasParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(reglasParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			instructions();
			setState(69);
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

	public static class InstructionsContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitInstructions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instructions);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LA:
			case FOR:
			case WHILE:
			case IF:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
			case RETURN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				instruction();
				setState(72);
				instructions();
				}
				break;
			case EOF:
			case LC:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(reglasParser.LA, 0); }
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public TerminalNode LC() { return getToken(reglasParser.LC, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(LA);
			setState(78);
			instructions();
			setState(79);
			match(LC);
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

	public static class InstructionContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode PYC() { return getToken(reglasParser.PYC, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CycleforContext cyclefor() {
			return getRuleContext(CycleforContext.class,0);
		}
		public CyclewhileContext cyclewhile() {
			return getRuleContext(CyclewhileContext.class,0);
		}
		public CondifContext condif() {
			return getRuleContext(CondifContext.class,0);
		}
		public PrototypeContext prototype() {
			return getRuleContext(PrototypeContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public CallfunctionContext callfunction() {
			return getRuleContext(CallfunctionContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				declaration();
				setState(82);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				assignment();
				setState(85);
				match(PYC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				cyclefor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				cyclewhile();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				condif();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(90);
				prototype();
				setState(91);
				match(PYC);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				function();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(94);
				callfunction();
				setState(95);
				match(PYC);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(97);
				retorno();
				setState(98);
				match(PYC);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(100);
				block();
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

	public static class RetornoContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(reglasParser.RETURN, 0); }
		public OpalContext opal() {
			return getRuleContext(OpalContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterRetorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitRetorno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_retorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(RETURN);
			setState(104);
			opal();
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

	public static class DeclarationContext extends ParserRuleContext {
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(reglasParser.ID, 0); }
		public AsignContext asign() {
			return getRuleContext(AsignContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				datatype();
				setState(107);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				datatype();
				setState(110);
				match(ID);
				setState(111);
				asign();
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

	public static class AsignContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(reglasParser.EQ, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitAsign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitAsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignContext asign() throws RecognitionException {
		AsignContext _localctx = new AsignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_asign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(EQ);
			setState(116);
			operation();
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

	public static class DatatypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(reglasParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(reglasParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(reglasParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(reglasParser.VOID, 0); }
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitDatatype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitDatatype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_datatype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID))) != 0)) ) {
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(reglasParser.ID, 0); }
		public AsignContext asign() {
			return getRuleContext(AsignContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(ID);
			setState(121);
			asign();
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

	public static class CycleforContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(reglasParser.FOR, 0); }
		public TerminalNode PA() { return getToken(reglasParser.PA, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public List<TerminalNode> PYC() { return getTokens(reglasParser.PYC); }
		public TerminalNode PYC(int i) {
			return getToken(reglasParser.PYC, i);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode ID() { return getToken(reglasParser.ID, 0); }
		public AsignContext asign() {
			return getRuleContext(AsignContext.class,0);
		}
		public TerminalNode PC() { return getToken(reglasParser.PC, 0); }
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public CycleforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cyclefor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterCyclefor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitCyclefor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitCyclefor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleforContext cyclefor() throws RecognitionException {
		CycleforContext _localctx = new CycleforContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cyclefor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(FOR);
			setState(124);
			match(PA);
			setState(125);
			assignment();
			setState(126);
			match(PYC);
			setState(127);
			operation();
			setState(128);
			match(PYC);
			setState(129);
			match(ID);
			setState(130);
			asign();
			setState(131);
			match(PC);
			setState(132);
			instruction();
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

	public static class CyclewhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(reglasParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(reglasParser.PA, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode PC() { return getToken(reglasParser.PC, 0); }
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public CyclewhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cyclewhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterCyclewhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitCyclewhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitCyclewhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CyclewhileContext cyclewhile() throws RecognitionException {
		CyclewhileContext _localctx = new CyclewhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cyclewhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(WHILE);
			setState(135);
			match(PA);
			setState(136);
			operation();
			setState(137);
			match(PC);
			setState(138);
			instruction();
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

	public static class CondifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(reglasParser.IF, 0); }
		public TerminalNode PA() { return getToken(reglasParser.PA, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode PC() { return getToken(reglasParser.PC, 0); }
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(reglasParser.ELSE, 0); }
		public CondifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterCondif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitCondif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitCondif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondifContext condif() throws RecognitionException {
		CondifContext _localctx = new CondifContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condif);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(IF);
				setState(141);
				match(PA);
				setState(142);
				operation();
				setState(143);
				match(PC);
				setState(144);
				instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(IF);
				setState(147);
				match(PA);
				setState(148);
				operation();
				setState(149);
				match(PC);
				setState(150);
				block();
				setState(151);
				match(ELSE);
				setState(152);
				block();
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

	public static class PrototypeContext extends ParserRuleContext {
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(reglasParser.ID, 0); }
		public TerminalNode PA() { return getToken(reglasParser.PA, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode PC() { return getToken(reglasParser.PC, 0); }
		public PrototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prototype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterPrototype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitPrototype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitPrototype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrototypeContext prototype() throws RecognitionException {
		PrototypeContext _localctx = new PrototypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prototype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			datatype();
			setState(157);
			match(ID);
			setState(158);
			match(PA);
			setState(159);
			parameters();
			setState(160);
			match(PC);
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

	public static class FunctionContext extends ParserRuleContext {
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(reglasParser.ID, 0); }
		public TerminalNode PA() { return getToken(reglasParser.PA, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode PC() { return getToken(reglasParser.PC, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			datatype();
			setState(163);
			match(ID);
			setState(164);
			match(PA);
			setState(165);
			parameters();
			setState(166);
			match(PC);
			setState(167);
			block();
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

	public static class ParametersContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			param();
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

	public static class ParamContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode COMA() { return getToken(reglasParser.COMA, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_param);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				declaration();
				setState(172);
				param();
				}
				break;
			case COMA:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(COMA);
				setState(175);
				declaration();
				setState(176);
				param();
				}
				break;
			case PC:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class CallfunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(reglasParser.ID, 0); }
		public TerminalNode PA() { return getToken(reglasParser.PA, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode PC() { return getToken(reglasParser.PC, 0); }
		public CallfunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callfunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterCallfunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitCallfunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitCallfunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallfunctionContext callfunction() throws RecognitionException {
		CallfunctionContext _localctx = new CallfunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_callfunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(ID);
			setState(182);
			match(PA);
			setState(183);
			arguments();
			setState(184);
			match(PC);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			operation();
			setState(187);
			arg();
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

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode COMA() { return getToken(reglasParser.COMA, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arg);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(COMA);
				setState(190);
				operation();
				setState(191);
				arg();
				}
				break;
			case PC:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class OperationContext extends ParserRuleContext {
		public OpalContext opal() {
			return getRuleContext(OpalContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			opal();
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

	public static class OpalContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public OpalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterOpal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitOpal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitOpal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpalContext opal() throws RecognitionException {
		OpalContext _localctx = new OpalContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_opal);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PA:
			case SUM:
			case RES:
			case NOT:
			case ID:
			case INTEGER:
			case DECIMAL:
			case CHARACTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				disjunction();
				}
				break;
			case PC:
			case PYC:
			case COMA:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class DisjunctionContext extends ParserRuleContext {
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public DisyContext disy() {
			return getRuleContext(DisyContext.class,0);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			conjunction();
			setState(203);
			disy();
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

	public static class DisyContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(reglasParser.OR, 0); }
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public DisyContext disy() {
			return getRuleContext(DisyContext.class,0);
		}
		public DisyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterDisy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitDisy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitDisy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisyContext disy() throws RecognitionException {
		DisyContext _localctx = new DisyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_disy);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OR:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(OR);
				setState(206);
				conjunction();
				setState(207);
				disy();
				}
				break;
			case PC:
			case PYC:
			case COMA:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ConjunctionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ConjContext conj() {
			return getRuleContext(ConjContext.class,0);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			comparison();
			setState(213);
			conj();
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

	public static class ConjContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(reglasParser.AND, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ConjContext conj() {
			return getRuleContext(ConjContext.class,0);
		}
		public ConjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterConj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitConj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitConj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjContext conj() throws RecognitionException {
		ConjContext _localctx = new ConjContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_conj);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(AND);
				setState(216);
				comparison();
				setState(217);
				conj();
				}
				break;
			case PC:
			case PYC:
			case COMA:
			case OR:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ComparisonContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			expression();
			setState(223);
			comp();
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

	public static class CompContext extends ParserRuleContext {
		public OpcompContext opcomp() {
			return getRuleContext(OpcompContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_comp);
		try {
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAY:
			case MAYEQ:
			case MEN:
			case MENEQ:
			case EQL:
			case DST:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				opcomp();
				setState(226);
				expression();
				setState(227);
				comp();
				}
				break;
			case PC:
			case PYC:
			case COMA:
			case OR:
			case AND:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class OpcompContext extends ParserRuleContext {
		public TerminalNode EQL() { return getToken(reglasParser.EQL, 0); }
		public TerminalNode DST() { return getToken(reglasParser.DST, 0); }
		public TerminalNode MAY() { return getToken(reglasParser.MAY, 0); }
		public TerminalNode MAYEQ() { return getToken(reglasParser.MAYEQ, 0); }
		public TerminalNode MEN() { return getToken(reglasParser.MEN, 0); }
		public TerminalNode MENEQ() { return getToken(reglasParser.MENEQ, 0); }
		public OpcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterOpcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitOpcomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitOpcomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcompContext opcomp() throws RecognitionException {
		OpcompContext _localctx = new OpcompContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_opcomp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAY) | (1L << MAYEQ) | (1L << MEN) | (1L << MENEQ) | (1L << EQL) | (1L << DST))) != 0)) ) {
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

	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			term();
			setState(235);
			exp();
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

	public static class ExpContext extends ParserRuleContext {
		public TerminalNode SUM() { return getToken(reglasParser.SUM, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RES() { return getToken(reglasParser.RES, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_exp);
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(SUM);
				setState(238);
				term();
				setState(239);
				exp();
				}
				break;
			case RES:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				match(RES);
				setState(242);
				term();
				setState(243);
				exp();
				}
				break;
			case PC:
			case PYC:
			case COMA:
			case MAY:
			case MAYEQ:
			case MEN:
			case MENEQ:
			case EQL:
			case DST:
			case OR:
			case AND:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerContext ter() {
			return getRuleContext(TerContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			factor();
			setState(249);
			ter();
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

	public static class TerContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(reglasParser.MUL, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerContext ter() {
			return getRuleContext(TerContext.class,0);
		}
		public TerminalNode DIV() { return getToken(reglasParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(reglasParser.MOD, 0); }
		public TerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterTer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitTer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitTer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerContext ter() throws RecognitionException {
		TerContext _localctx = new TerContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ter);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(MUL);
				setState(252);
				factor();
				setState(253);
				ter();
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(DIV);
				setState(256);
				factor();
				setState(257);
				ter();
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				match(MOD);
				setState(260);
				factor();
				setState(261);
				ter();
				}
				break;
			case PC:
			case PYC:
			case COMA:
			case MAY:
			case MAYEQ:
			case MEN:
			case MENEQ:
			case EQL:
			case DST:
			case SUM:
			case RES:
			case OR:
			case AND:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 4);
				{
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

	public static class FactorContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TerminalNode PA() { return getToken(reglasParser.PA, 0); }
		public OpalContext opal() {
			return getRuleContext(OpalContext.class,0);
		}
		public TerminalNode PC() { return getToken(reglasParser.PC, 0); }
		public CallfunctionContext callfunction() {
			return getRuleContext(CallfunctionContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(reglasParser.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(reglasParser.DECIMAL, 0); }
		public TerminalNode CHARACTER() { return getToken(reglasParser.CHARACTER, 0); }
		public TerminalNode ID() { return getToken(reglasParser.ID, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_factor);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				f();
				setState(267);
				match(PA);
				setState(268);
				opal();
				setState(269);
				match(PC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				f();
				setState(272);
				callfunction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				f();
				setState(275);
				match(INTEGER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(277);
				f();
				setState(278);
				match(DECIMAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(280);
				f();
				setState(281);
				match(CHARACTER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(283);
				f();
				setState(284);
				match(ID);
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

	public static class FContext extends ParserRuleContext {
		public TerminalNode SUM() { return getToken(reglasParser.SUM, 0); }
		public TerminalNode RES() { return getToken(reglasParser.RES, 0); }
		public TerminalNode NOT() { return getToken(reglasParser.NOT, 0); }
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof reglasListener ) ((reglasListener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof reglasVisitor ) return ((reglasVisitor<? extends T>)visitor).visitF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_f);
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(SUM);
				}
				break;
			case RES:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(RES);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				match(NOT);
				}
				break;
			case PA:
			case ID:
			case INTEGER:
			case DECIMAL:
			case CHARACTER:
				enterOuterAlt(_localctx, 4);
				{
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0129\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3N\n\3\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5h\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7t\n\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009d\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00b6\n\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00c5\n\24\3\25\3\25\3\26\3\26\5\26\u00cb"+
		"\n\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u00d5\n\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u00df\n\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u00e9\n\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00f9\n\37\3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u010b\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0121\n\"\3#\3#\3"+
		"#\3#\5#\u0127\n#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BD\2\4\3\2\36!\3\2\f\21\2\u0126\2F\3\2\2\2\4M\3\2"+
		"\2\2\6O\3\2\2\2\bg\3\2\2\2\ni\3\2\2\2\fs\3\2\2\2\16u\3\2\2\2\20x\3\2\2"+
		"\2\22z\3\2\2\2\24}\3\2\2\2\26\u0088\3\2\2\2\30\u009c\3\2\2\2\32\u009e"+
		"\3\2\2\2\34\u00a4\3\2\2\2\36\u00ab\3\2\2\2 \u00b5\3\2\2\2\"\u00b7\3\2"+
		"\2\2$\u00bc\3\2\2\2&\u00c4\3\2\2\2(\u00c6\3\2\2\2*\u00ca\3\2\2\2,\u00cc"+
		"\3\2\2\2.\u00d4\3\2\2\2\60\u00d6\3\2\2\2\62\u00de\3\2\2\2\64\u00e0\3\2"+
		"\2\2\66\u00e8\3\2\2\28\u00ea\3\2\2\2:\u00ec\3\2\2\2<\u00f8\3\2\2\2>\u00fa"+
		"\3\2\2\2@\u010a\3\2\2\2B\u0120\3\2\2\2D\u0126\3\2\2\2FG\5\4\3\2GH\7\2"+
		"\2\3H\3\3\2\2\2IJ\5\b\5\2JK\5\4\3\2KN\3\2\2\2LN\3\2\2\2MI\3\2\2\2ML\3"+
		"\2\2\2N\5\3\2\2\2OP\7\7\2\2PQ\5\4\3\2QR\7\b\2\2R\7\3\2\2\2ST\5\f\7\2T"+
		"U\7\t\2\2Uh\3\2\2\2VW\5\22\n\2WX\7\t\2\2Xh\3\2\2\2Yh\5\24\13\2Zh\5\26"+
		"\f\2[h\5\30\r\2\\]\5\32\16\2]^\7\t\2\2^h\3\2\2\2_h\5\34\17\2`a\5\"\22"+
		"\2ab\7\t\2\2bh\3\2\2\2cd\5\n\6\2de\7\t\2\2eh\3\2\2\2fh\5\6\4\2gS\3\2\2"+
		"\2gV\3\2\2\2gY\3\2\2\2gZ\3\2\2\2g[\3\2\2\2g\\\3\2\2\2g_\3\2\2\2g`\3\2"+
		"\2\2gc\3\2\2\2gf\3\2\2\2h\t\3\2\2\2ij\7\"\2\2jk\5*\26\2k\13\3\2\2\2lm"+
		"\5\20\t\2mn\7#\2\2nt\3\2\2\2op\5\20\t\2pq\7#\2\2qr\5\16\b\2rt\3\2\2\2"+
		"sl\3\2\2\2so\3\2\2\2t\r\3\2\2\2uv\7\13\2\2vw\5(\25\2w\17\3\2\2\2xy\t\2"+
		"\2\2y\21\3\2\2\2z{\7#\2\2{|\5\16\b\2|\23\3\2\2\2}~\7\32\2\2~\177\7\3\2"+
		"\2\177\u0080\5\22\n\2\u0080\u0081\7\t\2\2\u0081\u0082\5(\25\2\u0082\u0083"+
		"\7\t\2\2\u0083\u0084\7#\2\2\u0084\u0085\5\16\b\2\u0085\u0086\7\4\2\2\u0086"+
		"\u0087\5\b\5\2\u0087\25\3\2\2\2\u0088\u0089\7\33\2\2\u0089\u008a\7\3\2"+
		"\2\u008a\u008b\5(\25\2\u008b\u008c\7\4\2\2\u008c\u008d\5\b\5\2\u008d\27"+
		"\3\2\2\2\u008e\u008f\7\34\2\2\u008f\u0090\7\3\2\2\u0090\u0091\5(\25\2"+
		"\u0091\u0092\7\4\2\2\u0092\u0093\5\b\5\2\u0093\u009d\3\2\2\2\u0094\u0095"+
		"\7\34\2\2\u0095\u0096\7\3\2\2\u0096\u0097\5(\25\2\u0097\u0098\7\4\2\2"+
		"\u0098\u0099\5\6\4\2\u0099\u009a\7\35\2\2\u009a\u009b\5\6\4\2\u009b\u009d"+
		"\3\2\2\2\u009c\u008e\3\2\2\2\u009c\u0094\3\2\2\2\u009d\31\3\2\2\2\u009e"+
		"\u009f\5\20\t\2\u009f\u00a0\7#\2\2\u00a0\u00a1\7\3\2\2\u00a1\u00a2\5\36"+
		"\20\2\u00a2\u00a3\7\4\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\5\20\t\2\u00a5"+
		"\u00a6\7#\2\2\u00a6\u00a7\7\3\2\2\u00a7\u00a8\5\36\20\2\u00a8\u00a9\7"+
		"\4\2\2\u00a9\u00aa\5\6\4\2\u00aa\35\3\2\2\2\u00ab\u00ac\5 \21\2\u00ac"+
		"\37\3\2\2\2\u00ad\u00ae\5\f\7\2\u00ae\u00af\5 \21\2\u00af\u00b6\3\2\2"+
		"\2\u00b0\u00b1\7\n\2\2\u00b1\u00b2\5\f\7\2\u00b2\u00b3\5 \21\2\u00b3\u00b6"+
		"\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00ad\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6!\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8\u00b9\7\3\2\2\u00b9"+
		"\u00ba\5$\23\2\u00ba\u00bb\7\4\2\2\u00bb#\3\2\2\2\u00bc\u00bd\5(\25\2"+
		"\u00bd\u00be\5&\24\2\u00be%\3\2\2\2\u00bf\u00c0\7\n\2\2\u00c0\u00c1\5"+
		"(\25\2\u00c1\u00c2\5&\24\2\u00c2\u00c5\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00bf\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\'\3\2\2\2\u00c6\u00c7\5*\26\2"+
		"\u00c7)\3\2\2\2\u00c8\u00cb\5,\27\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3"+
		"\2\2\2\u00ca\u00c9\3\2\2\2\u00cb+\3\2\2\2\u00cc\u00cd\5\60\31\2\u00cd"+
		"\u00ce\5.\30\2\u00ce-\3\2\2\2\u00cf\u00d0\7\27\2\2\u00d0\u00d1\5\60\31"+
		"\2\u00d1\u00d2\5.\30\2\u00d2\u00d5\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00cf"+
		"\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5/\3\2\2\2\u00d6\u00d7\5\64\33\2\u00d7"+
		"\u00d8\5\62\32\2\u00d8\61\3\2\2\2\u00d9\u00da\7\30\2\2\u00da\u00db\5\64"+
		"\33\2\u00db\u00dc\5\62\32\2\u00dc\u00df\3\2\2\2\u00dd\u00df\3\2\2\2\u00de"+
		"\u00d9\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\63\3\2\2\2\u00e0\u00e1\5:\36"+
		"\2\u00e1\u00e2\5\66\34\2\u00e2\65\3\2\2\2\u00e3\u00e4\58\35\2\u00e4\u00e5"+
		"\5:\36\2\u00e5\u00e6\5\66\34\2\u00e6\u00e9\3\2\2\2\u00e7\u00e9\3\2\2\2"+
		"\u00e8\u00e3\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\67\3\2\2\2\u00ea\u00eb"+
		"\t\3\2\2\u00eb9\3\2\2\2\u00ec\u00ed\5> \2\u00ed\u00ee\5<\37\2\u00ee;\3"+
		"\2\2\2\u00ef\u00f0\7\22\2\2\u00f0\u00f1\5> \2\u00f1\u00f2\5<\37\2\u00f2"+
		"\u00f9\3\2\2\2\u00f3\u00f4\7\23\2\2\u00f4\u00f5\5> \2\u00f5\u00f6\5<\37"+
		"\2\u00f6\u00f9\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00ef\3\2\2\2\u00f8\u00f3"+
		"\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9=\3\2\2\2\u00fa\u00fb\5B\"\2\u00fb\u00fc"+
		"\5@!\2\u00fc?\3\2\2\2\u00fd\u00fe\7\24\2\2\u00fe\u00ff\5B\"\2\u00ff\u0100"+
		"\5@!\2\u0100\u010b\3\2\2\2\u0101\u0102\7\25\2\2\u0102\u0103\5B\"\2\u0103"+
		"\u0104\5@!\2\u0104\u010b\3\2\2\2\u0105\u0106\7\26\2\2\u0106\u0107\5B\""+
		"\2\u0107\u0108\5@!\2\u0108\u010b\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u00fd"+
		"\3\2\2\2\u010a\u0101\3\2\2\2\u010a\u0105\3\2\2\2\u010a\u0109\3\2\2\2\u010b"+
		"A\3\2\2\2\u010c\u010d\5D#\2\u010d\u010e\7\3\2\2\u010e\u010f\5*\26\2\u010f"+
		"\u0110\7\4\2\2\u0110\u0121\3\2\2\2\u0111\u0112\5D#\2\u0112\u0113\5\"\22"+
		"\2\u0113\u0121\3\2\2\2\u0114\u0115\5D#\2\u0115\u0116\7$\2\2\u0116\u0121"+
		"\3\2\2\2\u0117\u0118\5D#\2\u0118\u0119\7%\2\2\u0119\u0121\3\2\2\2\u011a"+
		"\u011b\5D#\2\u011b\u011c\7&\2\2\u011c\u0121\3\2\2\2\u011d\u011e\5D#\2"+
		"\u011e\u011f\7#\2\2\u011f\u0121\3\2\2\2\u0120\u010c\3\2\2\2\u0120\u0111"+
		"\3\2\2\2\u0120\u0114\3\2\2\2\u0120\u0117\3\2\2\2\u0120\u011a\3\2\2\2\u0120"+
		"\u011d\3\2\2\2\u0121C\3\2\2\2\u0122\u0127\7\22\2\2\u0123\u0127\7\23\2"+
		"\2\u0124\u0127\7\31\2\2\u0125\u0127\3\2\2\2\u0126\u0122\3\2\2\2\u0126"+
		"\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127E\3\2\2\2"+
		"\20Mgs\u009c\u00b5\u00c4\u00ca\u00d4\u00de\u00e8\u00f8\u010a\u0120\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}