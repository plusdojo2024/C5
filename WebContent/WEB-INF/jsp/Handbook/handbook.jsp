<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" class="bg">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--  <link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">-->
<title>衣食住のハンドブック</title>

<style>

/*ヘッダー*/
header {
	text-align: center;
	margin-top: 0px;
	padding: 5px;
	background-color: #f9c146;
	width: 100%;
	color: white;
}
/*ハンドブックのフォントを游ゴシックに変更*/
h1 {
	font-family: "Yu Gothic", "游ゴシック", YuGothic, "游ゴシック体";
	position: relative;
	padding: 1rem 2rem;
}

.tab {
	max-width: 800px;
	margin: 0 auto;
	margin-top: 120px;
}

/* タブメニュー */
.tab__menu {
	display: flex;
	align-items: flex-end; /* メニューを下揃え */
	justify-content: center;
	min-height: 50px; /* メニュー切替時にタブがズレないように */
	padding: 0;
	margin: 0;
}

.tab__menu-item {
	list-style: none;
	width: 200px;
	padding: 8px 5px; /* メニューに高さを付ける */
	text-align: center;
	margin-right: 6px;
	background-color: #cdcdcd;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	cursor: pointer;
	transition: all .3s; /* アニメーション */
}

.tab__menu-item:last-of-type {
	margin-right: 0px;
}

/* is-activeがついている時のスタイル */
.tab__menu-item.is-active {
	background-color: #0068b7;
	color: #FFFFFF;
	padding: 12px 5px;
}

/* タブパネル */
.tab__panel {
	width: 100%;
}

.tab__panel-box {
	min-height: 400px;
	padding: 10px 30px;
	border-radius: 10px;
}

.tab__panel-box001 {
	background-color: #e6e6fa;
	display: none;
}

.tab__panel-box002 {
	background-color: #bbe2f1;
	display: none;
}

.tab__panel-box003 {
	background-color: #f7f7ad;
	display: none;
}

/* is-showがついている時のスタイル */
.tab__panel-box.is-show {
	display: block;
}

.testStart {
	text-align: center;
}

.omutsu, .meal, .kids {
	text-align: center;
}

.book {
	color: white;
	margin-top: 0px;
	background-color: #5abca5;
	width: 100%;
	padding: 5px;
}

.bg {
	background-color: #e0f2ed;
}

.button {
	display: inline-block;
	border-radius: 14%; /* 角丸       */
	font-size: 10pt; /* 文字サイズ */
	text-align: center; /* 文字位置   */
	cursor: pointer; /* カーソル   */
	padding: 5px 4px; /* 余白       */
	background: #5abca5; /* 背景色     */
	color: #ffffff; /* 文字色     */
	line-height: 1em; /* 1行の高さ  */
	opacity: 0.9; /* 透明度     */
	transition: .3s; /* なめらか変化 */
}

.button:hover {
	box-shadow: none; /* カーソル時の影消去 */
	opacity: 1; /* カーソル時透明度 */
}

.FixedBar {
	width: 40px;
	height: 40px;
}

footer {
	position: fixed;
	bottom: 0;
	left: 0;
	width: 100%;
	text-align: center;
	background: white;
	margin-top: 10px;
	padding: 10px 0;
}

.mg {
	margin: auto;
}

.ct {
	text-align: center;
}
</style>

</head>

<header style="text-align: center;">
	<h3>IKUMI</h3>
</header>

<body style="text-align: center;">
	<h1 class="book">Handbook</h1>
