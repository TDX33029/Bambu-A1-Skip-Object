package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.hardware.camera2.CaptureResult;
import android.util.Log;
import com.bambulab.bambulab.model.AppNewbieTaskV4RewardType;
import com.bambulab.bambulab.model.BeginnerTaskV4Level;
import com.bambulab.bambulab.model.CalibrateFlags;
import com.bambulab.bambulab.model.IotFilament;
import com.bambulab.bambulab.model.IotPlateObjectId;
import com.bambulab.creator.R;
import com.bambulab.printer.model.generated.BblpAmsType;
import com.bbl.config.core.EnvironmentConfig;
import com.bbl.config.core.UrlExtensionsKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.ek;
import com.umeng.ccg.a;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.security.KeyFactory;
import java.security.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public final class x0k implements y35, y7h, x6t, ezs, gr4, cq0, fa5, v7k, znd, vjb, bdl, e26, czb {
    public static x0k a;
    public static final x0k b = null;
    public static final x0k c = null;
    public static final x0k d = null;
    public static final ewn e = null;
    public static final x0k f = null;
    public static final x0k g = null;
    public static final x0k h = null;

    static {
        b = new x0k();
        c = new x0k();
        d = new x0k();
        e = new ewn(Float.NaN, Float.NaN, Float.NaN, Float.NaN);
        f = new x0k();
        g = new x0k();
        h = new x0k();
    }

    public x0k() {
    }

    public static sjp s(String r10, String r11, String r12, act r13, gls r14) {
        if (fuq.B0("liveview") == true) goto L6;
        String r4 = fuq.f1("liveview").toString();
        r4.getClass();
        r10.getClass();
        r11.getClass();
        return new sjp(r4, r10, new gjp(r11, r12), null, new ubt(r13, n2v.b(new z2n[]{r14}), null, 18), 40);
    L6:
        vc0.k("businessId must not be blank");
        return null;
    }

    public static ws v(gjp r21, zs r22, int r23, zy1 r24) {
        r21.getClass();
        String r2 = r21.b;
        if (r2 == null) goto L13;
        String r25 = fuq.f1(r2).toString();
        if (r25 == null) goto L13;
        if (r25.length() <= 0) goto L9;
        String r6 = r25;
    L10:
        if (r6 == null) goto L13;
        return new ws(r6, r21.a, r22.a, r22.b, r22.c, r22.d, r22.e, r22.f, r22.g, r23, r22.h, r24, r22.i, r22.j, r22.k);
    L9:
        r6 = null;
    L13:
        vc0.k("SessionCredential.authKey is required for Agora appId");
        return null;
    }

    public static int w(int r11, int r12, int r13, byte[] r14) {
        if (r11 == 0) goto L56;
        if (r12 < r13) goto L6;
        return r11;
    L6:
        byte r8 = (byte) r11;
        if (r8 >= (-32)) goto L12;
        if (r8 < (-62)) goto L99;
        int r112 = r12 + 1;
        if (r14[r12] > (-65)) goto L99;
    L11:
        r12 = r112;
    L99:
        return -1;
    L12:
        int r9 = ~(r11 >> 8);
        if (r8 >= (-16)) goto L29;
        byte r113 = (byte) r9;
        if (r113 != 0) goto L21;
        int r114 = r12 + 1;
        byte r122 = r14[r12];
        if (r114 >= r13) goto L20;
        r12 = r114;
        r113 = r122;
        goto L21
    L20:
        return dtu.d(r8, r122);
    L21:
        if (r113 > (-65)) goto L99;
        if (r8 != (-32)) goto L24;
        if (r113 < (-96)) goto L99;
    L24:
        if (r8 != (-19)) goto L26;
        if (r113 >= (-96)) goto L99;
    L26:
        r112 = r12 + 1;
        if (r14[r12] > (-65)) goto L99;
    L29:
        byte r92 = (byte) r9;
        if (r92 != 0) goto L36;
        int r115 = r12 + 1;
        r92 = r14[r12];
        if (r115 >= r13) goto L35;
        r12 = r115;
        int r116 = 0;
    L37:
        if (r116 != 0) goto L49;
        int r117 = r12 + 1;
        byte r123 = r14[r12];
        if (r117 >= r13) goto L41;
        r12 = r117;
        r116 = r123;
        goto L49
    L41:
        x0k r118 = dtu.a;
        if (r8 > (-12)) goto L48;
        if (r92 > (-65)) goto L48;
        if (r123 > (-65)) goto L48;
        return ((r92 << 8) ^ r8) ^ (r123 << ek.n);
    L48:
        return -1;
    L49:
        if (r92 > (-65)) goto L99;
        if ((((r92 + 112) + (r8 << 28)) >> 30) != 0) goto L99;
        if (r116 > (-65)) goto L99;
        r112 = r12 + 1;
        if (r14[r12] > (-65)) goto L99;
    L35:
        return dtu.d(r8, r92);
    L36:
        r116 = r11 >> 16;
    L56:
        if (r12 >= r13) goto L60;
        if (r14[r12] < 0) goto L60;
        r12 = r12 + 1;
    L60:
        if (r12 >= r13) goto L63;
    L62:
        if (r12 >= r13) goto L63;
        int r119 = r12 + 1;
        byte r82 = r14[r12];
        if (r82 < 0) goto L66;
        r12 = r119;
        goto L62
    L66:
        if (r82 < (-32)) goto L67;
        if (r82 < (-16)) goto L75;
        if (r119 >= (r13 - 2)) goto L90;
        int r93 = r12 + 2;
        byte r1110 = r14[r119];
        if (r1110 > (-65)) goto L99;
        if ((((r1110 + 112) + (r82 << 28)) >> 30) != 0) goto L99;
        int r1111 = r12 + 3;
        if (r14[r93] > (-65)) goto L99;
        r12 = r12 + 4;
        if (r14[r1111] <= (-65)) goto L62;
    L90:
        return dtu.a(r119, r13, r14);
    L75:
        if (r119 >= (r13 - 1)) goto L77;
        int r94 = r12 + 2;
        byte r1112 = r14[r119];
        if (r1112 > (-65)) goto L99;
        if (r82 != (-32)) goto L82;
        if (r1112 < (-96)) goto L99;
    L82:
        if (r82 != (-19)) goto L84;
        if (r1112 >= (-96)) goto L99;
    L84:
        r12 = r12 + 3;
        if (r14[r94] <= (-65)) goto L62;
    L77:
        return dtu.a(r119, r13, r14);
    L67:
        if (r119 >= r13) goto L68;
        if (r82 < (-62)) goto L99;
        r12 = r12 + 2;
        if (r14[r119] <= (-65)) goto L62;
    L68:
        return r82;
    L63:
        return 0;
    }

    @Override // defpackage.v7k
    public Object W() {
        return new ArrayDeque();
    }

    @Override // defpackage.fa5
    public long a() {
        return -1;
    }

    @Override // defpackage.fa5
    public xcr c() {
        return xcr.b;
    }

    @Override // defpackage.fa5
    public int d() {
        return 1;
    }

    @Override // defpackage.y7h
    public void debug(String r1) {
        Log.d("bup", r1);
    }

    @Override // defpackage.gr4
    public long e(qcp r1, int r2) {
        String r0 = r1.f.a.a.b;
        return h5j.b(ji8.h(r0, r2), ji8.g(r0, r2));
    }

    @Override // defpackage.fa5
    public ca5 f() {
        return ca5.a;
    }

    @Override // defpackage.x6t
    public Object g(nzf r12, float r13) {
        boolean r132 = true;
        if (r12.h() == 1) goto L6;
        r132 = false;
    L6:
        if (r132 == false) goto L8;
        r12.beginArray();
    L8:
        double r0 = r12.nextDouble();
        double r2 = r12.nextDouble();
        double r4 = r12.nextDouble();
        if (r12.h() != 7) goto L11;
        double r9 = r12.nextDouble();
    L12:
        if (r132 == false) goto L15;
        r12.endArray();
    L15:
        if (r0 > 1.0d) goto L24;
        if (r2 > 1.0d) goto L24;
        if (r4 > 1.0d) goto L24;
        r0 = r0 * 255.0d;
        r2 = r2 * 255.0d;
        r4 = r4 * 255.0d;
        if (r9 > 1.0d) goto L24;
        r9 = r9 * 255.0d;
    L24:
        return Integer.valueOf(Color.argb((int) r9, (int) r0, (int) r2, (int) r4));
    L11:
        r9 = 1.0d;
        goto L12
    }

    @Override // defpackage.fa5
    public da5 i() {
        return da5.a;
    }

    @Override // defpackage.ezs
    public boolean j() {
        return false;
    }

    @Override // defpackage.czb
    public void k(yap r1) {
    }

    @Override // defpackage.fa5
    public ba5 l() {
        return ba5.a;
    }

    @Override // defpackage.vjb
    public Object m(String r1, Provider r2) {
        if (r2 != null) goto L6;
        return KeyFactory.getInstance(r1);
    L6:
        return KeyFactory.getInstance(r1, r2);
    }

    @Override // defpackage.ezs
    public Object n(r9 r1, rf7 r2) {
        return rs4.boxBoolean(false);
    }

    public Object o(Context r21, EnvironmentConfig r22, BeginnerTaskV4Level r23, AppNewbieTaskV4RewardType r24, tf7 r25) {
        Context r0 = r21;
        if ((r25 instanceof n04) == false) goto L7;
        n04 r2 = (n04) r25;
        int r3 = r2.g;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.g = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.e;
        Object r32 = nsf.getCOROUTINE_SUSPENDED();
        int r4 = r2.g;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L12;
        AppNewbieTaskV4RewardType r02 = (AppNewbieTaskV4RewardType) r2.d;
        BeginnerTaskV4Level r03 = r2.c;
        EnvironmentConfig r33 = r2.b;
        Context r26 = r2.a;
        gti.r(r1);
        BeginnerTaskV4Level r10 = r03;
        r0 = r26;
    L30:
        String r13 = (String) r1;
        if (r13 != null) goto L33;
        return null;
    L33:
        int r12 = m04.a[r10.ordinal()];
        if (r12 == 1) goto L41;
        if (r12 == 2) goto L40;
        if (r12 != 3) goto L38;
        int r14 = R.string.newbieV4Level3;
    L42:
        String r122 = zcv.e(r0, R.string.beginnerPrintChallengeShareText, new Object[]{zcv.d(r14, r0)});
        r33.getClass();
        String r15 = UrlExtensionsKt.beginnerActivityV4Url(r33, "ShareLink");
        return new h23(r122, r13, null, r15, r15, true, null, 9962);
    L38:
        cze.d();
        return null;
    L40:
        r14 = R.string.newbieV4Level2;
        goto L42
    L41:
        r14 = R.string.newbieV4Level1;
        goto L42
    L12:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L14:
        gti.r(r1);
        int r16 = m04.a[r23.ordinal()];
        if (r16 == 1) goto L25;
        if (r16 == 2) goto L24;
        if (r16 != 3) goto L22;
        AppNewbieTaskV4RewardType r42 = r24;
        if (r42 != AppNewbieTaskV4RewardType.POINT) goto L21;
        int r17 = R.drawable.beginner_reward_share_level_3_1;
    L26:
        r2.a = r0;
        r2.b = r22;
        r10 = r23;
        r2.c = r10;
        r2.d = ibq.nullOutSpilledVariable(r42);
        r2.g = 1;
        wh8 r43 = mwa.a;
        r1 = dy4.d(ve8.b, new g23("beginner_reward_share_", r0, r17, null), r2);
        if (r1 != r32) goto L29;
        return r32;
    L29:
        r33 = r22;
        goto L30
    L21:
        r17 = R.drawable.beginner_reward_share_level_3_2;
        goto L26
    L22:
        cze.d();
        return null;
    L24:
        r42 = r24;
        r17 = R.drawable.beginner_reward_share_level_2;
        goto L26
    L25:
        r42 = r24;
        r17 = R.drawable.beginner_reward_share_level_1;
    L7:
        r2 = new n04(this, r25);
        goto L8
    }

    @Override // defpackage.czb
    public void p() {
    }

    @Override // defpackage.czb
    public l7s q(int r1, int r2) {
        return new nta();
    }

    @Override // defpackage.fa5
    public CaptureResult r() {
        return null;
    }

    public Object t(String r7, u4j r8, z3m r9, y4j r10, tf7 r11) {
        if ((r11 instanceof z3j) == false) goto L7;
        z3j r0 = (z3j) r11;
        int r1 = r0.h;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.h = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f;
        Object r112 = nsf.getCOROUTINE_SUSPENDED();
        int r12 = r0.h;
        boolean r4 = true;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L12;
        String r72 = r0.e;
        r10 = r0.d;
        z3m r82 = (z3m) r0.c;
        u4j r83 = (u4j) r0.b;
        String r84 = (String) r0.a;
        gti.r(r6);
    L24:
        qwr r62 = (qwr) r6;
        if (r62 == null) goto L27;
        Boolean r85 = rs4.boxBoolean(r62.a);
    L28:
        if (r62 != null) goto L30;
    L32:
        r4 = false;
    L33:
        boolean r63 = lsf.l(r72, UMModuleRegister.INNER);
        h3j r92 = h3j.a;
        if (r85 != null) goto L36;
    L39:
        Object r86 = r92;
    L41:
        if (r86.equals(r92) == false) goto L44;
    L42:
        return null;
    L44:
        if ((r86 instanceof i3j) == false) goto L47;
        r10.invoke(new y3j(r72, 0));
        i3j r87 = (i3j) r86;
        return new r4j(r87.a, r87.b);
    L47:
        cze.d();
        return null;
    L36:
        if (r85.booleanValue() == true) goto L39;
        r86 = new i3j(r63, r4);
        goto L41
    L30:
        if (r62.b <= 0) goto L32;
    L27:
        r85 = null;
        goto L28
    L12:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L14:
        gti.r(r6);
        if (r8.e == false) goto L42;
        if (r8.q == false) goto L42;
        String r64 = r8.s;
        r0.a = ibq.nullOutSpilledVariable(r7);
        r0.b = ibq.nullOutSpilledVariable(r8);
        r0.c = ibq.nullOutSpilledVariable(r9);
        r0.d = r10;
        r0.e = r64;
        r0.h = 1;
        Object r73 = r9.c(0, r0, r7, r64);
        if (r73 != r112) goto L23;
        return r112;
    L23:
        r72 = r64;
        r6 = r73;
    L7:
        r0 = new z3j(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v44, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList] */
    public Object u(String r27, String r28, String r29, u4j r30, enm r31, y4j r32, zsg r33, tf7 r34) {
        if ((r34 instanceof a4j) == false) goto L7;
        a4j r3 = (a4j) r34;
        int r4 = r3.t;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.t = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.r;
        Object r42 = nsf.getCOROUTINE_SUSPENDED();
        int r5 = r3.t;
        trs r6 = trs.a;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L13;
        Map r0 = (Map) r3.n;
        Map r02 = (Map) r3.m;
        Boolean r03 = (Boolean) r3.l;
        List r04 = (List) r3.k;
        List r05 = (List) r3.j;
        List r06 = (List) r3.i;
        zal r07 = (zal) r3.h;
        Function2 r08 = (Function2) r3.g;
        Function1 r09 = r3.f;
        enm r1 = (enm) r3.e;
        u4j r12 = (u4j) r3.d;
        String r13 = (String) r3.c;
        String r14 = (String) r3.b;
        String r15 = (String) r3.a;
        gti.r(r2);
        trs r24 = r6;
        boolean r26 = false;
    L155:
        r09.invoke(rs4.boxBoolean(r26));
        return r24;
    L13:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L15:
        boolean r010 = r3.q;
        int r16 = r3.p;
        ?? r52 = (Map) r3.n;
        ?? r9 = (Map) r3.m;
        Boolean r10 = (Boolean) r3.l;
        List r11 = (List) r3.k;
        ?? r122 = (List) r3.j;
        ?? r132 = (List) r3.i;
        zal r142 = (zal) r3.h;
        Function2 r152 = (Function2) r3.g;
        r26 = false;
        Function1 r8 = r3.f;
        enm r7 = (enm) r3.e;
        u4j r011 = (u4j) r3.d;
        r29 = (String) r3.c;
        String r012 = (String) r3.b;
        String r013 = (String) r3.a;
        gti.r(r2);
        r24 = r6;
        egb r162 = r122;
        egb r17 = r132;
        zal r18 = r142;
        boolean r62 = r010;
        String r272 = r013;
        huh r123 = r9;
        Boolean r133 = r10;
        Collection r143 = r11;
        int r92 = r16;
        Object r102 = ((pfo) r2).a;
        huh r112 = r52;
        u4j r53 = r011;
        String r19 = r012;
    L16:
        String r22 = r29;
        pfo r014 = new pfo(r102);
        r3.a = ibq.nullOutSpilledVariable(r272);
        r3.b = ibq.nullOutSpilledVariable(r19);
        r3.c = ibq.nullOutSpilledVariable(r22);
        r3.d = ibq.nullOutSpilledVariable(r53);
        r3.e = ibq.nullOutSpilledVariable(r7);
        r3.f = r8;
        r3.g = ibq.nullOutSpilledVariable(r152);
        r3.h = ibq.nullOutSpilledVariable(r18);
        r3.i = ibq.nullOutSpilledVariable(r17);
        r3.j = ibq.nullOutSpilledVariable(r162);
        r3.k = ibq.nullOutSpilledVariable(r143);
        r3.l = ibq.nullOutSpilledVariable(r133);
        r3.m = ibq.nullOutSpilledVariable(r123);
        r3.n = ibq.nullOutSpilledVariable(r112);
        r3.o = ibq.nullOutSpilledVariable(r102);
        r3.p = r92;
        r3.q = r62;
        r3.t = 2;
        if (r152.invoke(r014, r3) != r42) goto L154;
    L153:
        return r42;
    L154:
        r09 = r8;
        goto L155
    L17:
        r26 = false;
        gti.r(r2);
        zal r144 = r30.d();
        boolean r23 = r30.A;
        boolean r54 = r30.e;
        Map r72 = r30.D;
        if (r144 != null) goto L20;
        return r6;
    L20:
        r32.invoke(rs4.boxBoolean(true));
        List r82 = r30.U;
        if (r82 == null) goto L28;
        int r83 = r82.size();
        Integer r113 = Integer.valueOf(r83);
        if (r83 > 0) goto L26;
        r113 = null;
    L26:
        if (r113 == null) goto L28;
        int r84 = r113.intValue();
    L41:
        r72.getClass();
        egb r114 = egb.a;
        if (r84 > 0) goto L45;
        egb r134 = r114;
    L44:
        boolean r172 = r23;
        Integer r25 = 255;
        if (r84 > 0) goto L71;
        egb r124 = r114;
    L70:
        boolean r163 = r54;
        List r210 = r30.d0;
        if (r210 != null) goto L97;
    L96:
        Collection r115 = null;
    L113:
        if (r163 == true) goto L115;
    L117:
        Boolean r103 = null;
    L118:
        List r211 = r30.C;
        Set r55 = b4j.a;
        if (r172 == false) goto L121;
        boolean r212 = false;
    L122:
        String r56 = r144.d;
        boolean r73 = r30.d;
        if (r30.f == true) goto L125;
    L128:
        boolean r93 = false;
    L129:
        int r153 = r30.g;
        int r57 = r30.h;
        int r58 = r30.i;
        boolean r59 = r30.p;
        r28.getClass();
        r29.getClass();
        huh r510 = new huh();
        r24 = r6;
        r510.put("subtask_name", r28);
        r510.put("url", "file://".concat(r29));
        if (r56 != null) goto L132;
        String r63 = "";
    L133:
        r510.put(RemoteMessageConst.MessageBody.PARAM, r63);
        r510.put("subtask_id", "0");
        r510.put("plate_idx", 0);
        r510.put("job_type", 1);
        r510.put("use_ams", Boolean.valueOf(r172));
        r510.put("ams_mapping", r134);
        r510.put("ams_mapping2", r124);
        r510.put(CalibrateFlags.Ids.BED_LEVELING, Boolean.valueOf(r73));
        r510.put("timelapse", Boolean.valueOf(r163));
        r510.put("flow_cali", Boolean.valueOf(r93));
        Boolean r64 = Boolean.FALSE;
        r510.put("vibration_cali", r64);
        r510.put("layer_inspect", r64);
        r510.put("auto_bed_leveling", Integer.valueOf(r153));
        r510.put("extrude_cali_flag", Integer.valueOf(r57));
        r510.put("nozzle_offset_cali", Integer.valueOf(r58));
        if (r115 == null) goto L136;
        r510.put("skip_objects", r115);
    L136:
        r510.put(a.o, z0v.e(Boolean.valueOf(r59), r103));
        huh r94 = r510.c();
        boolean r511 = r30.J;
        boolean r65 = r144.n;
        boolean r74 = r30.j;
        List r154 = r30.e();
        if (r154.isEmpty() == false) goto L140;
        r154 = null;
    L140:
        if (r511 == true) goto L142;
        huh r512 = r94;
    L147:
        r3.a = ibq.nullOutSpilledVariable(r27);
        r3.b = ibq.nullOutSpilledVariable(r28);
        r3.c = ibq.nullOutSpilledVariable(r29);
        r3.d = ibq.nullOutSpilledVariable(r30);
        r3.e = ibq.nullOutSpilledVariable(r31);
        r3.f = r32;
        r3.g = r33;
        r3.h = ibq.nullOutSpilledVariable(r144);
        r3.i = ibq.nullOutSpilledVariable(r134);
        r3.j = ibq.nullOutSpilledVariable(r124);
        r3.k = ibq.nullOutSpilledVariable(r115);
        r3.l = ibq.nullOutSpilledVariable(r103);
        r3.m = ibq.nullOutSpilledVariable(r94);
        r3.n = ibq.nullOutSpilledVariable(r512);
        r3.p = r84;
        r3.q = r212;
        r3.t = 1;
        r7 = r31;
        Object r155 = r7.a(r27, r512, r3);
        if (r155 == r42) goto L153;
        r272 = r27;
        r162 = r124;
        r17 = r134;
        r18 = r144;
        r62 = r212;
        r123 = r94;
        r133 = r103;
        r143 = r115;
        r102 = r155;
        r152 = r33;
        r112 = r512;
        r92 = r84;
        r53 = r30;
        r8 = r32;
        r19 = r28;
        goto L16
    L142:
        huh r513 = new huh();
        r513.putAll(r94);
        r513.put("extrude_cali_manual_mode", Integer.valueOf(!r74 ? 1 : 0));
        if (r65 == true) goto L146;
        if (r154 == null) goto L146;
        r513.put("nozzle_mapping", r154);
    L146:
        r512 = r513.c();
        goto L147
    L132:
        r63 = r56;
        goto L133
    L125:
        if (r30.o == false) goto L128;
        if (r212 == true) goto L128;
        r93 = true;
        goto L129
    L121:
        r212 = r86.c0((String) ehp.u(ehp.x(new soc(r86.Z(r211), true, new b3j(1)), new b3j(2))), b4j.a);
        goto L122
    L115:
        if (r30.q == false) goto L117;
        r103 = rs4.boxBoolean(r30.s.equals(UMModuleRegister.INNER));
        goto L118
    L97:
        List r514 = r144.g;
        ArrayList r75 = new ArrayList();
        Iterator r515 = r514.iterator();
    L99:
        if (r515.hasNext() == false) goto L104;
        Long r95 = ((IotPlateObjectId) r515.next()).getIdentifyId();
        if (r95 == null) goto L99;
        r75.add(r95);
        goto L99
    L104:
        if (r75.isEmpty() == true) goto L96;
        Set r213 = r86.V0(r210);
        ArrayList r516 = new ArrayList();
        Iterator r76 = r75.iterator();
    L108:
        if (r76.hasNext() == false) goto L112;
        Object r96 = r76.next();
        if (r213.contains(Long.valueOf(((Number) r96).longValue())) == true) goto L108;
        r516.add(r96);
        goto L108
    L112:
        r115 = r516;
        goto L113
    L71:
        ?? r97 = new ArrayList(r84);
        int r104 = 0;
    L72:
        if (r104 >= r84) goto L93;
        r104 = r104 + 1;
        t63 r116 = (t63) r72.get(Integer.valueOf(r104));
        if (r116 == null) goto L87;
        Integer r125 = r116.a();
        if (r125 == null) goto L87;
        int r126 = r125.intValue();
        Integer r156 = r116.getSlotId();
        if (r156 == null) goto L87;
        int r157 = r156.intValue();
        boolean r164 = r54;
        if ((r116 instanceof nz1) == false) goto L82;
        nz1 r117 = (nz1) r116;
    L83:
        if (r117 == null) goto L85;
        BblpAmsType r517 = r117.k;
    L86:
        ko7 r518 = tdv.c(r126, r157, r517);
    L89:
        if (r518 != null) goto L91;
        Map r519 = vvh.h0(new dtk[]{new dtk("ams_id", r25), new dtk("slot_id", r25)});
        Integer r20 = r25;
    L92:
        r97.add(r519);
        r54 = r164;
        r25 = r20;
        goto L72
    L91:
        r20 = r25;
        r519 = vvh.h0(new dtk[]{new dtk("ams_id", Integer.valueOf(r518.b)), new dtk("slot_id", Integer.valueOf(r518.c))});
        goto L92
    L85:
        r517 = null;
        goto L86
    L82:
        r117 = null;
    L87:
        r164 = r54;
        r518 = null;
        goto L89
    L93:
        r124 = r97;
        goto L70
    L45:
        ?? r127 = new ArrayList(r84);
        int r135 = 0;
    L46:
        if (r135 >= r84) goto L66;
        r135 = r135 + 1;
        t63 r158 = (t63) r72.get(Integer.valueOf(r135));
        int r165 = -1;
        if (r158 != null) goto L50;
        boolean r173 = r23;
    L65:
        r127.add(Integer.valueOf(r165));
        r23 = r173;
        goto L46
    L50:
        Integer r174 = r158.a();
        if (r174 == null) goto L62;
        int r98 = r174.intValue();
        Integer r175 = r158.getSlotId();
        if (r175 == null) goto L62;
        int r105 = r175.intValue();
        r173 = r23;
        if ((r158 instanceof nz1) == false) goto L57;
        nz1 r159 = (nz1) r158;
    L58:
        if (r159 == null) goto L60;
        BblpAmsType r214 = r159.k;
    L61:
        ko7 r215 = tdv.c(r98, r105, r214);
    L63:
        if (r215 == null) goto L65;
        r165 = r215.a;
        goto L65
    L60:
        r214 = null;
        goto L61
    L57:
        r159 = null;
    L62:
        r173 = r23;
        r215 = null;
        goto L63
    L66:
        r134 = r127;
    L28:
        List r85 = r144.f;
        ArrayList r118 = new ArrayList();
        Iterator r86 = r85.iterator();
    L30:
        if (r86.hasNext() == false) goto L34;
        Integer r128 = ((IotFilament) r86.next()).getFilamentIdx();
        if (r128 == null) goto L30;
        r118.add(r128);
        goto L30
    L34:
        Integer r87 = (Integer) r86.s0(r118);
        if (r87 == null) goto L37;
    L36:
        r84 = r87.intValue();
        goto L41
    L37:
        r87 = (Integer) r86.s0(r72.keySet());
        if (r87 != null) goto L36;
        r84 = 0;
    L7:
        r3 = new a4j(this, r34);
        goto L8
    }
}
