<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/tcg.css" type="text/css">
<meta charset="UTF-8">
<title>Role Play Games</title>
</head>
<body>
	<div class="navbar">
		<jsp:include page="navbar.jsp" />
	</div>
	<div class=background>

		<h1 class="text-center">Table Top Role Play Games</h1>

		<div class="container-fluid">
			<div class="row">

				<!--team-1-->
				<div class="col-xl-4">
					<div class="our-team-main">

						<div class="team-front">

							<h1>Final Fantasy</h1>

						</div>

				<a href="eventsByGame.do?game=Final Fantasy" >
						<div class="team-back">
							<span> Final Fantasy trading card game is a trading card game by Square Enix and Hobby Japan.
							 Each player uses a deck of 50 cards, with no more than 3 copies of the same card.
							  Players play cards by spending Crystal Points, earned by "dulling" (turning from vertical to horizontal) 
							  Backup cards, or by discarding cards. The game features a wide range of Characters from games in the Final
							   Fantasy series.<br> <br> <br> <br>
								<br> <br> <br>
							</span>
						</div>
				</a>

					</div>
				</div>
				<!--team-1-->

				<!--team-2-->
				<div class="col-xl-4">
					<div class="our-team-main">

						<div class="team-front">

							<h1>KeyForge</h1>
						</div>

				<a href="eventsByGame.do?game=KeyForge" >
						<div class="team-back"><span>
							Enter a world where anything is possible in KeyForge! In the center of the universe hangs the Crucible,
							 an artificial world built from the pieces of countless planets. Here, in the world’s first Unique Deck Game,
							  created by legendary designer Richard Garfield, two players step into the roles of mighty Archons,
							   racing to forge keys that unlock the Crucible’s hidden Vaults.<br> <br> <br> <br> <br>
							<br> <br></span>
						</div>
				</a>

					</div>
				</div>
				<!--team-2-->

				<!--team-3-->
				<div class="col-xl-4">
					<div class="our-team-main">

						<div class="team-front">

							<h1>Legend of the Five Rings</h1>
						</div>

				<a href="eventsByGame.do?game=Legend of theFive Rings" >
						<div class="team-back">
							<span> Enter the vibrant world of Rokugan with Legend of the Five Rings: The Card Game, a Living Card Game® of
							 honor and conflict for two players! Drawing on the legacy of AEG’s original Legend of the Five Rings 
							 collectible card game, and now reimagined with new mechanics, story, and the Living Card Game distribution
							  model, you are invited to join the Great Clans, uphold the tenets of Bushidō, and fulfill your duty. <br> <br> <br> <br> <br> <br>
								<br>​
							</span>
						</div>
				</a>

					</div>
				</div>
				<!--team-3-->

				<!--team-4-->
				<div class="col-xl-4">
					<div class="our-team-main">

						<div class="team-front">

							<h1>Pokemon</h1>
						</div>

				<a href="eventsByGame.do?game=Pokemon" >
						<div class="team-back">
							<span>  The Pokémon Trading Card Game, often abbreviated as Pokémon TCG or just TCG, is a tabletop game that
							 involves collecting, trading and playing with Pokémon themed playing cards. It has its own set of rules but
							  uses many motifs and ideas derived from the video games. There are Pokémon cards for every species of 
							  Pokémon, as well as Trainer cards featuring characters, items and other themes of the franchise (each with 
							  a different use) and Energy cards to power various actions. The artwork for the cards is provided by 
							  numerous artists.<br> <br> <br>
								<br> <br> <br> <br>
							</span>
						</div>
				</a>

					</div>
				</div>
				<!--team-4-->

				<!--team-5-->
				<div class="col-xl-4">
					<div class="our-team-main">

						<div class="team-front">

							<h1>Star Wars Trading Card Game</h1>
						</div>

				<a href="eventsByGame.do?game=Star Wars Trading Card Game" >
						<div class="team-back">
							<span> The Star Wars: TCG focuses on gaining control of in-game arenas. In this two-player game, each player
							 controls units which battle in the arenas. The main way to win is to take control of two of the three arenas.
							  Some cards also add new win conditions for the game.<br> <br>
								<br> <br> <br> <br> <br> <br> <br>
								<br> <br> <br> <br> <br>
							</span>
						</div>
				</a>

					</div>
				</div>
				<!--team-5-->

				<!--team-6-->
				<div class="col-xl-4">
					<div class="our-team-main">

						<div class="team-front">

							<h1>Yu-Gi-Oh</h1>
						</div>

				<a href="eventsByGame.do?game=Yu-Gi-Oh" >
						<div class="team-back">
							<span> In this game, two players Duel each other using a variety of Monster, Spell, and Trap Cards to defeat
							 their opponent's monsters and be the first to drop the other's Life Points to 0.<br> <br> <br>
								<br> <br> <br> <br><br> <br>
							</span>
						</div>
				</a>

					</div>
				</div>
				<!--team-6-->
				<!--team-6-->

				<div class="col-xl-4">
					<div class="our-team-main">

						<div class="team-front">

							<h1>Magic: The Gathering</h1>
						</div>

				<a href="eventsByGame.do?game=Yu-Gi-Oh" >
						<div class="team-back">
							<span>Magic: The Gathering is a card game in which wizards cast spells, summon creatures, and exploit magic
							 objects to defeat their opponents. In the game, two or more players each assemble a deck of 60 cards with
							  varying powers. They choose these decks from a pool of some 20,000 cards created as the game 
							  evolved.<br> <br> <br>
								<br> <br> <br> <br>
							</span>
						</div>
				</a>

					</div>
				</div>
				<!--team-6-->
				
		</div>

			<div class="game-list">
				<table class="table table-hover">
					<thead>
						<tr>
							<h2><th scope="col">Upcoming Events</th></h2>
							<h2><th scope="col">Date</th></h2>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="event" items="${category}">
							<tr>
						<td>	<a href="singleEvent.do?id=${event.id}">${event.title}</a><p>${event.address.city}, ${event.address.state}<p></td>
							<td>${event.eventDate }</td></h3>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>













			<%-- <div class="game-list">
				<c:forEach var="event" items="${category}">
				<h3>${event.title}<br>
				${event.eventDate }</h3>
				</c:forEach>


		</div>  --%>

	<jsp:include page="login-popout.jsp"></jsp:include>
	</div>
</div>





</body>
</html>