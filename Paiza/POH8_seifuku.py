# coding: utf-8
class Game:
    class Player:
        def __init__(self, num, rank, card, alive=True):
            self.num = num
            self.rank = rank
            self.card = card
            self.alive= True
            
    class Card:
        cards = ["3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"]
        def __init__(self, mark):
            self.mark = mark
            self.strength = Game.Card.cards.index(mark)
    
    def __init__(self, query, field=None):
        self.field = None
        self.query = query
        
        self.players = []
        for num, card in enumerate(query):
            player = Game.Player(num, -1, Game.Card(card))
            self.players.append(player)
            
    def execute(self):
        rank = 1
        pointer = 0
        pointer_memo = -1
        while rank <= 52:
            #print("pointer:" + str(pointer) + " memo:" + str(pointer_memo) + " rank:" + str(rank))
            if self.players[pointer].alive and self.field == None:
                self.players[pointer].alive = False
                self.players[pointer].rank = rank
                self.field = self.players[pointer].card
                rank += 1
                pointer_memo = int(pointer)
            elif self.players[pointer].alive and self.players[pointer].card.strength > self.field.strength:
                self.players[pointer].alive = False
                self.players[pointer].rank = rank
                self.field = self.players[pointer].card
                rank += 1
                pointer_memo = int(pointer)
            elif not self.players[pointer].alive and pointer == pointer_memo:
                self.field = None
            else:
                pass
            pointer += 1
            pointer = pointer%52
         
    def print_result(self):
        for player in self.players:
            print(player.rank)

if __name__ == "__main__":
    query = input().split(" ")
    game = Game(query)
    game.execute()
    game.print_result()
    
