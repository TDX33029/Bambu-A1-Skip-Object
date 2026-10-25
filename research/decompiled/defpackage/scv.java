package defpackage;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bambulab.bambulab.model.IotPlate;
import com.bambulab.bambulab.model.IotPlateObjectId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class scv {
    public static final laq a = null;
    public static hdf b;

    static {
        a = new laq(12);
    }

    public static final List a(IotPlate r3, Set r4, Set r5) {
        if (r3 == null) goto L28;
        List<IotPlateObjectId> r0 = r3.getObjects();
        if (r0 == null) goto L28;
        if (r4 != null) goto L10;
        r4 = b(r3, r5);
        if (r4 != null) goto L10;
        r4 = mgb.a;
    L10:
        ArrayList r32 = new ArrayList();
        Iterator<T> r52 = r0.iterator();
    L12:
        if (r52.hasNext() == false) goto L16;
        Long r02 = ((IotPlateObjectId) r52.next()).getIdentifyId();
        if (r02 == null) goto L12;
        r32.add(r02);
        goto L12
    L16:
        ArrayList r53 = new ArrayList();
        Iterator r33 = r32.iterator();
    L18:
        if (r33.hasNext() == false) goto L22;
        Object r03 = r33.next();
        if (r4.contains(Long.valueOf(((Number) r03).longValue())) == true) goto L18;
        r53.add(r03);
        goto L18
    L22:
        ArrayList r34 = new ArrayList(t86.N(r53, 10));
        Iterator r42 = r53.iterator();
    L24:
        if (r42.hasNext() == false) goto L26;
        r34.add(String.valueOf(((Number) r42.next()).longValue()));
        goto L24
    L26:
        return r34;
    L28:
        return egb.a;
    }

    public static final Set b(IotPlate r6, Set r7) {
        Set r0 = null;
        if (r6 == null) goto L38;
        List<IotPlateObjectId> r1 = r6.getObjects();
        if (r1 == null) goto L38;
        if (r1.isEmpty() == true) goto L38;
        List<IotPlateObjectId> r62 = r6.getSkippedObjects();
        if (r62 == null) goto L19;
        ArrayList r02 = new ArrayList();
        Iterator<T> r63 = r62.iterator();
    L14:
        if (r63.hasNext() == false) goto L18;
        Long r2 = ((IotPlateObjectId) r63.next()).getIdentifyId();
        if (r2 == null) goto L14;
        r02.add(r2);
        goto L14
    L18:
        r0 = r86.V0(r02);
    L19:
        if (r0 != null) goto L21;
        r0 = mgb.a;
    L21:
        ArrayList r64 = new ArrayList();
        Iterator<T> r12 = r1.iterator();
    L23:
        if (r12.hasNext() == false) goto L27;
        Long r22 = ((IotPlateObjectId) r12.next()).getIdentifyId();
        if (r22 == null) goto L23;
        r64.add(r22);
        goto L23
    L27:
        ArrayList r13 = new ArrayList();
        Iterator r65 = r64.iterator();
    L29:
        if (r65.hasNext() == false) goto L37;
        Object r23 = r65.next();
        long r3 = ((Number) r23).longValue();
        if (r0.contains(Long.valueOf(r3)) == true) goto L29;
        if (r7.contains(String.valueOf(r3)) == true) goto L29;
        r13.add(r23);
        goto L29
    L37:
        return r86.V0(r13);
    L38:
        return null;
    }

    public static void c(Intent r4) {
        String r0 = r4.getAction();
        if (r0 == null) goto L32;
        int r1 = r0.hashCode();
        if (r1 == (-1520117578)) goto L19;
        if (r1 == (-1173264947)) goto L15;
        if (r1 == (-58484670)) goto L12;
        return;
    L12:
        if (r0.equals("android.intent.action.SEND_MULTIPLE") == false) goto L36;
    L16:
        r4.addFlags(270532608);
        return;
    L36:
        return;
    L15:
        if (r0.equals("android.intent.action.SEND") == true) goto L16;
        return;
    L19:
        if (r0.equals("android.intent.action.CHOOSER") == true) goto L22;
        return;
    L22:
        if (Build.VERSION.SDK_INT < 34) goto L24;
        Object r42 = c7.i(r4, "android.intent.extra.INTENT", Intent.class);
    L28:
        Intent r43 = (Intent) r42;
        if (r43 == null) goto L34;
        c(r43);
        return;
    L34:
        return;
    L24:
        r42 = r4.getParcelableExtra("android.intent.extra.INTENT");
        if (Intent.class.isInstance(r42) == true) goto L28;
        r42 = null;
        goto L28
    }

    public static ArrayList d(uzh r4, CharSequence r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r4.getChildCount()) goto L11;
        View r2 = r4.getChildAt(r1);
        if ((r2 instanceof TextView) == false) goto L10;
        TextView r22 = (TextView) r2;
        if (TextUtils.equals(r22.getText(), r5) == false) goto L10;
        r0.add(r22);
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }
}
