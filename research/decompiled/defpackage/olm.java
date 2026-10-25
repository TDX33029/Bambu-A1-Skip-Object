package defpackage;

import com.bambulab.bambulab.core.device.storage.api.DeviceStorageMemPrintModel;
import com.bambulab.bambulab.core.device.storage.api.DeviceStorageModelObjectInfo;
import com.bambulab.bambulab.core.device.storage.api.DeviceStorageModelPlateInfo;
import com.bambulab.bambulab.core.device.storage.api.MemPrintModelRequest;
import com.bambulab.bambulab.model.MultiTaskProjectModel;
import com.bambulab.bambulab.model.MultiTaskProjectPlateModel;
import com.bambulab.bambulab.model.MultiTaskProjectsResponse;
import com.bambulab.bambulab.model.MultiTaskStatus;
import com.bambulab.bambulab.model.RateModel;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.umeng.analytics.pro.ek;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function2;
import timber.log.Timber;

/* loaded from: classes.dex */
public final class olm implements vkm {
    public final cna a;
    public final uim b;
    public final ow7 c;
    public final ljm d;
    public final una e;
    public final ine f;
    public final zpa g;
    public final e8g h;
    public final jhq i;
    public final jhq j;
    public final ConcurrentHashMap k;
    public final ConcurrentHashMap l;
    public final ConcurrentHashMap m;
    public final ConcurrentHashMap n;

    public olm(cna r1, uim r2, ow7 r3, ljm r4, una r5, ine r6, zpa r7, e8g r8) {
        r1.getClass();
        r2.getClass();
        r4.getClass();
        r5.getClass();
        r6.getClass();
        r7.getClass();
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        fgb r12 = fgb.a;
        this.i = f88.f(r12);
        this.j = f88.f(r12);
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
    }

    public static beq f(lm7 r7, jhq r8, String r9, Function2 r10) {
        mzn r3 = new mzn();
        Long r0 = (Long) ((Map) r8.getValue()).get(r9);
        if (r0 == null) goto L5;
        long r02 = r0.longValue();
    L6:
        r3.a = r02;
        return dy4.c(r7, null, null, new xgc(r8, r9, r3, r10, null, ek.n), 3);
    L5:
        r02 = 0;
        goto L6
    }

    @Override // defpackage.vkm
    public final svc a(String r4) {
        r4.getClass();
        rf7 r1 = null;
        if (fuq.B0(r4) == false) goto L7;
        return new a55(null, (byte) 5);
    L7:
        return new hn1(new yto(new llm(this, r4, r1, 0)), new m80((byte) 28), (byte) 19);
    }

    @Override // defpackage.vkm
    public final qlm b(String r1) {
        r1.getClass();
        return (qlm) this.k.get(r1);
    }

    @Override // defpackage.vkm
    public final void c(String r14, long r15, RateModel r17) {
        r14.getClass();
        r17.getClass();
        if (fuq.B0(r14) == false) goto L5;
        return;
    L5:
        if (r15 <= 0) goto L33;
        this.m.put(r14, new jgn(r15, r17));
        ConcurrentHashMap r4 = this.k;
        qlm r5 = (qlm) r4.get(r14);
        if (r5 == null) goto L23;
        omm r6 = r5.d();
        if (r6 == null) goto L12;
        Long r62 = v0v.c(r6);
    L13:
        if (r62 == null) goto L23;
        if (r62.longValue() != r15) goto L23;
        Integer r0 = r17.getScore();
        if (r0 == null) goto L21;
        int r02 = r0.intValue();
    L22:
        r4.put(r14, qlm.a(r5, null, r17, r02, lsf.l(r17.getUserCanRating(), Boolean.TRUE), null, null, 2019));
        goto L23
    L21:
        r02 = 0;
        goto L22
    L12:
        r62 = null;
    L23:
        jhq r03 = this.j;
        Object r1 = r03.getValue();
        Map r42 = (Map) r1;
        Long r52 = (Long) r42.get(r14);
        if (r52 == null) goto L26;
        long r53 = r52.longValue();
    L28:
        if (r03.compareAndSet(r1, vvh.l0(r42, new dtk(r14, Long.valueOf(r53 + 1)))) == false) goto L23;
        return;
    L26:
        r53 = 0;
        goto L28
    }

