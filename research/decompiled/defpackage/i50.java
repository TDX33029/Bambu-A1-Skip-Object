package defpackage;

import com.bambulab.bambulab.common.device.data.model.PrintTask2DStateKt;
import com.bambulab.bambulab.common.device.data.model.PrintTaskDataKt;
import com.bambulab.bambulab.common.device.data.model.RuntimeCloudSlicingQueue;
import com.bambulab.bambulab.common.device.data.model.RuntimeTaskSnapshot;
import com.bambulab.bambulab.model.AMSCompatibility;
import com.bambulab.bambulab.model.DeviceModelNames;
import com.bambulab.printer.model.generated.BblpAirPurification;
import com.bambulab.printer.model.generated.BblpCapabilities;
import com.bambulab.printer.model.generated.BblpDesignShotSwitcher;
import com.bambulab.printer.model.generated.BblpDoorDetectConfig;
import com.bambulab.printer.model.generated.BblpFeatures;
import com.bambulab.printer.model.generated.BblpOptionFlag;
import com.bambulab.printer.model.generated.BblpPrintConfig;
import com.bambulab.printer.model.generated.BblpPrintStage;
import com.bambulab.printer.model.generated.BblpPrintState;
import com.bambulab.printer.model.generated.BblpPrintType;
import com.bbl.device.model.BblPrinterStateView;
import com.bbl.device.model.BblProductAmsProfile;
import com.bbl.device.model.BblProductCameraProfile;
import com.bbl.device.model.BblProductProfileState;
import com.bbl.device.model.BblProductStorageProfile;
import com.bbl.device.model.BblProductStructure;
import com.bbl.device.model.BblPurifyAirAtPrintEndSetting;
import com.bbl.device.model.BblTaskInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class i50 extends o7r implements kpd {
    public final /* synthetic */ byte a;
    public /* synthetic */ Object b;
    public /* synthetic */ Object c;
    public /* synthetic */ Object d;
    public /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ i50(Object r1, rf7 r2, byte r3) {
        this.a = r3;
        this.f = r1;
        super(5, r2);
    }

    @Override // defpackage.kpd
    public final Object e(Object r4, Object r5, Object r6, Object r7, Object r8) {
        byte r0 = this.a;
        trs r1 = trs.a;
        Object r3 = this.f;
        switch(r0) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        lwt r32 = (lwt) r3;
        i50 r02 = new i50(r32, (rf7) r8, 4);
        r02.b = (rwt) r4;
        r02.d = (BblProductProfileState) r5;
        r02.c = (BblPrinterStateView) r6;
        r02.e = (f2h) r7;
        return r02.invokeSuspend(r1);
    L6:
        oqq r33 = (oqq) r3;
        i50 r03 = new i50(r33, (rf7) r8, 3);
        r03.b = (pnq) r4;
        r03.c = (ckq) r5;
        r03.d = (eqq) r6;
        r03.e = (Throwable) r7;
        return r03.invokeSuspend(r1);
    L8:
        sfm r34 = (sfm) r3;
        i50 r04 = new i50(r34, (rf7) r8, 2);
        r04.b = (BblProductProfileState) r4;
        r04.c = (BblPrinterStateView) r5;
        r04.d = (cv3) r6;
        r04.e = (wvt) r7;
        return r04.invokeSuspend(r1);
    L10:
        h5i r35 = (h5i) r3;
        i50 r05 = new i50(r35, (rf7) r8, 1);
        r05.b = (BblTaskInfo) r4;
        r05.c = (cv3) r5;
        r05.d = (BblpCapabilities) r6;
        r05.e = (uy2) r7;
        return r05.invokeSuspend(r1);
    L12:
        c50 r36 = (c50) r3;
        i50 r06 = new i50(r36, (rf7) r8, 0);
        r06.b = (List) r4;
        r06.c = (BblPrinterStateView) r5;
        r06.d = (c90) r6;
        r06.e = (b90) r7;
        r06.invokeSuspend(r1);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // defpackage.ft1
    public final Object invokeSuspend(Object r69) {
        byte r1 = this.a;
        List r2 = egb.a;
        Object r5 = this.f;
        Object r6 = null;
        switch(r1) {
            case 0: goto L498;
            case 1: goto L227;
            case 2: goto L69;
            case 3: goto L31;
            default: goto L4;
        };
    L4:
        rwt r12 = (rwt) this.b;
        BblProductProfileState r22 = (BblProductProfileState) this.d;
        BblPrinterStateView r7 = (BblPrinterStateView) this.c;
        f2h r17 = (f2h) this.e;
        nsf.getCOROUTINE_SUSPENDED();
        gti.r(r69);
        lwt r52 = (lwt) r5;
        if (r22 == null) goto L7;
        BblProductStructure r0 = r22.getStructure();
    L8:
        boolean r11 = !fuq.m0(String.valueOf(r0), "i3", true);
        boolean r13 = r12.d;
        boolean r122 = r12.b;
        String r9 = r52.a;
        String r02 = r12.a;
        if (r02 != null) goto L11;
        r02 = "";
    L11:
        boolean r10 = r02.equalsIgnoreCase("RUNNING");
        String r14 = r52.b;
        if (r7 == null) goto L25;
        List<vw3> r03 = r7.getVersions();
        if (r03 == null) goto L25;
        Iterator r04 = r03.iterator();
    L17:
        if (r04.hasNext() == false) goto L21;
        Object r15 = r04.next();
        if (((vw3) r15).e() == false) goto L17;
    L22:
        vw3 r16 = (vw3) r15;
        if (r16 == null) goto L25;
        r6 = r16.d;
        goto L25
    L21:
        r15 = null;
    L25:
        ?? r152 = r6;
        if (r22 == null) goto L28;
        boolean r162 = true;
    L30:
        return new hwt(r9, r10, r11, r122, r13, r14, r152, r162, r17);
    L28:
        r162 = false;
        goto L30
    L7:
        r0 = null;
        goto L8
    L31:
        pnq r18 = (pnq) this.b;
        ckq r23 = (ckq) this.c;
        eqq r3 = (eqq) this.d;
        Throwable r05 = (Throwable) this.e;
        nsf.getCOROUTINE_SUSPENDED();
        gti.r(r69);
        oqq r53 = (oqq) r5;
        boolean r72 = r23.a;
        boolean r8 = r23.b;
        if (r72 == false) goto L35;
        if (r8 == false) goto L35;
        Object r73 = new iqq(r3, r23);
    L40:
        boolean r32 = r18 instanceof onq;
        if (r32 == false) goto L45;
        if (r73 == null) goto L45;
        r53.k = true;
    L45:
        if (r53.k == false) goto L48;
        if (r73 == null) goto L48;
    L618:
        return r73;
    L48:
        boolean r92 = r18 instanceof nnq;
        if (r92 == true) goto L52;
        r53.j = true;
    L52:
        if ((r18 instanceof mnq) == false) goto L55;
        if (r05 == null) goto L620;
        return new lqq(r05, r23);
    L620:
        return mqq.a;
    L55:
        if (r92 == true) goto L57;
        if (r32 == false) goto L67;
        if (r73 != null) goto L618;
        StringBuilder r19 = dgh.q("No supported storage tab for deviceId=", r53.a, ": supportTimelapse=", ", isApiV2=", r23.a);
        r19.append(r8);
        return new lqq(new IllegalStateException(r19.toString()), r23);
    L67:
        cze.d();
        return null;
    L57:
        if (r53.j == true) goto L61;
        if (r05 == null) goto L620;
    L61:
        if (r05 != null) goto L621;
        r05 = ((nnq) r18).a;
    L621:
        return new lqq(r05, r23);
    L35:
        if (r72 == false) goto L37;
        r73 = new kqq(r23);
        goto L40
    L37:
        if (r8 == false) goto L39;
        r73 = new jqq(r23);
        goto L40
    L39:
        r73 = null;
        goto L40
    L69:
        BblProductProfileState r110 = (BblProductProfileState) this.b;
        BblPrinterStateView r24 = (BblPrinterStateView) this.c;
        cv3 r74 = (cv3) this.d;
        wvt r132 = (wvt) this.e;
        nsf.getCOROUTINE_SUSPENDED();
        gti.r(r69);
        sfm r54 = (sfm) r5;
        String r93 = r54.a;
        boolean r112 = r54.h;
        if (r24 == null) goto L72;
        BblpPrintConfig r06 = r24.getPrintConfig();
    L73:
        if (r06 != null) goto L75;
        afm r82 = new afm(false, false, false, false);
    L76:
        if (r24 != null) goto L78;
    L80:
        boolean r21 = false;
    L81:
        if (r24 == null) goto L83;
        boolean r28 = r24.getCapabilities().getSoundPlayback();
    L88:
        if (r06 != null) goto L90;
    L92:
        boolean r31 = false;
    L93:
        if (r06 == null) goto L95;
        BblpDoorDetectConfig r102 = r06.getDoorDetectConfig();
    L96:
        if (r06 == null) goto L102;
        BblpDesignShotSwitcher r123 = r06.getDesignShotSwitcher();
        if (r123 == null) goto L102;
        if (r123 == BblpDesignShotSwitcher.NO_EFFECT) goto L102;
        boolean r142 = true;
    L103:
        if (r24 == null) goto L109;
        BblPurifyAirAtPrintEndSetting r124 = r24.getPurifyAirAtPrintEndSetting();
        if (r124 == null) goto L109;
        if (r124.getAvailable() != true) goto L109;
    L114:
        boolean r242 = true;
    L116:
        if (r24 == null) goto L118;
        Boolean r125 = Boolean.valueOf(r24.getAirPrintDetectNoXcamVisible());
    L119:
        boolean r34 = lsf.l(r125, Boolean.TRUE);
        if (r110 == null) goto L122;
        BblProductStructure r126 = r110.getStructure();
    L124:
        if (r126 != BblProductStructure.I3) goto L126;
        boolean r127 = true;
    L127:
        if (r24 == null) goto L129;
        r24.isOnline();
    L129:
        if (r06 == null) goto L131;
        BblpDesignShotSwitcher r153 = r06.getDesignShotSwitcher();
    L133:
        if (r153 != BblpDesignShotSwitcher.ENABLE) goto L135;
        boolean r154 = true;
    L136:
        if (r132 != null) goto L138;
    L140:
        boolean r172 = false;
    L141:
        if (r132 != null) goto L143;
    L145:
        boolean r192 = false;
    L146:
        if (r102 != null) goto L148;
        boolean r222 = false;
    L153:
        if (r102 == null) goto L155;
        int r232 = r102.getCode();
    L156:
        if (r06 == null) goto L160;
        BblpAirPurification r33 = r06.getCfgAirPurification();
        if (r33 == null) goto L160;
        int r25 = r33.getCode();
    L161:
        if (r132 == null) goto L163;
        boolean r26 = r132.I;
    L164:
        if (r74 == null) goto L166;
        boolean r27 = r74.c;
    L167:
        if (r110 == null) goto L173;
        BblProductStorageProfile r35 = r110.getStorage();
        if (r35 == null) goto L173;
        if (r35.getPrintCacheAvailable() != true) goto L173;
        boolean r30 = true;
    L174:
        if (r132 != null) goto L176;
    L178:
        boolean r322 = false;
    L179:
        if (r06 == null) goto L183;
        BblpOptionFlag r36 = r06.getSmartClumpDetectConfig();
        if (r36 == null) goto L183;
        int r332 = r36.getCode();
    L184:
        if (r06 != null) goto L186;
    L188:
        boolean r352 = false;
    L189:
        if (r110 == null) goto L195;
        BblProductCameraProfile r07 = r110.getCamera();
        if (r07 == null) goto L195;
        if (r07.getFirstLayerInspect() != true) goto L195;
        boolean r362 = true;
    L196:
        if (r24 == null) goto L201;
        mn3 r08 = r24.getCamera();
        if (r08 == null) goto L201;
        boolean r09 = r08.y;
    L200:
        boolean r37 = r09;
    L207:
        r93.getClass();
        if (r24 != null) goto L210;
    L212:
        boolean r103 = false;
    L213:
        if (r24 != null) goto L215;
    L217:
        boolean r38 = false;
    L218:
        pfm r010 = r54.m;
        boolean r111 = r82.a;
        boolean r29 = r82.c;
        boolean r4 = r82.d;
        boolean r75 = r82.b;
        if (r38 == false) goto L222;
        pfm r83 = new pfm(r93, r103, r112, r127, r132, r142, r154, r111, r172, r29, r192, r4, r21, r222, r232, r242, r25, r26, r27, r28, r75, r30, r31, r322, r332, r34, r352, r362, r37);
        dtk r011 = new dtk(r83, r83);
    L225:
        pfm r113 = (pfm) r011.a;
        r54.m = (pfm) r011.b;
        return r113;
    L222:
        if (r010 == null) goto L224;
        String r114 = r010.a;
        boolean r210 = r010.c;
        boolean r39 = r010.d;
        wvt r42 = r010.e;
        boolean r62 = r010.f;
        boolean r76 = r010.g;
        r010.getClass();
        boolean r84 = r010.h;
        boolean r94 = r010.i;
        boolean r115 = r010.j;
        boolean r128 = r010.k;
        boolean r133 = r010.l;
        boolean r143 = r010.m;
        boolean r155 = r010.n;
        int r116 = r010.o;
        boolean r117 = r010.p;
        int r118 = r010.q;
        boolean r119 = r010.r;
        boolean r120 = r010.s;
        boolean r121 = r010.t;
        boolean r129 = r010.u;
        boolean r130 = r010.v;
        boolean r131 = r010.w;
        boolean r134 = r010.x;
        int r135 = r010.y;
        boolean r136 = r010.z;
        boolean r137 = r010.A;
        boolean r138 = r010.B;
        boolean r139 = r010.C;
        r010.getClass();
        r114.getClass();
        r011 = new dtk(new pfm(r114, r103, r210, r39, r42, r62, r76, r84, r94, r115, r128, r133, r143, r155, r116, r117, r118, r119, r120, r121, r129, r130, r131, r134, r135, r136, r137, r138, r139), r010);
        goto L225
    L224:
        r011 = new dtk(new pfm(r93, r103, r112, r127, r132, r142, r154, r111, r172, r29, r192, r4, r21, r222, r232, r242, r25, r26, r27, r28, r75, r30, r31, r322, r332, r34, r352, r362, r37), null);
        goto L225
    L215:
        if (r24.isReady() != true) goto L217;
        r38 = true;
        goto L218
    L210:
        if (r24.isOnline() != true) goto L212;
        r103 = true;
    L201:
        if (r132 == null) goto L203;
        Boolean r012 = r132.a;
    L204:
        if (r012 == null) goto L206;
        r09 = r012.booleanValue();
        goto L200
    L206:
        r37 = false;
        goto L207
    L203:
        r012 = null;
    L195:
        r362 = false;
        goto L196
    L186:
        if (r06.getAirprintDetectWithoutXcamEnabled() != true) goto L188;
        r352 = true;
    L183:
        r332 = 0;
        goto L184
    L176:
        if (r132.H != true) goto L178;
        r322 = true;
    L173:
        r30 = false;
        goto L174
    L166:
        r27 = false;
        goto L167
    L163:
        r26 = false;
    L160:
        r25 = 0;
        goto L161
    L155:
        r232 = 0;
        goto L156
    L148:
        if (r102 == BblpDoorDetectConfig.DISABLE) goto L150;
        boolean r310 = true;
    L151:
        r222 = r310;
        goto L153
    L150:
        r310 = false;
        goto L151
    L143:
        if (r132.x != true) goto L145;
        r192 = true;
        goto L146
    L138:
        if (r132.w != true) goto L140;
        r172 = true;
        goto L141
    L135:
        r154 = false;
        goto L136
    L131:
        r153 = null;
        goto L133
    L126:
        r127 = false;
        goto L127
    L122:
        r126 = null;
        goto L124
    L118:
        r125 = null;
    L109:
        if (r24 == null) goto L115;
        BblpFeatures r1210 = r24.getFeatures();
        if (r1210 == null) goto L115;
        if (r1210.getPurifyAirAtPrintEnd() == true) goto L114;
    L115:
        r242 = false;
    L102:
        r142 = false;
        goto L103
    L95:
        r102 = null;
        goto L96
    L90:
        if (r06.getCache3mf() != true) goto L92;
        r31 = true;
        goto L93
    L83:
        if (r132 != null) goto L85;
    L87:
        r28 = false;
        goto L88
    L85:
        if (r132.v != true) goto L87;
        r28 = true;
        goto L88
    L78:
        if (r24.getDoorDetectSettingVisibleInPrintOptions() != true) goto L80;
        r21 = true;
        goto L81
    L75:
        r82 = new afm(r06.getAutoRecoveryEnabled(), r06.getSoundPlaybackEnabled(), r06.getFilamentTangleDetectEnabled(), r06.getNozzleBlobDetectEnabled());
        goto L76
    L72:
        r06 = null;
        goto L73
    L227:
        BblTaskInfo r77 = (BblTaskInfo) this.b;
        cv3 r140 = (cv3) this.c;
        BblpCapabilities r311 = (BblpCapabilities) this.d;
        uy2 r013 = (uy2) this.e;
        nsf.getCOROUTINE_SUSPENDED();
        gti.r(r69);
        if (r013 == null) goto L232;
        jv3 r014 = (jv3) r013.o.getValue();
        if (r014 == null) goto L232;
        BblpPrintState r015 = PrintTask2DStateKt.toTaskPrintState(r014);
    L233:
        h5i r55 = (h5i) r5;
        if (r311 != null) goto L236;
    L238:
        boolean r252 = false;
    L239:
        if (r140 != null) goto L241;
    L243:
        boolean r243 = false;
    L244:
        if (r140 == null) goto L246;
        Integer r272 = r140.z;
    L247:
        if (r015 != null) goto L251;
        if (r140 == null) goto L250;
        BblpPrintState r312 = r140.b;
    L252:
        int r1310 = -1;
        if (r312 == null) goto L255;
        int r95 = r312.getCode();
    L257:
        if (r312 != BblpPrintState.SLICING) goto L259;
        boolean r313 = true;
    L260:
        if (r140 == null) goto L283;
        Integer r85 = r140.G;
        if (r313 == false) goto L267;
        if (r85 == null) goto L267;
        if (r85.intValue() == 0) goto L267;
        boolean r314 = true;
    L268:
        Integer r104 = r140.I;
        if (r104 != null) goto L271;
    L273:
        r104 = null;
    L274:
        long r1110 = System.currentTimeMillis() / 1000;
        if (r314 == false) goto L281;
        if (r104 == null) goto L281;
        int r315 = (int) ((r1110 - r104.intValue()) / 60);
        if (r315 >= 0) goto L280;
        r315 = 0;
    L280:
        Integer r316 = Integer.valueOf(r315);
    L282:
        RuntimeCloudSlicingQueue r212 = new RuntimeCloudSlicingQueue(r85, r140.H, r316);
    L284:
        if (r140 != null) goto L286;
    L352:
        boolean r282 = false;
    L353:
        if (r77 == null) goto L389;
        if (r140 == null) goto L356;
        BblpPrintStage r105 = r140.y;
    L357:
        if (r140 == null) goto L359;
        List r317 = r140.w;
    L360:
        if (r317 != null) goto L362;
        r317 = r2;
    L362:
        List r318 = r317;
        ArrayList r1111 = new ArrayList(t86.N(r318, 10));
        Iterator r319 = r318.iterator();
    L364:
        if (r319.hasNext() == false) goto L367;
        r1111.add(Integer.valueOf(((BblpPrintStage) r319.next()).getCode()));
        goto L364
    L367:
        if (r140 == null) goto L369;
        Integer r182 = Integer.valueOf(r140.i);
    L370:
        if (r140 == null) goto L372;
        Integer r193 = Integer.valueOf(r140.F);
    L373:
        if (r140 == null) goto L375;
        Integer r20 = Integer.valueOf(r140.j);
    L376:
        if (r140 == null) goto L378;
        BblpPrintType r223 = r140.K;
    L379:
        if (r140 == null) goto L381;
        Integer r233 = r140.E;
    L382:
        if (r140 == null) goto L384;
        List r320 = r140.x;
    L385:
        if (r320 != null) goto L387;
        List r262 = r2;
    L388:
        boolean r321 = r243;
        boolean r211 = r252;
        omm r86 = PrintTaskDataKt.toPrintTaskData(r77, "", r95, r105, r1111, new RuntimeTaskSnapshot(r182, r193, r20, r212, r223, r233, r243, r252, r262, r272, r282));
    L390:
        if (r140 == null) goto L394;
        BblpPrintState r96 = r140.b;
        if (r96 == null) goto L394;
        r1310 = r96.getCode();
    L394:
        if (r015 != null) goto L400;
        if (r140 == null) goto L397;
        r015 = r140.b;
    L398:
        if (r015 != null) goto L400;
        tt3 r016 = BblpPrintState.Companion;
        Integer r97 = Integer.valueOf(r1310);
        r016.getClass();
        r015 = tt3.a(r97);
        goto L400
    L397:
        r015 = null;
    L400:
        if (r015 != null) goto L402;
    L408:
        boolean r98 = false;
    L409:
        if (r86 != null) goto L413;
        if (r98 == false) goto L413;
        r55.b = null;
    L413:
        if (r86 != null) goto L415;
    L414:
        omm r43 = null;
    L444:
        if (r43 != null) goto L623;
        if (r77 == null) goto L448;
        r55.c = r77.getJobId() + Constants.COLON_SEPARATOR + r77.getTaskId() + Constants.COLON_SEPARATOR + r77.getFileName();
    L448:
        if (r86 == null) goto L454;
        BblpPrintState r44 = r86.b;
        if (r44 == null) goto L454;
        boolean r78 = true;
        if (r44.isFinished() == true) goto L475;
    L455:
        if (r86 == null) goto L461;
        BblpPrintState r45 = r86.b;
        if (r45 == null) goto L461;
        if (r45.isFailed() == r78) goto L475;
    L461:
        if (r86 != null) goto L476;
        omm r46 = (omm) r55.b;
        if (r46 == null) goto L469;
        BblpPrintState r47 = r46.b;
        if (r47 == null) goto L469;
        if (r47.isFinished() == true) goto L475;
    L469:
        omm r48 = (omm) r55.b;
        if (r48 == null) goto L476;
        BblpPrintState r49 = r48.b;
        if (r49 == null) goto L476;
        if (r49.isFailed() == true) goto L475;
    L476:
        boolean r410 = false;
    L477:
        omm r79 = (omm) r55.b;
        if (r79 == null) goto L485;
        if (r410 == false) goto L485;
        if (r015 == null) goto L485;
        if (r015 == BblpPrintState.IDLE) goto L485;
        if (r98 == true) goto L485;
        boolean r163 = true;
    L486:
        if (r86 != null) goto L490;
        if (r163 == true) goto L491;
        r79 = z5j.E(r140, r015, r211, r321);
    L491:
        if (r86 == null) goto L494;
        r55.b = r86;
    L497:
        return d1v.a(r79, (omm) r55.b, r015);
    L494:
        if (r015 != BblpPrintState.IDLE) goto L497;
        r55.b = null;
        goto L497
    L490:
        r79 = r86;
    L485:
        r163 = false;
    L475:
        r410 = true;
    L454:
        r78 = true;
        goto L455
    L623:
        return r43;
    L415:
        BblpPrintState r1112 = r86.b;
        omm r1211 = (omm) r55.b;
        if (r1211 == null) goto L414;
        BblpPrintState r1212 = r1211.b;
        if (r77 == null) goto L421;
        String r1311 = r77.getJobId();
    L422:
        if (r77 == null) goto L424;
        String r144 = r77.getTaskId();
    L425:
        if (r77 == null) goto L427;
        String r156 = r77.getFileName();
    L428:
        String r411 = r1311 + Constants.COLON_SEPARATOR + r144 + Constants.COLON_SEPARATOR + r156;
        if (r77 != null) goto L431;
    L433:
        boolean r1312 = false;
    L435:
        if (r1112.isFinished() == true) goto L439;
        if (r1112.isFailed() == false) goto L414;
    L439:
        if (r1212.isFinished() == false) goto L441;
    L442:
        if (r1312 == false) goto L414;
        r55.b = null;
        r55.c = r411;
        r43 = d1v.a(z5j.E(r140, r015, r211, r321), null, r015);
        goto L444
    L441:
        if (r1212.isFailed() == false) goto L414;
    L431:
        if (r411.equals((String) r55.c) == true) goto L433;
        r1312 = true;
        goto L435
    L427:
        r156 = null;
        goto L428
    L424:
        r144 = null;
        goto L425
    L421:
        r1311 = null;
        goto L422
    L402:
        if (r015.isFinished() == true) goto L408;
        if (r015.isFailed() == true) goto L408;
        if (r015 == BblpPrintState.IDLE) goto L408;
        r98 = true;
        goto L409
    L387:
        r262 = r320;
        goto L388
    L384:
        r320 = null;
        goto L385
    L381:
        r233 = null;
        goto L382
    L378:
        r223 = null;
        goto L379
    L375:
        r20 = null;
        goto L376
    L372:
        r193 = null;
        goto L373
    L369:
        r182 = null;
        goto L370
    L359:
        r317 = null;
        goto L360
    L356:
        r105 = null;
        goto L357
    L389:
        r321 = r243;
        r211 = r252;
        r86 = null;
        goto L390
    L286:
        if (r140.R != true) goto L352;
        if (r77 == null) goto L296;
        String r87 = r77.getJobId();
        if (r87 == null) goto L296;
        if (fuq.B0(r87) == true) goto L296;
        if (r87.equals("0") == true) goto L296;
    L297:
        String r106 = r140.C;
        if (r106 != null) goto L300;
    L304:
        r106 = null;
    L305:
        if (r77 == null) goto L313;
        String r1113 = r77.getTaskId();
        if (r1113 == null) goto L313;
        if (fuq.B0(r1113) == true) goto L313;
        if (r1113.equals("0") == true) goto L313;
    L314:
        String r1213 = r140.A;
        if (r1213 != null) goto L317;
    L321:
        r1213 = null;
    L322:
        if (r87 != null) goto L345;
        if (r106 != null) goto L345;
        if (r1113 != null) goto L345;
        if (r1213 != null) goto L345;
        if (r77 == null) goto L333;
        String r323 = r77.getFileName();
        if (r323 == null) goto L333;
        if (fuq.B0(r323) == true) goto L333;
    L334:
        String r88 = r140.B;
        if (r88 != null) goto L337;
    L339:
        r88 = null;
    L340:
        if (r323 == null) goto L351;
        if (r88 == null) goto L351;
        if (r323.equals(r88) == false) goto L352;
    L351:
        r282 = true;
        goto L353
    L337:
        if (fuq.B0(r88) == true) goto L339;
    L333:
        r323 = null;
    L345:
        if (r87 != null) goto L347;
    L348:
        if (r1113 == null) goto L352;
        if (r1113.equals(r1213) == false) goto L352;
    L347:
        if (r87.equals(r106) == true) goto L351;
    L317:
        if (fuq.B0(r1213) == true) goto L321;
        if (r1213.equals("0") == true) goto L321;
    L313:
        r1113 = null;
        goto L314
    L300:
        if (fuq.B0(r106) == true) goto L304;
        if (r106.equals("0") == true) goto L304;
    L296:
        r87 = null;
    L281:
        r316 = null;
        goto L282
    L271:
        if (r104.intValue() <= 0) goto L273;
    L267:
        r314 = false;
        goto L268
    L283:
        r212 = null;
        goto L284
    L259:
        r313 = false;
        goto L260
    L255:
        r95 = -1;
        goto L257
    L250:
        r312 = null;
        goto L252
    L251:
        r312 = r015;
        goto L252
    L246:
        r272 = null;
        goto L247
    L241:
        if (r140.e != true) goto L243;
        r243 = true;
        goto L244
    L236:
        if (r311.getSkipObjectsCommand() != true) goto L238;
        r252 = true;
    L232:
        r015 = null;
        goto L233
    L498:
        List r141 = (List) this.b;
        BblPrinterStateView r324 = (BblPrinterStateView) this.c;
        c90 r412 = (c90) this.d;
        b90 r017 = (b90) this.e;
        nsf.getCOROUTINE_SUSPENDED();
        gti.r(r69);
        r141.getClass();
        if (r141.isEmpty() == false) goto L501;
        AMSCompatibility r263 = null;
    L524:
        if (r324 == null) goto L526;
        BblpPrintConfig r145 = r324.getPrintConfig();
    L527:
        if (r324 == null) goto L531;
        BblProductProfileState r710 = r324.getProductProfile();
        if (r710 == null) goto L531;
        List r711 = r710.getAmsProfiles();
    L532:
        if (r711 == null) goto L536;
        r2 = r711;
    L536:
        if (r2.isEmpty() == false) goto L538;
    L537:
        boolean r107 = false;
    L567:
        c50 r56 = (c50) r5;
        jhq r213 = r56.j;
    L568:
        Object r712 = r213.getValue();
        b50 r89 = (b50) r712;
        boolean r99 = r017.a;
        boolean r1114 = r017.b;
        if (r145 == null) goto L571;
        boolean r1214 = r145.getCalibrateRemainFlag();
    L573:
        if (r89.d == r99) goto L576;
        r56.g = r99;
    L576:
        if (r89.e == r1114) goto L579;
        r56.h = r1114;
    L579:
        if (r89.g == r1214) goto L581;
        r56.i = r1214;
    L581:
        boolean r194 = !lsf.l(r6, rs4.boxBoolean(true));
        if (r324 != null) goto L584;
    L586:
        boolean r224 = r107;
    L587:
        if (r145 == null) goto L590;
        boolean r1313 = r145.getAutoSwitchFilamentEnabled();
    L589:
        boolean r244 = r1313;
        if (r324 == null) goto L595;
        cv3 r1314 = r324.getRuntime();
        if (r1314 == null) goto L595;
        boolean r273 = lsf.l(r1314.O0, rs4.boxBoolean(true));
    L596:
        c90 r253 = r412;
        if (r213.compareAndSet(r712, b50.a(r89, r194, r99, r1114, r224, r1214, r244, r253, r263, r273, false, 260099)) == true) goto L599;
        r412 = r253;
        goto L568
    L599:
        return trs.a;
    L595:
        r273 = r107;
        goto L596
    L590:
        r1313 = r89.h;
        goto L589
    L584:
        if (r324.getAmsRemainingCapacitySettingVisible() != true) goto L586;
        r224 = true;
        goto L587
    L571:
        r1214 = r89.g;
        goto L573
    L538:
        if (r412 != null) goto L542;
        BblProductAmsProfile r214 = (BblProductAmsProfile) r86.k0(r2);
        if (r214 == null) goto L537;
        r6 = Boolean.valueOf(r214.getRfidAutoReadAvailable());
        goto L537
    L542:
        String r713 = r412.a;
        if (r713 == null) goto L554;
        String r714 = r713.toLowerCase(Locale.ROOT);
        r714.getClass();
        r107 = false;
        if (fuq.m0(r714, "lite", false) != true) goto L555;
        Iterator r715 = r2.iterator();
    L548:
        if (r715.hasNext() == false) goto L552;
        Object r810 = r715.next();
        if (lsf.l(((BblProductAmsProfile) r810).getModelId(), DeviceModelNames.AMS_F1) == false) goto L548;
    L553:
        BblProductAmsProfile r811 = (BblProductAmsProfile) r810;
    L563:
        if (r811 != null) goto L565;
        r811 = (BblProductAmsProfile) r86.k0(r2);
    L565:
        if (r811 == null) goto L567;
        r6 = Boolean.valueOf(r811.getRfidAutoReadAvailable());
        goto L567
    L552:
        r810 = null;
    L555:
        Iterator r716 = r2.iterator();
    L557:
        if (r716.hasNext() == false) goto L561;
        Object r812 = r716.next();
        if (lsf.l(((BblProductAmsProfile) r812).getModelId(), DeviceModelNames.AMS_F1) == true) goto L557;
    L562:
        r811 = (BblProductAmsProfile) r812;
        goto L563
    L561:
        r812 = null;
        goto L562
    L554:
        r107 = false;
    L531:
        r711 = null;
        goto L532
    L526:
        r145 = null;
        goto L527
    L501:
        if (r412 != null) goto L504;
        AMSCompatibility r146 = (AMSCompatibility) r86.k0(r141);
    L503:
        r263 = r146;
        goto L524
    L504:
        String r717 = r412.a;
        if (r717 == null) goto L516;
        String r718 = r717.toLowerCase(Locale.ROOT);
        r718.getClass();
        if (fuq.m0(r718, "lite", false) != true) goto L516;
        Iterator r147 = r141.iterator();
    L510:
        if (r147.hasNext() == false) goto L514;
        AMSCompatibility r719 = r147.next();
        if (lsf.l(((AMSCompatibility) r719).getModelName(), DeviceModelNames.AMS_F1) == false) goto L510;
    L515:
        r146 = r719;
        goto L503
    L514:
        r719 = 0;
    L516:
        Iterator r148 = r141.iterator();
    L518:
        if (r148.hasNext() == false) goto L522;
        Object r720 = r148.next();
        if (lsf.l(((AMSCompatibility) r720).getModelName(), DeviceModelNames.AMS_F1) == true) goto L518;
    L523:
        r146 = (AMSCompatibility) r720;
        goto L503
    L522:
        r720 = null;
        goto L523
    }
}
