package defpackage;

import com.bbl.device.command.BblCommandPublishException;
import com.bbl.mqtt.api.model.MqttError;
import com.bbl.mqtt.api.model.PublishResult;
import com.bbl.mqtt.sdk.MqttSdk;
import com.heytap.mcssdk.constant.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class bhp {
    public static final Set j = null;
    public final String a;
    public final lm7 b;
    public volatile MqttSdk c;
    public final AtomicInteger d;
    public final ConcurrentHashMap e;
    public final Object f;
    public final LinkedHashSet g;
    public long h;
    public final c59 i;

    static {
        j = r71.L0(new String[]{"sequence_id", b.y, "timestamp"});
    }

    public bhp(String r2, MqttSdk r3, lm7 r4) {
        r2.getClass();
        r3.getClass();
        r4.getClass();
        this.a = r2;
        this.b = r4;
        this.c = r3;
        this.d = new AtomicInteger(2001);
        this.e = new ConcurrentHashMap();
        this.f = new Object();
        this.g = new LinkedHashSet();
        rf7 r0 = null;
        this.i = new c59(1, r0, 4);
    }

    public static /* synthetic */ Object d(bhp r8, String r9, String r10, Map r11, tf7 r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r11 = null;
    L6:
        return r8.c(r9, r10, r11, 10000, null, r12);
    }

    public static /* synthetic */ Object f(bhp r8, String r9, Map r10, tf7 r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r12 & 4) == 0) goto L9;
        Map r5 = null;
    L11:
        return r8.e("pushing", r4, r5, null, r11);
    L9:
        r5 = r10;
        goto L11
    L5:
        r4 = r9;
        goto L7
    }

    public final Object a(String r9, String r10, String r11, Map r12, Function2 r13, tf7 r14) {
        if ((r14 instanceof wgp) == false) goto L7;
        wgp r0 = (wgp) r14;
        int r1 = r0.j;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.j = r1 - Integer.MIN_VALUE;
    L8:
        Object r142 = r0.h;
        Object r15 = nsf.getCOROUTINE_SUSPENDED();
        int r2 = r0.j;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L12;
        JSONObject r8 = r0.g;
        JSONObject r92 = (JSONObject) r0.f;
        Function2 r93 = r0.e;
        Map r102 = (Map) r0.d;
        String r103 = (String) r0.c;
        String r104 = (String) r0.b;
        String r105 = (String) r0.a;
        gti.r(r142);
        r13 = r93;
    L40:
        JSONObject r143 = (JSONObject) r142;
        if (r143 != null) goto L44;
        JSONObject r22 = r8;
    L43:
        r143 = r22;
    L44:
        if (r13 != null) goto L46;
    L59:
        String r82 = r143.toString();
        r82.getClass();
    L60:
        byte[] r83 = r82.getBytes(hs5.a);
        r83.getClass();
        return r83;
    L46:
        if (r143.has("header") == false) goto L59;
        JSONObject r94 = r143.optJSONObject("header");
        if (r94 != null) goto L50;
        r82 = b9v.e(r143);
        goto L60
    L50:
        JSONObject r106 = new JSONObject(r143.toString());
        r106.remove("header");
        String r84 = b9v.e(r106);
        if (fuq.q0(r84, AbstractJsonLexerKt.END_OBJ) == false) goto L57;
        String r112 = fuq.p0(1, r84);
        if (r112.length() <= 1) goto L55;
        String r122 = ",";
    L56:
        String r95 = b9v.e(r94);
        int r85 = r84.length();
        StringBuilder r86 = new StringBuilder((r95.length() + r85) + 16);
        r86.append(r112);
        r86.append(r122);
        r86.append("\"header\":");
        r86.append(r95);
        r86.append(AbstractJsonLexerKt.END_OBJ);
        r82 = r86.toString();
        goto L60
    L55:
        r122 = "";
        goto L56
    L57:
        cze.h(dgh.n("Unexpected sortedBody format: '", r84, "'"));
        return null;
    L12:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L14:
        gti.r(r142);
        JSONObject r144 = new JSONObject();
        r144.put("sequence_id", r10);
        if (r11 == null) goto L17;
        r144.put(b.y, r11);
    L17:
        r144.put("timestamp", System.currentTimeMillis());
        if (r12 == null) goto L31;
        Iterator r23 = r12.entrySet().iterator();
    L21:
        if (r23.hasNext() == false) goto L31;
        Map.Entry r5 = (Map.Entry) r23.next();
        String r6 = (String) r5.getKey();
        Object r52 = r5.getValue();
        if (j.contains(r6) == true) goto L21;
        if (r52 != null) goto L26;
        r52 = JSONObject.NULL;
        r52.getClass();
    L30:
        r144.put(r6, r52);
        goto L21
    L26:
        Object r7 = JSONObject.wrap(r52);
        if (r7 == null) goto L30;
        r52 = r7;
    L31:
        r22 = new JSONObject();
        String r87 = this.c.userId();
        if (r87 == null) goto L34;
        r22.put("user_id", r87);
    L34:
        r22.put(r9, r144);
        if (r13 == null) goto L43;
        r0.a = ibq.nullOutSpilledVariable(r9);
        r0.b = ibq.nullOutSpilledVariable(r10);
        r0.c = ibq.nullOutSpilledVariable(r11);
        r0.d = ibq.nullOutSpilledVariable(r12);
        r0.e = r13;
        r0.f = ibq.nullOutSpilledVariable(r144);
        r0.g = r22;
        r0.j = 1;
        r142 = r13.invoke(r22, r0);
        if (r142 != r15) goto L39;
        return r15;
    L39:
        r8 = r22;
    L7:
        r0 = new wgp(this, r14);
        goto L8
    }

    public final void b() {
        Object r0 = this.f;
        monitor-enter(r0);
        this.h++;
        this.g.clear();     // Catch: Throwable -> L11
        ArrayList r1 = new ArrayList(this.e.keySet());     // Catch: Throwable -> L11
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r12 = r1.iterator();     // Catch: Throwable -> L11
    L5:
        if (r12.hasNext() == false) goto L13;
        ugp r3 = (ugp) this.e.remove((String) r12.next());     // Catch: Throwable -> L11
        if (r3 == null) goto L5;
        r2.add(r3);     // Catch: Throwable -> L11
        goto L5
    L13:
        monitor-exit(r0);
        Iterator r5 = r2.iterator();
    L16:
        if (r5.hasNext() == false) goto L21;
        ugp r02 = (ugp) r5.next();
        uxf r13 = r02.b;
        if (r13 == null) goto L20;
        r13.b(null);
    L20:
        r02.a.b(null);
        goto L16
    L21:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [uxf] */
    /* JADX WARN: Type inference failed for: r5v11, types: [fs6] */
    public final Object c(String r22, String r23, Map r24, long r25, Function2 r27, tf7 r28) {
        bhp r1 = this;
        if ((r28 instanceof xgp) == false) goto L8;
        xgp r2 = (xgp) r28;
        int r3 = r2.n;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L8;
        r2.n = r3 - Integer.MIN_VALUE;
    L7:
        xgp r7 = r2;
        Object r0 = r7.l;
        Object r9 = nsf.getCOROUTINE_SUSPENDED();
        int r26 = r7.n;
        if (r26 == 0) goto L29;
        if (r26 == 1) goto L24;
        if (r26 == 2) goto L23;
        if (r26 == 3) goto L22;
        if (r26 != 4) goto L20;
        PublishResult r29 = (PublishResult) r7.j;
        uxf r210 = r7.i;
        fs6 r32 = (fs6) r7.h;
        byte[] r33 = (byte[]) r7.g;
        String r34 = r7.f;
        vgp r4 = (vgp) r7.e;
        Function2 r42 = (Function2) r7.d;
        Map r43 = (Map) r7.c;
        String r44 = (String) r7.b;
        String r45 = (String) r7.a;
        gti.r(r0);     // Catch: Throwable -> L18
    L63:
        byte[] r02 = (byte[]) r0;     // Catch: Throwable -> L66
        r210.b(null);
        r1.e.remove(r34);
        return r02;
    L66:
        Throwable th = th;
        CancellationException r8 = null;
    L68:
        r210.b(r8);
        r1.e.remove(r34);
        throw th;
    L18:
        th = th;
        r8 = null;
        goto L68
    L20:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L22:
        long r211 = r7.k;
        uxf r46 = r7.i;
        fs6 r5 = (fs6) r7.h;
        byte[] r6 = (byte[]) r7.g;
        String r82 = r7.f;
        vgp r11 = (vgp) r7.e;
        Function2 r12 = (Function2) r7.d;
        Map r13 = (Map) r7.c;
        String r15 = (String) r7.b;
        String r10 = (String) r7.a;
        gti.r(r0);
        String r14 = r10;
        xgp r102 = r7;
        String r72 = r15;
        Function2 r152 = r12;
        r210 = r46;
        r34 = r82;
        vgp r47 = r11;
        long r112 = r211;
    L54:
        PublishResult r03 = (PublishResult) r0;
        if ((r03 instanceof PublishResult.Failed) == true) goto L57;
    L59:
        PublishResult r222 = r03;
    L100:
        r102.a = ibq.nullOutSpilledVariable(r14);     // Catch: Throwable -> L66
        r102.b = ibq.nullOutSpilledVariable(r72);     // Catch: Throwable -> L66
        r102.c = ibq.nullOutSpilledVariable(r13);     // Catch: Throwable -> L66
        r102.d = ibq.nullOutSpilledVariable(r152);     // Catch: Throwable -> L66
        r102.e = ibq.nullOutSpilledVariable(r47);     // Catch: Throwable -> L66
        r102.f = r34;     // Catch: Throwable -> L66
        r102.g = ibq.nullOutSpilledVariable(r6);     // Catch: Throwable -> L66
        r102.h = ibq.nullOutSpilledVariable(r5);     // Catch: Throwable -> L66
        r102.i = r210;     // Catch: Throwable -> L66
        r102.j = ibq.nullOutSpilledVariable(r222);     // Catch: Throwable -> L66
        r102.k = r112;     // Catch: Throwable -> L66
        r102.n = 4;     // Catch: Throwable -> L66
        r0 = r5.S0(r102);     // Catch: Throwable -> L66
        if (r0 != r9) goto L63;
    L62:
        return r9;
    L57:
        if (r1.e.remove(r34) == null) goto L59;
        r210.b(null);
        r222 = r03;
        r5.w(new BblCommandPublishException(((PublishResult.Failed) r03).getError(), r72, r34));
        goto L100
    L23:
        long r212 = r7.k;
        ?? r48 = r7.i;
        ?? r52 = (fs6) r7.h;
        byte[] r62 = (byte[]) r7.g;
        String r83 = r7.f;
        vgp r103 = (vgp) r7.e;
        Function2 r122 = (Function2) r7.d;
        Map r132 = (Map) r7.c;
        String r153 = (String) r7.b;
        String r113 = (String) r7.a;
        gti.r(r0);
        r14 = r113;
        Map r17 = r132;
        gs6 r133 = r52;
        byte[] r53 = r62;
        beq r84 = r48;
        String r49 = r153;
        r152 = r122;
        r112 = r212;
        r34 = r83;
        vgp r213 = r103;
        r102 = r7;
    L50:
        zgp r04 = new zgp(r1, r213, r34, r49, r53, null, 0);
        r102.a = ibq.nullOutSpilledVariable(r14);
        r102.b = r49;
        r102.c = ibq.nullOutSpilledVariable(r17);
        r102.d = ibq.nullOutSpilledVariable(r152);
        r102.e = ibq.nullOutSpilledVariable(r213);
        r102.f = r34;
        r102.g = ibq.nullOutSpilledVariable(r53);
        r102.h = r133;
        r102.i = r84;
        r102.k = r112;
        r102.n = 3;
        r0 = mm7.c(r04, r102);
        if (r0 == r9) goto L62;
        r72 = r49;
        r6 = r53;
        r5 = r133;
        r13 = r17;
        r47 = r213;
        r210 = r84;
        goto L54
    L24:
        long r214 = r7.k;
        String r410 = r7.f;
        vgp r54 = (vgp) r7.e;
        Function2 r63 = (Function2) r7.d;
        Map r104 = (Map) r7.c;
        String r114 = (String) r7.b;
        String r154 = (String) r7.a;
        gti.r(r0);     // Catch: Throwable -> L27
        Function2 r115 = r63;
        String r64 = r114;
    L37:
        byte[] r05 = (byte[]) r0;     // Catch: Throwable -> L27
        Object r123 = r1.f;
        monitor-enter(r123);
        long r223 = r214;
        if (r54.b != r1.h) goto L73;
        if (r1.g.remove(r410) == false) goto L73;
        vgp r215 = r54;
        gs6 r55 = new gs6();     // Catch: Throwable -> L70
        r1.e.put(r410, new ugp(r55, null));     // Catch: Throwable -> L70
        lm7 r134 = r1.b;     // Catch: Throwable -> L70
        pm7 r142 = pm7.b;     // Catch: Throwable -> L70
        Map r242 = r104;
        r102 = r7;
        Function2 r20 = r115;
        String r232 = r154;
        i97 r06 = new i97(r223, r1, r410, r55, r64, null, 4);     // Catch: Throwable -> L70
        r1 = r1;
        beq r07 = dy4.c(r134, null, r142, r06, 1);     // Catch: Throwable -> L70
        r1.e.computeIfPresent(r410, new cw2(new d8p(r07, 6), 4));     // Catch: Throwable -> L70
        r07.start();     // Catch: Throwable -> L70
        monitor-exit(r123);
        c59 r73 = r1.i;
        r102.a = ibq.nullOutSpilledVariable(r232);
        r102.b = r64;
        r102.c = ibq.nullOutSpilledVariable(r242);
        r102.d = ibq.nullOutSpilledVariable(r20);
        r102.e = r215;
        r102.f = r410;
        r102.g = r05;
        r102.h = r55;
        r102.i = r07;
        r102.k = r223;
        r102.n = 2;
        r73.invoke(r102);
        if (trs.a == r9) goto L62;
        r213 = r215;
        r112 = r223;
        r14 = r232;
        r17 = r242;
        r84 = r07;
        r34 = r410;
        r133 = r55;
        r49 = r64;
        r53 = r05;
        r152 = r20;
    L73:
        throw new CancellationException("Command '" + r64 + "' (seq=" + r410 + ") cancelled before publish");     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    L27:
        th = th;
    L78:
        Object r216 = r1.f;
        monitor-enter(r216);
        r1.g.remove(r410);     // Catch: Throwable -> L83
        monitor-exit(r216);
        throw th;
    L83:
        th = move-exception;
        throw th;
    L29:
        gti.r(r0);
        Object r217 = r1.f;
        monitor-enter(r217);
        String r35 = String.valueOf(r1.d.getAndIncrement());     // Catch: Throwable -> L86
        r1.g.add(r35);     // Catch: Throwable -> L86
        vgp r08 = new vgp(r35, r1.h);     // Catch: Throwable -> L86
        monitor-exit(r217);
        r7.a = ibq.nullOutSpilledVariable(r22);     // Catch: Throwable -> L76
        r7.b = r23;     // Catch: Throwable -> L76
        r7.c = ibq.nullOutSpilledVariable(r24);     // Catch: Throwable -> L76
        r7.d = ibq.nullOutSpilledVariable(r27);     // Catch: Throwable -> L76
        r7.e = r08;     // Catch: Throwable -> L76
        r7.f = r35;     // Catch: Throwable -> L76
        r7.k = r25;     // Catch: Throwable -> L76
        r7.n = 1;     // Catch: Throwable -> L76
        Object r155 = r1.a(r22, r35, r23, r24, r27, r7);     // Catch: Throwable -> L76
        if (r155 == r9) goto L62;
        r64 = r23;
        r54 = r08;
        r410 = r35;
        r214 = r25;
        r0 = r155;
        r154 = r22;
        r104 = r24;
        r115 = r27;
    L76:
        th = th;
        r410 = r35;
    L86:
        th = move-exception;
        throw th;
    L8:
        r2 = new xgp(r1, r28);
        goto L7
    }

    public final Object e(String r16, String r17, Map r18, Function2 r19, tf7 r20) {
        if ((r20 instanceof ahp) == false) goto L8;
        ahp r2 = (ahp) r20;
        int r3 = r2.j;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L8;
        r2.j = r3 - Integer.MIN_VALUE;
    L7:
        ahp r7 = r2;
        Object r0 = r7.h;
        Object r8 = nsf.getCOROUTINE_SUSPENDED();
        int r22 = r7.j;
        MqttError r9 = null;
        if (r22 == 0) goto L21;
        if (r22 == 1) goto L16;
        if (r22 != 2) goto L14;
        byte[] r1 = (byte[]) r7.g;
        String r12 = r7.f;
        vgp r23 = (vgp) r7.e;
        Function2 r24 = (Function2) r7.d;
        Map r25 = (Map) r7.c;
        String r26 = (String) r7.b;
        String r27 = (String) r7.a;
        gti.r(r0);
    L36:
        PublishResult r02 = (PublishResult) r0;
        if ((r02 instanceof PublishResult.Failed) == false) goto L39;
        PublishResult.Failed r03 = (PublishResult.Failed) r02;
    L40:
        if (r03 == null) goto L43;
        r9 = r03.getError();
    L43:
        return new dtk(r12, r9);
    L39:
        r03 = null;
        goto L40
    L14:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L16:
        String r28 = r7.f;
        vgp r32 = (vgp) r7.e;
        Function2 r4 = (Function2) r7.d;
        Map r5 = (Map) r7.c;
        String r6 = (String) r7.b;
        String r11 = (String) r7.a;
        gti.r(r0);     // Catch: Throwable -> L19
        String r33 = r28;
        vgp r29 = r32;
        Function2 r14 = r4;
        Map r13 = r5;
        String r42 = r6;
        ahp r122 = r7;
    L31:
        byte[] r52 = (byte[]) r0;     // Catch: Throwable -> L44
        zgp r04 = new zgp(this, r29, r33, r42, r52, null, 1);
        r122.a = ibq.nullOutSpilledVariable(r11);
        r122.b = ibq.nullOutSpilledVariable(r42);
        r122.c = ibq.nullOutSpilledVariable(r13);
        r122.d = ibq.nullOutSpilledVariable(r14);
        r122.e = ibq.nullOutSpilledVariable(r29);
        r122.f = r33;
        r122.g = ibq.nullOutSpilledVariable(r52);
        r122.j = 2;
        r0 = mm7.c(r04, r122);
        if (r0 != r8) goto L35;
    L34:
        return r8;
    L35:
        r12 = r33;
    L44:
        th = th;
    L45:
        r28 = r33;
    L48:
        Object r34 = this.f;
        monitor-enter(r34);
        this.g.remove(r28);     // Catch: Throwable -> L53
        monitor-exit(r34);
        throw th;
    L53:
        th = move-exception;
        throw th;
    L19:
        th = th;
        goto L48
    L21:
        gti.r(r0);
        Object r210 = this.f;
        monitor-enter(r210);
        String r43 = String.valueOf(this.d.getAndIncrement());     // Catch: Throwable -> L56
        this.g.add(r43);     // Catch: Throwable -> L56
        vgp r05 = new vgp(r43, this.h);     // Catch: Throwable -> L56
        monitor-exit(r210);
        r7.a = ibq.nullOutSpilledVariable(r16);     // Catch: Throwable -> L46
        r7.b = r17;     // Catch: Throwable -> L46
        r7.c = ibq.nullOutSpilledVariable(r18);     // Catch: Throwable -> L46
        r7.d = ibq.nullOutSpilledVariable(r19);     // Catch: Throwable -> L46
        r7.e = r05;     // Catch: Throwable -> L46
        r7.f = r43;     // Catch: Throwable -> L46
        r7.j = 1;     // Catch: Throwable -> L46
        r33 = r43;
        Object r112 = a(r16, r33, r17, r18, r19, r7);     // Catch: Throwable -> L44
        r122 = r7;
        if (r112 == r8) goto L34;
        r42 = r17;
        r13 = r18;
        r14 = r19;
        r29 = r05;
        r0 = r112;
        r11 = r16;
    L46:
        th = th;
        r33 = r43;
    L56:
        th = move-exception;
        throw th;
    L8:
        r2 = new ahp(this, r20);
        goto L7
    }
}
