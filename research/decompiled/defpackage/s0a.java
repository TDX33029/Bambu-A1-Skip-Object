package defpackage;

import com.heytap.mcssdk.constant.b;
import defpackage.r0a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* loaded from: classes2.dex */
public abstract class s0a {
    public static final Json a = null;

    static {
        a = JsonKt.Json$default(null, new lp9((byte) 5), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Serializable a(JsonElement r3) {
        if ((r3 instanceof JsonNull) == false) goto L5;
        vc0.k("null values are not supported in custom command");
        return null;
    L5:
        if ((r3 instanceof JsonPrimitive) == false) goto L29;
        JsonPrimitive r32 = (JsonPrimitive) r3;
        if (r32.isString() == false) goto L11;
        return r32.getContent();
    L11:
        if (JsonElementKt.getBooleanOrNull(r32) == null) goto L15;
        Boolean r33 = JsonElementKt.getBooleanOrNull(r32);
        r33.getClass();
        return r33;
    L15:
        if (JsonElementKt.getIntOrNull(r32) == null) goto L19;
        Integer r34 = JsonElementKt.getIntOrNull(r32);
        r34.getClass();
        return r34;
    L19:
        if (JsonElementKt.getLongOrNull(r32) == null) goto L23;
        Long r35 = JsonElementKt.getLongOrNull(r32);
        r35.getClass();
        return r35;
    L23:
        if (JsonElementKt.getDoubleOrNull(r32) == null) goto L27;
        Double r36 = JsonElementKt.getDoubleOrNull(r32);
        r36.getClass();
        return r36;
    L27:
        return r32.getContent();
    L29:
        if ((r3 instanceof JsonObject) == false) goto L36;
        Map r37 = (Map) r3;
        LinkedHashMap r0 = new LinkedHashMap(vvh.f0(r37.size()));
        Iterator r38 = r37.entrySet().iterator();
    L32:
        if (r38.hasNext() == false) goto L34;
        Map.Entry r1 = (Map.Entry) r38.next();
        r0.put(r1.getKey(), a((JsonElement) r1.getValue()));
        goto L32
    L34:
        return r0;
    L36:
        if ((r3 instanceof JsonArray) == false) goto L42;
        Iterable r39 = (Iterable) r3;
        ArrayList r02 = new ArrayList(t86.N(r39, 10));
        Iterator r310 = r39.iterator();
    L39:
        if (r310.hasNext() == false) goto L41;
        r02.add(a((JsonElement) r310.next()));
        goto L39
    L41:
        return r02;
    L42:
        cze.d();
        return null;
    }

    public static s82 b(String r8, boolean r9) {
        String r82 = fuq.f1(r8).toString();
        if (r82.length() == 0) goto L58;
        JsonObject r83 = JsonElementKt.getJsonObject(a.parseToJsonElement(r82));
        c(r83);
        if (r83.size() != 1) goto L50;
        Map.Entry r84 = (Map.Entry) r86.h0(r83.entrySet());
        String r2 = (String) r84.getKey();
        JsonElement r85 = (JsonElement) r84.getValue();
        if ((r85 instanceof JsonObject) == false) goto L10;
        JsonObject r86 = (JsonObject) r85;
    L11:
        if (r86 == null) goto L47;
        JsonElement r3 = (JsonElement) r86.get(b.y);
        if (r3 == null) goto L45;
        JsonPrimitive r32 = JsonElementKt.getJsonPrimitive(r3);
        if (r32 == null) goto L45;
        String r33 = JsonElementKt.getContentOrNull(r32);
        if (r33 == null) goto L45;
        if (fuq.B0(r33) == false) goto L22;
        r33 = null;
    L22:
        if (r33 == null) goto L45;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<Map.Entry<String, JsonElement>> r87 = r86.entrySet().iterator();
    L25:
        if (r87.hasNext() == false) goto L29;
        Map.Entry<String, JsonElement> r5 = r87.next();
        if (lsf.l(r5.getKey(), b.y) == true) goto L25;
        r4.put(r5.getKey(), r5.getValue());
        goto L25
    L29:
        LinkedHashMap r88 = new LinkedHashMap();
        Iterator r0 = r4.entrySet().iterator();
    L31:
        if (r0.hasNext() == false) goto L35;
        Map.Entry r42 = (Map.Entry) r0.next();
        if ((((JsonElement) r42.getValue()) instanceof JsonNull) == true) goto L31;
        r88.put(r42.getKey(), r42.getValue());
        goto L31
    L35:
        LinkedHashMap r02 = new LinkedHashMap(vvh.f0(r88.size()));
        Iterator r89 = r88.entrySet().iterator();
    L37:
        if (r89.hasNext() == false) goto L40;
        Map.Entry r43 = (Map.Entry) r89.next();
        r02.put(r43.getKey(), a((JsonElement) r43.getValue()));
        goto L37
    L40:
        if (r02.isEmpty() == false) goto L42;
        LinkedHashMap r44 = null;
    L44:
        return new s82(r2, r33, r44, r9, null, 48);
    L42:
        r44 = r02;
    L45:
        r2.getClass();
        throw new r0a.c(dgh.n("Missing command in \"", r2, "\""));
    L47:
        r2.getClass();
        throw new r0a.e(dgh.n("Section \"", r2, "\" must be an object"));
    L10:
        r86 = null;
        goto L11
    L50:
        throw new r0a.d("Root must contain exactly one section key");
    L54:
        e = move-exception;
        throw new r0a.b(e);
    L51:
        e = move-exception;
        throw new r0a.b(e);
    L58:
        throw new r0a.a("JSON is empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(JsonElement r2) {
        if ((r2 instanceof JsonObject) == false) goto L29;
        JsonObject r22 = (JsonObject) r2;
        JsonElement r0 = (JsonElement) r22.get("sequence_id");
        if (r0 != null) goto L7;
    L24:
        Iterator<T> r23 = r22.values().iterator();
    L26:
        if (r23.hasNext() == false) goto L37;
        c((JsonElement) r23.next());
        goto L26
    L37:
        return;
    L7:
        if ((r0 instanceof JsonNull) == true) goto L24;
        Integer r1 = JsonElementKt.getIntOrNull(JsonElementKt.getJsonPrimitive(r0));
        if (r1 == null) goto L11;
        int r02 = r1.intValue();
    L18:
        if (r02 >= 2001) goto L24;
        vc0.k("sequence_id must bigger than 2001");
        return;
    L11:
        String r03 = JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(r0));
        if (r03 == null) goto L14;
        Integer r04 = muq.h0(10, r03);
    L15:
        if (r04 == null) goto L22;
        r02 = r04.intValue();
        goto L18
    L22:
        vc0.k("sequence_id must be an int");
        return;
    L14:
        r04 = null;
        goto L15
    L29:
        if ((r2 instanceof JsonArray) == false) goto L34;
        Iterator r24 = ((Iterable) r2).iterator();
    L32:
        if (r24.hasNext() == false) goto L38;
        c((JsonElement) r24.next());
        goto L32
    L38:
        return;
    }
}
