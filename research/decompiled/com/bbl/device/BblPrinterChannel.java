package com.bbl.device;

import com.bambulab.printer.model.generated.BblpCapabilities;
import com.bambulab.printer.model.generated.BblpFeatures;
import com.bbl.device.model.BblPrinterStateView;
import com.bbl.device.model.BblProductCatalogEntry;
import com.bbl.device.model.BblProductProfileState;
import com.bbl.device.model.BblSessionRuntimeState;
import com.bbl.mqtt.sdk.MqttSdk;
import com.hivemq.client.mqtt.datatypes.MqttTopic;
import com.tencent.connect.common.Constants;
import defpackage.b0;
import defpackage.b8n;
import defpackage.beq;
import defpackage.c8n;
import defpackage.cm7;
import defpackage.cw2;
import defpackage.dgh;
import defpackage.dw2;
import defpackage.egb;
import defpackage.ei2;
import defpackage.ew2;
import defpackage.f9t;
import defpackage.fum;
import defpackage.fuq;
import defpackage.gg;
import defpackage.gq5;
import defpackage.gs6;
import defpackage.hw2;
import defpackage.jhq;
import defpackage.kn2;
import defpackage.kw3;
import defpackage.l0o;
import defpackage.lm7;
import defpackage.lsf;
import defpackage.mm7;
import defpackage.mwa;
import defpackage.n57;
import defpackage.ow4;
import defpackage.r77;
import defpackage.r86;
import defpackage.ry2;
import defpackage.sn5;
import defpackage.sna;
import defpackage.tfr;
import defpackage.trs;
import defpackage.vc0;
import defpackage.ve8;
import defpackage.vx2;
import defpackage.wh8;
import defpackage.xl7;
import defpackage.z5j;
import defpackage.zgh;
import defpackage.zw2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006*\u0001_\u0018\u0000 i2\u00020\u0001:\u0001jB\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012:\b\u0002\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aB\u0097\u0001\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012:\b\u0002\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010 J[\u0010)\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010%\u001a\u00020\u00162\b\b\u0002\u0010&\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u0004\u0018\u00010+2\b\u0010!\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b.\u0010/J!\u00102\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\r2\b\u00101\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b2\u00103J\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\r042\b\u00100\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\r042\b\u00100\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b7\u00106J!\u0010:\u001a\u0002092\u0006\u00108\u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0004\u0018\u0001092\u0006\u00108\u001a\u00020\r¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u001b¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0012¢\u0006\u0004\bA\u0010BR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010CR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010DR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010ER\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010FRF\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010GR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010HR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010IR\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010IR \u0010K\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002090J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bM\u0010F\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010R\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010TR\"\u0010V\u001a\u00020U8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020+048F¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0e8F¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006k"}, d2 = {"Lcom/bbl/device/BblPrinterChannel;", "", "Lcom/bbl/mqtt/sdk/MqttSdk;", "mqttSdk", "Lcom/bbl/device/BblPrinterCoreFactory;", "coreFactory", "Lcom/bbl/device/BblDeviceServiceProvider;", "serviceProvider", "Llm7;", Constants.PARAM_SCOPE, "Lcm7;", "reportDispatcher", "Lkotlin/Function2;", "", "Lguk;", "name", "tag", "message", "Ltrs;", "onLog", "", "presenceInactivityTimeoutMs", "", "presenceWatchdogEnabled", "sntpSyncEnabled", "<init>", "(Lcom/bbl/mqtt/sdk/MqttSdk;Lcom/bbl/device/BblPrinterCoreFactory;Lcom/bbl/device/BblDeviceServiceProvider;Llm7;Lcm7;Lkotlin/jvm/functions/Function2;JZZ)V", "Lvx2;", "link", "(Lvx2;Lcom/bbl/device/BblPrinterCoreFactory;Lcom/bbl/device/BblDeviceServiceProvider;Llm7;Lcm7;Lkotlin/jvm/functions/Function2;JZZ)V", "topic", "extractDeviceId", "(Ljava/lang/String;)Ljava/lang/String;", "modelId", "otaVersion", "amsOtaVersion", "bedVoltageKey", "supportBrtc", "tpuLeftExtruder", "motorNoiseSuppress", "Lcom/bbl/device/model/BblProductProfileState;", "productProfile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Lcom/bbl/device/model/BblProductProfileState;", "Lcom/bbl/device/model/BblProductCatalogEntry;", "catalogEntry", "(Ljava/lang/String;)Lcom/bbl/device/model/BblProductCatalogEntry;", "isKnownModel", "(Ljava/lang/String;)Z", "sourceModelId", "targetModelId", "isSliceCompatible", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "sliceCompatibleModelIds", "(Ljava/lang/String;)Ljava/util/List;", "sliceProfileTargets", "deviceId", "Lzw2;", "getOrCreate", "(Ljava/lang/String;Ljava/lang/String;)Lzw2;", "get", "(Ljava/lang/String;)Lzw2;", "newLink", "rebind", "(Lvx2;)V", "close", "()V", "Lcom/bbl/device/BblPrinterCoreFactory;", "Lcom/bbl/device/BblDeviceServiceProvider;", "Llm7;", "Lcm7;", "Lkotlin/jvm/functions/Function2;", "J", "Z", "Ljava/util/concurrent/ConcurrentHashMap;", "devices", "Ljava/util/concurrent/ConcurrentHashMap;", "listenerDispatcher", "getListenerDispatcher$device_biz", "()Lcm7;", "setListenerDispatcher$device_biz", "(Lcm7;)V", "currentLink", "Lvx2;", "Lcom/bbl/mqtt/sdk/MqttSdk;", "Ln57;", "connectionMode", "Ln57;", "getConnectionMode$device_biz", "()Ln57;", "setConnectionMode$device_biz", "(Ln57;)V", "Lfum;", "productProfileResolver", "Lfum;", "ew2", "globalListener", "Lew2;", "getProductCatalog", "()Ljava/util/List;", "productCatalog", "", "getDeviceIds", "()Ljava/util/Set;", "deviceIds", "Companion", "dw2", "device-biz"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BblPrinterChannel {
    public static final dw2 Companion = null;
    private static final l0o INVALID_DEVICE_ID_CHARS = null;
    public static final long PRESENCE_INACTIVITY_TIMEOUT_MS_DEFAULT = 30000;
    public static final long PRESENCE_TIMEOUT_MS_MAX = 300000;
    public static final long PRESENCE_TIMEOUT_MS_MIN = 1000;
    private volatile n57 connectionMode;
    private final BblPrinterCoreFactory coreFactory;
    private vx2 currentLink;
    private final ConcurrentHashMap<String, zw2> devices;
    private final ew2 globalListener;
    private cm7 listenerDispatcher;
    private volatile MqttSdk mqttSdk;
    private final Function2<String, String, trs> onLog;
    private final long presenceInactivityTimeoutMs;
    private final boolean presenceWatchdogEnabled;
    private final fum productProfileResolver;
    private final cm7 reportDispatcher;
    private final lm7 scope;
    private final BblDeviceServiceProvider serviceProvider;
    private final boolean sntpSyncEnabled;

    static {
        Companion = new dw2();
        INVALID_DEVICE_ID_CHARS = new l0o("[#+/]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BblPrinterChannel(MqttSdk r2, BblPrinterCoreFactory r3, BblDeviceServiceProvider r4, lm7 r5, cm7 r6, Function2<? super String, ? super String, trs> r7, long r8, boolean r10, boolean r11) {
        egb r0 = egb.a;
        r2.getClass();
        r5.getClass();
        r6.getClass();
        this.coreFactory = r3;
        this.serviceProvider = r4;
        this.scope = r5;
        this.reportDispatcher = r6;
        this.onLog = r7;
        egb r52 = null;
        if (1000 <= r8) goto L5;
    L23:
        ow4.q(r77.k(r8, "presenceInactivityTimeoutMs must be in 1000..300000, was "));
        throw null;
    L5:
        if (r8 >= 300001) goto L23;
        this.presenceInactivityTimeoutMs = r8;
        this.presenceWatchdogEnabled = r10;
        this.sntpSyncEnabled = r11;
        this.devices = new ConcurrentHashMap();
        this.mqttSdk = r2;
        this.connectionMode = BblBrokerConfig.INSTANCE.inferConnectionMode$device_biz(r2.config().getBroker());
        if (r4 == null) goto L11;
        ry2 r62 = r4.getProductProfileExtensionProvider();
        if (r62 == null) goto L11;
        List r63 = r62.a();
    L12:
        if (r63 != null) goto L14;
        r63 = r0;
    L14:
        if (r4 != null) goto L16;
    L18:
        if (r52 == null) goto L21;
        r0 = r52;
    L21:
        this.productProfileResolver = new fum(63, r63, r0);
        ew2 r32 = new ew2(this);
        this.globalListener = r32;
        r2.addListener(r32);
        return;
    L16:
        if (r4.getProductProfileExtensionProvider() == null) goto L18;
        r52 = r0;
    L11:
        r63 = null;
        goto L12
    }

    public BblPrinterChannel(MqttSdk r3, BblPrinterCoreFactory r4, BblDeviceServiceProvider r5, lm7 r6, cm7 r7, Function2 r8, long r9, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r13 & 8) == 0) goto L12;
        r6 = mm7.a(xl7.plus(z5j.f(), mwa.a));
    L12:
        if ((r13 & 16) == 0) goto L15;
        wh8 r72 = mwa.a;
        r7 = ve8.b.b2(1);
    L15:
        if ((r13 & 32) == 0) goto L18;
        r8 = null;
    L18:
        if ((r13 & 64) == 0) goto L21;
        r9 = 30000;
    L21:
        if ((r13 & 128) == 0) goto L24;
        r11 = true;
    L24:
        if ((r13 & 256) == 0) goto L26;
        r12 = true;
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r11, r12);
    }

    public BblPrinterChannel(vx2 r12, BblPrinterCoreFactory r13, BblDeviceServiceProvider r14, lm7 r15, cm7 r16, Function2<? super String, ? super String, trs> r17, long r18, boolean r20, boolean r21) {
        r12.getClass();
        r15.getClass();
        r16.getClass();
        this(r12.a(), r13, r14, r15, r16, r17, r18, r20, r21);
        this.currentLink = r12;
        this.connectionMode = r12.b();
    }

    public BblPrinterChannel(vx2 r3, BblPrinterCoreFactory r4, BblDeviceServiceProvider r5, lm7 r6, cm7 r7, Function2 r8, long r9, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r13 & 8) == 0) goto L12;
        r6 = mm7.a(xl7.plus(z5j.f(), mwa.a));
    L12:
        if ((r13 & 16) == 0) goto L15;
        wh8 r72 = mwa.a;
        r7 = ve8.b.b2(1);
    L15:
        if ((r13 & 32) == 0) goto L18;
        r8 = null;
    L18:
        if ((r13 & 64) == 0) goto L21;
        r9 = 30000;
    L21:
        if ((r13 & 128) == 0) goto L24;
        r11 = true;
    L24:
        if ((r13 & 256) == 0) goto L26;
        r12 = true;
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r11, r12);
    }

    public static /* synthetic */ trs a(BblPrinterChannel r0, String r1) {
        return getOrCreate$lambda$2$1(r0, r1);
    }

    public static final /* synthetic */ String access$extractDeviceId(BblPrinterChannel r0, String r1) {
        return r0.extractDeviceId(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap access$getDevices$p(BblPrinterChannel r0) {
        return r0.devices;
    }

    public static /* synthetic */ zw2 b(String r0, BblPrinterChannel r1, String r2, String r3, zw2 r4) {
        return getOrCreate$lambda$2(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ cm7 c(BblPrinterChannel r0) {
        return getOrCreate$lambda$2$0(r0);
    }

    public static /* synthetic */ zw2 d(gg r0, Object r1, Object r2) {
        return getOrCreate$lambda$3(r0, r1, r2);
    }

    private final String extractDeviceId(String r4) {
        List r42 = fuq.Q0(r4, new char[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, 6);
        if (r42.size() == 3) goto L5;
        return null;
    L5:
        if (lsf.l(r42.get(0), "device") == true) goto L7;
        return null;
    L7:
        if (lsf.l(r42.get(2), "report") == true) goto L9;
        return null;
    L9:
        if (((CharSequence) r42.get(1)).length() > 0) goto L11;
        return null;
    L11:
        return (String) r42.get(1);
    }

    public static /* synthetic */ zw2 getOrCreate$default(BblPrinterChannel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getOrCreate(r1, r2);
    }

    private static final zw2 getOrCreate$lambda$2(String r17, BblPrinterChannel r18, String r19, String r20, zw2 r21) {
        r20.getClass();
        if (r21 != null) goto L5;
    L55:
        MqttSdk r2 = r18.mqttSdk;
        n57 r3 = r18.connectionMode;
        lm7 r4 = r18.scope;
        cm7 r5 = r18.reportDispatcher;
        b0 r6 = new b0(r18, 25);
        BblPrinterCoreFactory r9 = r18.coreFactory;
        if (r9 == null) goto L59;
        hw2 r92 = r9.create();
    L61:
        return new zw2(r19, r2, r3, r4, r5, r6, r92, r18.serviceProvider, r18.productProfileResolver, r17, new ei2(r18, 5), r18.onLog, r18.presenceInactivityTimeoutMs, r18.presenceWatchdogEnabled, r18.sntpSyncEnabled);
    L59:
        r92 = null;
        goto L61
    L5:
        if (r21.r.get() == true) goto L55;
        if (r17 != null) goto L8;
    L54:
        return r21;
    L8:
        if (r21.j != null) goto L50;
        if (fuq.B0(r17) == true) goto L54;
        monitor-enter(r21);
    L17:
        th = move-exception;
        throw th;
    L14:
        if (r21.j != null) goto L19;
        r21.j = r17;     // Catch: Throwable -> L17
        boolean r0 = true;
    L20:
        monitor-exit(r21);
        if (r0 == false) goto L54;
        fum r02 = r21.e;
        String r42 = r21.h();
        BblpCapabilities r52 = (BblpCapabilities) r21.V.getValue();
        if (r52 != null) goto L26;
    L28:
        boolean r53 = false;
    L29:
        BblpCapabilities r62 = (BblpCapabilities) r21.V.getValue();
        if (r62 != null) goto L32;
    L34:
        boolean r63 = false;
    L35:
        BblpFeatures r7 = (BblpFeatures) r21.X.getValue();
        if (r7 != null) goto L38;
    L41:
        boolean r72 = false;
    L42:
        BblProductProfileState r03 = r02.d(r17, r42, null, null, r53, r63, r72);
        if (r03 != null) goto L45;
        r03 = BblProductProfileState.Companion.getDEFAULT();
    L45:
        r21.d0.setValue(r03);
        r21.b();
        r21.u("bound modelId='" + r17 + "' (late bind)");
        return r21;
    L38:
        if (r7.getMotorNoiseSuppress() != true) goto L41;
        r72 = true;
        goto L42
    L32:
        if (r62.getTpuLeftExtruder() != true) goto L34;
        r63 = true;
        goto L35
    L26:
        if (r52.getSupportBrtc() != true) goto L28;
        r53 = true;
        goto L29
    L19:
        r0 = false;
        goto L20
    L50:
        if (lsf.l(r21.j, r17) == true) goto L54;
        Function2<String, String, trs> r04 = r18.onLog;
        if (r04 == null) goto L54;
        String r32 = r21.j;
        StringBuilder r1 = kn2.v("getOrCreate(", r19, "): modelId '", r17, "' ignored; device already exists with modelId='");
        r1.append(r32);
        r1.append("'");
        r04.invoke("BblPrinterChannel", r1.toString());
        goto L54
    }

    private static final cm7 getOrCreate$lambda$2$0(BblPrinterChannel r0) {
        cm7 r02 = r0.listenerDispatcher;
        if (r02 != null) goto L6;
        wh8 r03 = mwa.a;
        return zgh.a.e;
    L6:
        return r02;
    }

    private static final trs getOrCreate$lambda$2$1(BblPrinterChannel r0, String r1) {
        r1.getClass();
        r0.devices.remove(r1);
        return trs.a;
    }

    private static final zw2 getOrCreate$lambda$3(Function2 r0, Object r1, Object r2) {
        return (zw2) r0.invoke(r1, r2);
    }

    public static /* synthetic */ BblProductProfileState productProfile$default(BblPrinterChannel r1, String r2, String r3, String r4, String r5, boolean r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 16) == 0) goto L15;
        r6 = false;
    L15:
        if ((r9 & 32) == 0) goto L18;
        r7 = false;
    L18:
        if ((r9 & 64) == 0) goto L21;
        r8 = false;
    L21:
        return r1.productProfile(r2, r3, r4, r5, r6, r7, r8);
    }

    public final BblProductCatalogEntry catalogEntry(String r4) {
        fum r3 = this.productProfileResolver;
        r3.getClass();
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        if (fuq.B0(r4) == true) goto L22;
        String r42 = r3.b(r4);
        if (r42 == null) goto L23;
        Iterator r32 = r3.c.iterator();
    L12:
        if (r32.hasNext() == false) goto L17;
        Object r1 = r32.next();
        if (lsf.l(((BblProductCatalogEntry) r1).getModelId(), r42) == false) goto L12;
        r0 = r1;
    L17:
        return (BblProductCatalogEntry) r0;
    L23:
        return null;
    L22:
        return null;
    }

    public final void close() {
        Collection<zw2> r0 = this.devices.values();
        r0.getClass();
        Iterator r02 = r86.Q0(r0).iterator();
    L4:
        if (r02.hasNext() == false) goto L51;
        zw2 r1 = (zw2) r02.next();
        if (r1.r.compareAndSet(false, true) == false) goto L4;
        sna r3 = r1.C0;
        r3.i.b(null);
    L10:
        if ((r3.g.g() instanceof gq5) == false) goto L10;
        r1.n0.f(trs.a);
        monitor-enter(r1);
        beq r32 = r1.z;     // Catch: Throwable -> L16
        if (r32 == null) goto L18;
        r32.b(null);     // Catch: Throwable -> L16
    L18:
        r1.z = null;     // Catch: Throwable -> L16
        r1.A = null;     // Catch: Throwable -> L16
        r1.o.clear();     // Catch: Throwable -> L16
        r1.p.clear();     // Catch: Throwable -> L16
        if (r1.w == false) goto L21;
        r1.w = false;     // Catch: Throwable -> L16
        r1.x = false;     // Catch: Throwable -> L16
        r1.y = false;     // Catch: Throwable -> L16
        MqttSdk r33 = r1.m;     // Catch: Throwable -> L16
        String r5 = r1.a;     // Catch: Throwable -> L16
        r5.getClass();     // Catch: Throwable -> L16
        r33.unsubscribe("device/" + r5 + "/report");     // Catch: Throwable -> L16
    L21:
        monitor-exit(r1);
        r1.z0.c();
        r1.t.set(false);
        r1.s.set(false);
        r1.H.set(false);
        r1.f();
        r1.j0.setValue(BblSessionRuntimeState.Companion.getDEFAULT());
        r1.k0.setValue(BblPrinterStateView.Companion.getDEFAULT());
        jhq r34 = r1.e0;
        kw3 r52 = new kw3();
        r34.getClass();
        r34.k(null, r52);
        r1.p0.setValue(null);
        tfr r35 = r1.r0;
        if (r35 == null) goto L25;
        r35.b();
    L25:
        r1.s0.b();
        r1.k.b(null);
        sn5 r36 = r1.t0;
        if (r36 == null) goto L28;
        r36.close();
    L28:
        f9t r37 = r1.q();
        beq r53 = r37.f;
        if (r53 == null) goto L31;
        r53.b(null);
    L31:
        r37.f = null;
        beq r54 = r37.g;
        if (r54 == null) goto L34;
        r54.b(null);
    L34:
        r37.g = null;
        hw2 r38 = r1.c;
        if (r38 == null) goto L37;
        r38.close();
    L37:
        b8n r39 = r1.y0;
        r39.r = false;
        Object r55 = r39.i;
        monitor-enter(r55);
        r39.g.set(c8n.d);     // Catch: Throwable -> L42
        gs6 r6 = r39.s;     // Catch: Throwable -> L42
        if (r6 == null) goto L44;
        r6.b(null);     // Catch: Throwable -> L42
    L44:
        r39.s = null;     // Catch: Throwable -> L42
        r39.d(false);     // Catch: Throwable -> L42
        monitor-exit(r55);
        r39.c();
        r1.f.invoke(r1.a);
    L42:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L51:
        this.mqttSdk.removeListener(this.globalListener);
        vx2 r03 = this.currentLink;
        if (r03 == null) goto L54;
        r03.close();
    L54:
        mm7.b(this.scope, null);
    }

    public final zw2 get(String r1) {
        r1.getClass();
        return this.devices.get(r1);
    }

    public final n57 getConnectionMode$device_biz() {
        return this.connectionMode;
    }

    public final Set<String> getDeviceIds() {
        Set<String> r0 = this.devices.keySet();
        r0.getClass();
        return r86.V0(r0);
    }

    public final cm7 getListenerDispatcher$device_biz() {
        return this.listenerDispatcher;
    }

    public final zw2 getOrCreate(String r4, String r5) {
        r4.getClass();
        if (fuq.B0(r4) == false) goto L5;
        vc0.k("deviceId must not be blank");
        return null;
    L5:
        if (INVALID_DEVICE_ID_CHARS.a(r4) == true) goto L8;
        zw2 r3 = this.devices.compute(r4, new cw2(new gg(r5, this, r4, 26), 0));
        r3.getClass();
        return r3;
    L8:
        ow4.q(dgh.n("deviceId must not contain MQTT wildcard characters (+, #) or path separator (/): '", r4, "'"));
        return null;
    }

    public final List<BblProductCatalogEntry> getProductCatalog() {
        return this.productProfileResolver.c;
    }

    public final boolean isKnownModel(String r1) {
        return this.productProfileResolver.c(r1);
    }

    public final boolean isSliceCompatible(String r2, String r3) {
        fum r1 = this.productProfileResolver;
        r1.getClass();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (fuq.B0(r2) == true) goto L27;
        if (r3 != null) goto L9;
        return false;
    L9:
        if (fuq.B0(r3) == true) goto L28;
        String r22 = r1.b(r2);
        if (r22 == null) goto L29;
        String r32 = r1.b(r3);
        if (r32 == null) goto L30;
        Set r12 = (Set) r1.e.get(r22);
        if (r12 != null) goto L20;
        return false;
    L20:
        if (r12.contains(r32) != true) goto L26;
        return true;
    L26:
        return false;
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    }

    public final BblProductProfileState productProfile(String r2, String r3, String r4, String r5, boolean r6, boolean r7, boolean r8) {
        return this.productProfileResolver.d(r2, r5, r3, r4, r6, r7, r8);
    }

    public final synchronized void rebind(vx2 r7) {
        monitor-enter(this);
        r7.getClass();     // Catch: Throwable -> L7
        MqttSdk r0 = this.mqttSdk;     // Catch: Throwable -> L7
        vx2 r1 = this.currentLink;     // Catch: Throwable -> L7
        r0.removeListener(this.globalListener);     // Catch: Throwable -> L7
        Collection<zw2> r02 = this.devices.values();     // Catch: Throwable -> L7
        r02.getClass();     // Catch: Throwable -> L7
        List r03 = r86.Q0(r02);     // Catch: Throwable -> L7
        Iterator r2 = r03.iterator();     // Catch: Throwable -> L7
    L5:
        if (r2.hasNext() == false) goto L9;
        ((zw2) r2.next()).i("rebind", true);     // Catch: Throwable -> L7
        goto L5
    L9:
        if (r1 == null) goto L11;
        r1.close();     // Catch: Throwable -> L7
    L11:
        this.mqttSdk = r7.a();     // Catch: Throwable -> L7
        this.connectionMode = r7.b();     // Catch: Throwable -> L7
        this.currentLink = r7;     // Catch: Throwable -> L7
        Iterator r12 = r03.iterator();     // Catch: Throwable -> L7
    L13:
        if (r12.hasNext() == false) goto L15;
        ((zw2) r12.next()).v(r7.a(), r7.b());     // Catch: Throwable -> L7
        goto L13
    L15:
        r7.a().addListener(this.globalListener);     // Catch: Throwable -> L7
        Iterator r72 = r03.iterator();     // Catch: Throwable -> L7
    L16:
        if (r72.hasNext() == false) goto L20;
        ((zw2) r72.next()).D();     // Catch: Throwable -> L7
        goto L16
    L20:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setConnectionMode$device_biz(n57 r1) {
        r1.getClass();
        this.connectionMode = r1;
    }

    public final void setListenerDispatcher$device_biz(cm7 r1) {
        this.listenerDispatcher = r1;
    }

    public final List<String> sliceCompatibleModelIds(String r2) {
        fum r1 = this.productProfileResolver;
        r1.getClass();
        if (r2 == null) goto L15;
        if (fuq.B0(r2) == true) goto L15;
        String r22 = r1.b(r2);
        if (r22 == null) goto L15;
        List<String> r12 = (List) r1.d.get(r22);
        if (r12 == null) goto L15;
        return r12;
    L15:
        return egb.a;
    }

    public final List<String> sliceProfileTargets(String r2) {
        fum r1 = this.productProfileResolver;
        r1.getClass();
        if (r2 == null) goto L15;
        if (fuq.B0(r2) == true) goto L15;
        String r22 = r1.b(r2);
        if (r22 == null) goto L15;
        List<String> r12 = (List) r1.d.get(r22);
        if (r12 == null) goto L15;
        return r12;
    L15:
        return egb.a;
    }
}
