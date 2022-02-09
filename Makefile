clean:
	rm -fr ./docs/ ./classes/


doc:
	javadoc -d ./docs/ -sourcepath ./src/ -subpackages player games character board board.tile action action.army action.worker


cls:
	cd src/ ; javac -d ../classes/ player/*.java games/*.java character/*.java board/*.java board/tile/*.java action/*.java action/army/*.java action/worker/*.java


guerre.jar: cls
	cd classes/ ; jar cfe ../jar/guerre.jar games/WarGame games/WarGame.class player/Player.class player/PlayerArmy.class character/Character.class character/CharacterArmy.class board/Board.class board/tile/*.class action/Action.class action/army/*.class


agricole.jar: cls
	cd classes/ ; jar cfe ../jar/agricole.jar games/AgriculturalDevelopmentGame games/AgriculturalDevelopmentGame.class player/Player.class player/PlayerWorker.class character/Character.class character/CharacterWorker.class board/Board.class board/tile/*.class action/Action.class action/worker/*.class