<body>

	<p style="text-align: center;">ハンドブックの理解度をテストしてみよう！</p>
	<form method="post" action="/C5/HandbookServlet">
		<div class="testStart">
			<input type="submit" name="test" value="テスト" class="button">
		</div>
	</form>


	<div class="tab">
		<ul class="tab__menu">
			<li class="tab__menu-item is-active" data-tab="01">衣</li>
			<li class="tab__menu-item" data-tab="02">食</li>
			<li class="tab__menu-item" data-tab="03">住</li>
		</ul>
		<div class="tab__panel">
			<div class="tab__panel-box tab__panel-box001 is-show" data-panel="01">
				<h2>おむつの替え方</h2>
				<p style="text-align: left;" class="tab__panel-text">

					準備するもの<br> • おむつ • おしりふき<br> <br> おむつ替え手順 <br>
					１．おむつがぬれているかチェックします <br> ２．おむつを軽く開けておしっこやうんちが出ていないか確認してみましょう。
					<br> 慣れてくると匂いでわかることもあります。 <br> ３．新しい紙おむつを敷きます <br>
					こうするとおむつを外したとき、急におしっこをされても大丈夫ですよ。 <br> ４．おむつをはずしておしりを拭きます <br>
					５．汚れたおむつを引き抜きます <br> おしりの下に手を入れて、おしりを浮かせて、汚れたほうのおむつを引き抜きます。 <br>
					６．新しいおむつをあてます <br> <br>
				</p>

				<div class="omutsu">
					<img src="/C5/images/omutsu.png" width="400" height="150">
				</div>

				<p>
					注意点 <br> 赤ちゃんは皮膚がとても薄く、おむつかぶれを起こしやすいので、以下のようなことに注意してあげましょう。
					おしっこやうんちで赤ちゃんの肌が汚れたまま、ぬれたままの状態にしないこと。
				</p>
				<h2>洗濯時の注意</h2>
				<p style="text-align: left;" class="tab__panel-text">
					・少なくとも生後一か月未満は大人服と一緒に洗わない <br>
					赤ちゃんの肌はデリケートなため、肌トラブルを起こす可能性があります。 <br>
					赤ちゃんが生後1ヶ月から1年未満であれば、ベビー服と大人の服と一緒に洗えますが、洗剤を減らすなどの工夫が必要です。 <br>
					・柔軟剤は避けるのがベター！ 使うときは赤ちゃん用が安心です。 <br> ・すすぎと乾燥は念入りに行う <br>
					洗剤が残らないようにすすぎを2回行いましょう。 <br>
					ベビー服を干すときは外干しをしましょう。室内干しでも、部屋の換気をし、洗たく物の通気を良くして、きちんと乾かせば問題ありません。
				</p>
				<h2>外出時の持ち物</h2>
				<p style="text-align: left;" class="tab__panel-text">
					赤ちゃんと外出時の必需品は「ミルク、おむつ、おしりふき」 <br>
					ミルクセット(哺乳びん・粉ミルクなど)や、おむつポーチ(紙おむつ・おしり拭き)を用意しておくと◎ <br> <br>
					持っていると安心！何かと便利！ <br> ・着替え <br> ・抱っこ紐 <br> ・ガーゼやタオル <br>
					・ビニール袋 <br> ・母子手帳 <br> ・お気に入りのおもちゃ <br>
					・離乳食用フォークスプーンセット <br> <br>
					そのほか、季節や気温によっては持っていると便利な物もあります！ <br>
					お出掛けする時期や気候に合わせて持ち歩いてくださいね。
				</p>
			</div>
			<div class="tab__panel-box tab__panel-box002" data-panel="02">
				<h2>食べてはいけないもの</h2>
				<p style="text-align: left;" class="tab__panel-text">
					子供に食べてはいけないものは、のどの詰まりや窒息の原因となる「食材自体が危険なもの」と「子どもの噛む力や口の大きさに見合わないもの」です！
					<br> <br> 注意すべき食材一覧 <br> ・はちみつ（1
					歳未満の赤ちゃんがハチミツを食べることによって乳児ボツリヌス症にかかる） <br> ・刺身、生魚 <br>
					・香辛料 <br> ・イカやタコ <br> ・ウィンナー、ハム、ベーコン <br> ・練りもの <br>
					・大豆、落花生、アーモンド <br> ・エビ、カニ、貝、蕎麦 <br> ・ぎんなん <br> ・生卵 <br>
					・牛乳 <br> ・フルーツ <br> ・そのほかアレルギーのおこしやすいもの <br>
					・のどに詰まりやすいもの <br> ・辛味や刺激が強いもの <br> ・糖分や塩分が多いもの <br>
					・消化しにくいもの <br> <br>
					食品アレルギーになるのかまだわからない時期はとにかく赤ちゃんの様子をよく観察しながら与えてくださいね。
					大きくなればなんでも（食物アレルギーを除いて）食べられるようになるので、１～２歳の食事はできるだけ不安のない安心できる食材を与えてあげてください

				</p>
				<h2>栄養バランス</h2>
				<p style="text-align: left;" class="tab__panel-text">
					離乳食がすすむにつれ、気になるのが栄養バランス！1日3食になる頃から、それまで半々だった母乳やミルクからの栄養／離乳食からの栄養の割合が、徐々に離乳食の方が多くなっていくため、
					<br>「炭水化物、ビタミン・ミネラル類、たんぱく質」を取り入れることが大切<br>
				<div class="meal">
					<img src="/C5/images/meal.png" width="500" height="200">
				</div>

				初めは炭水化物源の米がゆ（10倍がゆ）からスタートし、 ビタミン・ミネラル源→ タンパク質源の順に慣らしていきます！ <br>
				食べる量は赤ちゃんにまかせてOK！ただ「ほうっておく」のではなく、食べられるようにいろいろな助けは必要です。好きなものと交互に食べさせたり、手づかみ食べしやすいように調理したり。まったく食べていないものはもしかすると「飲み込みにくい」「噛みにくい」ことも。つぶしたり水分を足してみてください。
				<br> 発達をしっかりと見極め、発達段階に合った食べ物を与えることが重要◎

				</p>

				<h2>ミルクの作り方と飲ませ方</h2>
				<p style="text-align: left;" class="tab__panel-text">
					粉ミルクを溶かすときは70度以上のお湯を使いましょう！ <br>
					・お湯で溶かした粉ミルクは、流水にあてるか冷水または氷水の入った容器に入れて授乳できる温度まで短期間で冷やしましょう。 <br>
					・溶かした後、2時間以内に使用しなかったミルクは捨てましょう。 <br> 離乳食の進み具合によっても違いますが、 <br>
					1日のミルクの摂取量は 1000～1400ml（トータル）ほどが目安！ <br> 1度に約200～220ml、
					5～6時間間隔を空けて、 1日に4回ほど！！ <br> 食後に少しずつこまめに飲ませてあげよう◎
				</p>
			</div>
			<div class="tab__panel-box tab__panel-box003" data-panel="03">
				<h2>温度・湿度について</h2>
				<p style="text-align: left;" class="tab__panel-text">
					個人差はあるものの、体温の基準は「36.5～37.5℃くらい」 <br>
					子どもの体温は、成人と比較すると0.5～0.6℃高いのが普通です。
				</p>
				<br>

				<div class="kids">
					<img src="/C5/images/kids.png" width="500" height="250">
				</div>
				<p style="text-align: left;">
					<br> ・夏の場合 <br>
					室温26℃から28℃くらいが目安になります。エアコン（冷房）を使用したうえでの温度です。 <br> ・冬の場合 <br>
					室温は20℃から23℃が目安になります。エアコンや暖房を使用したうえでの温度です。 <br> ・湿度 <br>
					温度に比べて見落とされがちですが、湿度の管理も重要です。夏場は50％～60％、冬場は40％～60％が目安になります
				</p>
				<h2>お風呂の入れ方</h2>
				<p style="text-align: left;" class="tab__panel-text">
					生まれて間もない赤ちゃんは抵抗力が弱いので、生後1ヶ月頃までは、大人と一緒のお風呂ではなく、ベビーバスで沐浴をさせてあげます。 <br>
					<br> 沐浴の準備と方法は？ ・ベビーバス
					大きめのゆったりタイプ、キッチンや洗面台のシンクにセットして使うタイプ、空気を入れて膨らませて使うタイプなどがあります。 ・洗面器
					・湯温計 ・沐浴布 ・ガーゼ ・バスタオル 赤ちゃんの体についた石けん分を流すために使います。柔らかいガーゼが適しています。 <br>
					<br> ・沐浴手順 <br> 1)ベビーバスにお湯を張る <br>
					適温は38度前後。季節によって、少しぬるめ、暖かめに設定する。 <br> 2)頭、顔を洗う <br>
					ゴシゴシとこすらないように手のひらを使って軽くくるくると洗いましょう。 <br> 3)体を洗う <br>
					4)あがり湯ですすぐ <br> 5)バスタオルにのせて体を拭く <br> 優しく拭き取りましょう <br>
					6)綿棒で鼻と耳の水分を取る <br> <br> 注意点 <br> ・いつ、どのくらい入れるのか
					生活のリズムを作るため、おおよそ決まった時間帯に入れてあげましょう。ただし、授乳の直前や授乳後30分以内は避けてください。 <br>・体調を見ながら沐浴

				</p>
				<h2>注意する家具</h2>
				<p style="text-align: left;" class="tab__panel-text">
					・テーブルや棚などの角・隙間でけがをしないように保護する <br>
					赤ちゃんがけがをしないように、テーブル・棚・椅子の角を保護するカバーをつけるなど対策をしましょう。
					・家電のコードはまとめてコンセントにはカバーを付ける <br>
					家電のコードをそのままの状態にしていると、赤ちゃんがコードを引っ張るだけでなく、首に巻き付けて窒息したり、誤ってコードを噛んでしまって感電したりする可能性があります。
					<br>・簡単に引き出しが開かないようにチャイルドロックを使う <br>
					頭をぶつけるだけでなく、赤ちゃんが知らない間に引き出しの中身を取り出して散らかしたり、引き出しに手を挟むなどのトラブルも起こりにくくなります。
					<br>・ベビーサークル・ゲートを使う <br>
					ハイハイできるスペースを保ち、サークル内以外への赤ちゃんの移動を制限しながら、目の届く範囲で赤ちゃんを遊ばせておけるので安心です。

				</p>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<footer>
		<table class="ct mg">
			<tr>
				<td><img src="/C5/images/icons/home.png" class="FixedBar"
					alt="ホーム"></a></td>
				<td><img src="/C5/images/icons/record.png" class="FixedBar"
					alt="記録書"></a></td>
				<td><img src="/C5/images/icons/handbook.png" class="FixedBar"
					alt="ハンドブック"></a></td>
				<td><img src="/C5/images/icons/consul.png" class="FixedBar"
					alt="相談所"></a></td>
			</tr>
			<tr>
				<td>
					<form method="get" action="/C5/HomeServlet">
						<input type="submit" id="" value="ホーム" class="button"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/RecordServlet">
						<input type="submit" id="" value="記録書" class="button"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/HandbookServlet">
						<input type="submit" id="" value="ハンドブック" class="button"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/ConsulServlet">
						<input type="submit" id="" value="相談所" class="button"></input>
					</form>
				</td>
			</tr>
		</table>
	</footer>
	<!-- スクリプトを読み込む -->
	<script>
  'use strict'; /* 厳格にエラーをチェック */

