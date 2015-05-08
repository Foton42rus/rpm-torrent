# Extracting general attributes value associated with peers in connected swarm #

## Who are peers ?? ##

**Peers** are the end-users of Bittorrent protocol. It is among them that
pieces of target files are exchanged.Among these peers, it is possible to denote two subcategories of peers called, in the Bittorrent language, seeders and leechers.

_Seeders_ are the peers that own the complete target files corresponding to a torrent and share them with other peers. Equivalently, we could say that they only upload these files and do not download from other peers.

_Leechers_ are all the other peers, the ones that do not own the complete file and therefore download pieces from other peers .They can
also serve the pieces of the files that they already have. Once they’ll have downloaded all parts of the files, leechers become seeders if they continue to share the files after there download has beev completed.

**_Each peer runs a Bittorrent client to share or download files to/from other peers. A peer chokes a client to inform it that no requests will be
answered until the client is unchoked. Therefore, the client should not
send any requests for blocks of data and consider all pending requests to be discarded.A peer can be interested in another if the latter owns pieces of data that the former itself does not._**

this pieces of code contain listed attribues..

id: peer id

ip: peer ip address

port\_listening: listening port of peer

interested: the remote peer is interested in the client.

choked:the client is choking the remote peer

interesting: the client is interested in the remote peer

choking :the remote peer is choking the client

hasPiece :how many pieces does peer have.

downloaded\_pieces : how many pieces are downloaded from peer.

downrate: rate of download from peer.

lastDL : number of pieces download before reset.

uprate :uplink rate to peer

lastUL :number of pieces upload before reset

uploaded\_pieces: how many pieces are uploaded to peer.