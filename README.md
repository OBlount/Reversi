# Reversi ⚫ ⚪ - _A fun little game written in Java!_

---

## 🔎 About

This is a project I did during my second semester studying computer science at UoN. The aim of the project was to:

- Develop Java skills and nice readable code
- Implement a game using the OOP paradigm
- Learn Swing GUI tool kit

The game is [Reversi / Othello](https://en.wikipedia.org/wiki/Reversi), the rules are very simple. Each turn a player puts down a counter of their colour. The counter must "sandwich" the opposition's counter with one of your own (this in-turn captures the pieces). The player at the end of the game with the most counters on the board wins!

## 🕹 Controls

The player/s are shown with two boards, one for white and one for black.

The player during their turn can click on the board to place down a piece (subject to legality).

The player can (sneakily) use the "greedy AI" button if desired which puts down a counter which captures the most pieces (sometimes not the best move).

## 📷

![ScreenShot1](/docs/Screenshot_1.png "Reversi")

## 💾 Installation

The project is deliberately without build tools, instead you should create the jar yourself. If you're lucky enough to be on a linux machine, simply run `$ cleanbuild -r`.

## 📄 License

Under [MIT](https://choosealicense.com/licenses/mit/)

🟢 Author: Owen Blount
