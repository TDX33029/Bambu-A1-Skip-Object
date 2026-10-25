package defpackage;

import androidx.navigation3.runtime.NavBackStack;
import com.bambulab.bambulab.filament3mf.ThreeMfSceneLoader;
import com.bambulab.bambulab.model.IotPlateObjectId;
import com.bambulab.bambulab.navigation.route.HomeAppRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class jr9 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(HomeAppRoute.DesignSkipObjects r26, a9j r27, o07 r28, int r29) {
        grd r8 = r28.z(1289458840);
        if ((r29 & 6) == 0) goto L5;
        int r0 = r29;
    L13:
        int r02 = r0 | 48;
        if ((r02 & 19) == 18) goto L16;
        boolean r2 = true;
    L18:
        if (r8.D(r02 & 1, r2) == false) goto L75;
        a9j r12 = z8j.b;
        c1q r22 = null;
        lsf.c("MWPreparePrint", null, r8, 6, 2);
        NavBackStack r6 = (NavBackStack) r8.P(vo1.a);
        fwj r5 = (fwj) r8.P(gwj.a);
        Set r03 = r86.V0(r26.getDisabledIds());
        List<IotPlateObjectId> r1 = r26.getObjects();
        ArrayList r13 = new ArrayList();
        Iterator r3 = r1.iterator();
    L20:
        boolean r132 = r3.hasNext();
        long r14 = ThreeMfSceneLoader.MODEL_MAX_FILE_SIZE;
        if (r132 == false) goto L39;
        IotPlateObjectId r133 = (IotPlateObjectId) r3.next();
        Long r18 = r133.getIdentifyId();
        c1q r272 = r22;
        Iterator r282 = r3;
        if (r18 == null) goto L35;
        long r23 = r18.longValue();
        if ((-2147483648L) <= r23) goto L27;
    L29:
        Integer r24 = r272;
    L30:
        if (r24 == 0) goto L35;
        int r25 = r24.intValue();
        String r142 = r133.getName();
        if (r142 != null) goto L34;
        r142 = "";
    L34:
        Object r32 = new e53(r142, r25, b1v.i(r25), r86.c0(r133.getIdentifyId(), r03));
    L36:
        if (r32 == null) goto L38;
        r13.add(r32);
    L38:
        r22 = r272;
        r3 = r282;
        goto L20
    L27:
        if (r23 >= ThreeMfSceneLoader.MODEL_MAX_FILE_SIZE) goto L29;
        r24 = Integer.valueOf((int) r23);
    L35:
        r32 = r272;
        goto L36
    L39:
        c1q r273 = r22;
        List<Long> r04 = r26.getSelectedIds();
        ArrayList r210 = new ArrayList();
        Iterator<T> r05 = r04.iterator();
    L41:
        if (r05.hasNext() == false) goto L51;
        long r19 = r14;
        long r143 = ((Number) r05.next()).longValue();
        if ((-2147483648L) <= r143) goto L45;
    L47:
        Object r33 = r273;
    L48:
        if (r33 == null) goto L50;
        r210.add(r33);
    L50:
        r14 = r19;
        goto L41
    L45:
        if (r143 >= r19) goto L47;
        r33 = Integer.valueOf((int) r143);
        goto L48
    L51:
        Set r211 = r86.V0(r210);
        boolean r06 = r8.u(r26.getPlateIndex()) | r8.s(r26.getUseMemoryPick());
        Object r34 = r8.I();
        if (r06 == true) goto L56;
        if (r34 == n07.a) goto L56;
    L67:
        c1q r35 = (c1q) r34;
        if (r35 == null) goto L70;
        b1q r36 = new b1q(null, null, r35.a, r35.b, 3);
    L74:
        xpr.b(false, mi6.v(-1025807386, new to9(r13, r211, r36, r26, r5, r6), r8), r8, 48, 1);
    L76:
        evn r07 = r8.Z();
        if (r07 == null) goto L88;
        r07.d = new oa7(r26, r12, r29, 11);
        return;
    L88:
        return;
    L70:
        String r08 = r26.getPickPictureUrl();
        if (r08 != null) goto L73;
        r08 = "";
    L73:
        r36 = new b1q(r08, r26.getTopPictureUrl(), null, null, 12);
    L56:
        if (r26.getUseMemoryPick() == false) goto L65;
        Object r37 = wbv.a;
        monitor-enter(r37);
        c1q r09 = wbv.b;     // Catch: Throwable -> L62
        wbv.b = r273;     // Catch: Throwable -> L62
        monitor-exit(r37);
    L66:
        r8.E(r09);
        r34 = r09;
    L62:
        th = move-exception;
        throw th;
    L65:
        r09 = r273;
        goto L66
    L75:
        r8.m();
        r12 = r27;
        goto L76
    L16:
        r2 = false;
        goto L18
    L5:
        if ((r29 & 8) != 0) goto L7;
        boolean r010 = r8.q(r26);
    L8:
        if (r010 == false) goto L10;
        int r011 = 4;
    L11:
        r0 = r011 | r29;
        goto L13
    L10:
        r011 = 2;
        goto L11
    L7:
        r010 = r8.J(r26);
        goto L8
    }
}
