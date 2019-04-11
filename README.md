# PatternProject
Small Text Adventure
Spielweise:
Man spawnt mit einem Kader an zufälligen Spielern, nachdem man einen Draftpick hat. Man hat für die ersten 20 Spiele alle 5 Spiele die Chance einen Vetranspieler oder
ein junges Talent zu wählen. Diese verändern die Chance ob man gewinnt (Veteran low Risk low Reward, Rookie high Risk high Reward)
Patterns:
Factory - Zum Erstellen der Spieler
Singleton - Nur 1 Factory erlaubt
State - Für Verloren oder Gewonnen bzw. noch im Spiel
Observer - Um zu sehen in welchem State wir uns befinden