{ /* ローカルスコープ */

// DOM取得
const tabMenus = document.querySelectorAll('.tab__menu-item');
console.log(tabMenus);

// イベント付加
tabMenus.forEach((tabMenu) => {
  tabMenu.addEventListener('click', tabSwitch);
})

// イベントの処理
function tabSwitch(e) {

  // クリックされた要素のデータ属性を取得
  const tabTargetData = e.currentTarget.dataset.tab;
  // クリックされた要素の親要素と、その子要素を取得
  const tabList = e.currentTarget.closest('.tab__menu');
  console.log(tabList);
  const tabItems = tabList.querySelectorAll('.tab__menu-item');
  console.log(tabItems);
  // クリックされた要素の親要素の兄弟要素の子要素を取得
  const tabPanelItems = tabList.
  nextElementSibling.querySelectorAll('.tab__panel-box');
  console.log(tabPanelItems);

  // クリックされたtabの同階層のmenuとpanelのクラスを削除
  tabItems.forEach((tabItem) => {
    tabItem.classList.remove('is-active');
  })
  tabPanelItems.forEach((tabPanelItem) => {
    tabPanelItem.classList.remove('is-show');
  })

     // クリックされたmenu要素にis-activeクラスを付加
  e.currentTarget.classList.add('is-active');
  // クリックしたmenuのデータ属性と等しい値を持つパネルにis-showクラスを付加
  tabPanelItems.forEach((tabPanelItem) => {
    if (tabPanelItem.dataset.panel ===  tabTargetData) {
      tabPanelItem.classList.add('is-show');
    }
  })

}

}
  </script>
</body>
</html>