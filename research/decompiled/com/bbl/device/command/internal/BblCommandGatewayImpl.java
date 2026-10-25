package com.bbl.device.command.internal;

import com.alipay.sdk.m.y.q;
import com.bambulab.bambulab.feature.threemfviewer.presentation.preview.Preview3DViewportStageKt;
import com.bbl.device.command.BblCommandFailureReason;
import com.bbl.device.command.BblCommandGateway;
import com.bbl.device.command.BblCommandPublishException;
import com.bbl.device.command.BblCommandReceipt;
import com.bbl.device.command.BblErrorRecoveryHandler;
import com.bbl.device.command.BblProceedAction;
import com.bbl.device.command.BblProceedContext;
import com.bbl.device.command.BblRmIdxEntry;
import com.bbl.device.command.BblTypedReceipt;
import com.bbl.device.model.BblPrinterStateView;
import com.bbl.mqtt.api.model.MqttError;
import com.facebook.imageutils.JfifUtil;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.ek;
import defpackage.a82;
import defpackage.am8;
import defpackage.bhp;
import defpackage.bqu;
import defpackage.bug;
import defpackage.cm8;
import defpackage.dgh;
import defpackage.dtk;
import defpackage.dy4;
import defpackage.egb;
import defpackage.eq1;
import defpackage.eru;
import defpackage.fd6;
import defpackage.gti;
import defpackage.hhq;
import defpackage.huh;
import defpackage.i1k;
import defpackage.ibq;
import defpackage.ipd;
import defpackage.jfn;
import defpackage.l2v;
import defpackage.lm7;
import defpackage.mm7;
import defpackage.nod;
import defpackage.nsf;
import defpackage.nzn;
import defpackage.o78;
import defpackage.o7r;
import defpackage.ob2;
import defpackage.ofo;
import defpackage.rf7;
import defpackage.rs4;
import defpackage.s86;
import defpackage.t86;
import defpackage.tf7;
import defpackage.trs;
import defpackage.uzn;
import defpackage.vvh;
import defpackage.vzr;
import defpackage.xhb;
import defpackage.y72;
import defpackage.yjn;
import defpackage.z72;
import io.agora.rtc2.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0081\u0001\u0010\u0019\u001a}\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012(\u0012&\u0012\"\u0012 \b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f\u0012\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J \u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b%\u0010&J(\u0010'\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b'\u0010(J2\u0010*\u001a\u0004\u0018\u00010$2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010)\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b*\u0010+J(\u0010,\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b,\u0010(J'\u00102\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J4\u00106\u001a\u00020$2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b04H\u0082@¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u0013H\u0002¢\u0006\u0004\b:\u0010;JB\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>\"\u0004\b\u0000\u0010<2\u0006\u0010\u001f\u001a\u00020\u001e2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00018\u0000042\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b?\u0010@J \u0010?\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b?\u0010AR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010BR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010CR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010DR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010DR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010DR\u008f\u0001\u0010\u0019\u001a}\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012(\u0012&\u0012\"\u0012 \b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010ER\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010D¨\u0006F"}, d2 = {"Lcom/bbl/device/command/internal/BblCommandGatewayImpl;", "Lcom/bbl/device/command/BblCommandGateway;", "Lbhp;", "commandTracker", "Lhhq;", "Lcom/bbl/device/model/BblPrinterStateView;", "stateView", "Lkotlin/Function0;", "", "isReady", "isClosed", "isTransportConnected", "Lkotlin/Function4;", "Lguk;", "name", "sign", "", "", "encryptKeys", "", "timeoutMs", "Lrf7;", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "buildTransform", "Lcom/bbl/device/command/BblErrorRecoveryHandler;", "recoveryHandler", "<init>", "(Lbhp;Lhhq;Lnod;Lnod;Lnod;Lipd;Lnod;)V", "Lob2;", "request", "isCommandRouteUnavailable", "(Lob2;)Z", "Lxhb;", "encoded", "Lcom/bbl/device/command/BblCommandReceipt;", "fireAndForget", "(Lxhb;JLrf7;)Ljava/lang/Object;", "ack", "(Lob2;Lxhb;JLrf7;)Ljava/lang/Object;", "failedReceipt", "maybeRecover", "(Lob2;Lxhb;Lcom/bbl/device/command/BblCommandReceipt;JLrf7;)Ljava/lang/Object;", "sendAndBuildReceipt", "seqId", "", "resp", "Lfd6;", "cmdResult", "buildFailedReceipt", "(Ljava/lang/String;[BLfd6;)Lcom/bbl/device/command/BblCommandReceipt;", "Lkotlin/Function1;", "predicate", "observed", "(Lxhb;JLkotlin/jvm/functions/Function1;Lrf7;)Ljava/lang/Object;", "totalTimeoutMs", "startedAtNanos", "remainingBudgetMs", "(JJ)J", "T", "parser", "Lcom/bbl/device/command/BblTypedReceipt;", "send", "(Lob2;Lkotlin/jvm/functions/Function1;JLrf7;)Ljava/lang/Object;", "(Lob2;JLrf7;)Ljava/lang/Object;", "Lbhp;", "Lhhq;", "Lnod;", "Lipd;", "device-biz"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BblCommandGatewayImpl implements BblCommandGateway {
    private final ipd<Boolean, List<String>, Long, rf7<? super Function2<? super JSONObject, ? super rf7<? super JSONObject>, ? extends Object>>, Object> buildTransform;
    private final bhp commandTracker;
    private final nod<Boolean> isClosed;
    private final nod<Boolean> isReady;
    private final nod<Boolean> isTransportConnected;
    private final nod<BblErrorRecoveryHandler> recoveryHandler;
    private final hhq<BblPrinterStateView> stateView;

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[y72.values().length];
            r0[0] = 1;     // Catch: NoSuchFieldError -> L10
        L13:
            r0[1] = 2;     // Catch: NoSuchFieldError -> L11
        L17:
            r0[2] = 3;     // Catch: NoSuchFieldError -> L12
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl", f = "BblCommandGatewayImpl.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {174, Constants.VIDEO_ORIENTATION_180}, m = "ack", n = {"request", "encoded", "timeoutMs", "request", "encoded", "receipt", "timeoutMs"}, nl = {175, -1}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"}, v = 2)
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$ack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends tf7 {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        public AnonymousClass1(BblCommandGatewayImpl r1, rf7<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return BblCommandGatewayImpl.access$ack(this.this$0, null, null, 0, this);
        }
    }

    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl", f = "BblCommandGatewayImpl.kt", i = {0, 0, 1, 1, 1}, l = {156, 157}, m = "fireAndForget", n = {"encoded", "timeoutMs", "encoded", "transform", "timeoutMs"}, nl = {157, 160}, s = {"L$0", "J$0", "L$0", "L$1", "J$0"}, v = 2)
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$fireAndForget$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02971 extends tf7 {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        public C02971(BblCommandGatewayImpl r1, rf7<? super C02971> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return BblCommandGatewayImpl.access$fireAndForget(this.this$0, null, 0, this);
        }
    }

    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl", f = "BblCommandGatewayImpl.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {203, JfifUtil.MARKER_EOI}, m = "maybeRecover", n = {"request", "encoded", "failedReceipt", "proceedCtx", "handler", "timeoutMs", "request", "encoded", "failedReceipt", "proceedCtx", "handler", "action", "proceedData", "timeoutMs"}, nl = {205, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0"}, v = 2)
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$maybeRecover$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02981 extends tf7 {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        public C02981(BblCommandGatewayImpl r1, rf7<? super C02981> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return BblCommandGatewayImpl.access$maybeRecover(this.this$0, null, null, null, 0, this);
        }
    }

    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl", f = "BblCommandGatewayImpl.kt", i = {0, 0, 0, 0}, l = {319}, m = "observed", n = {"encoded", "predicate", "ackPayload", "timeoutMs"}, nl = {347}, s = {"L$0", "L$1", "L$2", "J$0"}, v = 2)
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$observed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02991 extends tf7 {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        public C02991(BblCommandGatewayImpl r1, rf7<? super C02991> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return BblCommandGatewayImpl.access$observed(this.this$0, null, 0, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Llm7;", "Lcom/bbl/device/model/BblPrinterStateView;", "<anonymous>", "(Llm7;)Lcom/bbl/device/model/BblPrinterStateView;"}, k = 3, mv = {2, 4, 0})
    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl$observed$2", f = "BblCommandGatewayImpl.kt", i = {}, l = {Preview3DViewportStageKt.PREVIEW3D_MODEL_CROSS_DISSOLVE_MS}, m = "invokeSuspend", n = {}, nl = {345}, s = {}, v = 2)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$observed$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o7r implements Function2<lm7, rf7<? super BblPrinterStateView>, Object> {
        final /* synthetic */ nzn $ackPayload;
        final /* synthetic */ xhb $encoded;
        final /* synthetic */ Function1<BblPrinterStateView, Boolean> $predicate;
        final /* synthetic */ long $timeoutMs;
        int label;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Llm7;", "Lcom/bbl/device/model/BblPrinterStateView;", "<anonymous>", "(Llm7;)Lcom/bbl/device/model/BblPrinterStateView;"}, k = 3, mv = {2, 4, 0})
        @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl$observed$2$1", f = "BblCommandGatewayImpl.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2}, l = {326, 328, 344}, m = "invokeSuspend", n = {"$this$coroutineScope", "stateDeferred", "startedAt", "$this$coroutineScope", "stateDeferred", "transform", "startedAt", "remainingTimeoutMs", "$this$coroutineScope", "stateDeferred"}, nl = {327, 332, -1}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1"}, v = 2)
        /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$observed$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o7r implements Function2<lm7, rf7<? super BblPrinterStateView>, Object> {
            final /* synthetic */ nzn $ackPayload;
            final /* synthetic */ xhb $encoded;
            final /* synthetic */ Function1<BblPrinterStateView, Boolean> $predicate;
            final /* synthetic */ long $timeoutMs;
            long J$0;
            long J$1;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ BblCommandGatewayImpl this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(BblCommandGatewayImpl r1, xhb r2, long r3, nzn r5, Function1<? super BblPrinterStateView, Boolean> r6, rf7<? super AnonymousClass1> r7) {
                this.this$0 = r1;
                this.$encoded = r2;
                this.$timeoutMs = r3;
                this.$ackPayload = r5;
                this.$predicate = r6;
                super(2, r7);
            }

            @Override // defpackage.ft1
            public final rf7<trs> create(Object r9, rf7<?> r10) {
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$encoded, this.$timeoutMs, this.$ackPayload, this.$predicate, r10);
                r0.L$0 = r9;
                return r0;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((lm7) r1, (rf7) r2);
            }

            public final Object invoke(lm7 r1, rf7<? super BblPrinterStateView> r2) {
                return ((AnonymousClass1) create(r1, r2)).invokeSuspend(trs.a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v6, types: [am8] */
            @Override // defpackage.ft1
            public final Object invokeSuspend(Object r23) {
                lm7 r8 = (lm7) this.L$0;
                Object r9 = nsf.getCOROUTINE_SUSPENDED();
                int r0 = this.label;
                if (r0 == 0) goto L23;
                if (r0 == 1) goto L17;
                if (r0 == 2) goto L11;
                if (r0 != 3) goto L9;
                am8 r02 = (am8) this.L$1;
                gti.r(r23);
                return r23;
            L9:
                jfn.u("call to 'resume' before 'invoke' with coroutine");
                return null;
            L11:
                nzn r03 = (nzn) this.L$3;
                Function2 r1 = (Function2) this.L$2;
                am8 r12 = (am8) this.L$1;
                gti.r(r23);     // Catch: BblCommandPublishException -> L14 TimeoutException -> L67 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                nzn r13 = r03;
                Object r04 = r23;
            L83:
                r13.a = r04;     // Catch: TimeoutException -> L66 BblCommandPublishException -> L39 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
            L39:
                e = e;
            L40:
                CancellationException r2 = null;
            L59:
                r12.b(r2);
                throw e;
            L38:
                Object r22 = null;
            L62:
                this.L$0 = ibq.nullOutSpilledVariable(r8);
                this.L$1 = ibq.nullOutSpilledVariable(r12);
                this.L$2 = r22;
                this.L$3 = r22;
                this.label = 3;
                Object r05 = r12.S0(this);
                if (r05 != r9) goto L65;
            L64:
                return r9;
            L65:
                return r05;
            L14:
                e = e;
            L15:
                r2 = null;
            L16:
                r22 = null;
                goto L62
            L17:
                long r24 = this.J$0;
                ?? r4 = (am8) this.L$1;
                gti.r(r23);     // Catch: BblCommandPublishException -> L20 TimeoutException -> L22 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                Object r06 = r23;
                cm8 r122 = r4;
            L75:
                Function2 r6 = (Function2) r06;     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                long r42 = BblCommandGatewayImpl.access$remainingBudgetMs(this.this$0, this.$timeoutMs, r24);     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                r13 = this.$ackPayload;     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                bhp r07 = BblCommandGatewayImpl.access$getCommandTracker$p(this.this$0);     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                xhb r14 = this.$encoded;     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                String r15 = r14.a;     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                String r10 = r14.b;     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                Map r142 = r14.c;     // Catch: BblCommandPublishException -> L47 TimeoutException -> L49 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                long r18 = r24;
                cm8 r17 = r122;
                long r16 = Math.min(r42 / 2, 10000);     // Catch: BblCommandPublishException -> L44 TimeoutException -> L46 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.L$0 = ibq.nullOutSpilledVariable(r8);     // Catch: BblCommandPublishException -> L44 TimeoutException -> L46 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                cm8 r11 = r17;
                this.L$1 = r11;     // Catch: BblCommandPublishException -> L41 TimeoutException -> L68 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.L$2 = ibq.nullOutSpilledVariable(r6);     // Catch: BblCommandPublishException -> L41 TimeoutException -> L68 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.L$3 = r13;     // Catch: BblCommandPublishException -> L41 TimeoutException -> L68 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.J$0 = r18;     // Catch: BblCommandPublishException -> L41 TimeoutException -> L68 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.J$1 = r42;     // Catch: BblCommandPublishException -> L41 TimeoutException -> L68 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.label = 2;     // Catch: BblCommandPublishException -> L41 TimeoutException -> L68 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                r04 = r07.c(r15, r10, r142, r16, r6, this);     // Catch: BblCommandPublishException -> L41 TimeoutException -> L68 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                if (r04 == r9) goto L64;
                r12 = r11;
                goto L83
            L41:
                e = e;
            L42:
                r12 = r11;
            L43:
                r12 = r11;
                goto L38
            L44:
                e = e;
                r11 = r17;
            L46:
                r11 = r17;
                goto L43
            L47:
                e = e;
                r11 = r122;
            L49:
                r11 = r122;
                goto L43
            L20:
                e = e;
                r12 = r4;
            L22:
                r12 = r4;
                goto L16
            L23:
                gti.r(r23);
                cm8 r3 = dy4.a(r8, null, null, new BblCommandGatewayImpl$observed$2$1$stateDeferred$1(this.this$0, this.$predicate, null), 3);
                long r43 = System.nanoTime();     // Catch: BblCommandPublishException -> L50 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57 TimeoutException -> L61
                ipd r08 = BblCommandGatewayImpl.access$getBuildTransform$p(this.this$0);     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                Boolean r62 = rs4.boxBoolean(this.$encoded.d);     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                List r123 = this.$encoded.e;     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                Long r132 = rs4.boxLong(this.$timeoutMs);     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.L$0 = ibq.nullOutSpilledVariable(r8);     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.L$1 = r3;     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.J$0 = r43;     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                this.label = 1;     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                r06 = r08.invoke(r62, r123, r132, this);     // Catch: BblCommandPublishException -> L50 TimeoutException -> L52 SecurityException -> L53 CapabilitiesNotReadyException -> L55 CancellationException -> L57
                if (r06 == r9) goto L64;
                r122 = r3;
                r24 = r43;
                goto L75
            L52:
                r12 = r3;
            L50:
                e = e;
                r12 = r3;
            L61:
                r22 = null;
                r12 = r3;
            L55:
                e = move-exception;
                throw e;
            L53:
                e = move-exception;
                throw e;
            L57:
                e = move-exception;
                throw e;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(BblCommandGatewayImpl r1, xhb r2, long r3, nzn r5, Function1<? super BblPrinterStateView, Boolean> r6, rf7<? super AnonymousClass2> r7) {
            this.this$0 = r1;
            this.$encoded = r2;
            this.$timeoutMs = r3;
            this.$ackPayload = r5;
            this.$predicate = r6;
            super(2, r7);
        }

        @Override // defpackage.ft1
        public final rf7<trs> create(Object r9, rf7<?> r10) {
            return new AnonymousClass2(this.this$0, this.$encoded, this.$timeoutMs, this.$ackPayload, this.$predicate, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((lm7) r1, (rf7) r2);
        }

        public final Object invoke(lm7 r1, rf7<? super BblPrinterStateView> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(trs.a);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r12) {
            Object r0 = nsf.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L7;
            gti.r(r12);
            return r12;
        L7:
            jfn.u("call to 'resume' before 'invoke' with coroutine");
            return null;
        L9:
            gti.r(r12);
            AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$encoded, this.$timeoutMs, this.$ackPayload, this.$predicate, null);
            this.label = 1;
            Object r11 = mm7.c(r3, this);
            if (r11 != r0) goto L12;
            return r0;
        L12:
            return r11;
        }
    }

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl", f = "BblCommandGatewayImpl.kt", i = {0, 0, 0}, l = {70}, m = "send", n = {"request", "parser", "timeoutMs"}, nl = {73}, s = {"L$0", "L$1", "J$0"}, v = 2)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$send$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03001<T> extends tf7 {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        public C03001(BblCommandGatewayImpl r1, rf7<? super C03001> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.send(null, null, 0, this);
        }
    }

    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl", f = "BblCommandGatewayImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {117, Constants.WARN_SET_CLIENT_ROLE_TIMEOUT, q.h}, m = "send", n = {"request", bv.br, "encoded", "timeoutMs", "request", bv.br, "encoded", "timeoutMs", "request", bv.br, "encoded", "predicate", "timeoutMs"}, nl = {Constants.WARN_SET_CLIENT_ROLE_TIMEOUT, 120, 116}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"}, v = 2)
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$send$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03012 extends tf7 {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        public C03012(BblCommandGatewayImpl r1, rf7<? super C03012> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.send(null, 0, this);
        }
    }

    @o78(c = "com.bbl.device.command.internal.BblCommandGatewayImpl", f = "BblCommandGatewayImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {228, 230}, m = "sendAndBuildReceipt", n = {"request", "encoded", "timeoutMs", "startedAt", "request", "encoded", "transform", "timeoutMs", "startedAt", "remainingTimeoutMs"}, nl = {229, 237}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2"}, v = 2)
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.bbl.device.command.internal.BblCommandGatewayImpl$sendAndBuildReceipt$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03021 extends tf7 {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BblCommandGatewayImpl this$0;

        public C03021(BblCommandGatewayImpl r1, rf7<? super C03021> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // defpackage.ft1
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return BblCommandGatewayImpl.access$sendAndBuildReceipt(this.this$0, null, null, 0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BblCommandGatewayImpl(bhp r1, hhq<BblPrinterStateView> r2, nod<Boolean> r3, nod<Boolean> r4, nod<Boolean> r5, ipd<? super Boolean, ? super List<String>, ? super Long, ? super rf7<? super Function2<? super JSONObject, ? super rf7<? super JSONObject>, ? extends Object>>, ? extends Object> r6, nod<? extends BblErrorRecoveryHandler> r7) {
        r1.getClass();
        r2.getClass();
        r3.getClass();
        r4.getClass();
        r5.getClass();
        r6.getClass();
        r7.getClass();
        this.commandTracker = r1;
        this.stateView = r2;
        this.isReady = r3;
        this.isClosed = r4;
        this.isTransportConnected = r5;
        this.buildTransform = r6;
        this.recoveryHandler = r7;
    }

    public /* synthetic */ BblCommandGatewayImpl(bhp r10, hhq r11, nod r12, nod r13, nod r14, ipd r15, nod r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        r14 = new eq1(ek.k);
    L5:
        this(r10, r11, r12, r13, r14, r15, r16);
    }

    private static final boolean _init_$lambda$0() {
        return true;
    }

    public static /* synthetic */ boolean a() {
        return _init_$lambda$0();
    }

    public static final /* synthetic */ Object access$ack(BblCommandGatewayImpl r0, ob2 r1, xhb r2, long r3, rf7 r5) {
        return r0.ack(r1, r2, r3, r5);
    }

    public static final /* synthetic */ Object access$fireAndForget(BblCommandGatewayImpl r0, xhb r1, long r2, rf7 r4) {
        return r0.fireAndForget(r1, r2, r4);
    }

    public static final /* synthetic */ ipd access$getBuildTransform$p(BblCommandGatewayImpl r0) {
        return r0.buildTransform;
    }

    public static final /* synthetic */ bhp access$getCommandTracker$p(BblCommandGatewayImpl r0) {
        return r0.commandTracker;
    }

    public static final /* synthetic */ hhq access$getStateView$p(BblCommandGatewayImpl r0) {
        return r0.stateView;
    }

    public static final /* synthetic */ Object access$maybeRecover(BblCommandGatewayImpl r0, ob2 r1, xhb r2, BblCommandReceipt r3, long r4, rf7 r6) {
        return r0.maybeRecover(r1, r2, r3, r4, r6);
    }

    public static final /* synthetic */ Object access$observed(BblCommandGatewayImpl r0, xhb r1, long r2, Function1 r4, rf7 r5) {
        return r0.observed(r1, r2, r4, r5);
    }

    public static final /* synthetic */ long access$remainingBudgetMs(BblCommandGatewayImpl r0, long r1, long r3) {
        return r0.remainingBudgetMs(r1, r3);
    }

    public static final /* synthetic */ Object access$sendAndBuildReceipt(BblCommandGatewayImpl r0, ob2 r1, xhb r2, long r3, rf7 r5) {
        return r0.sendAndBuildReceipt(r1, r2, r3, r5);
    }

    private final Object ack(ob2 r10, xhb r11, long r12, rf7<? super BblCommandReceipt> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L8;
        AnonymousClass1 r0 = (AnonymousClass1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L8;
        r0.label = r1 - Integer.MIN_VALUE;
    L7:
        AnonymousClass1 r142 = r0;
        Object r02 = r142.result;
        Object r8 = nsf.getCOROUTINE_SUSPENDED();
        int r13 = r142.label;
        if (r13 == 0) goto L18;
        if (r13 == 1) goto L16;
        if (r13 != 2) goto L14;
        BblCommandReceipt r9 = (BblCommandReceipt) r142.L$2;
        xhb r102 = (xhb) r142.L$1;
        ob2 r103 = (ob2) r142.L$0;
        gti.r(r02);
    L30:
        BblCommandReceipt r03 = (BblCommandReceipt) r02;
        if (r03 != null) goto L33;
        return r9;
    L33:
        return r03;
    L14:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L16:
        r12 = r142.J$0;
        r11 = (xhb) r142.L$1;
        r10 = (ob2) r142.L$0;
        gti.r(r02);
    L17:
        xhb r3 = r11;
        long r5 = r12;
        BblCommandReceipt r4 = (BblCommandReceipt) r02;
        if (r4.getStatus() != BblCommandReceipt.Status.FAILED) goto L24;
    L26:
        r142.L$0 = ibq.nullOutSpilledVariable(r10);
        r142.L$1 = ibq.nullOutSpilledVariable(r3);
        r142.L$2 = r4;
        r142.J$0 = r5;
        r142.label = 2;
        r02 = maybeRecover(r10, r3, r4, r5, r142);
        if (r02 != r8) goto L29;
    L28:
        return r8;
    L29:
        r9 = r4;
        goto L30
    L24:
        if (r4.getStatus() == BblCommandReceipt.Status.RECOVERABLE_FAILED) goto L26;
        return r4;
    L18:
        gti.r(r02);
        r142.L$0 = r10;
        r142.L$1 = r11;
        r142.J$0 = r12;
        r142.label = 1;
        r02 = sendAndBuildReceipt(r10, r11, r12, r142);
        if (r02 != r8) goto L17;
    L8:
        r0 = new AnonymousClass1(this, r14);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [egb] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList] */
    private final BblCommandReceipt buildFailedReceipt(String r15, byte[] r16, fd6 r17) {
        boolean r0 = r17.a;
        List r1 = r17.h;
        if (r0 == true) goto L17;
        Integer r02 = r17.f;
        if (r02 != null) goto L7;
        if (r1 == null) goto L17;
    L7:
        r02.getClass();
        int r03 = r02.intValue();
        List r2 = r17.g;
        ?? r3 = egb.a;
        if (r2 != null) goto L10;
        r2 = r3;
    L10:
        if (r1 == null) goto L15;
        List r12 = r1;
        r3 = new ArrayList(t86.N(r12, 10));
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        yjn r4 = (yjn) r13.next();
        r3.add(new BblRmIdxEntry(r4.a, r4.b));
    L15:
        BblProceedContext r14 = new BblProceedContext(r03, r2, r3);
    L16:
        BblProceedContext r10 = r14;
        if (r10 == null) goto L22;
        BblCommandReceipt.Status r04 = BblCommandReceipt.Status.RECOVERABLE_FAILED;
    L21:
        BblCommandReceipt.Status r32 = r04;
        String r05 = r17.e;
        if (r05 != null) goto L26;
        r05 = dgh.g(r17.b, "Device rejected command (msg=", ")");
    L26:
        String r5 = r05;
        Integer r06 = r17.c;
        Integer r18 = r17.d;
        if (r06 != null) goto L29;
    L31:
        if (r18 != null) goto L33;
    L35:
        if (r06 == null) goto L36;
    L30:
        Integer r7 = r06;
    L37:
        BblCommandFailureReason r11 = null;
        return new BblCommandReceipt(r32, r15, r5, r16, r7, r17.c, r17.d, r10, r11, 256, null);
    L36:
        r7 = r18;
        goto L37
    L33:
        if (r18.intValue() == 0) goto L35;
    L29:
        if (r06.intValue() == 0) goto L31;
    L22:
        r04 = BblCommandReceipt.Status.FAILED;
    L17:
        r14 = null;
        goto L16
    }

    private final Object fireAndForget(xhb r15, long r16, rf7<? super BblCommandReceipt> r18) {
        if ((r18 instanceof C02971) == false) goto L8;
        C02971 r2 = (C02971) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L8;
        r2.label = r3 - Integer.MIN_VALUE;
    L7:
        C02971 r8 = r2;
        Object r1 = r8.result;
        Object r22 = nsf.getCOROUTINE_SUSPENDED();
        int r32 = r8.label;
        if (r32 == 0) goto L17;
        if (r32 == 1) goto L16;
        if (r32 != 2) goto L14;
        Function2 r14 = (Function2) r8.L$1;
        xhb r142 = (xhb) r8.L$0;
        gti.r(r1);
    L24:
        dtk r12 = (dtk) r1;
        String r4 = (String) r12.a;
        MqttError r143 = (MqttError) r12.b;
        if (r143 != null) goto L29;
        String r5 = null;
        byte[] r6 = null;
        Integer r7 = null;
        Integer r82 = null;
        Integer r9 = null;
        BblProceedContext r10 = null;
        BblCommandFailureReason r11 = null;
        return new BblCommandReceipt(BblCommandReceipt.Status.SENT, r4, r5, r6, r7, r82, r9, r10, r11, 508, null);
    L29:
        return MqttPublishFailureMapperKt.transportUnavailableReceipt(r143, r4);
    L14:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L16:
        long r52 = r8.J$0;
        xhb r0 = (xhb) r8.L$0;
        gti.r(r1);
    L21:
        Function2 r72 = (Function2) r1;
        bhp r33 = this.commandTracker;
        String r144 = r0.a;
        String r13 = r0.b;
        Map r92 = r0.c;
        r8.L$0 = ibq.nullOutSpilledVariable(r0);
        r8.L$1 = ibq.nullOutSpilledVariable(r72);
        r8.J$0 = r52;
        r8.label = 2;
        r1 = r33.e(r144, r13, r92, r72, r8);
        if (r1 != r22) goto L24;
    L23:
        return r22;
    L17:
        gti.r(r1);
        ipd<Boolean, List<String>, Long, rf7<? super Function2<? super JSONObject, ? super rf7<? super JSONObject>, ? extends Object>>, Object> r17 = this.buildTransform;
        Boolean r34 = rs4.boxBoolean(r15.d);
        List r62 = r15.e;
        Long r73 = rs4.boxLong(r16);
        r8.L$0 = r15;
        r8.J$0 = r16;
        r8.label = 1;
        r1 = r17.invoke(r34, r62, r73, r8);
        if (r1 == r22) goto L23;
        r0 = r15;
        r52 = r16;
    L8:
        r2 = new C02971(this, r18);
        goto L7
    }

    private final boolean isCommandRouteUnavailable(ob2 r1) {
        if ((r1 instanceof a82) == true) goto L7;
        return false;
    L7:
        return !((BblPrinterStateView) this.stateView.getValue()).getProductProfile().getWorkflow().getAmsChangeFilamentByCommand();
    }

    private final Object maybeRecover(ob2 r20, xhb r21, BblCommandReceipt r22, long r23, rf7<? super BblCommandReceipt> r25) {
        if ((r25 instanceof C02981) == false) goto L7;
        C02981 r3 = (C02981) r25;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r42 = nsf.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L16;
        if (r5 != 2) goto L14;
        Map r0 = (Map) r3.L$6;
        BblProceedAction r02 = (BblProceedAction) r3.L$5;
        BblErrorRecoveryHandler r03 = (BblErrorRecoveryHandler) r3.L$4;
        BblProceedContext r04 = (BblProceedContext) r3.L$3;
        BblCommandReceipt r05 = (BblCommandReceipt) r3.L$2;
        xhb r06 = (xhb) r3.L$1;
        ob2 r07 = (ob2) r3.L$0;
        gti.r(r2);
        return r2;
    L14:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L16:
        long r9 = r3.J$0;
        BblErrorRecoveryHandler r1 = (BblErrorRecoveryHandler) r3.L$4;
        BblProceedContext r52 = (BblProceedContext) r3.L$3;
        BblCommandReceipt r7 = (BblCommandReceipt) r3.L$2;
        xhb r11 = (xhb) r3.L$1;
        ob2 r12 = (ob2) r3.L$0;
        gti.r(r2);
        xhb r92 = r11;
        long r10 = r9;
    L27:
        BblProceedAction r24 = (BblProceedAction) r2;
        if (r24 != null) goto L30;
    L29:
        return null;
    L30:
        huh r8 = new huh();
        Map r13 = r92.c;
        if (r13 == null) goto L33;
        r8.putAll(r13);
    L33:
        r8.put("err_index", rs4.boxInt(r52.getErrIndex()));
        bug r132 = s86.s();
        r132.addAll(r52.getErrIgnored());
        if (r52.getErrIgnored().contains(rs4.boxInt(r52.getErrIndex())) == true) goto L36;
        r132.add(rs4.boxInt(r52.getErrIndex()));
    L36:
        r8.put("err_ignored", s86.n(r132));
        bug r133 = s86.s();
        List<BblRmIdxEntry> r14 = r52.getRmIdx();
        ArrayList r15 = new ArrayList(t86.N(r14, 10));
        Iterator<T> r6 = r14.iterator();
    L37:
        BblErrorRecoveryHandler r202 = r1;
        if (r6.hasNext() == false) goto L40;
        BblRmIdxEntry r142 = (BblRmIdxEntry) r6.next();
        BblProceedAction r212 = r24;
        BblProceedContext r222 = r52;
        r15.add(vvh.h0(new dtk[]{new dtk("idx", rs4.boxInt(r142.getIdx())), new dtk("mode", rs4.boxInt(r142.getMode()))}));
        r1 = r202;
        r24 = r212;
        r52 = r222;
        goto L37
    L40:
        BblProceedAction r213 = r24;
        BblProceedContext r223 = r52;
        r133.addAll(r15);
        r133.add(vvh.h0(new dtk[]{new dtk("idx", rs4.boxInt(r223.getErrIndex())), new dtk("mode", rs4.boxInt(r213.getMode()))}));
        r8.put("rm_idx", s86.n(r133));
        huh r08 = r8.c();
        xhb r16 = xhb.a(r92, r08, 27);
        r3.L$0 = ibq.nullOutSpilledVariable(r12);
        r3.L$1 = ibq.nullOutSpilledVariable(r92);
        r3.L$2 = ibq.nullOutSpilledVariable(r7);
        r3.L$3 = ibq.nullOutSpilledVariable(r223);
        r3.L$4 = ibq.nullOutSpilledVariable(r202);
        r3.L$5 = ibq.nullOutSpilledVariable(r213);
        r3.L$6 = ibq.nullOutSpilledVariable(r08);
        r3.J$0 = r10;
        r3.label = 2;
        long r232 = r10;
        ob2 r214 = r12;
        Object r09 = sendAndBuildReceipt(r214, r16, r232, r3);
        if (r09 != r42) goto L43;
    L42:
        return r42;
    L43:
        return r09;
    L17:
        gti.r(r2);
        r52 = r22.getProceedContext();
        if (r52 == null) goto L29;
        BblErrorRecoveryHandler r26 = (BblErrorRecoveryHandler) this.recoveryHandler.invoke();
        if (r26 == null) goto L29;
        r3.L$0 = r20;
        r92 = r21;
        r3.L$1 = r92;
        r3.L$2 = ibq.nullOutSpilledVariable(r22);
        r3.L$3 = r52;
        r3.L$4 = ibq.nullOutSpilledVariable(r26);
        r10 = r23;
        r3.J$0 = r10;
        r3.label = 1;
        r7 = r22;
        Object r122 = r26.onRecoverableError(r20, r7, r3);
        if (r122 == r42) goto L42;
        r12 = r20;
        r1 = r26;
        r2 = r122;
    L7:
        r3 = new C02981(this, r25);
        goto L8
    }

    private final Object observed(xhb r24, long r25, Function1<? super BblPrinterStateView, Boolean> r27, rf7<? super BblCommandReceipt> r28) {
        if ((r28 instanceof C02991) == false) goto L8;
        C02991 r1 = (C02991) r28;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L8;
        r1.label = r2 - Integer.MIN_VALUE;
        BblCommandGatewayImpl r22 = this;
    L7:
        C02991 r8 = r1;
        Object r0 = r8.result;
        Object r9 = nsf.getCOROUTINE_SUSPENDED();
        int r12 = r8.label;
        String r10 = null;
        if (r12 == 0) goto L17;
        if (r12 != 1) goto L15;
        nzn r13 = (nzn) r8.L$2;
        Function1 r23 = (Function1) r8.L$1;
        xhb r26 = (xhb) r8.L$0;
        gti.r(r0);     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
    L22:
        byte[] r02 = (byte[]) r13.a;     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        if (r02 == null) goto L30;
        dtk r03 = l2v.c(r02);     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        if (r03 == null) goto L27;
        r10 = (String) r03.b;     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
    L27:
        if (r10 == null) goto L30;
    L29:
        String r132 = r10;
        String r14 = null;
        Integer r16 = null;
        Integer r17 = null;
        Integer r18 = null;
        BblProceedContext r19 = null;
        BblCommandFailureReason r20 = null;
        return new BblCommandReceipt(BblCommandReceipt.Status.SUCCEEDED, r132, r14, (byte[]) r13.a, r16, r17, r18, r19, r20, 500, null);
    L30:
        r10 = "";
        goto L29
    L15:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L17:
        gti.r(r0);
        nzn r5 = new nzn();     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        AnonymousClass2 r04 = new AnonymousClass2(r22, r24, r25, r5, r27, null);     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        r8.L$0 = ibq.nullOutSpilledVariable(r24);     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        r8.L$1 = ibq.nullOutSpilledVariable(r27);     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        r8.L$2 = r5;     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        r8.J$0 = r25;     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        r8.label = 1;     // Catch: Exception -> L33 CancellationException -> L35 SecurityException -> L37 CapabilitiesNotReadyException -> L39 vzr -> L41 BblCommandPublishException -> L42
        if (bqu.f(r25, r04, r8) != r9) goto L21;
        return r9;
    L21:
        r13 = r5;
    L42:
        e = move-exception;
        return MqttPublishFailureMapperKt.transportUnavailableReceipt(e);
    L39:
        e = move-exception;
        throw e;
    L37:
        e = move-exception;
        throw e;
    L41:
        String r3 = null;
        String r4 = null;
        byte[] r52 = null;
        Integer r6 = null;
        Integer r7 = null;
        Integer r82 = null;
        BblProceedContext r92 = null;
        BblCommandFailureReason r102 = null;
        return new BblCommandReceipt(BblCommandReceipt.Status.TIMEOUT, r3, r4, r52, r6, r7, r82, r92, r102, 510, null);
    L35:
        e = move-exception;
        throw e;
    L33:
        e = move-exception;
        String r32 = null;
        byte[] r53 = null;
        Integer r62 = null;
        Integer r72 = null;
        Integer r83 = null;
        BblProceedContext r93 = null;
        BblCommandFailureReason r103 = null;
        return new BblCommandReceipt(BblCommandReceipt.Status.FAILED, r32, e.getMessage(), r53, r62, r72, r83, r93, r103, 506, null);
    L8:
        r22 = this;
        r1 = new C02991(r22, r28);
        goto L7
    }

    private final long remainingBudgetMs(long r3, long r5) {
        long r32 = r3 - ((System.nanoTime() - r5) / 1000000);
        if (r32 >= 0) goto L5;
        return 0;
    L5:
        return r32;
    }

    private final Object sendAndBuildReceipt(ob2 r17, xhb r18, long r19, rf7<? super BblCommandReceipt> r21) {
        xhb r1 = r18;
        if ((r21 instanceof C03021) == false) goto L8;
        C03021 r3 = (C03021) r21;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L8;
        r3.label = r4 - Integer.MIN_VALUE;
    L7:
        C03021 r11 = r3;
        Object r2 = r11.result;
        Object r32 = nsf.getCOROUTINE_SUSPENDED();
        int r42 = r11.label;
        if (r42 == 0) goto L21;
        if (r42 == 1) goto L18;
        if (r42 != 2) goto L16;
        Function2 r12 = (Function2) r11.L$2;
        xhb r13 = (xhb) r11.L$1;
        ob2 r14 = (ob2) r11.L$0;
        gti.r(r2);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        Object r22 = r2;
    L29:
        byte[] r7 = (byte[]) r22;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        dtk r15 = l2v.c(r7);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        if (r15 == null) goto L35;
        String r16 = (String) r15.b;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        if (r16 == null) goto L35;
    L34:
        String r5 = r16;
        fd6 r110 = l2v.b(r7);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        if (r110 != null) goto L39;
    L43:
        BblCommandReceipt.Status r43 = BblCommandReceipt.Status.ACCEPTED;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        if (r110 == null) goto L57;
        Integer r0 = r110.c;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        Integer r23 = r110.d;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        if (r0 != null) goto L48;
    L50:
        if (r23 != null) goto L52;
    L54:
        if (r0 != null) goto L56;
    L55:
        r0 = r23;
    L56:
        Integer r8 = r0;
    L58:
        if (r110 == null) goto L60;
        Integer r9 = r110.c;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
    L61:
        if (r110 == null) goto L63;
        Integer r10 = r110.d;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
    L64:
        String r6 = null;
        BblProceedContext r112 = null;
        BblCommandFailureReason r122 = null;
        return new BblCommandReceipt(r43, r5, r6, r7, r8, r9, r10, r112, r122, 388, null);
    L63:
        r10 = null;
        goto L64
    L60:
        r9 = null;
        goto L61
    L52:
        if (r23.intValue() == 0) goto L54;
    L48:
        if (r0.intValue() == 0) goto L50;
    L57:
        r8 = null;
        goto L58
    L39:
        if (r110.a == true) goto L43;
        return buildFailedReceipt(r5, r7, r110);
    L35:
        r16 = "";
        goto L34
    L16:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L18:
        long r62 = r11.J$1;
        long r82 = r11.J$0;
        r1 = (xhb) r11.L$1;
        ob2 r44 = (ob2) r11.L$0;
        gti.r(r2);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        long r132 = r82;
        Object r24 = r2;
    L26:
        Function2 r102 = (Function2) r24;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        long r83 = remainingBudgetMs(r132, r62);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        ob2 r25 = r44;
        bhp r45 = this.commandTracker;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        String r152 = r1.a;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        String r123 = r1.b;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        Map r52 = r1.c;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.L$0 = ibq.nullOutSpilledVariable(r25);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.L$1 = ibq.nullOutSpilledVariable(r1);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.L$2 = ibq.nullOutSpilledVariable(r102);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.J$0 = r132;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.J$1 = r62;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.J$2 = r83;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.label = 2;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        Object r26 = r45.c(r152, r123, r52, r83, r102, r11);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r22 = r26;
        if (r26 != r32) goto L29;
    L28:
        return r32;
    L21:
        gti.r(r2);
        long r72 = System.nanoTime();     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        ipd<Boolean, List<String>, Long, rf7<? super Function2<? super JSONObject, ? super rf7<? super JSONObject>, ? extends Object>>, Object> r27 = this.buildTransform;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        Boolean r46 = rs4.boxBoolean(r1.d);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        List r92 = r1.e;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        Long r103 = rs4.boxLong(r19);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.L$0 = ibq.nullOutSpilledVariable(r17);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.L$1 = r1;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r132 = r19;
        r11.J$0 = r132;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.J$1 = r72;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        r11.label = 1;     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        Object r28 = r27.invoke(r46, r92, r103, r11);     // Catch: Exception -> L66 BblCommandPublishException -> L72 SecurityException -> L75 CapabilitiesNotReadyException -> L77 CancellationException -> L79
        if (r28 == r32) goto L28;
        r44 = r17;
        r62 = r72;
        r24 = r28;
    L72:
        e = move-exception;
        return MqttPublishFailureMapperKt.transportUnavailableReceipt(e);
    L77:
        e = move-exception;
        throw e;
    L75:
        e = move-exception;
        throw e;
    L79:
        e = move-exception;
        throw e;
    L66:
        e = move-exception;
        if ((e instanceof TimeoutException) == false) goto L70;
        BblCommandReceipt.Status r29 = BblCommandReceipt.Status.TIMEOUT;
    L71:
        String r33 = null;
        byte[] r53 = null;
        Integer r63 = null;
        Integer r73 = null;
        Integer r84 = null;
        BblProceedContext r93 = null;
        BblCommandFailureReason r104 = null;
        return new BblCommandReceipt(r29, r33, e.getMessage(), r53, r63, r73, r84, r93, r104, 506, null);
    L70:
        r29 = BblCommandReceipt.Status.FAILED;
    L8:
        r3 = new C03021(this, r21);
        goto L7
    }

    @Override // com.bbl.device.command.BblCommandGateway
    public Object send(ob2 r25, long r26, rf7<? super BblCommandReceipt> r28) {
        if ((r28 instanceof C03012) == false) goto L7;
        C03012 r5 = (C03012) r28;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r1 = r5.result;
        Object r62 = nsf.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L24;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L18;
        if (r7 != 3) goto L16;
        Function1 r0 = (Function1) r5.L$3;
        xhb r02 = (xhb) r5.L$2;
        z72 r03 = (z72) r5.L$1;
        ob2 r04 = (ob2) r5.L$0;
        gti.r(r1);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
    L55:
        return (BblCommandReceipt) r1;
    L16:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L18:
        xhb r05 = (xhb) r5.L$2;
        z72 r06 = (z72) r5.L$1;
        ob2 r07 = (ob2) r5.L$0;
        gti.r(r1);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
    L62:
        return (BblCommandReceipt) r1;
    L21:
        xhb r08 = (xhb) r5.L$2;
        z72 r09 = (z72) r5.L$1;
        ob2 r010 = (ob2) r5.L$0;
        gti.r(r1);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
    L67:
        return (BblCommandReceipt) r1;
    L24:
        gti.r(r1);
        if (((Boolean) this.isClosed.invoke()).booleanValue() == true) goto L27;
        z72 r12 = eru.c(r25);
        if (r12.c == false) goto L35;
        if (((Boolean) this.isReady.invoke()).booleanValue() == true) goto L35;
        return new BblCommandReceipt(BblCommandReceipt.Status.UNAVAILABLE, null, null, null, null, null, null, null, BblCommandFailureReason.DEVICE_NOT_READY, 254, null);
    L35:
        if (isCommandRouteUnavailable(r25) == false) goto L39;
        return new BblCommandReceipt(BblCommandReceipt.Status.UNAVAILABLE, null, null, null, null, null, null, null, BblCommandFailureReason.COMMAND_ROUTE_UNAVAILABLE, 254, null);
    L39:
        if (((Boolean) this.isTransportConnected.invoke()).booleanValue() == true) goto L43;
        return new BblCommandReceipt(BblCommandReceipt.Status.UNAVAILABLE, null, null, null, null, null, null, null, BblCommandFailureReason.MQTT_NOT_CONNECTED, 254, null);
    L43:
        xhb r11 = BblCommandEncoderKt.encodeCommand(r25, r12);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        int r122 = r12.a.ordinal();     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        if (r122 == 0) goto L63;
        if (r122 == 1) goto L58;
        if (r122 != 2) goto L57;
        Function1<? super BblPrinterStateView, Boolean> r9 = StateObservedPredicateKt.stateObservedPredicate(r25);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        if (r9 == null) goto L50;
        r5.L$0 = ibq.nullOutSpilledVariable(r25);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.L$1 = ibq.nullOutSpilledVariable(r12);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.L$2 = ibq.nullOutSpilledVariable(r11);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.L$3 = ibq.nullOutSpilledVariable(r9);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.J$0 = r26;     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.label = 3;     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r1 = observed(r11, r26, r9, r5);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        if (r1 != r62) goto L55;
    L65:
        return r62;
    L50:
        return new BblCommandReceipt(BblCommandReceipt.Status.REJECTED, null, "No state predicate for " + uzn.a(r25.getClass()).d(), null, null, null, null, null, null, 506, null);
    L57:
        throw new i1k();     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
    L58:
        r5.L$0 = ibq.nullOutSpilledVariable(r25);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.L$1 = ibq.nullOutSpilledVariable(r12);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.L$2 = ibq.nullOutSpilledVariable(r11);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.J$0 = r26;     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.label = 2;     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r1 = ack(r25, r11, r26, r5);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        if (r1 != r62) goto L62;
    L63:
        r5.L$0 = ibq.nullOutSpilledVariable(r25);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.L$1 = ibq.nullOutSpilledVariable(r12);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.L$2 = ibq.nullOutSpilledVariable(r11);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.J$0 = r26;     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r5.label = 1;     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        r1 = fireAndForget(r11, r26, r5);     // Catch: BblCommandPublishException -> L68 SecurityException -> L70 CapabilitiesNotReadyException -> L76
        if (r1 != r62) goto L67;
    L27:
        return new BblCommandReceipt(BblCommandReceipt.Status.UNAVAILABLE, null, null, null, null, null, null, null, BblCommandFailureReason.DEVICE_CLOSED, 254, null);
    L68:
        e = move-exception;
        return MqttPublishFailureMapperKt.transportUnavailableReceipt(e);
    L76:
        e = move-exception;
        String r3 = null;
        byte[] r52 = null;
        Integer r63 = null;
        Integer r72 = null;
        Integer r8 = null;
        BblProceedContext r92 = null;
        BblCommandReceipt r13 = new BblCommandReceipt(BblCommandReceipt.Status.UNAVAILABLE, r3, e.getMessage(), r52, r63, r72, r8, r92, BblCommandFailureReason.CAPABILITIES_NOT_READY, 250, null);
    L80:
        return r13;
    L70:
        e = move-exception;
        BblCommandReceipt.Status r2 = BblCommandReceipt.Status.FAILED;
        BblCommandFailureReason r10 = BblCommandFailureReason.SECURITY_FAILED;
        String r14 = e.getMessage();
        if (r14 != null) goto L74;
        r14 = e.toString();
    L74:
        r13 = new BblCommandReceipt(r2, null, r14, null, null, null, null, null, r10, 250, null);
    L7:
        r5 = new C03012(this, r28);
        goto L8
    }

    @Override // com.bbl.device.command.BblCommandGateway
    public <T> Object send(ob2 r20, Function1<? super byte[], ? extends T> r21, long r22, rf7<? super BblTypedReceipt<? extends T>> r24) {
        if ((r24 instanceof C03001) == false) goto L7;
        C03001 r4 = (C03001) r24;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r52 = nsf.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        Object r7 = null;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L12;
        Function1<? super byte[], ? extends T> r0 = (Function1) r4.L$1;
        ob2 r1 = (ob2) r4.L$0;
        gti.r(r3);
    L18:
        BblCommandReceipt r32 = (BblCommandReceipt) r3;
        byte[] r12 = r32.getResponsePayload();
        if (r12 != null) goto L30;
    L28:
        BblCommandReceipt.Status r9 = r32.getStatus();
        return new BblTypedReceipt(r9, r7, r32.getCommandId(), r32.getMessage(), r32.getErrorCode(), r32.getProtocolErrCode(), r32.getBusinessErrno(), r32.getRecoveryContext(), r32.getFailureReason());
    L30:
        Object r02 = r0.invoke(r12);     // Catch: Throwable -> L22
    L25:
        if ((r02 instanceof ofo) == true) goto L28;
        r7 = r02;
    L22:
        th = move-exception;
        r02 = new ofo(th);
        goto L25
    L12:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L14:
        gti.r(r3);
        r4.L$0 = ibq.nullOutSpilledVariable(r20);
        r4.L$1 = r21;
        r4.J$0 = r22;
        r4.label = 1;
        Object r03 = send(r20, r22, r4);
        if (r03 != r52) goto L17;
        return r52;
    L17:
        r3 = r03;
        r0 = r21;
    L7:
        r4 = new C03001(this, r24);
        goto L8
    }
}
