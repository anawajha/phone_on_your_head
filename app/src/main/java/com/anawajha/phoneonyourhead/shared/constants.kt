package com.anawajha.phoneonyourhead.shared

import android.graphics.Color
import com.anawajha.phoneonyourhead.model.Category
import com.anawajha.phoneonyourhead.R

var countries = arrayListOf("النرويج","فلسطين","السعودية","المغرب","الولايات المتحدة","بريطانيا","الإمارات العربية المتحدة","فرنسا","الجزائر","روسيا","الصومال","الهند","أسبانيا","لبنان")
var jobs = arrayListOf("مهندس","ميكانيكي","كهربائي","عامل بناء","طبيب","طبيب أسنان","كوافير","سبّاك","مُبرمج","محامي","مُدرس","نجار","صيدلي","مدرب رياضي","صحفي","صياد")
var plants = arrayListOf("صبّار","زيتون","نعناع","بابونج","السرو","الفل","البامبو","ملفوف","بروكلي","التين","بصل","كرفس","فجل","خس","بطاطس","جزر","فلورا","أفوكادو")
var tools = arrayListOf("مفك","زرادية","كماشة","مطرقة","الفأرة","فأس","مجرفة","منشار","مثقاب","شريط القياس (متر)","ميزان","مفتاح","مربط معدني","فرشاة دهان","كف","صندوق","مسمار")
var accents = arrayListOf("أجرمنعنو","لز","حدانا","احزق حالك","سحيج","طاح","حزقان","أوضة","برداية","مقشََة","خوصة","فلينة","خشم","طوى","كلنس","مغرفة","","","")
var capitals = arrayListOf("طوكيو","الرياض","دبي","نيويورك","القدس","لندن","برلين","باريس","بروكسل","دمشق","بيروت","أنقرة","أوتاوا","بكين","ستوكهولم","القاهرة","روما","أثينا","كوالالامبور")
var animals = arrayListOf("فيل","زرافة","فأر","حصان","قطة","كلب","أسد","فهد","كنغر","دب","غزال","كوالا","بطريق","باندا","حمار وحشي","سنجاب","ذئب","خنزير","خروف","تيس","ثور","ضبع")
var birds = arrayListOf("غراب","ببغاء","نعامة","عصفور","بجعة","لقلق","نورس","صقر","نسر","عٌقاب","حمام","شنار(حجل)","نقار الخشب","طاووس","كناري","بوم","دجاج","الأوز","بطة","الشرقرق","خفاش")
var foods = arrayListOf("ملوخية","برجر","حمصيص","فطيرة ذهبية","دمسة","كالازوني","مسقعة","شاورما","بامية","شوربة","بيتزا","دجاج مشوي","بشاميل","ورق عنب","منسف","أرز أوزي","سباغيتي","محاشي","كباب")
var actions = arrayListOf("رقص","طبخ","قضاء الحاجة","في العمل","نوم","استيقاظ","دراسة","تنزه","تسوق","كذب","جلي","لعب","حلاقة","استحمام","تنظيف","غسيل")
var movies = arrayListOf("توم وجيري","بات مان","جيمس بوند","الأرض الطيبة","سنوات الضياع","سبايدر مان","لوز وسكر","دموع الورد","الجاسوسات","سلاحف النينجا","السرعة والغضب","باباي","هاري بوتر","الأصدقاء","عهد الأصدقاء","غامبول","فتيات القوة")

var categories = arrayListOf(
    Category("دول", R.mipmap.countries,Color.CYAN,"countries", countries),
    Category("مهن", R.mipmap.jobs,Color.MAGENTA,"jobs", jobs),
    Category("نباتات", R.mipmap.plants,Color.DKGRAY,"plants", plants),
    Category("أدوات", R.mipmap.tools,Color.YELLOW,"tools", tools),
    Category("لهجات و لغات", R.mipmap.accents,Color.GREEN,"accents", accents),
    Category("عواصم", R.mipmap.newyork,Color.RED,"capitals", capitals),
    Category("حيوانات", R.mipmap.animals,Color.LTGRAY,"animals", animals),
    Category("طيور", R.mipmap.birds,Color.CYAN,"birds", birds),
    Category("أكلات", R.mipmap.foods,Color.CYAN,"foods", foods),
    Category("أفعال و حركات", R.mipmap.actions,Color.CYAN,"actions", actions),
    Category("عروض تلفزيونية", R.mipmap.movies,Color.CYAN,"movies", movies),)