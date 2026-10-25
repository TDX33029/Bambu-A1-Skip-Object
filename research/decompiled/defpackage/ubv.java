package defpackage;

import android.view.View;
import androidx.recyclerview.widget.p;
import com.bambulab.bambulab.filament3mf.telemetry.ModelPreviewEntry;
import com.bambulab.bambulab.model.CalibrateFlags;
import com.bambulab.bambulab.model.DeviceModelNames;
import com.bambulab.bambulab.reactnative.specs.BblRnLocaleCodes;
import com.bambulab.printer.model.generated.BblpHaltPrintSensitivityName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.push.core.b;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.cl;
import com.umeng.ccg.a;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.metrics.MetricsUnit;
import io.sentry.protocol.Geo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class ubv {
    public static final rqp a = null;

    static {
        a = new rqp(1);
    }

    public static int a(dxn r1, kjk r2, View r3, View r4, p r5, boolean r6) {
        if (r5.getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (r1.b() == 0) goto L16;
        if (r3 == null) goto L17;
        if (r4 == null) goto L18;
        if (r6 == false) goto L11;
        int r12 = r2.b(r4) - r2.e(r3);
        return Math.min(r2.l(), r12);
    L11:
        return Math.abs(r5.getPosition(r3) - r5.getPosition(r4)) + 1;
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static int b(dxn r4, kjk r5, View r6, View r7, p r8, boolean r9, boolean r10) {
        if (r8.getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r4.b() == 0) goto L17;
        if (r6 == null) goto L17;
        if (r7 == null) goto L17;
        int r0 = Math.min(r8.getPosition(r6), r8.getPosition(r7));
        int r2 = Math.max(r8.getPosition(r6), r8.getPosition(r7));
        if (r10 == false) goto L12;
        int r42 = Math.max(0, (r4.b() - r2) - 1);
    L13:
        if (r9 == true) goto L16;
        return r42;
    L16:
        return Math.round((r42 * (Math.abs(r5.b(r7) - r5.e(r6)) / (Math.abs(r8.getPosition(r6) - r8.getPosition(r7)) + 1))) + (r5.k() - r5.e(r6)));
    L12:
        r42 = Math.max(0, r0);
        goto L13
    }

    public static int c(dxn r1, kjk r2, View r3, View r4, p r5, boolean r6) {
        if (r5.getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (r1.b() == 0) goto L16;
        if (r3 == null) goto L17;
        if (r4 == null) goto L18;
        if (r6 == true) goto L13;
        return r1.b();
    L13:
        return (int) (((r2.b(r4) - r2.e(r3)) / (Math.abs(r5.getPosition(r3) - r5.getPosition(r4)) + 1)) * r1.b());
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static final q7g d(d8g r1, String r2) {
        r1.getClass();
        c8g r12 = r1.a(r2);
        if ((r12 instanceof q7g) == true) goto L5;
        ow4.q(dgh.n("KvStore for ", r2, " does not implement KvDebugOps"));
        return null;
    L5:
        return (q7g) r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final xhb e(ob2 r25, z72 r26) {
        boolean r2 = true;
        String r8 = "disable";
        if ((r25 instanceof t92) == false) goto L10;
        if (((t92) r25).a == false) goto L7;
        r8 = cl.q;
    L7:
        String r13 = "camera";
        String r14 = "ipcam_cap_pic_set";
        xhb r12 = new xhb(r13, r14, vvh.g0(izr.f("control", r8)), null, 24);
    L8:
        xhb r17 = null;
    L401:
        if (r12 != null) goto L404;
        return r17;
    L404:
        if (r26.b == true) goto L406;
        return r12;
    L406:
        return xhb.a(r12, r17, 23);
    L10:
        if ((r25 instanceof u92) == false) goto L16;
        if (((u92) r25).a == false) goto L14;
        r8 = cl.q;
    L14:
        String r132 = "camera";
        String r142 = "ipcam_record_set";
        r12 = new xhb(r132, r142, vvh.g0(izr.f("control", r8)), null, 24);
        goto L8
    L16:
        if ((r25 instanceof v92) == false) goto L22;
        if (((v92) r25).a == false) goto L20;
        r8 = cl.q;
    L20:
        String r133 = "camera";
        String r143 = "ipcam_timelapse";
        r12 = new xhb(r133, r143, vvh.g0(izr.f("control", r8)), null, 24);
        goto L8
    L22:
        if ((r25 instanceof ra2) == false) goto L25;
        String r134 = "camera";
        String r144 = "ipcam_resolution_set";
        r12 = new xhb(r134, r144, vvh.g0(izr.f("resolution", ((ra2) r25).a)), null, 24);
        goto L8
    L25:
        if (lsf.l(r25, h92.a) == false) goto L28;
        String r135 = "camera";
        String r145 = "ipcam_resolution_get";
        Map r15 = null;
        r12 = new xhb(r135, r145, r15, null, 28);
        goto L8
    L28:
        if ((r25 instanceof t82) == false) goto L32;
        t82 r0 = (t82) r25;
        String r146 = "camera";
        String r152 = "ipcam_delete_oldest_timelapse";
        xhb r136 = new xhb(r146, r152, vvh.h0(new dtk[]{izr.f("storage", r0.a), izr.f("total_layer", Integer.valueOf(r0.b))}), null, 24);
    L30:
        r12 = r136;
        goto L8
    L32:
        if ((r25 instanceof g92) == false) goto L42;
        g92 r02 = (g92) r25;
        LinkedHashMap r5 = vvh.i0(new dtk[]{izr.f("sub_command", r02.a)});
        String r1 = r02.b;
        if (r1 == null) goto L36;
        r5.put("storage", r1);
    L36:
        Integer r03 = r02.c;
        if (r03 == null) goto L39;
        r5.put("total_layer", Integer.valueOf(r03.intValue()));
    L39:
        String r3 = "camera";
        String r4 = "ipcam_get_media_info";
        xhb r22 = new xhb(r3, r4, r5, null, 24);
    L40:
        r12 = r22;
        goto L8
    L42:
        if ((r25 instanceof s82) == false) goto L45;
    L43:
        r12 = null;
        goto L8
    L45:
        if ((r25 instanceof w92) == false) goto L57;
        w92 r04 = (w92) r25;
        LinkedHashMap r52 = vvh.i0(new dtk[]{izr.f("ttcode", r04.a)});
        String r16 = r04.b;
        if (r16 == null) goto L49;
        r52.put("passwd", r16);
    L49:
        String r18 = r04.c;
        if (r18 == null) goto L52;
        r52.put("authkey", r18);
    L52:
        String r05 = r04.d;
        if (r05 == null) goto L55;
        r52.put(Geo.JsonKeys.REGION, r05);
    L55:
        String r32 = "liveview";
        String r42 = "prepare";
        r22 = new xhb(r32, r42, r52, s86.E("liveview:ttcode"), 8);
        goto L40
    L57:
        if ((r25 instanceof fb2) == false) goto L60;
        fb2 r06 = (fb2) r25;
        String r147 = ModelPreviewEntry.PRINT;
        String r153 = "ams_select_slot";
        r136 = new xhb(r147, r153, vvh.h0(new dtk[]{izr.f("ams_id", Integer.valueOf(r06.a)), izr.f("slot_id", Integer.valueOf(r06.b))}), null, 24);
        goto L30
    L60:
        if ((r25 instanceof a82) == false) goto L75;
        a82 r07 = (a82) r25;
        int r19 = r07.b;
        LinkedHashMap r53 = vvh.i0(new dtk[]{izr.f(a.F, Integer.valueOf(r19)), izr.f("ams_id", Integer.valueOf(r07.a)), izr.f("slot_id", Integer.valueOf(r19))});
        Integer r110 = r07.c;
        if (r110 == null) goto L64;
        r53.put("curr_temp", Integer.valueOf(r110.intValue()));
    L64:
        Integer r111 = r07.d;
        if (r111 == null) goto L67;
        r53.put("tar_temp", Integer.valueOf(r111.intValue()));
    L67:
        Boolean r112 = r07.e;
        if (r112 == null) goto L70;
        r53.put("temper_check", r112);
    L70:
        Integer r08 = r07.f;
        if (r08 == null) goto L73;
        r53.put("extruder_id", Integer.valueOf(r08.intValue()));
    L73:
        String r33 = ModelPreviewEntry.PRINT;
        String r43 = "ams_change_filament";
        r22 = new xhb(r33, r43, r53, null, 24);
        goto L40
    L75:
        if ((r25 instanceof d82) == false) goto L102;
        d82 r09 = (d82) r25;
        int r113 = r09.b;
        LinkedHashMap r54 = vvh.i0(new dtk[]{izr.f("ams_id", Integer.valueOf(r09.a)), izr.f("slot_id", Integer.valueOf(r113)), izr.f("tray_id", Integer.valueOf(r113))});
        String r114 = r09.c;
        if (r114 == null) goto L79;
        r54.put("tray_color", r114);
    L79:
        Integer r115 = r09.e;
        if (r115 == null) goto L82;
        r54.put("nozzle_temp_min", Integer.valueOf(r115.intValue()));
    L82:
        Integer r116 = r09.f;
        if (r116 == null) goto L85;
        r54.put("nozzle_temp_max", Integer.valueOf(r116.intValue()));
    L85:
        String r117 = r09.g;
        if (r117 == null) goto L88;
        r54.put("tray_info_idx", r117);
    L88:
        String r118 = r09.d;
        if (r118 == null) goto L91;
        r54.put("tray_type", r118);
    L91:
        String r119 = r09.h;
        if (r119 == null) goto L94;
        r54.put("setting_id", r119);
    L94:
        Integer r120 = r09.i;
        if (r120 == null) goto L97;
        r54.put("ctype", Integer.valueOf(r120.intValue()));
    L97:
        List r010 = r09.j;
        if (r010 == null) goto L100;
        r54.put("cols", r010);
    L100:
        String r34 = ModelPreviewEntry.PRINT;
        String r44 = "ams_filament_setting";
        r22 = new xhb(r34, r44, r54, null, 24);
        goto L40
    L102:
        if ((r25 instanceof h82) == false) goto L106;
        h82 r011 = (h82) r25;
        String r23 = ModelPreviewEntry.PRINT;
        String r35 = "ams_user_setting";
        xhb r121 = new xhb(r23, r35, vvh.i0(new dtk[]{izr.f("ams_id", 0), izr.f("startup_read_option", Boolean.valueOf(r011.a)), izr.f("tray_read_option", Boolean.valueOf(r011.b)), izr.f("calibrate_remain_flag", Boolean.valueOf(r011.c))}), null, 24);
    L104:
        r12 = r121;
        goto L8
    L106:
        if ((r25 instanceof b82) == false) goto L110;
        String r154 = ModelPreviewEntry.PRINT;
        String r162 = "ams_control";
        xhb r148 = new xhb(r154, r162, vvh.g0(izr.f(RemoteMessageConst.MessageBody.PARAM, ((b82) r25).a.getValue())), null, 24);
    L108:
        r12 = r148;
        goto L8
    L110:
        if ((r25 instanceof e82) == false) goto L113;
        e82 r012 = (e82) r25;
        String r24 = ModelPreviewEntry.PRINT;
        String r36 = "ams_get_rfid";
        r121 = new xhb(r24, r36, vvh.i0(new dtk[]{izr.f("ams_id", Integer.valueOf(r012.a)), izr.f("slot_id", Integer.valueOf(r012.b))}), null, 24);
        goto L104
    L113:
        if (lsf.l(r25, f82.a) == false) goto L116;
        String r155 = ModelPreviewEntry.PRINT;
        String r163 = "ams_reset";
        Map r172 = null;
        r148 = new xhb(r155, r163, r172, null, 28);
        goto L108
    L116:
        if (lsf.l(r25, i82.a) == false) goto L119;
        String r156 = ModelPreviewEntry.PRINT;
        String r164 = "auto_ams_bind";
        Map r173 = null;
        r148 = new xhb(r156, r164, r173, null, 28);
        goto L108
    L119:
        if (lsf.l(r25, ib2.a) == false) goto L122;
        String r157 = ModelPreviewEntry.PRINT;
        String r165 = "unload_filament";
        Map r174 = null;
        r148 = new xhb(r157, r165, r174, null, 28);
        goto L108
    L122:
        if ((r25 instanceof c82) == false) goto L126;
        c82 r013 = (c82) r25;
        String r166 = ModelPreviewEntry.PRINT;
        String r175 = "ams_filament_drying";
        xhb r158 = new xhb(r166, r175, vvh.h0(new dtk[]{izr.f("ams_id", Integer.valueOf(r013.a)), izr.f("mode", Integer.valueOf(r013.b)), izr.f("filament", r013.c), izr.f("temp", Integer.valueOf(r013.d)), izr.f("duration", Integer.valueOf(r013.f)), izr.f("humidity", Integer.valueOf(r013.g)), izr.f("rotate_tray", Boolean.valueOf(r013.h)), izr.f("cooling_temp", Integer.valueOf(r013.e)), izr.f("close_power_conflict", Boolean.valueOf(r013.i))}), null, 24);
    L124:
        r12 = r158;
        goto L8
    L126:
        if (lsf.l(r25, j82.a) == false) goto L129;
        String r167 = ModelPreviewEntry.PRINT;
        String r176 = "auto_stop_ams_dry";
        Map r182 = null;
        r158 = new xhb(r167, r176, r182, null, 28);
        goto L124
    L129:
        if ((r25 instanceof x92) == true) goto L43;
        if ((r25 instanceof p92) == true) goto L43;
        if (lsf.l(r25, k82.a) == false) goto L138;
        String r168 = ModelPreviewEntry.PRINT;
        String r177 = "back_to_center";
        Map r183 = null;
        r158 = new xhb(r168, r177, r183, null, 28);
        goto L124
    L138:
        if (lsf.l(r25, y92.a) == false) goto L141;
        String r169 = ModelPreviewEntry.PRINT;
        String r178 = "move_to_capture";
        Map r184 = null;
        r158 = new xhb(r169, r178, r184, null, 28);
        goto L124
    L141:
        if ((r25 instanceof nb2) == false) goto L144;
        nb2 r014 = (nb2) r25;
        String r122 = r014.a.toUpperCase(Locale.ROOT);
        r122.getClass();
        String r1610 = ModelPreviewEntry.PRINT;
        String r179 = "xyz_ctrl";
        r158 = new xhb(r1610, r179, vvh.h0(new dtk[]{izr.f("axis", r122), izr.f("dir", Integer.valueOf(r014.b)), izr.f("mode", Integer.valueOf(r014.c))}), null, 24);
        goto L124
    L144:
        if (lsf.l(r25, ba2.a) == false) goto L147;
        String r1611 = ModelPreviewEntry.PRINT;
        String r1710 = "pause";
        Map r185 = null;
        r158 = new xhb(r1611, r1710, r185, null, 28);
        goto L124
    L147:
        if (lsf.l(r25, ga2.a) == false) goto L150;
        String r1612 = ModelPreviewEntry.PRINT;
        String r1711 = "resume";
        Map r186 = null;
        r158 = new xhb(r1612, r1711, r186, null, 28);
        goto L124
    L150:
        if (lsf.l(r25, db2.a) == false) goto L153;
        String r1613 = ModelPreviewEntry.PRINT;
        String r1712 = "stop";
        Map r187 = null;
        r158 = new xhb(r1613, r1712, r187, null, 28);
        goto L124
    L153:
        if (lsf.l(r25, m92.a) == false) goto L156;
        String r1614 = "info";
        String r1713 = "get_version";
        Map r188 = null;
        r158 = new xhb(r1614, r1713, r188, null, 28);
        goto L124
    L156:
        if ((r25 instanceof za2) == false) goto L159;
        String r1615 = ModelPreviewEntry.PRINT;
        String r1714 = "print_speed";
        r158 = new xhb(r1615, r1714, vvh.g0(izr.f(RemoteMessageConst.MessageBody.PARAM, String.valueOf(((za2) r25).a.getCode()))), null, 24);
        goto L124
    L159:
        if ((r25 instanceof na2) == false) goto L162;
        String r1616 = ModelPreviewEntry.PRINT;
        String r1715 = "set_ctt";
        r158 = new xhb(r1616, r1715, vvh.g0(izr.f("ctt_val", Integer.valueOf(((na2) r25).a))), null, 24);
        goto L124
    L162:
        if ((r25 instanceof la2) == false) goto L165;
        String r1617 = ModelPreviewEntry.PRINT;
        String r1716 = "set_bed_temp";
        r158 = new xhb(r1617, r1716, vvh.g0(izr.f("temp", Integer.valueOf(((la2) r25).a))), null, 24);
        goto L124
    L165:
        if ((r25 instanceof va2) == false) goto L168;
        va2 r015 = (va2) r25;
        String r1618 = ModelPreviewEntry.PRINT;
        String r1717 = "set_nozzle_temp";
        r158 = new xhb(r1618, r1717, vvh.h0(new dtk[]{izr.f("extruder_index", Integer.valueOf(r015.a)), izr.f("target_temp", Integer.valueOf(r015.b))}), null, 24);
        goto L124
    L168:
        if ((r25 instanceof ja2) == false) goto L171;
        String r1619 = ModelPreviewEntry.PRINT;
        String r1718 = "set_against_continued_heating_mode";
        r158 = new xhb(r1619, r1718, vvh.g0(izr.f(cl.q, Boolean.valueOf(((ja2) r25).a))), null, 24);
        goto L124
    L171:
        if ((r25 instanceof o82) == false) goto L177;
        o82 r016 = (o82) r25;
        LinkedHashMap r55 = vvh.i0(new dtk[]{izr.f("option", Integer.valueOf(r016.a))});
        Integer r017 = r016.b;
        if (r017 == null) goto L175;
        r55.put("bed_temp", Integer.valueOf(r017.intValue()));
    L175:
        String r37 = ModelPreviewEntry.PRINT;
        String r45 = "calibration";
        r22 = new xhb(r37, r45, r55, null, 24);
        goto L40
    L177:
        if (lsf.l(r25, d92.a) == false) goto L180;
        String r1620 = ModelPreviewEntry.PRINT;
        String r1719 = "extrusion_cali_get";
        Map r189 = null;
        r158 = new xhb(r1620, r1719, r189, null, 28);
        goto L124
    L180:
        if (lsf.l(r25, m82.a) == false) goto L183;
        String r1621 = ModelPreviewEntry.PRINT;
        String r1720 = "bubble_elim";
        Map r1810 = null;
        r158 = new xhb(r1621, r1720, r1810, null, 28);
        goto L124
    L183:
        if ((r25 instanceof ya2) == false) goto L195;
        ya2 r018 = (ya2) r25;
        LinkedHashMap r56 = vvh.i0(new dtk[]{izr.f("step", Integer.valueOf(r018.a.getCode()))});
        Double r123 = r018.b;
        if (r123 == null) goto L187;
        r56.put("offset_x", Double.valueOf(r123.doubleValue()));
    L187:
        Double r124 = r018.c;
        if (r124 == null) goto L190;
        r56.put("offset_y", Double.valueOf(r124.doubleValue()));
    L190:
        Double r019 = r018.d;
        if (r019 == null) goto L193;
        r56.put("rotation", Double.valueOf(r019.doubleValue()));
    L193:
        String r38 = ModelPreviewEntry.PRINT;
        String r46 = "set_ptc_step";
        r22 = new xhb(r38, r46, r56, null, 24);
        goto L40
    L195:
        if ((r25 instanceof r92) == false) goto L198;
        r92 r020 = (r92) r25;
        String r1622 = ModelPreviewEntry.PRINT;
        String r1721 = "ignore";
        r158 = new xhb(r1622, r1721, vvh.h0(new dtk[]{izr.f("err", r020.b), izr.f("job_id", r020.a)}), null, 24);
        goto L124
    L198:
        if ((r25 instanceof p82) == false) goto L211;
        LinkedHashMap r125 = new LinkedHashMap();
        p82 r021 = (p82) r25;
        String r27 = r021.a;
        if (r27 == null) goto L202;
        r125.put("subtask_id", r27);
    L202:
        Integer r022 = r021.b;
        if (r022 == null) goto L206;
        r125.put("print_error", Integer.valueOf(r022.intValue()));
    L206:
        if (r125.isEmpty() == false) goto L208;
        LinkedHashMap r57 = null;
    L209:
        r22 = new xhb(ModelPreviewEntry.PRINT, "clean_print_error", r57, null, 24);
        goto L40
    L208:
        r57 = r125;
        goto L209
    L211:
        if ((r25 instanceof ab2) == false) goto L214;
        String r1722 = ModelPreviewEntry.PRINT;
        String r1811 = "skip_objects";
        r12 = new xhb(r1722, r1811, vvh.g0(izr.f("obj_list", ((ab2) r25).a)), null, 24);
        goto L8
    L214:
        if ((r25 instanceof q92) == false) goto L216;
        q92 r023 = (q92) r25;
        String r1812 = ModelPreviewEntry.PRINT;
        String r192 = "idle_ignore";
        r12 = new xhb(r1812, r192, vvh.h0(new dtk[]{izr.f("type", Integer.valueOf(r023.a)), izr.f("err", Integer.valueOf(r023.b))}), null, 24);
        goto L8
    L216:
        r17 = null;
        if ((r25 instanceof ha2) == false) goto L221;
        String r193 = BblRnLocaleCodes.SYSTEM;
        String r20 = "uiop";
        xhb r1813 = new xhb(r193, r20, vvh.h0(new dtk[]{izr.f("name", "print_error"), izr.f("action", "close"), izr.f("err", ((ha2) r25).a), izr.f("source", 2), izr.f("type", "dialog")}), null, 24);
    L219:
        r12 = r1813;
        goto L401
    L221:
        if ((r25 instanceof qa2) == false) goto L224;
        qa2 r024 = (qa2) r25;
        String r194 = ModelPreviewEntry.PRINT;
        String r202 = "set_fan";
        r1813 = new xhb(r194, r202, vvh.h0(new dtk[]{izr.f("fan_index", Integer.valueOf(r024.a)), izr.f("speed", Integer.valueOf(r024.b))}), null, 24);
        goto L219
    L224:
        if ((r25 instanceof w82) == false) goto L231;
        String r025 = ((w82) r25).a;
        if (muq.W(r025, "\n") == true) goto L229;
        r025 = r025.concat(" \n");
    L229:
        String r195 = ModelPreviewEntry.PRINT;
        String r203 = "gcode_line";
        r1813 = new xhb(r195, r203, vvh.g0(izr.f(RemoteMessageConst.MessageBody.PARAM, r025)), s86.E("print:param"), 8);
        goto L219
    L231:
        if ((r25 instanceof u82) == false) goto L234;
        u82 r026 = (u82) r25;
        dtk r28 = izr.f(RemoteMessageConst.MessageBody.PARAM, r026.a);
        Boolean r126 = Boolean.FALSE;
        String r196 = ModelPreviewEntry.PRINT;
        String r204 = "gcode_file";
        r1813 = new xhb(r196, r204, vvh.h0(new dtk[]{r28, izr.f("timelapse", r126), izr.f(CalibrateFlags.Ids.BED_LEVELING, Boolean.valueOf(r026.b)), izr.f("flow_cali", Boolean.valueOf(r026.c)), izr.f("vibration_cali", Boolean.valueOf(r026.d)), izr.f("layer_inspect", Boolean.valueOf(r026.e)), izr.f("toolhead_offset_cali", r126)}), s86.E("print:param"), 8);
        goto L219
    L234:
        if ((r25 instanceof ca2) == false) goto L237;
        LinkedHashMap r127 = new LinkedHashMap();
        r127.putAll(((ca2) r25).a);
        String r197 = ModelPreviewEntry.PRINT;
        String r205 = "project_file";
        r1813 = new xhb(r197, r205, r127, s86.E("print:url"), 8);
        goto L219
    L237:
        if ((r25 instanceof n82) == false) goto L240;
        String r198 = ModelPreviewEntry.PRINT;
        String r206 = "buzzer_ctrl";
        r1813 = new xhb(r198, r206, vvh.g0(izr.f("mode", Integer.valueOf(((n82) r25).a ? 1 : 0))), null, 24);
        goto L219
    L240:
        if ((r25 instanceof v82) == false) goto L243;
        String r199 = ModelPreviewEntry.PRINT;
        String r207 = "fire_ext_ctrl";
        r1813 = new xhb(r199, r207, vvh.g0(izr.f("cmd", Integer.valueOf(((v82) r25).a))), null, 24);
        goto L219
    L243:
        if ((r25 instanceof ka2) == false) goto L246;
        ka2 r027 = (ka2) r25;
        String r1910 = ModelPreviewEntry.PRINT;
        String r208 = "set_airduct";
        r1813 = new xhb(r1910, r208, vvh.h0(new dtk[]{izr.f("modeId", Integer.valueOf(r027.a)), izr.f("submode", Integer.valueOf(r027.b))}), null, 24);
        goto L219
    L246:
        if (lsf.l(r25, y82.a) == false) goto L249;
        String r1911 = ModelPreviewEntry.PRINT;
        String r209 = "get_airduct_cfg";
        Map r21 = null;
        r1813 = new xhb(r1911, r209, r21, null, 28);
        goto L219
    L249:
        if ((r25 instanceof aa2) == false) goto L252;
        String r1912 = ModelPreviewEntry.PRINT;
        String r2010 = "part_control";
        r1813 = new xhb(r1912, r2010, vvh.h0(new dtk[]{izr.f("module", DeviceModelNames.APS), izr.f("action", ((aa2) r25).a)}), null, 24);
        goto L219
    L252:
        if (lsf.l(r25, hb2.a) == false) goto L255;
        String r1913 = ModelPreviewEntry.PRINT;
        String r2011 = "task_lock_erase";
        Map r212 = null;
        r1813 = new xhb(r1913, r2011, r212, null, 28);
        goto L219
    L255:
        if (lsf.l(r25, e92.a) == false) goto L258;
        String r1914 = ModelPreviewEntry.PRINT;
        String r2012 = "get_fan";
        Map r213 = null;
        r1813 = new xhb(r1914, r2012, r213, null, 28);
        goto L219
    L258:
        if ((r25 instanceof c92) == false) goto L261;
        String r1915 = ModelPreviewEntry.PRINT;
        String r2013 = "get_extruder";
        r1813 = new xhb(r1915, r2013, vvh.g0(izr.f("extruder_index", Integer.valueOf(((c92) r25).a))), null, 24);
        goto L219
    L261:
        if (lsf.l(r25, i92.a) == false) goto L264;
        String r1916 = ModelPreviewEntry.PRINT;
        String r2014 = "get_nozzle_temp";
        Map r214 = null;
        r1813 = new xhb(r1916, r2014, r214, null, 28);
        goto L219
    L264:
        if ((r25 instanceof z82) == false) goto L276;
        z82 r028 = (z82) r25;
        dtk r47 = izr.f("filament_seq", r028.a);
        dtk r58 = izr.f("ams_mapping", r028.b);
        List r128 = r028.c;
        ArrayList r39 = new ArrayList(t86.N(r128, 10));
        Iterator r129 = r128.iterator();
    L267:
        if (r129.hasNext() == false) goto L269;
        r39.add(((ms3) r129.next()).a());
        goto L267
    L269:
        dtk r130 = izr.f("fila_info", r39);
        List r310 = r028.d;
        ArrayList r7 = new ArrayList(t86.N(r310, 10));
        Iterator r311 = r310.iterator();
    L271:
        if (r311.hasNext() == false) goto L273;
        r7.add(((ns3) r311.next()).a());
        goto L271
    L273:
        Map r48 = vvh.h0(new dtk[]{r47, r58, r130, izr.f("nozzle_info", r7), izr.f("calibration", Integer.valueOf(r028.e)), izr.f("extrude_cali_manual_mode", Integer.valueOf(!r028.f ? 1 : 0))});
        xhb r131 = new xhb(ModelPreviewEntry.PRINT, "get_auto_nozzle_mapping", r48, null, 24);
    L274:
        r12 = r131;
        goto L401
    L276:
        if (lsf.l(r25, l82.a) == false) goto L279;
        String r1917 = ModelPreviewEntry.PRINT;
        String r2015 = "bed_clean";
        Map r215 = null;
        r1813 = new xhb(r1917, r2015, r215, null, 28);
        goto L219
    L279:
        if ((r25 instanceof gb2) == false) goto L282;
        String r1918 = ModelPreviewEntry.PRINT;
        String r2016 = "select_extruder";
        r1813 = new xhb(r1918, r2016, vvh.g0(izr.f("extruder_index", Integer.valueOf(((gb2) r25).a))), null, 24);
        goto L219
    L282:
        if ((r25 instanceof pa2) == false) goto L285;
        pa2 r029 = (pa2) r25;
        String r1919 = ModelPreviewEntry.PRINT;
        String r2017 = "set_extrusion_length";
        r1813 = new xhb(r1919, r2017, vvh.h0(new dtk[]{izr.f("extruder_index", Integer.valueOf(r029.a)), izr.f(SentryEnvelopeItemHeader.JsonKeys.LENGTH, Integer.valueOf(r029.b))}), null, 24);
        goto L219
    L285:
        if ((r25 instanceof ua2) == false) goto L288;
        ua2 r030 = (ua2) r25;
        String r29 = ModelPreviewEntry.PRINT;
        String r312 = "set_nozzle";
        r131 = new xhb(r29, r312, vvh.i0(new dtk[]{izr.f("id", Integer.valueOf(r030.a)), izr.f("type", r030.b), izr.f("wear", Integer.valueOf(r030.c)), izr.f("diameter", Double.valueOf(r030.d))}), null, 24);
        goto L274
    L288:
        if (lsf.l(r25, fa2.a) == false) goto L291;
        String r1920 = ModelPreviewEntry.PRINT;
        String r2018 = "refresh_nozzle";
        Map r216 = null;
        r1813 = new xhb(r1920, r2018, r216, null, 28);
        goto L219
    L291:
        if (lsf.l(r25, r82.a) == false) goto L294;
        String r1921 = ModelPreviewEntry.PRINT;
        String r2019 = "nozzle_info_confirm";
        r1813 = new xhb(r1921, r2019, vvh.g0(izr.f("id", 255)), null, 24);
        goto L219
    L294:
        if ((r25 instanceof z92) == false) goto L297;
        z92 r031 = (z92) r25;
        String r1922 = ModelPreviewEntry.PRINT;
        String r2020 = "nozzle_exchange";
        r1813 = new xhb(r1922, r2020, vvh.h0(new dtk[]{izr.f("from", Integer.valueOf(r031.a)), izr.f("to", Integer.valueOf(r031.b))}), null, 24);
        goto L219
    L297:
        if ((r25 instanceof o92) == false) goto L300;
        String r1923 = ModelPreviewEntry.PRINT;
        String r2021 = "holder_nozzle_refresh";
        r1813 = new xhb(r1923, r2021, vvh.g0(izr.f("id", Integer.valueOf(((o92) r25).a))), null, 24);
        goto L219
    L300:
        if (lsf.l(r25, n92.a) == false) goto L303;
        String r1924 = ModelPreviewEntry.PRINT;
        String r2022 = "holder_cali";
        Map r217 = null;
        r1813 = new xhb(r1924, r2022, r217, null, 28);
        goto L219
    L303:
        if ((r25 instanceof xa2) == false) goto L306;
        String r1925 = ModelPreviewEntry.PRINT;
        String r2023 = "print_option";
        r1813 = new xhb(r1925, r2023, ((xa2) r25).a, null, 24);
        goto L219
    L306:
        if (lsf.l(r25, q82.a) == false) goto L309;
        String r1926 = ModelPreviewEntry.PRINT;
        String r2024 = "close_air_filt";
        Map r218 = null;
        r1813 = new xhb(r1926, r2024, r218, null, 28);
        goto L219
    L309:
        if (lsf.l(r25, ea2.a) == false) goto L312;
        String r1927 = ModelPreviewEntry.PRINT;
        String r2025 = "refill";
        r1813 = new xhb(r1927, r2025, vvh.h0(new dtk[]{izr.f("version", 0), izr.f("refill_command", 5)}), null, 24);
        goto L219
    L312:
        if (lsf.l(r25, a92.a) == false) goto L315;
        String r1928 = "security";
        String r2026 = "app_cert_list";
        r1813 = new xhb(r1928, r2026, vvh.g0(izr.f("type", "app")), null, 24);
        goto L219
    L315:
        if ((r25 instanceof s92) == false) goto L322;
        s92 r032 = (s92) r25;
        LinkedHashMap r59 = vvh.i0(new dtk[]{izr.f("app_cert", r032.a)});
        String r033 = r032.b;
        if (r033 == null) goto L319;
        r59.put("crl", r033);
    L319:
        String r313 = "security";
        String r49 = "app_cert_install";
        xhb r210 = new xhb(r313, r49, r59, null, 24);
    L320:
        r12 = r210;
        goto L401
    L322:
        if ((r25 instanceof sa2) == false) goto L325;
        sa2 r034 = (sa2) r25;
        String r1929 = BblRnLocaleCodes.SYSTEM;
        String r2027 = "ledctrl";
        r1813 = new xhb(r1929, r2027, vvh.h0(new dtk[]{izr.f("led_node", r034.a.getValue()), izr.f("led_mode", r034.b.getValue()), izr.f("led_on_time", 500), izr.f("led_off_time", 500), izr.f("loop_times", 0), izr.f("interval_time", 0)}), null, 24);
        goto L219
    L325:
        if ((r25 instanceof ia2) == false) goto L328;
        LinkedHashMap r137 = new LinkedHashMap();
        r137.putAll(((ia2) r25).a);
        r137.put("accessory_type", "upgrade_kit");
        String r1930 = BblRnLocaleCodes.SYSTEM;
        String r2028 = "set_accessories";
        r1813 = new xhb(r1930, r2028, r137, null, 24);
        goto L219
    L328:
        if ((r25 instanceof ma2) == false) goto L331;
        String r1931 = BblRnLocaleCodes.SYSTEM;
        String r2029 = "chamber_mode_set";
        r1813 = new xhb(r1931, r2029, vvh.g0(izr.f("mode", Integer.valueOf(((ma2) r25).a ? 1 : 0))), null, 24);
        goto L219
    L331:
        if ((r25 instanceof oa2) == false) goto L334;
        String r1932 = BblRnLocaleCodes.SYSTEM;
        String r2030 = "set_door_stat";
        r1813 = new xhb(r1932, r2030, vvh.g0(izr.f(b.X, Integer.valueOf(((oa2) r25).a.getCode()))), null, 24);
        goto L219
    L334:
        if ((r25 instanceof wa2) == false) goto L337;
        String r1933 = BblRnLocaleCodes.SYSTEM;
        String r2031 = "print_cache_set";
        r1813 = new xhb(r1933, r2031, vvh.g0(izr.f(b.X, Boolean.valueOf(((wa2) r25).a))), null, 24);
        goto L219
    L337:
        if ((r25 instanceof ta2) == false) goto L340;
        ta2 r035 = (ta2) r25;
        String r1934 = BblRnLocaleCodes.SYSTEM;
        String r2032 = "sntp";
        r1813 = new xhb(r1934, r2032, vvh.h0(new dtk[]{izr.f(MetricsUnit.Duration.SECOND, Integer.valueOf(r035.a)), izr.f("us", Integer.valueOf(r035.b)), izr.f("tz", r035.c), izr.f("src", 3)}), null, 24);
        goto L219
    L340:
        if (lsf.l(r25, x82.a) == false) goto L343;
        String r1935 = BblRnLocaleCodes.SYSTEM;
        String r2033 = "get_access_code";
        Map r219 = null;
        r1813 = new xhb(r1935, r2033, r219, null, 28);
        goto L219
    L343:
        if (lsf.l(r25, b92.a) == false) goto L346;
        String r1936 = BblRnLocaleCodes.SYSTEM;
        String r2034 = "get_door_stat";
        Map r2110 = null;
        r1813 = new xhb(r1936, r2034, r2110, null, 28);
        goto L219
    L346:
        if (lsf.l(r25, j92.a) == false) goto L349;
        String r1937 = BblRnLocaleCodes.SYSTEM;
        String r2035 = "print_cache_get";
        Map r2111 = null;
        r1813 = new xhb(r1937, r2035, r2111, null, 28);
        goto L219
    L349:
        if (lsf.l(r25, bb2.a) == false) goto L352;
        String r1938 = "pushing";
        String r2036 = cl.r;
        Map r2112 = null;
        r1813 = new xhb(r1938, r2036, r2112, null, 28);
        goto L219
    L352:
        if (lsf.l(r25, eb2.a) == false) goto L355;
        String r1939 = "pushing";
        String r2037 = "stop";
        Map r2113 = null;
        r1813 = new xhb(r1939, r2037, r2113, null, 28);
        goto L219
    L355:
        if (lsf.l(r25, da2.a) == false) goto L358;
        String r1940 = "pushing";
        String r2038 = "pushall";
        r1813 = new xhb(r1940, r2038, vvh.g0(izr.f("version", 1)), null, 24);
        goto L219
    L358:
        if ((r25 instanceof kb2) == false) goto L361;
        kb2 r036 = (kb2) r25;
        String r1941 = "upgrade";
        String r2039 = cl.r;
        r1813 = new xhb(r1941, r2039, vvh.h0(new dtk[]{izr.f("module", r036.a), izr.f("version", r036.b), izr.f("url", r036.c), izr.f(Constants.PARAM_SRC_ID, 2)}), null, 24);
        goto L219
    L361:
        if ((r25 instanceof jb2) == false) goto L369;
        if (((jb2) r25).a != true) goto L366;
        String r037 = "consistency_confirm";
    L365:
        String r2040 = r037;
        String r1942 = "upgrade";
        r1813 = new xhb(r1942, r2040, vvh.g0(izr.f(Constants.PARAM_SRC_ID, 2)), null, 24);
        goto L219
    L366:
        r037 = "upgrade_confirm";
        goto L365
    L369:
        if ((r25 instanceof lb2) == false) goto L372;
        String r1943 = "upgrade";
        String r2041 = "upgrade_history";
        r1813 = new xhb(r1943, r2041, vvh.h0(new dtk[]{izr.f(Constants.PARAM_SRC_ID, 2), izr.f("firmware_optional", ((lb2) r25).a)}), null, 24);
        goto L219
    L372:
        if ((r25 instanceof g82) == false) goto L375;
        String r1944 = "upgrade";
        String r2042 = "mc_for_ams_firmware_upgrade";
        r1813 = new xhb(r1944, r2042, vvh.h0(new dtk[]{izr.f("id", Integer.valueOf(((g82) r25).a)), izr.f(Constants.PARAM_SRC_ID, 2)}), null, 24);
        goto L219
    L375:
        if (lsf.l(r25, k92.a) == false) goto L378;
        String r1945 = "upgrade";
        String r2043 = "get_history";
        r1813 = new xhb(r1945, r2043, vvh.g0(izr.f("format", "pb")), null, 24);
        goto L219
    L378:
        if ((r25 instanceof cb2) == false) goto L384;
        cb2 r038 = (cb2) r25;
        LinkedHashMap r510 = vvh.i0(new dtk[]{izr.f("user_id", r038.a), izr.f("type", r038.b), izr.f("time_start", Long.valueOf(r038.c)), izr.f("time_end", Long.valueOf(r038.d))});
        String r039 = r038.e;
        if (r039 == null) goto L382;
        r510.put("trouble_id", r039);
    L382:
        String r314 = "upload";
        String r410 = "start_upload";
        r210 = new xhb(r314, r410, r510, null, 24);
        goto L320
    L384:
        if (lsf.l(r25, l92.a) == false) goto L387;
        String r1946 = "upload";
        String r2044 = "get_upload_info";
        Map r2114 = null;
        r1813 = new xhb(r1946, r2044, r2114, null, 28);
        goto L219
    L387:
        if ((r25 instanceof mb2) == false) goto L399;
        mb2 r040 = (mb2) r25;
        BblpHaltPrintSensitivityName r138 = r040.c;
        boolean r315 = r040.b;
        LinkedHashMap r6 = vvh.i0(new dtk[]{izr.f("module_name", r040.a.getValue()), izr.f(cl.q, Boolean.valueOf(r315)), izr.f("control", Boolean.valueOf(r315)), izr.f("allow_skip_parts", Boolean.valueOf(r040.d))});
        if (r138 == null) goto L391;
        r6.put("halt_print_sensitivity", r138.getValue());
    L391:
        if (r138 != null) goto L393;
    L397:
        String r411 = CalibrateFlags.Ids.XCAM;
        String r511 = "xcam_control_set";
        r12 = new xhb(r411, r511, r6, null, 24);
        goto L401
    L393:
        if (r138 != BblpHaltPrintSensitivityName.NEVER_HALT) goto L396;
        r2 = false;
    L396:
        r6.put("print_halt", Boolean.valueOf(r2));
        goto L397
    L399:
        if (lsf.l(r25, f92.a) == false) goto L408;
        String r512 = CalibrateFlags.Ids.XCAM;
        String r62 = "get_height_from_xcam";
        r12 = new xhb(r512, r62, vvh.h0(new dtk[]{izr.f("peer_host", "studio"), izr.f("version", 1)}), null, 24);
        goto L401
    L408:
        cze.d();
        return null;
    }
}