    @Override // defpackage.vkm
    public final void d(String r8) {
        r8.getClass();
        if (fuq.B0(r8) == true) goto L11;
    L5:
        jhq r0 = this.i;
        Object r1 = r0.getValue();
        Map r2 = (Map) r1;
        Long r3 = (Long) r2.get(r8);
        if (r3 == null) goto L8;
        long r32 = r3.longValue();
    L10:
        if (r0.compareAndSet(r1, vvh.l0(r2, new dtk(r8, Long.valueOf(r32 + 1)))) == false) goto L5;
        return;
    L8:
        r32 = 0;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v8, types: [kotlin.jvm.functions.Function2] */
    public final Object e(String r28, hc r29, mjm r30, Object r31, mbn r32, aim r33, tf7 r34) {
        if ((r34 instanceof clm) == false) goto L7;
        clm r3 = (clm) r34;
        int r4 = r3.p;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.p = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.n;
        Object r42 = nsf.getCOROUTINE_SUSPENDED();
        int r5 = r3.p;
        trs r7 = trs.a;
        switch(r5) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L12;
            default: goto L10;
        };
    L10:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L12:
        RateModel r0 = (RateModel) r3.l;
    L13:
        RateModel r02 = (RateModel) r3.k;
    L14:
        Long r03 = (Long) r3.j;
        qlm r04 = (qlm) r3.i;
        hbn r05 = (hbn) r3.h;
        omm r06 = (omm) r3.g;
        Function2 r07 = (Function2) r3.f;
        mbn r08 = (mbn) r3.e;
        mjm r09 = (mjm) r3.c;
        hc r010 = (hc) r3.b;
        String r011 = (String) r3.a;
        gti.r(r2);
        return r7;
    L16:
        int r1 = r3.m;
        RateModel r52 = (RateModel) r3.k;
        Long r6 = (Long) r3.j;
        qlm r10 = (qlm) r3.i;
        hbn r11 = (hbn) r3.h;
        omm r12 = (omm) r3.g;
        Function2 r13 = (Function2) r3.f;
        mbn r14 = (mbn) r3.e;
        Object r15 = r3.d;
        mjm r8 = (mjm) r3.c;
        hc r9 = (hc) r3.b;
        String r16 = (String) r3.a;
        gti.r(r2);
        int r012 = r1;
        trs r282 = r7;
        clm r72 = r3;
        Long r35 = r6;
        olm r62 = this;
        qlm r18 = r10;
        hc r102 = r9;
        mjm r92 = r8;
        Object r82 = r2;
    L73:
        RateModel r83 = (RateModel) r82;
        r14.j(r35);
        r14.p(r83);
        mjm r292 = r92;
        hc r302 = r102;
        r62.m.put(r16, new jgn(r35.longValue(), r83));
        Integer r22 = r83.getScore();
        if (r22 == null) goto L76;
        int r21 = r22.intValue();
    L77:
        qlm r23 = qlm.a(r18, null, r83, r21, lsf.l(r83.getUserCanRating(), rs4.boxBoolean(true)), r14.e(), r14.f(), 1251);
        r72.a = ibq.nullOutSpilledVariable(r16);
        r72.b = ibq.nullOutSpilledVariable(r302);
        r72.c = ibq.nullOutSpilledVariable(r292);
        r72.d = ibq.nullOutSpilledVariable(r15);
        r72.e = ibq.nullOutSpilledVariable(r14);
        r72.f = ibq.nullOutSpilledVariable(r13);
        r72.g = ibq.nullOutSpilledVariable(r12);
        r72.h = ibq.nullOutSpilledVariable(r11);
        r72.i = ibq.nullOutSpilledVariable(r18);
        r72.j = ibq.nullOutSpilledVariable(r35);
        r72.k = ibq.nullOutSpilledVariable(r52);
        r72.l = ibq.nullOutSpilledVariable(r83);
        r72.m = r012;
        r72.p = 7;
        if (r13.invoke(r23, r72) != r42) goto L83;
    L79:
        return r42;
    L83:
        return r282;
    L76:
        r21 = 0;
        goto L77
    L17:
        int r17 = r3.m;
        r52 = (RateModel) r3.k;
        Long r63 = (Long) r3.j;
        qlm r84 = (qlm) r3.i;
        hbn r93 = (hbn) r3.h;
        omm r103 = (omm) r3.g;
        Function2 r112 = (Function2) r3.f;
        mbn r122 = (mbn) r3.e;
        Object r132 = r3.d;
        mjm r142 = (mjm) r3.c;
        hc r152 = (hc) r3.b;
        r16 = (String) r3.a;
        gti.r(r2);
        r012 = r17;
        r282 = r7;
        r72 = r3;
        r35 = r63;
        r62 = this;
        mjm r293 = r142;
        hc r303 = r152;
        r14 = r122;
        r15 = r132;
        r12 = r103;
        r13 = r112;
        qlm r104 = r84;
        r11 = r93;
    L69:
        long r85 = r35.longValue();
        r72.a = r16;
        r72.b = ibq.nullOutSpilledVariable(r303);
        r72.c = ibq.nullOutSpilledVariable(r293);
        r72.d = ibq.nullOutSpilledVariable(r15);
        r72.e = r14;
        r72.f = r13;
        r72.g = ibq.nullOutSpilledVariable(r12);
        r72.h = ibq.nullOutSpilledVariable(r11);
        r72.i = r104;
        r72.j = r35;
        r72.k = ibq.nullOutSpilledVariable(r52);
        r72.m = r012;
        r72.p = 6;
        r82 = r62.i(r85, 0, r72);
        if (r82 == r42) goto L79;
        r92 = r293;
        r18 = r104;
        r102 = r303;
        goto L73
    L18:
        int r19 = r3.m;
        qlm r53 = (qlm) r3.i;
        hbn r86 = (hbn) r3.h;
        omm r94 = (omm) r3.g;
        Function2 r105 = (Function2) r3.f;
        mbn r113 = (mbn) r3.e;
        Object r123 = r3.d;
        mjm r133 = (mjm) r3.c;
        hc r143 = (hc) r3.b;
        String r153 = (String) r3.a;
        gti.r(r2);
        r62 = this;
        String r013 = r153;
        RateModel r154 = null;
        qlm r182 = r53;
        trs r24 = r7;
        r72 = r3;
    L43:
        r35 = v0v.c(r94);
        if (r35 != null) goto L49;
        qlm r54 = qlm.a(r182, null, null, 0, false, r113.e(), r113.f(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_STOP_CLIENT);
        r72.a = ibq.nullOutSpilledVariable(r013);
        r72.b = ibq.nullOutSpilledVariable(r143);
        r72.c = ibq.nullOutSpilledVariable(r133);
        r72.d = ibq.nullOutSpilledVariable(r123);
        r72.e = ibq.nullOutSpilledVariable(r113);
        r72.f = ibq.nullOutSpilledVariable(r105);
        r72.g = ibq.nullOutSpilledVariable(r94);
        r72.h = ibq.nullOutSpilledVariable(r86);
        r72.i = ibq.nullOutSpilledVariable(r182);
        r72.j = ibq.nullOutSpilledVariable(r35);
        r72.m = r19;
        r72.p = 3;
        if (r105.invoke(r54, r72) == r42) goto L79;
    L80:
        return r24;
    L49:
        RateModel r55 = r113.h();
        if (r55 == null) goto L57;
        Long r192 = r113.b();
        long r20 = r35.longValue();
        if (r192 == null) goto L57;
        if (r192.longValue() != r20) goto L57;
        r154 = r55;
    L57:
        if (r154 == null) goto L65;
        Integer r56 = r154.getScore();
        if (r56 == null) goto L61;
        int r162 = r56.intValue();
    L62:
        qlm r27 = r182;
        qlm r57 = qlm.a(r27, null, r154, r162, lsf.l(r154.getUserCanRating(), rs4.boxBoolean(true)), r113.e(), r113.f(), 1251);
        r72.a = ibq.nullOutSpilledVariable(r013);
        r72.b = ibq.nullOutSpilledVariable(r143);
        r72.c = ibq.nullOutSpilledVariable(r133);
        r72.d = ibq.nullOutSpilledVariable(r123);
        r72.e = ibq.nullOutSpilledVariable(r113);
        r72.f = ibq.nullOutSpilledVariable(r105);
        r72.g = ibq.nullOutSpilledVariable(r94);
        r72.h = ibq.nullOutSpilledVariable(r86);
        r72.i = ibq.nullOutSpilledVariable(r182);
        r72.j = ibq.nullOutSpilledVariable(r35);
        r72.k = ibq.nullOutSpilledVariable(r154);
        r72.m = r19;
        r72.p = 4;
        if (r105.invoke(r57, r72) != r42) goto L80;
    L61:
        r162 = 0;
        goto L62
    L65:
        qlm r58 = qlm.a(r182, null, null, 0, false, r113.e(), r113.f(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_STOP_CLIENT);
        r282 = r24;
        qlm r25 = r182;
        r72.a = r013;
        String r294 = r013;
        r72.b = ibq.nullOutSpilledVariable(r143);
        r72.c = ibq.nullOutSpilledVariable(r133);
        r72.d = ibq.nullOutSpilledVariable(r123);
        r72.e = r113;
        r72.f = r105;
        r72.g = ibq.nullOutSpilledVariable(r94);
        r72.h = ibq.nullOutSpilledVariable(r86);
        r72.i = r25;
        r72.j = r35;
        r72.k = ibq.nullOutSpilledVariable(r154);
        r72.m = r19;
        r72.p = 5;
        if (r105.invoke(r58, r72) == r42) goto L79;
        r012 = r19;
        r303 = r143;
        r52 = r154;
        r16 = r294;
        r14 = r113;
        r15 = r123;
        r293 = r133;
        r11 = r86;
        r12 = r94;
        r13 = r105;
        r104 = r25;
        goto L69
    L19:
        r19 = r3.m;
        hbn r59 = (hbn) r3.h;
        omm r87 = (omm) r3.g;
        ?? r95 = (Function2) r3.f;
        mbn r106 = (mbn) r3.e;
        Object r114 = r3.d;
        mjm r124 = (mjm) r3.c;
        hc r134 = (hc) r3.b;
        String r144 = (String) r3.a;
        gti.r(r2);
        aim r135 = r95;
        hc r96 = r134;
        mbn r125 = r106;
        mjm r107 = r124;
    L35:
        List r26 = (List) r2;
        if (r26 == null) goto L38;
        r125.i(r26);
    L38:
        r125.l(r59);
        r154 = null;
        r24 = r7;
        r125.k(r96.a());
    L39:
        omm r295 = r87;
        qlm r64 = qlm.a(new qlm(r295, r107.b(), r107.a(), r114, r96.b()), r125.a(), null, 0, false, r125.e(), r125.f(), 1277);
        r3.a = r144;
        r3.b = ibq.nullOutSpilledVariable(r96);
        r3.c = ibq.nullOutSpilledVariable(r107);
        r3.d = ibq.nullOutSpilledVariable(r114);
        r3.e = r125;
        r3.f = r135;
        r3.g = r87;
        r3.h = ibq.nullOutSpilledVariable(r59);
        r3.i = r64;
        r3.m = r19;
        r3.p = 2;
        clm r342 = r3;
        Object r014 = j(r144, r87, r64, r125, r135, r342);
        r62 = this;
        r72 = r342;
        if (r014 == r42) goto L79;
        aim r015 = r135;
        r133 = r107;
        r105 = r015;
        mbn r016 = r125;
        r123 = r114;
        r113 = r016;
        r182 = r64;
        r013 = r144;
        r143 = r96;
        r94 = r87;
        r86 = r59;
        goto L43
    L20:
        gti.r(r2);
        r87 = r29.c();
        if (r87 == null) goto L81;
        r59 = v0v.b(r87);
        if (r29.a() == r32.c()) goto L25;
        int r210 = 1;
    L26:
        if (r210 == 0) goto L28;
    L31:
        r3.a = r28;
        r96 = r29;
        r3.b = r96;
        r107 = r30;
        r3.c = r107;
        r114 = r31;
        r3.d = r114;
        r125 = r32;
        r3.e = r125;
        r135 = r33;
        r3.f = r135;
        r3.g = r87;
        r3.h = r59;
        r3.m = r210;
        r3.p = 1;
        Object r145 = h(r28, r3);
        if (r145 == r42) goto L79;
        r144 = r28;
        r19 = r210;
        r2 = r145;
        goto L35
    L28:
        if (r32.d() != r59) goto L31;
        r96 = r29;
        r107 = r30;
        r114 = r31;
        r125 = r32;
        r135 = r33;
        r144 = r28;
        r19 = r210;
        r154 = null;
        r24 = r7;
        goto L39
    L25:
        r210 = 0;
        goto L26
    L81:
        vc0.k("Required value was null.");
        return null;
    L7:
        r3 = new clm(this, r34);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x03c5 -> B:135:0x03c6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x03cb -> B:48:0x0196). Please report as a decompilation issue!!! */
    public final Object g(String r24, omm r25, tf7 r26) {
        olm r0 = this;
        if ((r26 instanceof hlm) == false) goto L7;
        hlm r2 = (hlm) r26;
        int r3 = r2.k;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.k = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.i;
        Object r32 = nsf.getCOROUTINE_SUSPENDED();
        int r4 = r2.k;
        int r7 = 2;
        byte r8 = 0;
        byte r9 = 1;
        rf7 r10 = null;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L15;
        int r42 = r2.g;
        int r11 = r2.f;
        int r12 = r2.e;
        pfo r13 = (pfo) r2.d;
        MemPrintModelRequest r132 = (MemPrintModelRequest) r2.c;
        omm r133 = r2.b;
        String r14 = r2.a;
        gti.r(r1);
        int r5 = r42;
        int r6 = 2;
        byte r20 = 1;
    L135:
        hlm r02 = r2;
        omm r22 = r133;
        String r15 = r14;
    L48:
        int r134 = r12;
        int r122 = r11;
        r5 = r5 + 1;
        hlm r43 = r02;
        r7 = r6;
        r9 = r20;
        r10 = null;
        r0 = this;
    L25:
        if (r5 >= r122) goto L139;
        MemPrintModelRequest r142 = new MemPrintModelRequest(r15, r134);
        boolean r112 = r22.u();
        ine r152 = r0.f;
        if (r112 == false) goto L34;
        r43.a = r15;
        r43.b = r22;
        r43.c = ibq.nullOutSpilledVariable(r142);
        r43.d = r10;
        r43.e = r134;
        r43.f = r122;
        r43.g = r5;
        r43.h = r5;
        r43.k = r9;
        r152.getClass();
        Object r62 = r152.b(r142.getDeviceId(), new fne(r152, r142, r10, r8), r43);
        if (r62 == r32) goto L133;
        String r153 = r15;
        r1 = r62;
        r11 = r122;
        r12 = r134;
        MemPrintModelRequest r135 = r142;
        omm r143 = r22;
        r2 = r43;
        int r44 = r5;
    L32:
        pfo r16 = (pfo) r1;
        omm r222 = r143;
        r142 = r135;
    L33:
        r133 = r222;
        r20 = r9;
        byte[] r21 = r10;
        if (r16 != null) goto L51;
        StringBuilder r63 = kn2.s(r12, "loadMachineSkipSource session not ready, deviceId=", r153, ", plateIndex=", ", retry=");
        r63.append(r44 + 1);
        String r64 = r63.toString();
        i7c r72 = Timber.a;
        r72.c("PrintSummarySessionManager");
        r72.i(z86.B(r64), new Object[0]);
        r6 = 2;
        if (r44 >= 2) goto L49;
        r2.a = r153;
        r2.b = r133;
        r2.c = ibq.nullOutSpilledVariable(r142);
        r2.d = ibq.nullOutSpilledVariable(r16);
        r2.e = r12;
        r2.f = r11;
        r2.g = r5;
        r2.h = r44;
        r2.k = 3;
        if (ym8.b((1 << r44) * 1000, r2) == r32) goto L133;
        r02 = r2;
        r5 = r5;
        r22 = r133;
        r15 = r153;
        r6 = 2;
        r8 = 0;
        goto L48
    L49:
        r8 = 0;
    L136:
        r02 = r2;
        r22 = r133;
        r15 = r153;
        goto L48
    L51:
        Object r73 = r16.a;
        if ((r73 instanceof ofo) == true) goto L129;
        DeviceStorageMemPrintModel r74 = (DeviceStorageMemPrintModel) r73;
        List r17 = r133.o();
        boolean r23 = r133.u();
        Iterator<T> r33 = r74.getPlates().iterator();
    L55:
        if (r33.hasNext() == false) goto L59;
        Object r45 = r33.next();
        if (((DeviceStorageModelPlateInfo) r45).getIndex() != r12) goto L55;
    L60:
        DeviceStorageModelPlateInfo r46 = (DeviceStorageModelPlateInfo) r45;
        List r34 = r17;
        int r65 = vvh.f0(t86.N(r34, 10));
        if (r65 >= 16) goto L63;
        r65 = 16;
    L63:
        LinkedHashMap r82 = new LinkedHashMap(r65);
        Iterator r35 = r34.iterator();
    L65:
        if (r35.hasNext() == false) goto L67;
        Object r66 = r35.next();
        r82.put(Integer.valueOf(((djm) r66).b()), r66);
        goto L65
    L67:
        if (r46 == null) goto L69;
        List<DeviceStorageModelObjectInfo> r36 = r46.getObjects();
    L70:
        if (r36 != null) goto L72;
        r36 = egb.a;
    L72:
        List<DeviceStorageModelObjectInfo> r37 = r36;
        ArrayList r47 = new ArrayList(t86.N(r37, 10));
        Iterator<T> r38 = r37.iterator();
    L74:
        if (r38.hasNext() == false) goto L89;
        DeviceStorageModelObjectInfo r67 = (DeviceStorageModelObjectInfo) r38.next();
        int r92 = r67.getIdentifyId();
        djm r113 = (djm) r82.get(Integer.valueOf(r92));
        if (r113 == null) goto L86;
        String r93 = r113.c();
        if (r93 != null) goto L80;
    L84:
        r93 = r67.getName();
    L85:
        djm r68 = djm.a(r113, r93, r113.d(), 6);
    L87:
        r47.add(r68);
        goto L74
    L80:
        if (fuq.B0(r93) == false) goto L83;
        r93 = r21;
    L83:
        if (r93 != null) goto L85;
    L86:
        r68 = new djm(r67.getName(), r92, b1v.i(r92), false);
        goto L87
    L89:
        if (r47.isEmpty() == false) goto L98;
        List<DeviceStorageModelPlateInfo> r39 = r74.getPlates();
        ArrayList r69 = new ArrayList(t86.N(r39, 10));
        Iterator<T> r310 = r39.iterator();
    L92:
        if (r310.hasNext() == false) goto L94;
        DeviceStorageModelPlateInfo r52 = (DeviceStorageModelPlateInfo) r310.next();
        r69.add(r52.getIndex() + Constants.COLON_SEPARATOR + r52.getObjects().size());
        goto L92
    L94:
        String r311 = "toMachineSkipSource empty objects, plateIndex=" + r12 + ", plates=" + r69;
        i7c r53 = Timber.a;
        r53.c("PrintSummarySessionManager");
        boolean r610 = bgp.a;
        if (bgp.a == false) goto L97;
        r311 = bgp.a(r311);
    L97:
        r53.w(r311, new Object[0]);
    L98:
        byte[] r312 = r74.getCoverImage();
        if (r312 != null) goto L101;
    L102:
        r312 = r21;
    L103:
        if (r23 == false) goto L105;
        byte[] r54 = r312;
    L110:
        if (r312 != null) goto L117;
        if (r54 != null) goto L117;
        StringBuilder r03 = kn2.r(r12, r47.size(), "toMachineSkipSource missing skip/cover image, plateIndex=", ", objectCount=", ", is2d=");
        r03.append(r23);
        String r04 = r03.toString();
        i7c r18 = Timber.a;
        r18.c("PrintSummarySessionManager");
        boolean r27 = bgp.a;
        if (bgp.a == false) goto L115;
        r04 = bgp.a(r04);
    L115:
        r18.w(r04, new Object[0]);
        return r21;
    L117:
        int r05 = r47.size();
        if (r312 == null) goto L120;
        int r28 = r312.length;
    L121:
        if (r54 == null) goto L123;
        int r611 = r54.length;
    L124:
        int r19 = r17.size();
        StringBuilder r06 = kn2.r(r12, r05, "toMachineSkipSource ready plateIndex=", " objectCount=", " cover=");
        t4m.n(r28, r611, " pick=", " (iotSkipObjects=", r06);
        String r07 = kn2.p(r06, r19, ")");
        i7c r110 = Timber.a;
        r110.c("PrintSummarySessionManager");
        boolean r29 = bgp.a;
        if (bgp.a == false) goto L127;
        r07 = bgp.a(r07);
    L127:
        r110.i(r07, new Object[0]);
        return new wem(r47, r54, r21, r312);
    L123:
        r611 = 0;
        goto L124
    L120:
        r28 = 0;
        goto L121
    L105:
        r54 = r74.getSkipImage();
        if (r54 != null) goto L108;
    L109:
        r54 = r21;
        goto L110
    L108:
        if (r54.length != 0) goto L110;
    L101:
        if (r312.length != 0) goto L103;
    L69:
        r36 = r21;
        goto L70
    L59:
        r45 = r21;
        goto L60
    L129:
        boolean r75 = r133.u();
        pfo r242 = r16;
        StringBuilder r08 = kn2.s(r12, "loadMachineSkipSource failed, deviceId=", r153, ", plateIndex=", ", is2d=");
        r08.append(r75);
        r08.append(", retry=");
        r08.append(r44 + 1);
        String r09 = r08.toString();
        i7c r111 = Timber.a;
        r111.c("PrintSummarySessionManager");
        r8 = 0;
        r111.w(z86.B(r09), new Object[0]);
        r6 = 2;
        if (r44 >= 2) goto L136;
        r2.a = r153;
        r2.b = r133;
        r2.c = ibq.nullOutSpilledVariable(r142);
        r2.d = ibq.nullOutSpilledVariable(r242);
        r2.e = r12;
        r2.f = r11;
        r2.g = r5;
        r2.h = r44;
        r2.k = 4;
        if (ym8.b((1 << r44) * 1000, r2) == r32) goto L133;
        r14 = r153;
    L133:
        return r32;
    L34:
        r43.a = r15;
        r43.b = r22;
        r43.c = ibq.nullOutSpilledVariable(r142);
        r43.d = r10;
        r43.e = r134;
        r43.f = r122;
        r43.g = r5;
        r43.h = r5;
        r43.k = r7;
        r152.getClass();
        Object r612 = r152.b(r142.getDeviceId(), new fne(r152, r142, r10, r9), r43);
        if (r612 == r32) goto L133;
        omm r154 = r22;
        r2 = r43;
        r44 = r5;
        int r114 = r44;
        String r55 = r15;
        r1 = r612;
    L38:
        r16 = (pfo) r1;
        r222 = r154;
        r153 = r55;
        r5 = r114;
        r11 = r122;
        r12 = r134;
        goto L33
    L139:
        return r10;
    L15:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L17:
        int r48 = r2.g;
        r11 = r2.f;
        r12 = r2.e;
        pfo r136 = (pfo) r2.d;
        MemPrintModelRequest r137 = (MemPrintModelRequest) r2.c;
        omm r138 = r2.b;
        String r144 = r2.a;
        gti.r(r1);
        r20 = 1;
        r02 = r2;
        r5 = r48;
        r22 = r138;
        r15 = r144;
        r6 = 2;
        r8 = 0;
        goto L48
    L18:
        r44 = r2.h;
        r114 = r2.g;
        r122 = r2.f;
        r134 = r2.e;
        r142 = (MemPrintModelRequest) r2.c;
        r154 = r2.b;
        r55 = r2.a;
        gti.r(r1);
        goto L38
    L19:
        r44 = r2.h;
        r5 = r2.g;
        r11 = r2.f;
        r12 = r2.e;
        r135 = (MemPrintModelRequest) r2.c;
        r143 = r2.b;
        r153 = r2.a;
        gti.r(r1);
        goto L32
    L20:
        gti.r(r1);
        Integer r115 = r25.j();
        if (r115 == null) goto L23;
        int r116 = r115.intValue();
    L24:
        r134 = r116;
        r43 = r2;
        r122 = 3;
        r5 = 0;
        r15 = r24;
        r22 = r25;
        goto L25
    L23:
        r116 = 0;
    L7:
        r2 = new hlm(r0, r26);
        goto L8
    }

    public final Object h(String r9, tf7 r10) {
        if ((r10 instanceof ilm) == false) goto L8;
        ilm r0 = (ilm) r10;
        int r1 = r0.d;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L8;
        r0.d = r1 - Integer.MIN_VALUE;
    L7:
        ilm r6 = r0;
        Object r102 = r6.b;
        Object r02 = nsf.getCOROUTINE_SUSPENDED();
        int r12 = r6.d;
        if (r12 == 0) goto L15;
        if (r12 != 1) goto L13;
        String r8 = (String) r6.a;
        gti.r(r102);
        Object r82 = ((pfo) r102).a;
    L18:
        Throwable r92 = pfo.a(r82);
        if (r92 != null) goto L43;
        List<MultiTaskProjectModel> r83 = ((MultiTaskProjectsResponse) r82).getHits();
        egb r93 = egb.a;
        if (r83 != null) goto L23;
        r83 = r93;
    L23:
        ArrayList r103 = new ArrayList();
        Iterator<T> r84 = r83.iterator();
    L25:
        if (r84.hasNext() == false) goto L30;
        List<MultiTaskProjectPlateModel> r03 = ((MultiTaskProjectModel) r84.next()).getPlates();
        if (r03 != null) goto L29;
        r03 = r93;
    L29:
        x86.R(r103, r03);
        goto L25
    L30:
        ArrayList r85 = new ArrayList();
        Iterator r94 = r103.iterator();
    L32:
        if (r94.hasNext() == false) goto L38;
        Object r104 = r94.next();
        MultiTaskProjectPlateModel r04 = (MultiTaskProjectPlateModel) r104;
        if (r04.getStatus() == MultiTaskStatus.Queued) goto L37;
        if (r04.getStatus() != MultiTaskStatus.Cancelled) goto L32;
    L37:
        r85.add(r104);
        goto L32
    L38:
        ArrayList r95 = new ArrayList(t86.N(r85, 10));
        Iterator r86 = r85.iterator();
    L40:
        if (r86.hasNext() == false) goto L42;
        r95.add(v0v.d((MultiTaskProjectPlateModel) r86.next()));
        goto L40
    L42:
        return r95;
    L43:
        String r87 = kn2.n("getPrintQueue failed: ", r92.getMessage());
        i7c r96 = Timber.a;
        r96.c("PrintSummarySessionManager");
        r96.w(z86.B(r87), new Object[0]);
        return null;
    L13:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L15:
        gti.r(r102);
        r6.a = ibq.nullOutSpilledVariable(r9);
        r6.d = 1;
        r82 = this.b.mo45getPrintQueueyxL6bBk(r9, "in-progress", 0, 8, r6);
        if (r82 != r02) goto L18;
        return r02;
    L8:
        r0 = new ilm(this, r10);
        goto L7
    }

    public final Object i(long r50, int r52, tf7 r53) {
        long r1 = r50;
        if ((r53 instanceof jlm) == false) goto L7;
        jlm r4 = (jlm) r53;
        int r5 = r4.f;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.f = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.d;
        Object r54 = nsf.getCOROUTINE_SUSPENDED();
        int r6 = r4.f;
        if (r6 == 0) goto L19;
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L17;
        if (r6 != 3) goto L15;
        gti.r(r3);
        return r3;
    L15:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L17:
        int r12 = r4.b;
        long r8 = r4.a;
        Object r2 = r4.c;
        gti.r(r3);
    L31:
        r4.c = ibq.nullOutSpilledVariable(r2);
        r4.a = r8;
        r4.b = r12;
        r4.f = 3;
        Object r0 = i(r8, r12 + 1, r4);
        if (r0 != r54) goto L34;
    L33:
        return r54;
    L34:
        return r0;
    L18:
        int r13 = r4.b;
        long r10 = r4.a;
        gti.r(r3);
        Object r22 = ((pfo) r3).a;
        int r32 = r13;
        Object r62 = r22;
        r1 = r10;
    L23:
        if ((r62 instanceof ofo) == true) goto L26;
        gti.r(r62);
        return r62;
    L26:
        if (r32 >= 2) goto L35;
        r4.c = ibq.nullOutSpilledVariable(r62);
        r4.a = r1;
        r4.b = r32;
        r4.f = 2;
        if (ym8.b((2 << r32) * 1000, r4) == r54) goto L33;
        r8 = r1;
        r12 = r32;
        r2 = r62;
        goto L31
    L35:
        String r02 = r77.k(r1, "getRatingForInstance exhausted retries for instanceId=");
        i7c r14 = Timber.a;
        r14.c("PrintSummarySessionManager");
        r14.w(z86.B(r02), new Object[0]);
        return new RateModel(null, null, null, null, null, null, null, null, null, null, null, rs4.boxBoolean(true), null, null, null, null, null, null, null, rs4.boxBoolean(false), null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, -526337, 7, null);
    L19:
        gti.r(r3);
        r4.a = r1;
        r32 = r52;
        r4.b = r32;
        r4.f = 1;
        r62 = this.c.R(r1, r4);
        if (r62 != r54) goto L23;
    L7:
        r4 = new jlm(this, r53);
        goto L8
    }

    public final Object j(String r25, omm r26, qlm r27, mbn r28, Function2 r29, tf7 r30) {
        mbn r3 = r28;
        Function2 r4 = r29;
        if ((r30 instanceof klm) == false) goto L7;
        klm r6 = (klm) r30;
        int r7 = r6.k;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.k = r7 - Integer.MIN_VALUE;
    L8:
        Object r5 = r6.i;
        Object r72 = nsf.getCOROUTINE_SUSPENDED();
        int r8 = r6.k;
        xem r9 = xem.c;
        trs r14 = trs.a;
        ConcurrentHashMap r15 = this.n;
        if (r8 == 0) goto L19;
        if (r8 == 1) goto L18;
        if (r8 == 2) goto L17;
        if (r8 != 3) goto L15;
        wem r0 = (wem) r6.h;
        wem r02 = (wem) r6.g;
        String r03 = (String) r6.f;
        Function2 r04 = (Function2) r6.e;
        mbn r05 = (mbn) r6.d;
        qlm r06 = (qlm) r6.c;
        omm r07 = (omm) r6.b;
        String r08 = (String) r6.a;
        gti.r(r5);
        return r14;
    L15:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L17:
        wem r09 = (wem) r6.g;
        String r1 = (String) r6.f;
        Function2 r2 = (Function2) r6.e;
        r3 = (mbn) r6.d;
        qlm r42 = (qlm) r6.c;
        omm r82 = (omm) r6.b;
        String r10 = (String) r6.a;
        gti.r(r5);
        qlm r16 = r42;
    L36:
        wem r52 = (wem) r5;
        r3.m(r52);
        if (r52 != null) goto L40;
        r9 = xem.d;
    L40:
        r3.n(r9);
        if (r52 == null) goto L43;
        r15.put(r10, new bgh(r1, r52));
    L44:
        qlm r43 = qlm.a(r16, null, null, 0, false, r3.e(), r3.f(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_STOP_CLIENT);
        r6.a = ibq.nullOutSpilledVariable(r10);
        r6.b = ibq.nullOutSpilledVariable(r82);
        r6.c = ibq.nullOutSpilledVariable(r16);
        r6.d = ibq.nullOutSpilledVariable(r3);
        r6.e = ibq.nullOutSpilledVariable(r2);
        r6.f = ibq.nullOutSpilledVariable(r1);
        r6.g = ibq.nullOutSpilledVariable(r09);
        r6.h = ibq.nullOutSpilledVariable(r52);
        r6.k = 3;
        if (r2.invoke(r43, r6) != r72) goto L47;
    L46:
        return r72;
    L47:
        return r14;
    L43:
        r15.remove(r10);
        goto L44
    L18:
        wem r12 = (wem) r6.g;
        String r22 = (String) r6.f;
        Function2 r32 = (Function2) r6.e;
        mbn r44 = (mbn) r6.d;
        qlm r83 = (qlm) r6.c;
        omm r102 = (omm) r6.b;
        String r13 = (String) r6.a;
        gti.r(r5);
        r4 = r32;
        r3 = r44;
        qlm r11 = r83;
    L32:
        r6.a = r13;
        r6.b = ibq.nullOutSpilledVariable(r102);
        r6.c = r11;
        r6.d = r3;
        r6.e = r4;
        r6.f = r22;
        r6.g = ibq.nullOutSpilledVariable(r12);
        r6.k = 2;
        r5 = g(r13, r102, r6);
        if (r5 == r72) goto L46;
        r09 = r12;
        r1 = r22;
        r2 = r4;
        r82 = r102;
        r16 = r11;
        r10 = r13;
        goto L36
    L19:
        gti.r(r5);
        String r53 = v0v.a(r26);
        if (r53 != null) goto L23;
        r3.o(null);
        r3.m(null);
        r3.n(xem.a);
        r15.remove(r25);
        return r14;
    L23:
        wem r84 = r3.e();
        if (lsf.l(r3.g(), r53) == false) goto L28;
        if (r84 == null) goto L28;
        wem r010 = v0v.e(r84, r26);
        r3.m(r010);
        r3.n(r9);
        r15.put(r25, new bgh(r53, r010));
        return r14;
    L28:
        r3.o(r53);
        r3.n(xem.b);
        qlm r103 = qlm.a(r27, null, null, 0, false, null, r3.f(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_STOP_CLIENT);
        r6.a = r25;
        r6.b = r26;
        r11 = r27;
        r6.c = r11;
        r6.d = r3;
        r6.e = r4;
        r6.f = r53;
        r6.g = ibq.nullOutSpilledVariable(r84);
        r6.k = 1;
        if (r4.invoke(r103, r6) == r72) goto L46;
        r13 = r25;
        r102 = r26;
        r22 = r53;
        r12 = r84;
    L7:
        r6 = new klm(this, r30);
        goto L8
    }
}
