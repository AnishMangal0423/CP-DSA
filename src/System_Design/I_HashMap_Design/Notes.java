package System_Design.I_HashMap_Design;

public class Notes {

    public static void main(String[] args) {
 /**
  *
  * Ok so From My side , I want to Make the Notes for HashMaps..
  *
  * 1. So Internally what happens is ki hamare bass ek Bucket/hashtable hoti h , which have buckets and Har ek Bucket will
  *    Contain the Chaining's.
  *
  * 2. Aab Jab bhi Put Function Call hota h to str is
  *     put (k , V) , To aab hota kya h ki Jo hamari key hoti h oske pass Java kitraf se k.hasCode() function hota h jo
  *     os key ko ye btata h ki ye key konsi bucket mai jayegi.
  *     and hmm % bhi use krte h takii hmari bucket Size ki range mai value aaye and ye hashcode fn os key ke liye hmesha
  *     consistent bucketValue hi deta h .
  *     Now ese bhi ho sakta h ki for Key=1 , Key=7 ek hi bucket mai chaining kr rhi hoo.
  *     I think Reason is Clear.
  *
  * 3. Aab Collision ke Baree mai samajte h - 2 tarkike ke hote h ..
  *    Jab bucket allot ho to bucket agar shuraat mai hi khali h to hmm Initilize kr dete h
  *    to first Collision hota h jab ek bhi element present ho.
  *    and aab hmm os linkedlist mai search krte h agar same key ka element milta h to ose update krenge (2nd collsion)
  *    otherwise ye ek trah se new key h to ise add kr denge at last of list.
  *
  *
  *
  *  4. There is a Factor Known as Loading Factor (Lambda) - TotalNodesinMap / Bucket.size ye batyega ki avg size of every bucket
  *     and put serach and all ye sab O(lambda ya constant hi hote h ) , but hmm dekhte h ki thresold se jada ho lambda to
  *     rehash krenge that will take O(Total Nodes in Map * Lambda(pushfn)) ~ O(N)
  *
  *  yahi h maps.
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  * **/
    }
}
